#include "logger_factory.hpp"

ILogger* LoggerFactory::createLogger(LogLevel defined) {
    if(defined == LogLevel::DEBUG)
        return new DebugLogger();
    if(defined == LogLevel::INFO)
        return new InfoLogger();
    if(defined == LogLevel::ERROR)
        return new ErrorLogger();
    return nullptr;
}