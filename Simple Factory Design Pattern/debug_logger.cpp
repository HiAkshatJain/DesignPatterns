#include "debug_logger.hpp"

// Implementation of the log function for DebugLogger
void DebugLogger::log(const string &msg) {
    // Print the debug message to the standard output with a "DEBUG" prefix
    cout << "DEBUG : " << msg << endl;
}