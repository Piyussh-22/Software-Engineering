class PaymentService {

    public void makePayment(String paymentType, int amount) {

        if (paymentType.equalsIgnoreCase("UPI")) {
            System.out.println("Paid ₹" + amount + " using UPI");
        } else if (paymentType.equalsIgnoreCase("CARD")) {
            System.out.println("Paid ₹" + amount + " using Credit Card");
        } else if (paymentType.equalsIgnoreCase("CASH")) {
            System.out.println("Paid ₹" + amount + " using Cash");
        } else {
            System.out.println("Invalid Payment Method");
        }
    }
}

public class WithoutSP {

    public static void main(String[] args) {

        PaymentService payment = new PaymentService();

        payment.makePayment("UPI", 1000);
        payment.makePayment("CARD", 2500);
        payment.makePayment("CASH", 500);
    }
}

/*

=================== Why is this design bad? ===================

1. PaymentService knows every payment method.

Today:
UPI
CARD
CASH

Tomorrow if we add:
NET BANKING
PAYPAL
WALLET

we must modify this class.

---------------------------------------------------------------

2. Large if-else chain.

As payment methods increase,
this method becomes longer and harder to maintain.

if(...)
else if(...)
else if(...)
else if(...)
...

---------------------------------------------------------------

3. Violates Open/Closed Principle.

For every new payment method,
existing code must be modified.

Example:

else if(paymentType.equalsIgnoreCase("PAYPAL")) {
    ...
}

A tested class keeps changing.

---------------------------------------------------------------

4. Violates Single Responsibility Principle.

PaymentService is doing two jobs:

• Deciding which payment method to use.
• Performing the payment.

One class should have only one responsibility.

---------------------------------------------------------------

5. Tight Coupling.

PaymentService is directly connected
to every payment algorithm.

Any payment-related change requires
modifying PaymentService.

================== How Strategy Pattern fixes it ==================

Instead of writing:

if(type == "UPI")
else if(type == "CARD")
else if(type == "CASH")

Create:

PaymentStrategy
        │
        ├── UpiPayment
        ├── CardPayment
        └── CashPayment

Then PaymentService simply does:

paymentStrategy.pay(amount);

PaymentService no longer knows
HOW payment is made.

It simply delegates the work to the selected strategy.

*/