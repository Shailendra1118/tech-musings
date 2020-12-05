"use strict";

const { createLogger, format, transports } = require('winston');
const { combine, timestamp, splat, json , prettyPrint} = format;

const errorFormat = format(logged => {
    if (logged instanceof Error) {
      return Object.assign({}, logged, {
        stack: logged.stack,
        message: logged.message
      })
    }
    return logged
})

const logFormat = () => 
    combine(
        timestamp(),
        splat(),
        errorFormat(),
        json()
    )

const buildLogger = createLogger({
    level:  process.env.LOG_LEVEL || "info",
    silent:  process.env.LOG_SILENT || false,
    format: logFormat(),
    transports: [new transports.Console()]
})

module.exports = buildLogger;