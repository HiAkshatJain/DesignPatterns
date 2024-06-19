#include "logger_factory.hpp"

int main() {
    // Create a debug logger using the factory
    ILogger* debugLogger = LoggerFactory::createLogger(LogLevel::DEBUG);
    // Create an info logger using the factory
    ILogger* infoLogger = LoggerFactory::createLogger(LogLevel::INFO);
    // Create an error logger using the factory
    ILogger* errorLogger = LoggerFactory::createLogger(LogLevel::ERROR);
    
    // Log a message using the debug logger
    debugLogger->log("This is a debug log msg");
    // Log a message using the info logger
    infoLogger->log("This is an info log msg");
    // Log a message using the error logger
    errorLogger->log("This is an error log msg");

    // Clean up dynamically allocated loggers to avoid memory leaks
    delete debugLogger;
    delete infoLogger;
    delete errorLogger;

    // Return 0 to indicate successful execution
    return 0;
}
