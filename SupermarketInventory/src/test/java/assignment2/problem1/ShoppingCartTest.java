package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

  private ShoppingCart shoppingCart;
  private Cheese cheese;

  @BeforeAll
  static void beforeAll() {
    Product cheese = new Cheese("M1","P1",10,5);
    Inventory.getInstance().addStock(cheese,10);
  }

  @AfterAll
  static void afterAll() {
    Product cheese = new Cheese("M1","P1",10,5);
    Inventory.getInstance().removeStock(cheese);
  }

  @BeforeEach
  void setUp() {
    shoppingCart = new ShoppingCart();
    cheese = new Cheese("M1","P1",10,5);
  }

  @Test
  void addProduct() {
    shoppingCart.addProduct(cheese);
    Assertions.assertEquals(10,shoppingCart.getTotalPrice());
  }

  @Test
  void testAddProduct() {
    shoppingCart.addProduct(cheese,5);
    Assertions.assertEquals(50,shoppingCart.getTotalPrice());
  }

  /**
   * Testcase to verify the scenario where customer is trying to add more items than in stock
   */
  @Test
  void testAddProductMore() {
    shoppingCart.addProduct(cheese,50);
    Assertions.assertEquals(0,shoppingCart.getTotalPrice());
  }

  @Test
  void removeProduct() {
    shoppingCart.addProduct(cheese,5);
    shoppingCart.removeProduct(cheese);
    Assertions.assertEquals(0,shoppingCart.getCartItemsMap().size());
  }

  @Test
  void increaseQuantity() {
    shoppingCart.addProduct(cheese,5);
    shoppingCart.increaseQuantity(cheese,5);
    Assertions.assertEquals(100,shoppingCart.getTotalPrice());
  }

  /**
   * trying to increase quantity for a product that is not in shopping card
   */
  @Test
  void increaseQuantityInvalidItem() {
    shoppingCart.increaseQuantity(cheese,5);
    Assertions.assertEquals(0,shoppingCart.getTotalPrice());
  }

  /**
   * trying to increase quantity for a product with quantity more than available in stock
   */
  @Test
  void increaseQuantityMore() {
    shoppingCart.addProduct(cheese,5);
    shoppingCart.increaseQuantity(cheese,25);
    Assertions.assertEquals(50,shoppingCart.getTotalPrice());
  }

  @Test
  void decreaseQuantity() {
    shoppingCart.addProduct(cheese,5);
    shoppingCart.decreaseQuantity(cheese,3);
    Assertions.assertEquals(20,shoppingCart.getTotalPrice());
  }

  /**
   * trying to decrease quantity for a product that is not in shopping card
   */
  @Test
  void decreaseQuantityInvalidItem() {
    shoppingCart.decreaseQuantity(cheese,5);
    Assertions.assertEquals(0,shoppingCart.getTotalPrice());
  }

  @Test
  void getTotalPrice() {
    shoppingCart.addProduct(cheese,5);
    Assertions.assertEquals(50,shoppingCart.getTotalPrice());
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,shoppingCart.equals(null));
  }

  @Test
  void testToString(){
    shoppingCart.addProduct(cheese);
    Assertions.assertNotEquals("Test",shoppingCart.toString());
  }

  @Test
  void testHashCodeItemsNull() {
    shoppingCart.setCartItemsMap(null);
    Assertions.assertNotEquals(100,shoppingCart.hashCode());
  }
}