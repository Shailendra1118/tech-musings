'use strict';

const Prometheus = require('prom-client')
const onFinished = require("on-finished");

const collectDefaultMetrics = Prometheus.collectDefaultMetrics;
collectDefaultMetrics({timeout: 1000});

// Prometheus Metrics 
const httpRequestDurationMiliseconds = new Prometheus.Histogram({
  name: 'http_request_duration_ms',
  help: 'Duration of HTTP requests in milliseconds',
  labelNames: ['uri','method','status' ],
  buckets: [50, 200, 500, 2000, 5000, 10000]
})

const NS_PER_SEC = 1e9;
const NS_PER_MS = 1e6;

let prometheusMetrics = function(req, res, next){
  var hrstart = process.hrtime();
  onFinished(res, () => {
    const hrend = process.hrtime(hrstart);
    const milliSeconds = (hrend[0] * NS_PER_SEC + hrend[1]) / NS_PER_MS;
    httpRequestDurationMiliseconds
    .labels(req.path, req.method, res.statusCode)
    .observe(milliSeconds);
  });
  next();
}
module.exports = prometheusMetrics;
