'use strict';

const axios = require('axios');
const qs = require('qs');
const logger = require('../../logger');

const HEADER_TENANT_VALUE = process.env.AD_Tenant;
const HEADER_AUTH_VALUE = "Bearer ";
const MONOLITH_URL_BASE_URL = process.env.MONOLITH_URL;
const AUTHZ_BASE_URL = process.env.AUTHZ_URL;
const CLIENT_ID = process.env.client_id;
const CLIENT_SECRET = process.env.client_secret;
const CHANNEL_ADMIN_USERNAME = process.env.channel_admin_username;
const CHANNEL_ADMIN_PASSWORD = process.env.channel_admin_password;

const getOpaqueToken = async () => {
    try {
        const requestBodyContent = {
            "client_id": CLIENT_ID,
            "client_secret": CLIENT_SECRET,
            "grant_type": "password",
            "username": CHANNEL_ADMIN_USERNAME,
            "password": CHANNEL_ADMIN_PASSWORD,
            "scope": "ROLE_CHANNEL_ADMIN"
        };

        logger.info("Fetching opaque token");
        logger.info("MONOLITH_URL_BASE_URL::" + MONOLITH_URL_BASE_URL);
        const response = await axios({
            method: 'post',
            data: qs.stringify(requestBodyContent),
            url: MONOLITH_URL_BASE_URL + "/oauth2/token",
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
        logger.info("Opaque token successfully fetched");
        return response.data.access_token;
    } catch (error) {
        logger.info("ERROR in fetching Opaque token");
        console.error(error);
        return error;
    }
};

const getAuthToken = async () => {
    const opaqueToken = await getOpaqueToken();
    logger.info("Fetching auth token");
    logger.info("AUTHZ_BASE_URL::" + AUTHZ_BASE_URL);
    logger.info("HEADER_TENANT_VALUE::" + HEADER_TENANT_VALUE);
    try {
        const response = await axios({
            method: 'get',
            url: AUTHZ_BASE_URL + "/api/v1/authorize",
            headers: {
                Authorization: HEADER_AUTH_VALUE + opaqueToken,
                'Content-Type': 'application/json',
                'AD-Tenant': HEADER_TENANT_VALUE
            },
            data: {}
        });
        logger.info("Auth token successfully fetched");
        return response.data.token;
    } catch (error) {
        logger.info("ERROR in fetching Auth token");
        console.error(error);
        return error;
    }
};

module.exports = { getAuthToken};
