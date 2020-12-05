module.exports = {
	testURL: 'http://localhost/',
    setupTestFrameworkScriptFile: './src/__smoke_tests__/scripts/smoke.js',
	globals: {
		// available in all tests
		browser: null,
		page: null,
		tokenStr: null,
		user: null
	},
    testMatch: ['**/__smoke_tests__/**/*smoke.js'],
	reporters: [
		'default',
		[
			'./node_modules/jest-html-reporter',
			{
				pageTitle: 'Smoke Test Report',
				outputPath: './test-report/test-report.html',
				includeFailureMsg: true,
				includeConsoleLog: true
			}
		]
	]
};
