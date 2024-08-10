import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DatabaseConnection {

    private DatabaseConnection() {
        System.out.println("Database Connection initialized.");
    }

    private static DatabaseConnection instance;

    private static Lock lock = new ReentrantLock();

    public static DatabaseConnection getInstance() {
        if (instance == null) { // First check without locking
            lock.lock(); // Acquire the lock before creating the instance
            try {
                if (instance == null) { // Double-checked locking
                    instance = new DatabaseConnection();
                }
            } finally {
                lock.unlock(); // Always release the lock
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        System.out.println("Disconnecting from the database...");
    }

}

public class Database {
    public static void main(String[] args) {

        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.connect();
        dbConnection.disconnect();

        // Attempt to create another instance (should return the existing instance)
        DatabaseConnection anotherDbConnection = DatabaseConnection.getInstance();

        // Check if both instances are the same.
        if (dbConnection == anotherDbConnection) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Singleton pattern is not working correctly.");
        }
    }
}
