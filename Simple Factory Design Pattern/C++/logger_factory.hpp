#pragma once
#include "ilogger.hpp"
#include "debug_logger.hpp"
#include "info_logger.hpp"
#include "error_logger.hpp"

// Factory class for creating Logger objects based on log level
class LoggerFactory {
public:
    // Factory method to create a Logger based on the specified log level
    static ILogger* createLogger(LogLevel pLogLevel);
};