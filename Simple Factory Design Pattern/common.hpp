#pragma once
#include <iostream> 
using namespace std; // Use the standard namespace to simplify code readability

// Enumeration representing different log levels
enum class LogLevel {
    DEBUG, // Detailed information for diagnosing problems
    INFO,  // Informational messages that highlight the progress of the application
    ERROR  // Error events that might still allow the application to continue running
};
