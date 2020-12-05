'use strict';
const logger = require('./logger')

let authorize = function(req, res, next) {
	logger.info('Authorizing token');
	logger.debug(req);
	if (!req.user || !req.user.permissions) {       
		logger.error("message=No roles received in the token, error=AUTHORIZATION_ERROR")
		res.status(401).send({ "status": 401, 
			"code": "AUTHORIZATION_ERROR", 
			"message": "Authorization failed",
			"details":[{"message":"No roles received in the token" }] 
		});
		return;
	}
	let roleSet = new Set(['ROLE_CHANNEL_ADMIN', 'ROLE_INTERNAL']);
	logger.debug(roleSet);
	let intersection = new Set(req.user.permissions.filter(role => roleSet.has(role)));
	logger.debug(intersection);

	if (intersection.size > 0) {
		next();
	} else {
		logger.warn("message=Invalid roles received in token, error=AUTHORIZATION_ERROR")
		res.status(401).send({ "status": 401, 
			"code": "AUTHORIZATION_ERROR", 
			"message": "Authorization failed",
			"details":[{"message":"Invalid roles received in token" }] 
		});
		return;
	}
};

module.exports = {
	authorize: authorize
};
