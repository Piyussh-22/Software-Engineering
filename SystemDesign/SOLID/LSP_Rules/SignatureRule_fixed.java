// LSP SIGNATURE RULE — FIXED

class Animal {
    Animal create() { return new Animal(); }
    void makeSound(Animal a) { System.out.println("Animal sound"); }
    void run() throws IllegalStateException { System.out.println("Animal running"); }
}

class Dog extends Animal {

    // FIXED 1 — return type is more specific (Dog is a subtype of Animal) — covariance
    @Override
    Dog create() { return new Dog(); }

    // FIXED 2 — accepts same type as parent (Animal) — no unsafe narrowing
    @Override
    void makeSound(Animal a) {
        System.out.println("Dog barking");
    }

    // FIXED 3 — throws same or more specific exception than parent
    @Override
    void run() throws IllegalStateException {
        System.out.println("Dog running fast");
    }
}

public class SignatureRule_fixed {
    public static void main(String[] args) {
        Animal a = new Dog();

        try {
            a.run();                    // works — Dog substitutes Animal perfectly
            a.makeSound(new Animal());  // works — no unsafe cast
            Animal created = a.create(); // works — Dog returned, stored as Animal
            System.out.println("Created: " + created.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}