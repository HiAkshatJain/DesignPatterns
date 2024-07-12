// Class representing a Fast Food Meal
class Meal {
    String burger;
    String fries;
    String drink;
    String dessert;

    void display() {
        System.out.println("Meal Specs:");
        System.out.println("Burger: " + burger);
        System.out.println("Fries: " + fries);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
    }
}

// Abstract builder class for creating different parts of a meal
abstract class MealBuilder {
    protected Meal meal;

    // Abstract methods to build different components of the meal
    abstract MealBuilder buildBurger();
    abstract MealBuilder buildFries();
    abstract MealBuilder buildDrink();
    abstract MealBuilder buildDessert();

    // Final build method to get the constructed meal
    Meal build() {
        return meal;
    }
}

// Builder for creating a "Burger King" meal
class BurgerKingMealBuilder extends MealBuilder {
    BurgerKingMealBuilder() {
        meal = new Meal();
    }

    @Override
    MealBuilder buildBurger() {
        meal.burger = "Whopper";
        return this;
    }

    @Override
    MealBuilder buildFries() {
        meal.fries = "Large Fries";
        return this;
    }

    @Override
    MealBuilder buildDrink() {
        meal.drink = "Coca-Cola";
        return this;
    }

    @Override
    MealBuilder buildDessert() {
        meal.dessert = "Apple Pie";
        return this;
    }
}

// Builder for creating a "McDonald's" meal
class McDonaldsMealBuilder extends MealBuilder {
    McDonaldsMealBuilder() {
        meal = new Meal();
    }

    @Override
    MealBuilder buildBurger() {
        meal.burger = "Big Mac";
        return this;
    }

    @Override
    MealBuilder buildFries() {
        meal.fries = "Medium Fries";
        return this;
    }

    @Override
    MealBuilder buildDrink() {
        meal.drink = "Sprite";
        return this;
    }

    @Override
    MealBuilder buildDessert() {
        meal.dessert = "McFlurry";
        return this;
    }
}

// Director class that constructs the meal using a builder
class MealDirector {
    Meal buildMeal(MealBuilder builder) {
        return builder.buildBurger().buildFries().buildDrink().buildDessert().build();
    }
}

// Main class to demonstrate the builder pattern with fast food meals
public class MealBuilderDemo {
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
