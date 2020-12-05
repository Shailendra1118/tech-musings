'use strict';
const { Verifier } = require('@pact-foundation/pact');
var packageVersion = require('../../package.json');
const sinon = require('sinon');
let adJwtAuthorization;
let adJwtAuthentication;

describe("Pact provider verification", () => {
    before(()=>{
        adJwtAuthorization = require('../../src/adJwtAuthorization.js');
        adJwtAuthentication = require('../adJwtAuthentication.js');
        sinon.stub(adJwtAuthorization, 'authorize').callsFake(function(req, res, next) {
            return next();
        });
        sinon.stub(adJwtAuthentication, 'verify').callsFake(function(req, res, next) {
            return next();
        });
        const { app } = require('../../app.js');
        app.listen(8081, () => {
            console.log('example-html-generator service listening on http://localhost:8081');
        });
    });

    it("Validates the return of pdf stream in Base64 encoded format", () => {
        let opts = {
            provider: 'example-pdf-generator',
            logLevel: 'DEBUG',
            providerBaseUrl: 'http://localhost:8081',
            stateHandlers: {
                "Return Base64 encoded pdf stream": () => {
                    return Promise.resolve('Return Base64 encoded pdf stream');
                },
            },
            // Fetch pacts from broker
            pactBrokerUrl: process.env.PACTBROKER || 'https://pactbroker.example.tools',
            // Fetch from broker with given tags
            tags: ["master"],
            publishVerificationResult: true,
            providerVersion: packageVersion.version,
        }
        // Validates the pact & uploads the verification results to pact broker
        return new Verifier(opts).verifyProvider().then(output => {
            console.log(output);
        })
    })

    after(()=>{
        adJwtAuthorization.authorize.restore();
        adJwtAuthentication.verify.restore();
    });
})
