// LSP SIGNATURE RULE — VIOLATED

class Animal {
    Animal create() { return new Animal(); }                    // return type: Animal
    void makeSound(Animal a) { System.out.println("..."); }    // argument: Animal
    void run() throws Exception { System.out.println("Animal running"); }
}

class Dog extends Animal {

    // VIOLATION 1 — return type is broader (Object instead of Animal or Dog)
    @Override
    Object create() { return new Object(); }

    // VIOLATION 2 — argument is narrower (Dog instead of Animal)
    // forces caller to always pass Dog, not any Animal
    @Override
    void makeSound(Animal a) {
        Dog d = (Dog) a; // unsafe cast — crashes if anything other than Dog is passed
        System.out.println("Dog barking");
    }

    // VIOLATION 3 — throws broader exception than parent
    @Override
    void run() throws Exception {
        throw new Exception("Dog cannot run!"); // parent only declared Exception, but throwing unexpectedly
    }
}

public class SignatureRule_violated {
    public static void main(String[] args) {
        Animal a = new Dog();
        try {
            a.run(); // crashes — unexpected exception
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        a.makeSound(new Animal()); // crashes — unsafe Dog cast
    }
}