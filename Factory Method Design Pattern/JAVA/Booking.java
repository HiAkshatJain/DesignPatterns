// Define an interface Hotel with a method book()
interface Hotel {
    void book();
}

// Class Suite implements the Hotel interface
class Suite implements Hotel {
    @Override
    public void book(){
        System.out.println("You are booking a Suite");
    }
}

// Class Deluxe implements the Hotel interface
class Deluxe implements Hotel {
    @Override
    public void book(){
        System.out.println("You are booking a Deluxe");
    }
}

// Class Villa implements the Hotel interface
class Villa implements Hotel {
    @Override
    public void book() {
        System.out.println("You are booking a Villa");
    }
}

// Define an interface BookingFactory with a method createBooking()
interface BookingFactory {
    Hotel createBooking();
}

// SuiteFactory implements BookingFactory to create Suite bookings
class SuiteFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Suite();
    }
}

// DeluxeFactory implements BookingFactory to create Deluxe bookings
class DeluxeFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Deluxe();
    }
}

// VillaFactory implements BookingFactory to create Villa bookings
class VillaFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Villa();
    }
}

// Main class Booking for testing
public class Booking {
    public static void main(String[] arg) {
        // Create instances of the booking factories
        BookingFactory villaFactory = new VillaFactory();
        BookingFactory deluxeFactory = new DeluxeFactory();
        BookingFactory suiteFactory = new SuiteFactory();

        // Use the factories to create specific Hotel instances
        Hotel villa = villaFactory.createBooking();
        Hotel deluxe = deluxeFactory.createBooking();
        Hotel suite = suiteFactory.createBooking();

        // Perform booking actions on each hotel instance
        villa.book();
        deluxe.book();
        suite.book();
    }
}
