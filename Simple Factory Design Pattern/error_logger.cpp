#include "error_logger.hpp"

// Implementation of the log function for ErrorLogger
void ErrorLogger::log(const string &msg) {
    // Print the debug message to the standard output with a "ERROR" prefix
    cout << "ERROR : " << msg << endl;
}