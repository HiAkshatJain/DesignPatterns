#pragma once
#include "ilogger.hpp"

// Derived class for handling Info level logging
class InfoLogger : public ILogger {
    public:
     // Override the log function to print Info messages
        void log(const string& msg) override;
};
