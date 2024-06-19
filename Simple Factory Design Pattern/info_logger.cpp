#include "info_logger.hpp"

// Implementation of the log function for InfoLogger
void InfoLogger::log(const string& msg) {
    // Print the debug message to the standard output with a "INFO" prefix
    cout<<"INFO : "<<msg<<endl;
}

