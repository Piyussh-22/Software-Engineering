// File: Abstraction.java

/*
ABSTRACTION
- hide how expose what
- achieved using abstract class and interface

ABSTRACT CLASS
- can have abstract and concrete methods
- used when classes are related
- cannot be instantiated

INTERFACE
- pure contract
- only method declarations (basic level)
- used for flexibility and loose coupling
*/

abstract class Shape {

    // contract: every shape must implement this
    abstract double area();

    // common behavior
    void display() {
        System.out.println("Area: " + area());
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

interface PaymentGateway {

    // contract: must implement payment
    void pay(double amount);
}

class Stripe implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Stripe processing: $" + amount);
    }
}

class PayPal implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("PayPal processing: $" + amount);
    }
}

public class Abstraction {

    public static void main(String[] args) {

        // runtime polymorphism
        // reference type shape, object type circle/rectangle

        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 5);

        c.display();
        r.display();

        // interface polymorphism
        // same reference different implementation

        PaymentGateway payment = new Stripe();
        payment.pay(500);

        payment = new PayPal();
        payment.pay(500);
    }
}

/*
- shape defines what, subclasses define how
- display calls area, actual method decided at runtime
- interface defines contract, implementations define behavior
- polymorphism allows same reference different behavior
- helps in loose coupling and scalability
*/