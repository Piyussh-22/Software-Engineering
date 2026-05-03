// ACCESS MODIFIERS — Control who can access fields and methods

class Employee {
    public String name;        // accessible everywhere
    protected double salary;   // accessible in same package + subclasses
    private String password;   // accessible only within this class

    Employee(String name, double salary, String password) {
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    // private data exposed via controlled public method
    public String getPassword() { return password; }
}

class Manager extends Employee {
    Manager(String name, double salary, String password) {
        super(name, salary, password);
    }

    void showDetails() {
        System.out.println("Name: " + name);       // public    — accessible
        System.out.println("Salary: " + salary);   // protected — accessible in subclass
        // System.out.println(password);            // private   — NOT accessible, compile error
        System.out.println("Password: " + getPassword()); // access via public method
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Manager mgr = new Manager("Priya", 120000, "pass123");

        System.out.println(mgr.name);           // public    — accessible
        // System.out.println(mgr.salary);      // protected — accessible here because same package
        // would fail from a different package
        //System.out.println(mgr.password);    // private   — not accessible

        mgr.showDetails();
    }
}

// SUMMARY
// public    → accessible everywhere
// protected → accessible in same package + subclasses
// private   → accessible only inside the class
// 99% of inheritance is public — private and protected inheritance is rare