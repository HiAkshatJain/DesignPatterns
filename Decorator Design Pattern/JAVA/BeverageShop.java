interface Beverage {
    String getDescription();
    double getPrice();
}

// Concrete component
class Coffee implements Beverage {
    public String getDescription() {
        return "Coffee";
    }

    public double getPrice() {
        return 50.0;
    }
}

// Concrete component
class Tea implements Beverage {
    public String getDescription() {
        return "Tea";
    }

    public double getPrice() {
        return 30.0;
    }
}

// Decorator interface
abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// Concrete decorator for adding milk
class MilkDecorator extends BeverageDecorator {
    private double milkPrice;

    public MilkDecorator(Beverage beverage, double price) {
        super(beverage);
        this.milkPrice = price;
    }

    public String getDescription() {
        return beverage.getDescription() + " with Milk";
    }

    public double getPrice() {
        return beverage.getPrice() + milkPrice;
    }
}

// Concrete decorator for adding sugar
class SugarDecorator extends BeverageDecorator {
    private double sugarPrice;

    public SugarDecorator(Beverage beverage, double price) {
        super(beverage);
        this.sugarPrice = price;
    }

    public String getDescription() {
        return beverage.getDescription() + " with Sugar";
    }

    public double getPrice() {
        return beverage.getPrice() + sugarPrice;
    }
}

// Concrete decorator for adding whipped cream
class WhippedCreamDecorator extends BeverageDecorator {
    private double whippedCreamPrice;

    public WhippedCreamDecorator(Beverage beverage, double price) {
        super(beverage);
        this.whippedCreamPrice = price;
    }

    public String getDescription() {
        return beverage.getDescription() + " with Whipped Cream";
    }

    public double getPrice() {
        return beverage.getPrice() + whippedCreamPrice;
    }
}

class BeverageShop {
    public static void main(String[] args) {
        // Order a Coffee and a Tea.
        Beverage coffeeOrder = new Coffee();
        Beverage teaOrder = new Tea();

        coffeeOrder = new MilkDecorator(coffeeOrder, 10.0);
        coffeeOrder = new SugarDecorator(coffeeOrder, 5.0);
        coffeeOrder = new WhippedCreamDecorator(coffeeOrder, 20.0);

        teaOrder = new MilkDecorator(teaOrder, 10.0);
        teaOrder = new SugarDecorator(teaOrder, 5.0);

        System.out.println("Description of coffee order: " + coffeeOrder.getDescription());
        System.out.println("Price of coffee order: " + coffeeOrder.getPrice());

        System.out.println("Description of tea order: " + teaOrder.getDescription());
        System.out.println("Price of tea order: " + teaOrder.getPrice());
    }
}