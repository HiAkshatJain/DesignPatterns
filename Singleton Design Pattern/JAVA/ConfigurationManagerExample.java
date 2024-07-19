import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Singleton class for managing application configuration settings
class ConfigurationManager {
    // Private constructor to prevent instantiation from outside
    private ConfigurationManager() {
        System.out.println("Configuration Manager initialized.");
    }

    // Singleton instance of ConfigurationManager
    private static ConfigurationManager instance;

    // Lock for thread safety during instance initialization
    private static Lock mtx = new ReentrantLock();

    // Method to get the singleton instance of ConfigurationManager
    public static ConfigurationManager getInstance() {
        if(instance == null) {
            mtx.lock();  // Acquire lock to ensure thread safety
            try {
                if(instance == null) {
                    instance = new ConfigurationManager();  // Create instance if not already created
                }
            } finally {
                mtx.unlock();  // Release lock
            }
        }
        return instance;
    }

    // Method to set a configuration property
    public void setProperty(String key, String value) {
        System.out.println("Setting property: " + key + " = " + value);
        // Logic to set property goes here
    }

    // Method to get a configuration property
    public String getProperty(String key) {
        System.out.println("Getting property for key: " + key);
        // Logic to get property goes here
        return "dummy_value";  // Dummy return value for illustration
    }
}

// Example class demonstrating usage of ConfigurationManager singleton
public class ConfigurationManagerExample {
    public static void main(String[] args) {
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        // Demonstrate that both instances are the same
        if (configManager1 == configManager2) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Singleton pattern is not working correctly.");
        }

        // Use the singleton instance to set and get properties
        configManager1.setProperty("timeout", "1000");
        String timeout = configManager2.getProperty("timeout");
        System.out.println("Timeout value: " + timeout);
    }
}
