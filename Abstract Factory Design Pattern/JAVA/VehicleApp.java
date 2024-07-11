import java.util.Scanner;

// Interface for the vehicle factory method pattern
interface IVehicleFactory {
    ICar createCar(); // Method to create a car
    ITruck createTruck(); // Method to create a truck
}

// Interface representing a car
interface ICar {
    void drive(); // Method to simulate driving the car
}

// Interface representing a truck
interface ITruck {
    void load(); // Method to simulate loading the truck
}

// Implementation of the European car
class EuropeCar implements ICar {
    @Override
    public void drive() {
        System.out.println("Driving a European car"); // Print message specific to European car
    }
}

// Implementation of the Asian car
class AsiaCar implements ICar {
    @Override
    public void drive() {
        System.out.println("Driving an Asian car"); // Print message specific to Asian car
    }
}

// Implementation of the European truck
class EuropeTruck implements ITruck {
    @Override
    public void load() {
        System.out.println("Loading a European truck"); // Print message specific to European truck
    }
}

// Implementation of the Asian truck
class AsiaTruck implements ITruck {
    @Override
    public void load() {
        System.out.println("Loading an Asian truck"); // Print message specific to Asian truck
    }
}

// Factory class for creating European vehicles
class EuropeFactory implements IVehicleFactory {
    @Override
    public ICar createCar() {
        return new EuropeCar(); // Create and return a European car
    }

    @Override
    public ITruck createTruck() {
        return new EuropeTruck(); // Create and return a European truck
    }
}

// Factory class for creating Asian vehicles
class AsiaFactory implements IVehicleFactory {
    @Override
    public ICar createCar() {
        return new AsiaCar(); // Create and return an Asian car
    }

    @Override
    public ITruck createTruck() {
        return new AsiaTruck(); // Create and return an Asian truck
    }
}

// Abstract Factory class to generate appropriate vehicle factory based on region
class VehicleFactoryProducer {
    public static IVehicleFactory createFactory(String region) {
        if (region.equals("europe")) {
            return new EuropeFactory(); // Return European factory if region is "europe"
        } else if (region.equals("asia")) {
            return new AsiaFactory(); // Return Asian factory if region is "asia"
        }
        return null; // Return null if region is invalid
    }
}

// Main class to run the vehicle application
class VehicleApp {
    public static void main(String[] args) {
        System.out.println("Enter the Region (europe/asia)");
        Scanner scanner = new Scanner(System.in); // Create scanner to read user input
        String region = scanner.nextLine(); // Read the region input from the user
        scanner.close(); // Close the scanner to prevent resource leak

        IVehicleFactory factory = VehicleFactoryProducer.createFactory(region); // Create the appropriate factory
        if (factory != null) {
            ICar car = factory.createCar(); // Create a car using the factory
            car.drive(); // Simulate driving the car
            ITruck truck = factory.createTruck(); // Create a truck using the factory
            truck.load(); // Simulate loading the truck
        } else {
            System.out.println("Region is Invalid"); // Print error message if factory is null
        }
    }
}
