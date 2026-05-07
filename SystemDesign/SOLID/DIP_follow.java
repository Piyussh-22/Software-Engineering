// DIP FIXED — Both high-level and low-level depend on abstraction

// Abstraction — neither OrderService nor DB classes change this
interface OrderDao {
    void save(String data);
}

// Low-level modules implement the abstraction
class MySQLDao implements OrderDao {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class MongoDao implements OrderDao {
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

// High-level module depends on abstraction — not on any concrete class
class OrderService {
    private OrderDao dao; // depends on interface

    // Dependency injected from outside — not created inside
    OrderService(OrderDao dao) { this.dao = dao; }

    void placeOrder(String item) {
        System.out.println("Order placed: " + item);
        dao.save(item);
    }
}

public class DIP_follow {
    public static void main(String[] args) {

        // Inject MySQL
        OrderService service = new OrderService(new MySQLDao());
        service.placeOrder("Laptop");

        // Switch to Mongo — OrderService never changes
        OrderService service2 = new OrderService(new MongoDao());
        service2.placeOrder("Phone");
    }
}