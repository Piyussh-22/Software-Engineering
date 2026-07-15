// OPEN CLOSE PRINCIPLE (OCP)
// open for extension, closed for modification
// violated - modifying class for every new storage type;

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
    return price * quantity;
  }

  @Override
    public String toString() {
        return name + " x " + quantity + " ($" + calculateTotal() + ")";
    }
}

class InvoiceService{
  private Item item;
  private String storageType;

  InvoiceService(Item item, String storageType){
    this.item = item;
    this.storageType = storageType;
  }

  // problem must modify for every new storage type
  void saveInvoice(){
    if(storageType.equals("mysql")){
      System.out.println(" Saving " + item + " to mysql...");
    }else if(storageType.equals("mongo")){
      System.out.println(" Saving " + item + " to mongoDB");
    }
    // adding postgres → modify here again
  }

}

public class OCP_violated {
  public static void main(String[] args) {
    Item item = new Item("laptop",2 , 800);
    new InvoiceService(item, "mysql").saveInvoice();
    new InvoiceService(item, "mongo").saveInvoice();
    new InvoiceService(item, "monogo").saveInvoice();
  }
}
