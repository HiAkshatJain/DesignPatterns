// Class representing a Fast Food Meal
class Meal {
    private String burger;
    private String fries;
    private String drink;
    private String dessert;

    // Displays the meal specifications
    public void display() {
        System.out.println("Meal Specs:");
        System.out.println("Burger: " + burger);
        System.out.println("Fries: " + fries);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
    }

    // Getter and Setter methods for burger
    public String getBurger() {
        return burger;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    // Getter and Setter methods for fries
    public String getFries() {
        return fries;
    }

    public void setFries(String fries) {
        this.fries = fries;
    }

    // Getter and Setter methods for drink
    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    // Getter and Setter methods for dessert
    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}

// Abstract builder class for creating different parts of a meal
abstract class MealBuilder {
    protected Meal meal = new Meal();

    // Abstract methods to build different components of the meal
    public abstract void buildBurger();
    public abstract void buildFries();
    public abstract void buildDrink();
    public abstract void buildDessert();

    // Returns the constructed meal
    public Meal getMeal() {
        return meal;
    }
}

// Concrete builder for creating a "Burger King" meal
class BurgerKingMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("Whopper");
    }

    @Override
    public void buildFries() {
        meal.setFries("Large Fries");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coca-Cola");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Apple Pie");
    }
}

// Concrete builder for creating a "McDonald's" meal
class McDonaldsMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("Big Mac");
    }

    @Override
    public void buildFries() {
        meal.setFries("Medium Fries");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Sprite");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("McFlurry");
    }
}

// Director class that constructs the meal using a builder
class MealDirector {
    public Meal buildMeal(MealBuilder builder) {
        builder.buildBurger();
        builder.buildFries();
        builder.buildDrink();
        builder.buildDessert();
        return builder.getMeal();
    }
}

// Demo class to show the usage of the Builder pattern for creating meals
class MealBuilderDemo {
    public static void main(String[] args) {
        // Director
        MealDirector director = new MealDirector();

        // Build a Burger King meal
        MealBuilder burgerKingBuilder = new BurgerKingMealBuilder();
        Meal burgerKingMeal = director.buildMeal(burgerKingBuilder);

        // Build a McDonald's meal
        MealBuilder mcDonaldsBuilder = new McDonaldsMealBuilder();
        Meal mcDonaldsMeal = director.buildMeal(mcDonaldsBuilder);

        // Display Meal specifications
        burgerKingMeal.display();
        mcDonaldsMeal.display();
    }
}
