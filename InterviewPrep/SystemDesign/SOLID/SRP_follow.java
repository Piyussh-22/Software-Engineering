// SINGLE RESPONSIBILITY PRINCIPLE (SRP)
// A class should have only one reason to change

// SRP FOLLOWED — Each class has one job

class CartItem {
    String itemName;
    int quantity;
    double price;

    CartItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Only job: Business logic
    double calculateTotal() {
        return quantity * price;
    }
}

// Only job: Presentation
class InvoicePrinter {
    void print(CartItem item) {
        System.out.println("Item: " + item.itemName);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Total: $" + item.calculateTotal());
    }
}

// Only job: Persistence
class InvoiceDao {
    void save(CartItem item) {
        System.out.println("Saving " + item.itemName + " to database...");
    }
}

public class SRP_follow {
    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 2, 800);

        new InvoicePrinter().print(item); // presentation
        new InvoiceDao().save(item);      // persistence
    }
}