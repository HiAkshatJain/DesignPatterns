// Abstract base class representing a prototype for shapes
abstract class ShapePrototype {
    public abstract ShapePrototype clone();
    public abstract void draw();
}

// Concrete prototype class representing a shape
class Circle extends ShapePrototype {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public ShapePrototype clone() {
        return new Circle(this.radius);
    }

    @Override
    public void draw() {
        System.out.println("Circle with radius " + radius + " drawn");
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // Create prototype instances of shapes
        ShapePrototype circle1 = new Circle(30);
        ShapePrototype circle2 = new Circle(50);

        // Clone the prototypes to create new shape instances
        ShapePrototype newCircle1 = circle1.clone();
        ShapePrototype newCircle2 = circle2.clone();

        System.out.println("Original Shapes:");
        circle1.draw();
        circle2.draw();

        System.out.println("\nCloned Shapes:");
        newCircle1.draw();
        newCircle2.draw();
    }
}
