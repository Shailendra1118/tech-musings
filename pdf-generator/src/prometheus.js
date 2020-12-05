'use strict';

let express = require('express');
const Prometheus = require('prom-client')

let router = express.Router();
router.get('/', (req, res) => {
    res.set('Content-Type', Prometheus.register.contentType)
    res.end(Prometheus.register.metrics())
})

module.exports = router;