// LSP PROPERTY RULE — VIOLATED

class BankAccount {
    protected double balance;

    BankAccount(double balance) { this.balance = balance; }

    // Class Invariant: balance must never be negative
    void withdraw(double amount) {
        if (amount > balance) { System.out.println("Insufficient funds"); return; }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }
}

class BrokenAccount extends BankAccount {
    BrokenAccount(double balance) { super(balance); }

    // VIOLATION 1 — Class Invariant broken: allows negative balance
    @Override
    void withdraw(double amount) {
        balance -= amount; // no check — balance can go negative
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }

    // VIOLATION 2 — History Constraint: parent never allowed direct balance set
    // subclass adds mutation parent never intended
    void setBalance(double balance) {
        this.balance = balance; // parent never allowed this
        System.out.println("Balance forcefully set to $" + balance);
    }
}

public class Property_violated {
    public static void main(String[] args) {
        BankAccount acc = new BrokenAccount(100);
        acc.withdraw(500); // balance goes negative — invariant broken
        System.out.println("Final balance: $" + acc.balance);

        BrokenAccount broken = new BrokenAccount(100);
        broken.setBalance(-9999); // history constraint broken
        System.out.println("Forced balance: $" + broken.balance);
    }
}