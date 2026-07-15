// OPEN CLOSE PRINCIPLE OCP
// open for extension, closed for modification

// follow - extend behavior without modifying existing code 

interface InvoiceRepository{
  void save(Item item);
}

class Item {
  String name;
  int quantity;
  double price;

  Item(String name, int quantity, double price){
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  double calculateTotal(){
    return price*quantity;
  }
}

class MySQLInvoiceRepository implements InvoiceRepository{
  public void save(Item item){
    System.out.println("Saving item to mysql");
  }
}

class MongoInvoiceRepository implements InvoiceRepository{
  public void save(Item item){
    System.out.println("Saving item to mongo");
  }
}

class InvoiceService{
  private Item item;
  private InvoiceRepository repository;

  InvoiceService(Item item, InvoiceRepository repository){
    this.item = item;
    this.repository = repository;
  }

  void saveInvoice(){
    repository.save(item);
  }
}

public class OCP_follow {
  public static void main(String[] args) {
    Item item = new Item("laptop",2,800);
    new InvoiceService(item, new MySQLInvoiceRepository()).saveInvoice();
    new InvoiceService(item, new MongoInvoiceRepository()).saveInvoice();

    // Adding Postgres → create new class, no modification needed
  }
}
