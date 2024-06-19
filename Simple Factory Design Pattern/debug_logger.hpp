#pragma once
#include "ilogger.hpp"

// Derived class for handling debug level logging
class DebugLogger : public ILogger {
public:
    // Override the log function to print debug messages
    void log(const string& msg) override;
};