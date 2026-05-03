// INHERITANCE — Child class acquires properties and methods of parent class
// 99% of the time we use public inheritance

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void work() {
        System.out.println(name + " is working");
    }

    void showDetails() {
        System.out.println("Name: " + name + " | Salary: $" + salary);
    }
}

// Developer inherits name, salary, work(), showDetails() from Employee
class Developer extends Employee {
    String language;

    Developer(String name, double salary, String language) {
        super(name, salary); // calling parent constructor
        this.language = language;
    }

    void code() {
        System.out.println(name + " is coding in " + language);
    }
}

// Manager also inherits everything from Employee and adds its own
class Manager extends Employee {
    int teamSize;

    Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    void manage() {
        System.out.println(name + " is managing a team of " + teamSize);
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Developer dev = new Developer("Rahul", 80000, "Java");
        dev.showDetails();  // inherited from Employee
        dev.work();         // inherited from Employee
        dev.code();         // Developer's own method

        System.out.println();

        Manager mgr = new Manager("Priya", 120000, 10);
        mgr.showDetails();  // inherited from Employee
        mgr.work();         // inherited from Employee
        mgr.manage();       // Manager's own method
    }
}
