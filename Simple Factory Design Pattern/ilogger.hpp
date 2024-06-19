#pragma once
#include "common.hpp"

// Interface for generic logger
class ILogger {
public:
    // Pure virtual function for logging a message
    virtual void log(const string& msg) = 0;

    // Virtual destructor to allow proper cleanup of derived classes
    virtual ~ILogger() = default;
};