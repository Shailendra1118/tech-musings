module.exports = {
	automock: false,
	verbose: true,
	collectCoverage: true,
	collectCoverageFrom: [
		'!src/test/**/*.js'
	],
	coverageDirectory: 'coverage',
	coverageReporters: ['json', 'lcov', 'text-summary', 'text'],
	snapshotSerializers: ['enzyme-to-json/serializer'],
	testMatch: ['**/__tests__/**/*test.js'],
	moduleNameMapper: {
		'\\.(png|jpg|gif|ttf|eot|svg)$':
			'<rootDir>/src/test/'
	}
};
