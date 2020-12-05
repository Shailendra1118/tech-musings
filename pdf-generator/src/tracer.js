'use strict';
const {Tracer, ExplicitContext, ConsoleRecorder, BatchRecorder} = require('zipkin');
const logger = require('./logger')

let tracer;
const ZIPKIN_BASEURL = process.env.ZIPKIN_BASEURL;
if (ZIPKIN_BASEURL) {
	// We configured the runtime environment variable to a Zipkin endpoint
	const ctxImpl = new ExplicitContext();
	const recorder = new BatchRecorder({
		// Record all traces using the HTTP transport to Zipkin API
		logger: new(require('zipkin-transport-http')).HttpLogger({
			endpoint: `${ZIPKIN_BASEURL}api/v2/spans`,
			jsonEncoder: require('zipkin').jsonEncoder.JSON_V2
		})
	});
	tracer = new Tracer({
		ctxImpl: ctxImpl,
		recorder: recorder,
		localServiceName: 'example-pdf-generator' // Use the application package name in spans
	});
	logger.info('Reporting Zipkin traces to %s', ZIPKIN_BASEURL);
} else {
	tracer = new Tracer({
		ctxImpl: new ExplicitContext(),
		recorder: new ConsoleRecorder(),
		localServiceName: 'example-pdf-generator' // name of this application
	});
	logger.info(`Reporting Zipkin traces to console`);
}
// Make the tracer importable by to other packages
module.exports = tracer;
