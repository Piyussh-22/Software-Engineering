// File: Encapsulation.java

/*
ENCAPSULATION
- bundle data and methods in one unit
- restrict direct access using private
- access data through controlled methods

WHY
- protects data from invalid updates
- keeps control over how data changes
- improves maintainability
*/

class BankAccount {

    private String holder;
    private double balance;

    BankAccount(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    // read access
    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    // controlled write operations
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " | Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Rahul", 1000);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000);
        acc.deposit(-100);

        // acc.balance = 99999;  not allowed, private field
    }
}

/*
- fields are private to prevent direct access
- getters provide read access
- methods like deposit and withdraw control updates
- validation ensures correct state
- encapsulation protects and manages data safely
*/