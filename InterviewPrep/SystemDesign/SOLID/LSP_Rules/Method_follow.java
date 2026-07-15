// LSP METHOD RULE — FIXED (Pre-conditions and Post-conditions)

class Discount {
    // Pre-condition: amount > 0
    // Post-condition: result <= amount (always a discount)
    double apply(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        return amount * 0.9; // 10% discount
    }
}

class PremiumDiscount extends Discount {
    // FIXED 1 — Pre-condition weakened: accepts amount >= 0 (more permissive than parent)
    // callers of parent always pass > 0, so they still work fine
    @Override
    double apply(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be >= 0");
        return amount * 0.7; // 30% discount — still a discount
    }
}

class LoyaltyDiscount extends Discount {
    // FIXED 2 — Post-condition strengthened: guarantees bigger discount than parent
    @Override
    double apply(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        return amount * 0.5; // 50% discount — stronger guarantee than parent's 10%
    }
}

public class Method_follow {
    public static void main(String[] args) {
        Discount d = new PremiumDiscount();
        System.out.println("Premium: $" + d.apply(100)); // works — 70.0

        Discount l = new LoyaltyDiscount();
        System.out.println("Loyalty: $" + l.apply(100)); // works — 50.0

        // Both subclasses fully substitute parent — LSP satisfied
    }
}