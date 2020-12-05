'use strict';
const jwt = require('express-jwt');
const jwksRsa = require('jwks-rsa');
const authzUrl = process.env.AUTHZ_URL || 'http://authz/api/v1/certs';

const verify = jwt({
    // Dynamically provide a signing key based on the kid in the header and the singing keys provided by the JWKS endpoint.
    secret: jwksRsa.expressJwtSecret({
        cache: true,
        rateLimit: true,
        jwksRequestsPerMinute: 20,
        jwksUri: authzUrl
    }),
    getToken: function fromHeader(req) {
        console.log("From header function");
        if (req.get('ad-authorization') && req.get('ad-authorization').split(' ')[0] === 'Bearer') {
            return req.get('ad-authorization').split(' ')[1];
        }
        return null;
    },
    algorithms: ['RS256']
}).unless({ path: ['/health', '/prometheus'] });

module.exports = {
    verify: verify
};