// DIP VIOLATED — High-level module depends directly on low-level module

class MySQLDao {
    void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

// High-level module directly depends on low-level MySQLDao
class OrderService {
    private MySQLDao dao = new MySQLDao(); // tightly coupled

    void placeOrder(String item) {
        System.out.println("Order placed: " + item);
        dao.save(item); // directly tied to MySQL
        // to switch to MongoDB — must edit OrderService itself
    }
}

public class DIP_violated {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.placeOrder("Laptop");
    }
}