interface Hotel {
    void book ();
}

class Suite implements Hotel {
    @Override
    public void book(){
        System.out.println("You are booking a Suite");
    }
}

class Deluxe implements Hotel {
    @Override
    public void book(){
        System.out.println("You are booking a Deluxe");
    }
}

class Villa implements Hotel {
    @Override
    public void book() {
        System.out.println("You are booking a Villa");
    }
}

interface BookingFactory {
    Hotel createBooking();
}

class SuiteFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Suite();
    }
}

class DeluxeFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Deluxe();
    }
}

class VillaFactory implements BookingFactory {
    @Override
    public Hotel createBooking() {
        return new Villa();
    }
}

public class Booking {
    public static void main(String[] arg) {
        BookingFactory villaFactory = new VillaFactory();
        BookingFactory deluxeFactory = new DeluxeFactory();
        BookingFactory suiteFactory = new SuiteFactory();

        Hotel villa = villaFactory.createBooking();
        Hotel deluxe = deluxeFactory.createBooking();
        Hotel suite = suiteFactory.createBooking();

        villa.book();
        deluxe.book();
        suite.book();

    }
}








