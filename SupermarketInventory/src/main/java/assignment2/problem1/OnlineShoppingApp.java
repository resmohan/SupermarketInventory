package assignment2.problem1;

/**
 * This is a test class to verify the integrated flow of this online shopping application
 * @author resmohan
 */
public class OnlineShoppingApp {

  /**
   * Main method to verify the flow
   * @param args main arguments
   */
  public static void main(String[] args) {
    Product cheese1 = new Cheese("Emmi Roth", "Mozarella Shred", 8d, 7);
    Product cheese2 = new Cheese("Cabot", "Cheddar Cheese", 12d, 6);
    Product cheese3 = new Cheese("Cabot", "Cheddar Cheese Shreded", 6d, 6);
    Product paperTowel1 = new PaperTowel("Presto", "Flex Paper Towels", 10, 6);
    Product beer1 = new Beer("Company", "Beer", 10, 6);

    Inventory inventory = Inventory.getInstance();
    inventory.addStock(cheese1, 10);
    inventory.addStock(cheese2, 3);
    inventory.addStock(cheese3, 5);
    inventory.addStock(paperTowel1, 30);
    inventory.addStock(beer1, 30);

    Customer customer1 = new Customer(new Name("Vani", "Gupta"),19);

    ShoppingCart shoppingCart = customer1.startShopping();
    shoppingCart.addProduct(paperTowel1);//adds properly
    shoppingCart.addProduct(cheese2,3);//available now; but later become out of stock; but will be replaced with cheese1
    shoppingCart.addProduct(cheese1,1500);//can't add this, as not enough quantity in stock
    shoppingCart.addProduct(cheese3,5);//becomes out of stock later and can't be replaced
    shoppingCart.addProduct(beer1,1);//age restriction

    inventory.reduceStock(cheese2,1);
    inventory.reduceStock(cheese3,4);

    Order order = new Order(customer1,shoppingCart);
    Receipt receipt = order.processOrder();
    //System.out.println("Receipt : "+receipt);

    //resetting all
    inventory.removeStock(cheese1);
    inventory.removeStock(cheese2);
    inventory.removeStock(cheese3);
    inventory.removeStock(paperTowel1);
    inventory.removeStock(beer1);
  }

  /**
   * gives the string representation of OnlineShoppingApp
   * @return string representation of OnlineShoppingApp
   */
  @Override
  public String toString() {
    return "OnlineShoppingApp{}";
  }
}
