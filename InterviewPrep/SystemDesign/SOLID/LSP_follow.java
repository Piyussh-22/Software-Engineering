// LSP FIXED — Separate hierarchies based on actual capabilities

// Base class with only what ALL accounts can do
class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " | Balance: $" + balance);
    }
}

// Only accounts that CAN withdraw extend this
class WithdrawableAccount extends Account {
    WithdrawableAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void withdraw(double amount) {
        if (amount > balance) { System.out.println("Insufficient funds"); return; }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }
}

class SavingsAccount extends WithdrawableAccount {
    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }
}

// Fixed deposit only deposits — extends base Account, not WithdrawableAccount
class FixedDepositAccount extends Account {
    FixedDepositAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }
}

public class LSP_follow {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount("Rahul", 5000);
        savings.deposit(1000);
        savings.withdraw(500);  // works fine

        FixedDepositAccount fd = new FixedDepositAccount("Priya", 10000);
        fd.deposit(2000);       // works fine
        // fd.withdraw()        // doesn't exist — no broken promise

        // Every subclass fully honours its parent's contract — LSP satisfied
    }
}