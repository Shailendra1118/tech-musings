const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const client = require('prom-client');
const puppeteer = require('puppeteer-core');
const jwt = require('express-jwt');
const jwksRsa = require('jwks-rsa');
const adJwtAuthorization = require('./src/adJwtAuthorization.js');
const tracer = require('./src/tracer');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;
const adJwtAuthentication = require('./src/adJwtAuthentication.js');
const logger = require('./src/logger.js')

const PDF_GEN_ERR = "Error generating PDF Invoice";
const port = process.env.PORT || 8080;
const authzUrl = process.env.AUTHZ_URL || 'http://authz/api/v1/certs';

// Tell the bodyparser middleware to accept more data
app.use(bodyParser.urlencoded({limit: process.env.BODY_PARSER_LIMIT, extended: true}));
app.use(bodyParser.json({limit: process.env.BODY_PARSER_LIMIT}));

// Prometheus - set scrapping endpoint
app.use('/prometheus', require('./src/prometheus'));
// Prometheus - apply middleware
app.use(require('./src/metrics'));

app.use(adJwtAuthentication.verify);

app.use(function (err, req, res, next) {
	if (err.name === 'UnauthorizedError') {
    logger.error(err);
    res.status(err.status).send({ "status": 401,
                                "code": "AUTHORIZATION_ERROR",
                                "message": "Authorization failed - "+err.message
          });
		return;
	}
	next();
});

app.get('/health', (req, res) => {
  logger.debug('health: OK');
  res.status(200).send({"status":200,
                        "code":"OK",
                        "message":"example generator service is UP."
    })
});

app.post('/api/v1/pdfgenerator/pdfstream',
  adJwtAuthorization.authorize,
  zipkinMiddleware({tracer: tracer}),
  (req,res) => {
    (async () => {
      let browser;
      let page;
      logger.info('Request for traceId=%s, spanId=%s', tracer.id.traceId, tracer.id.spanId);
      try{
        logger.info(req.body.page)
        const reqStarted = Date.now();

        // 1. Check for chrome url env
        const chromeUrl = process.env.CHROME_WS_URL;
        if(!chromeUrl){
          logger.error("traceId=%s, message=Chrome WS URL is not set, error=MISSING_CHROME_WS_URL", tracer.id.traceId);
          res.status(500).send({ "status": 500,
              "code": "PDF_GENERATION_ERROR",
              "message": PDF_GEN_ERR,
              "details":[{ "field":"Chrome WS URL",
                  "code":"MISSING_CHROME_WS_URL",
                  "message":"Please check if environment variable CHROME_WS_URL is set."}]
          });
          return;
        }
        // 2. Get the default header for pages
        const encodedHeader = req.body.header;
        if(! encodedHeader) {
            logger.error("traceId=%s,message=Empty Header received, error=EMPTY_REQUEST_HEADER", tracer.id.traceId);
            res.status(400).send({ "status": 400,
                "code": "PDF_GENERATION_ERROR",
                "message": PDF_GEN_ERR,
                "details":[{ "field":"header",
                    "code":"EMPTY_REQUEST_HEADER",
                    "message":"Empty encoded header is received."
                }]
            });
            return;
        }

        // 3. Get the default footer for pages
        const encodedFooter = req.body.footer;
        if(! encodedFooter) {
            logger.error("traceId=%s,message=Empty Footer received, error=EMPTY_REQUEST_FOOTER", tracer.id.traceId );
            res.status(400).send({ "status": 400,
                "code": "PDF_GENERATION_ERROR",
                "message": PDF_GEN_ERR,
                "details":[{ "field":"footer",
                    "code":"EMPTY_REQUEST_FOOTER",
                    "message":"Empty encoded footer is received."
                }]
            });
            return;
        }

        // 4. Get the main page content
        const encodedBody = req.body.body;
        if(! encodedBody){
            logger.error("traceId=%s,message=Empty Body Field received, error=EMPTY_REQUEST_BODY", tracer.id.traceId);
            res.status(400).send({ "status": 400,
                "code": "PDF_GENERATION_ERROR",
                "message": PDF_GEN_ERR,
                "details":[{ "field":"body",
                    "code":"EMPTY_REQUEST_BODY",
                    "message":"Empty encoded body is received."
                }]
            });
            return;
        }
        const bodyHtml = Buffer.from(req.body.body, 'base64').toString();
        const headerHtml = Buffer.from(req.body.header, 'base64').toString();
        const footerHtml = Buffer.from(req.body.footer, 'base64').toString();

        // Get the watermark content if present
        const encodedWatermark = req.body.watermark;
        logger.debug("Received watermark: "+req.body.watermark);
        let wmHtml = "";
        if(encodedWatermark !== null && encodedWatermark !== ''){
            wmHtml = Buffer.from(req.body.watermark, 'base64').toString();
        }

        browser = await puppeteer.connect({ browserWSEndpoint: chromeUrl });
        const browserLaunched = Date.now();

        // 5. Create new page
        page = await browser.newPage();
        logger.debug("traceId=%s, browser.newPage ok", tracer.id.traceId)

        // 6. Listen to error events on the page
        page.on('error', msg => { logger.error('traceId=%s,Page error event:', tracer.id.traceId, msg);});
        page.on('pageerror', msg => { logger.error('traceId=%s,Page pageerror event:', tracer.id.traceId, msg);});
        page.on('console', msg => { logger.info('traceId=%s,Page logger event:', tracer.id.traceId, msg);});
        page.on('requestfailed', msg => { logger.error('traceId=%s,Page requestfailed event:', tracer.id.traceId, msg);});

        // 7. Set html to page
        await page.setContent(bodyHtml + wmHtml); //append watermark as well
        const contentSet = Date.now();
        logger.debug("traceId=%s, page.setContent ok", tracer.id.traceId)

        const pageProperties = req.body.page;
        const pageFormat = pageProperties.format === null ? '' : pageProperties.format;
        const pageHeight = pageProperties.height === null ? '' : pageProperties.height;
        const pageWidth = pageProperties.width === null ? '' : pageProperties.width;

        // 8. Get pdf of html content
        const buf = await page.pdf({
            format: pageFormat,
            height: pageHeight,
            width: pageWidth,
            printBackground:true,
            displayHeaderFooter: true,
            headerTemplate: headerHtml,
            footerTemplate: footerHtml
        });
        const pdfGenerated = Date.now();
        logger.debug("traceId=%s, page.pdf ok", tracer.id.traceId)

        let pdf;

        if(!buf){
          logger.error("traceId=%s,message=Received no data from Page.pdf() call, error=NO_DATA_FROM_PDF_CALL",tracer.id.traceId)
          // 9. Return error if empty
          res.status(500).send({ "status": 500,
              "code": "PDF_GENERATION_ERROR",
              "message": PDF_GEN_ERR,
              "details":[{"code":"NO_DATA_FROM_PDF_CALL",
                "message":"Received no data from Page.pdf() call."}]
          });
          return;
        }else{
          // 10. Encode pdf data to base64
          pdf = Buffer.from(buf).toString('base64');
          logger.debug("traceId=%s, Buffer.from() ok", tracer.id.traceId)
        }
        const pdfEncoded = Date.now();
        // 11. Close browser at last
        // NOTE: Do not close the page.close that hangs
        logger.debug("traceId=%s, before-> browser.close()",tracer.id.traceId)
        await browser.close();
        browser = null
        logger.debug("traceId=%s, after<- browser.close()",tracer.id.traceId)
        const browserClosed = Date.now();

        let result = {};
        result.content = pdf;
        result.contentType = "application/pdf";

        //12. Log times
        logger.info("traceId=%s, Stats: total=%s, browserLaunched=%s, pdfGenerated=%s,browserClosed=%s",
            tracer.id.traceId,
            browserClosed-reqStarted,
            browserLaunched-reqStarted,
            pdfGenerated-browserLaunched,
            browserClosed-pdfEncoded);

        res.status(200).send(result);

      } catch(err){
        logger.error('traceId=%s, spanId=%s, Exception in PDF generator',tracer.id.traceId, tracer.id.spanId);
        logger.error(err);

        // send error response
        if (err instanceof Error) {
          res.status(500).send({"status": 500,
              "code": "PDF_GENERATION_ERROR",
              "message": PDF_GEN_ERR,
              "details":[{ "code":"PUPPETEER_CDP_ERROR",
                "message":err.toString()}]
            });
        } else{
          res.status(500).send({"status": 500,
              "code": "PDF_GENERATION_ERROR",
              "message": PDF_GEN_ERR,
              "details":[{ "code":"PUPPETEER_CDP_EXCEPTION",
                "message":err.toString()}]
            });
        }
      } finally {
        if(browser){
          logger.info("traceId=%s, Closing Browser...",tracer.id.traceId);
          await browser.close();
          logger.info("traceId=%s, Browser closed.",tracer.id.traceId);
        }
      }
    })();
});

app.listen(port, () => {
  logger.log('info', 'Chrome url: %s', process.env.CHROME_WS_URL);
  logger.log('info','Body parser size %s', process.env.BODY_PARSER_LIMIT);
  logger.log('info','AuthZ URL: %s',  process.env.AUTHZ_URL);
  logger.log('info', 'Service listening on port %s!', port);
});

module.exports = { app };
