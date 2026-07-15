// LSP PROPERTY RULE — FIXED

class BankAccount {
    protected double balance;

    BankAccount(double balance) { this.balance = balance; }

    // Class Invariant: balance must never go negative
    void withdraw(double amount) {
        if (amount > balance) { System.out.println("Insufficient funds"); return; }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(double balance) { super(balance); }

    // FIXED 1 — Invariant preserved: still checks before withdrawing
    @Override
    void withdraw(double amount) {
        if (amount > balance) { System.out.println("Insufficient funds"); return; }
        balance -= amount;
        System.out.println("Savings withdrawn $" + amount + " | Balance: $" + balance);
    }
    // No setBalance() — history constraint respected, parent never allowed it
}

public class Property_fixed {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount(100);
        acc.withdraw(500); // rejected — invariant preserved
        acc.withdraw(50);  // works fine
        System.out.println("Final balance: $" + acc.balance); // never negative
    }
}