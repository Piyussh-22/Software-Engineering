interface PaymentStrategy {

    void pay(int amount);
}


class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}


class CardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}


class CashPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}


class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}


public class StrategyPatternDemo {

    public static void main(String[] args) {

        PaymentService payment1 =
                new PaymentService(new UpiPayment());

        payment1.makePayment(1000);

        System.out.println();

        PaymentService payment2 =
                new PaymentService(new CardPayment());

        payment2.makePayment(2500);

        System.out.println();

        PaymentService payment3 =
                new PaymentService(new CashPayment());

        payment3.makePayment(500);
    }
}


/*
==========================================================
NOTES
==========================================================

PaymentStrategy Interface
-------------------------
- Defines a common contract for every payment method.
- Think of it as a rulebook that every payment method must follow.

void pay(int amount)
--------------------
- Declares the payment operation that every strategy must implement.
- No matter how you pay, everyone must know how to perform a payment.

UpiPayment
----------
- Concrete implementation of PaymentStrategy for UPI payments.
- Contains the payment logic for UPI.

CardPayment
-----------
- Concrete implementation of PaymentStrategy for Card payments.
- Contains the payment logic for Credit Card payments.

CashPayment
-----------
- Concrete implementation of PaymentStrategy for Cash payments.
- Contains the payment logic for Cash payments.

@Override
----------
- Indicates that the interface method is being implemented.
- Helps the compiler verify that the correct method is overridden.

System.out.println(...)
-----------------------
- Prints the payment message on the console.
- Used here to simulate a successful payment.

PaymentService
--------------
- Uses a PaymentStrategy to perform payments.
- Think of it as a cashier who asks someone else to process the payment instead of doing it personally.

private PaymentStrategy paymentStrategy;
----------------------------------------
- Stores a reference to the PaymentStrategy interface.
- Like keeping a universal remote that can work with different compatible devices.

PaymentService(PaymentStrategy paymentStrategy)
-----------------------------------------------
- Receives the required payment strategy through the constructor.
- The client decides which payment method should be used.

this.paymentStrategy = paymentStrategy;
---------------------------------------
- Stores the received strategy inside the object.
- Saves the selected payment method for later use.

makePayment(int amount)
-----------------------
- Requests the selected strategy to perform the payment.
- PaymentService simply forwards the work without knowing the payment details.

paymentStrategy.pay(amount);
----------------------------
- Calls the pay() method of the selected strategy.
- Pressing the same "Pay" button gives different results depending on the selected payment method.

StrategyPatternDemo
-------------------
- Demonstrates how the Strategy Pattern works.
- Acts as the client that selects different payment methods.

PaymentService payment1 =
new PaymentService(new UpiPayment());
------------------------------------
- Creates a PaymentService using the UPI strategy.
- The client selects UPI before making the payment.

payment1.makePayment(1000);
---------------------------
- Makes a payment of ₹1000.
- Since UPI was selected, the UPI payment logic executes.

PaymentService payment2 =
new PaymentService(new CardPayment());
-------------------------------------
- Creates a PaymentService using the Card strategy.
- Only the strategy object changes; PaymentService remains unchanged.

payment2.makePayment(2500);
---------------------------
- Makes a payment of ₹2500.
- Card payment logic executes automatically.

PaymentService payment3 =
new PaymentService(new CashPayment());
-------------------------------------
- Creates a PaymentService using the Cash strategy.
- Easily switches to another payment method without modifying PaymentService.

payment3.makePayment(500);
--------------------------
- Makes a payment of ₹500.
- Cash payment logic executes automatically.

Strategy Pattern
----------------
- Encapsulates different algorithms into separate classes and lets the client choose one at runtime.
- Instead of changing PaymentService whenever a new payment method is added, we simply plug in a new strategy.

==========================================================
*/