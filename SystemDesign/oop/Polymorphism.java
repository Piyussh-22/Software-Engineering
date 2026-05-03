// POLYMORPHISM — Same method name, different behavior
// Two types: Static (overloading) and Dynamic (overriding)

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    // STATIC POLYMORPHISM — overloading
    // Same method name, different parameters — resolved at compile time
    void work() {
        System.out.println(name + " is working");
    }

    void work(String task) {
        System.out.println(name + " is working on " + task);
    }

    void work(String task, int hours) {
        System.out.println(name + " is working on " + task + " for " + hours + " hours");
    }
}

class Developer extends Employee {
    Developer(String name) { super(name); }

    // DYNAMIC POLYMORPHISM — overriding
    // Child redefines parent method — resolved at runtime
    @Override
    void work() {
        System.out.println(name + " is writing code");
    }
}

class Manager extends Employee {
    Manager(String name) { super(name); }

    @Override
    void work() {
        System.out.println(name + " is managing the team");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        System.out.println("=== Static Polymorphism (Overloading) ===");
        Developer dev = new Developer("Rahul");
        dev.work();                        // calls work()
        dev.work("LLD notes");             // calls work(String task)
        dev.work("System Design", 3);      // calls work(String task, int hours)
        // Java picks the right one based on arguments — compile time decision

        System.out.println();

        System.out.println("=== Dynamic Polymorphism (Overriding) ===");
        // Parent reference, child object — runtime decides which work() to call
        Employee e1 = new Developer("Rahul");
        Employee e2 = new Manager("Priya");

        e1.work(); // calls Developer's work() — not Employee's
        e2.work(); // calls Manager's work()   — not Employee's

        // In C++ you need 'virtual' keyword for this
        // In Java all methods are virtual by default — no keyword needed
    }
}
