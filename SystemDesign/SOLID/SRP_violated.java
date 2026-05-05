// SINGLE RESPONSIBILITY PRINCIPLE (SRP)
// A class should have only one reason to change

// SRP VIOLATED — One class doing multiple jobs

class CartItem {
    String itemName;
    int quantity;
    double price;

    CartItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Job 1: Business logic
    double calculateTotal() {
        return quantity * price;
    }

    // Job 2: Presentation
    void printInvoice() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: $" + calculateTotal());
    }

    // Job 3: Persistence
    void saveToDB() {
        System.out.println("Saving " + itemName + " to database...");
    }
}

public class SRP_violated {
    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 2, 800);

        item.printInvoice();   // presentation
        item.saveToDB();       // persistence
    }
}