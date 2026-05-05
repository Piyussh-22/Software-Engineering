// LSP VIOLATED — Subclass cannot fully substitute parent class

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

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " | Balance: $" + balance);
    }
}

class FixedDepositAccount extends Account {
    FixedDepositAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void withdraw(double amount) {
        // Fixed deposit cannot withdraw — breaks the parent's contract
        throw new UnsupportedOperationException("Cannot withdraw from Fixed Deposit!");
    }
}

public class LSP_violated {
    public static void main(String[] args) {
        Account acc = new FixedDepositAccount("Rahul", 5000);
        acc.deposit(1000);
        acc.withdraw(500); // crashes — LSP violated
        // FixedDepositAccount cannot substitute Account
    }
}