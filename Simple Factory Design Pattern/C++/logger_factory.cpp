#include "logger_factory.hpp"

// Implementation of the factory method to create loggers
ILogger* LoggerFactory::createLogger(LogLevel pLogLevel) {
    switch (pLogLevel) {
        case LogLevel::DEBUG:
            return new DebugLogger();
        case LogLevel::INFO:
            return new InfoLogger();
        case LogLevel::ERROR:
            return new ErrorLogger();
        default:
            throw invalid_argument("Unknown log level");
    }
}
