// LSP METHOD RULE — VIOLATED (Pre-conditions and Post-conditions)

class Discount {
    // Pre-condition: amount must be > 0
    // Post-condition: returned value must be <= amount
    double apply(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        return amount * 0.9; // 10% discount — always less than input
    }
}

class StrictDiscount extends Discount {
    // VIOLATION 1 — Pre-condition strengthened: now requires amount > 100
    // callers written for parent pass any amount > 0 — now breaks
    @Override
    double apply(double amount) {
        if (amount <= 100) throw new IllegalArgumentException("Amount must be > 100"); // stricter
        return amount * 0.8;
    }
}

class BrokenDiscount extends Discount {
    // VIOLATION 2 — Post-condition weakened: can return MORE than input
    @Override
    double apply(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        return amount * 1.5; // returns MORE than input — caller expects discount, gets surcharge
    }
}

public class Method_violated {
    public static void main(String[] args) {
        Discount d = new StrictDiscount();
        System.out.println(d.apply(50)); // crashes — pre-condition tightened

        Discount b = new BrokenDiscount();
        System.out.println(b.apply(100)); // returns 150 — post-condition broken
    }
}