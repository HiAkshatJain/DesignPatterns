import java.util.*;

// Define the Observer interface
interface Observer {
    void update(Stock stock);  // Method to be called when the observed object changes
}

// Investor class implements Observer
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Investor " + name + ": Stock " + stock.getSymbol() + " is now $" + stock.getPrice() + ".");
    }
}

// StockExchange class implements Observer
class StockExchange implements Observer {
    private String exchangeName;

    public StockExchange(String name) {
        this.exchangeName = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Stock Exchange " + exchangeName + ": Stock " + stock.getSymbol() + " is now $" + stock.getPrice() + ".");
    }
}

// Broker class implements Observer
class Broker implements Observer {
    private String brokerName;

    public Broker(String name) {
        this.brokerName = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Broker " + brokerName + ": Stock " + stock.getSymbol() + " is now $" + stock.getPrice() + ".");
    }
}

// Stock class manages a list of observers and notifies them of price changes
class Stock {
    private String symbol;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;  // Update the price of the stock
        notifyObservers();  // Notify all observers about the price change
    }

    public void attach(Observer observer) {
        observers.add(observer);  // Add an observer to the list
    }

    public void detach(Observer observer) {
        observers.remove(observer);  // Remove an observer from the list
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);  // Notify each observer of the change
        }
    }
}

public class StockMarket {
    public static void main(String[] args) {
        // Create a stock with a symbol and initial price
        Stock stock1 = new Stock("AAPL", 150.00);

        // Create different observers
        Investor investor1 = new Investor("Alice");
        StockExchange exchange1 = new StockExchange("NYSE");
        Broker broker1 = new Broker("Bob");

        // Attach observers to the stock
        stock1.attach(investor1);
        stock1.attach(exchange1);
        stock1.attach(broker1);

        // Simulate stock price updates
        stock1.setPrice(155.00);  // Notify observers about the price change

        // Detach an observer (if needed)
        stock1.detach(broker1);

        // Simulate more stock price updates
        stock1.setPrice(160.00);  // Notify remaining observers about the price change
    }
}
