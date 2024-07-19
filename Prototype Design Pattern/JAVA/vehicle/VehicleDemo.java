abstract class Vehicle {
    public abstract Vehicle clone();

    public abstract void display();

    public abstract void update(String newModel);
}

class Car extends Vehicle {
    private String model;
    private String manufacturer;
    private int year;

    public Car(String model, String manufacturer, int year) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    @Override
    public Vehicle clone() {
        return new Car(model, manufacturer, year);
    }

    @Override
    public void display() {
        System.out.println("Car - Model: " + model + ", Manufacturer: " + manufacturer + ", Year: " + year);
    }

    @Override
    public void update(String newModel) {
        model = newModel;
    }
}

class Motorcycle extends Vehicle {
    private String model;
    private String brand;

    public Motorcycle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public Vehicle clone() {
        return new Motorcycle(model, brand);
    }

    @Override
    public void display() {
        System.out.println("Motorcycle - Model: " + model + ", Brand: " + brand);
    }

    @Override
    public void update(String newModel) {
        model = newModel;
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        // Create prototype instances of a car and a motorcycle
        Vehicle carPrototype = new Car("SUV", "Toyota", 2023);
        Vehicle motorcyclePrototype = new Motorcycle("Sport", "Honda");

        // Clone and display car and motorcycle
        Vehicle carClone = carPrototype.clone();
        Vehicle motorcycleClone = motorcyclePrototype.clone();

        System.out.println("Car Clone:");
        carClone.display();

        System.out.println("\nMotorcycle Clone:");
        motorcycleClone.display();

        // Update the models of the clones
        carClone.update("Sedan");
        motorcycleClone.update("Cruiser");

        System.out.println("\nUpdated Car Clone:");
        carClone.display();

        System.out.println("\nUpdated Motorcycle Clone:");
        motorcycleClone.display();
    }
}
