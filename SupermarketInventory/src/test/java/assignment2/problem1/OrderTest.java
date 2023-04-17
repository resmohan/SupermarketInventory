package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

  private Order order;
  @BeforeEach
  void setUp() {
    order = new Order(new Customer(new Name("John","Mathew"),20), new ShoppingCart());
  }

  /**
   * Creating an order instance and processing it with sample data
   */
  @Test
  void processOrder() {
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

    Assertions.assertEquals(34d,receipt.getTotalPrice());

    //resetting all
    inventory.removeStock(cheese1);
    inventory.removeStock(cheese2);
    inventory.removeStock(cheese3);
    inventory.removeStock(paperTowel1);
    inventory.removeStock(beer1);
  }

  @Test
  void getCustomer() {
    order.setCustomer(new Customer(new Name("John1","Mathew1"),21));
    Assertions.assertEquals(new Customer(new Name("John1","Mathew1"),21), order.getCustomer());
  }

  @Test
  void getShoppingCart() {
    ShoppingCart sc = new ShoppingCart();
    order.setShoppingCart(sc);
    Assertions.assertEquals(sc,order.getShoppingCart());
  }

  @Test
  void testEquals() {
    Order order1 = new Order(new Customer(new Name("John","Mathew"),20), new ShoppingCart());
    Assertions.assertEquals(true, order1.equals(order));
  }

  @Test
  void testEqualsSame() {
    Assertions.assertEquals(true,order.equals(order));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,order.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,order.hashCode());
  }

  @Test
  void testHashCodeOrderNull() {
    order.setCustomer(null);
    Assertions.assertNotEquals(100,order.hashCode());
  }

  @Test
  void testHashCodeCartNull() {
    order.setShoppingCart(null);
    Assertions.assertNotEquals(100,order.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",order.toString());
  }
}