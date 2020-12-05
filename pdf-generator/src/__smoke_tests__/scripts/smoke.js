const fs = require('fs');
const axios = require('axios');
const pdfApi = `${process.env.MICROSERVICE_URL}/api/v1/pdfgenerator/pdfstream`;
const healthcheckApi = `${process.env.MICROSERVICE_URL}/health`;
const logger = require('../../logger');

const { getAuthToken } = require('./utils');
const HEADER_TENANT_VALUE = process.env.AD_Tenant;

describe('SMOKE for example-pdf-generator', () => {
	test('Check the health of the service', async () => {
        logger.info("TEST STARTED : Check the health of the service");
        logger.info(`Health Check API::${healthcheckApi}`);
		const response = await axios({
			method: 'get',
			url: healthcheckApi
		});
		expect(response.status).toEqual(200);
        logger.info("TEST PASSED : Check the health of the service");
	}, 10000);

	test('Get the pdf stream', async () => {
        logger.info("TEST STARTED : Get the pdf stream");
        logger.info(`Get the pdf stream API::${pdfApi}`);
        const HEADER_AUTH_VALUE = "Bearer " + await getAuthToken();
		const requestFileContent = await fs.readFileSync("src/__smoke_tests__/testdata/request.json").toString();
        logger.info(`Fetch PDF API::${pdfApi}`);
		const response = await axios({
			method: 'post',
			data: requestFileContent,
			url: pdfApi,
			headers: {
				'Content-Type': 'application/json',
                'AD-Authorization': HEADER_AUTH_VALUE,
                'AD-Tenant': HEADER_TENANT_VALUE
			}
		});
        expect(response.status).toEqual(200);
		expect(response.data.contentType).not.toBeNull();
        logger.info("TEST PASSED : Get the pdf stream");
	}, 10000);
})
