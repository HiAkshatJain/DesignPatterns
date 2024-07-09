#pragma once
#include "ilogger.hpp"

// Derived class for handling debug level logging
class ErrorLogger : public ILogger {
public:
    // Override the log function to print Error messages
    void log(const string& msg) override;
};