package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTest {

  private Receipt receipt;
  @BeforeEach
  void setUp() {
    List<Product> receivedProducts = new ArrayList<>();
    receivedProducts.add(new Cheese("Emmi Roth", "Mozarella Shred", 8d, 7));
    receipt = new Receipt(10d, receivedProducts, new ArrayList<>(), new ArrayList<>());
  }

  @Test
  void addReceivedProduct() {
    receipt.addReceivedProduct(new Beer("Company", "Beer", 10, 6));
    Assertions.assertEquals(2,receipt.getReceivedProducts().size());
  }

  @Test
  void addOutOfStockProduct() {
    receipt.addOutOfStockProduct(new Beer("Company", "Beer", 10, 6));
    Assertions.assertEquals(1,receipt.getOutOfStockProducts().size());
  }

  @Test
  void addRemovedProduct() {
    receipt.addRemovedProduct(new Beer("Company", "Beer", 10, 6));
    Assertions.assertEquals(1,receipt.getRemovedProducts().size());
  }

  @Test
  void addTotalPrice() {
    receipt.addTotalPrice(10);
    Assertions.assertEquals(20,receipt.getTotalPrice());
  }

  @Test
  void setTotalPrice() {
    receipt.setTotalPrice(25);
    Assertions.assertEquals(25,receipt.getTotalPrice());
  }

  @Test
  void setReceivedProducts() {
    receipt.setReceivedProducts(Arrays.asList(new PaperTowel("Presto", "Flex Paper Towels", 10, 6),
                                              new Beer("Company", "Beer", 10, 6)));
    Assertions.assertEquals(2,receipt.getReceivedProducts().size());
  }

  @Test
  void setOutOfStockProducts() {
    receipt.setOutOfStockProducts(Arrays.asList(new PaperTowel("Presto", "Flex Paper Towels", 10, 6),
        new Beer("Company", "Beer", 10, 6)));
    Assertions.assertEquals(2,receipt.getOutOfStockProducts().size());
  }

  @Test
  void setRemovedProducts() {
    receipt.setRemovedProducts(Arrays.asList(new PaperTowel("Presto", "Flex Paper Towels", 10, 6),
        new Beer("Company", "Beer", 10, 6)));
    Assertions.assertEquals(2,receipt.getRemovedProducts().size());
  }

  @Test
  void testEquals() {
    List<Product> receivedProducts = new ArrayList<>();
    receivedProducts.add(new Cheese("Emmi Roth", "Mozarella Shred", 8d, 7));
    Receipt receipt1 = new Receipt(10d, receivedProducts, new ArrayList<>(), null);
    receipt.setRemovedProducts(null);
    Assertions.assertEquals(true, receipt1.equals(receipt));
  }

  @Test
  void testEqualsSame() {
    Assertions.assertEquals(true,receipt.equals(receipt));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,receipt.equals(null));
  }

  @Test
  void testEqualsString() {
    Assertions.assertEquals(false,receipt.equals("null"));
  }

  @Test
  void testEqualsNullReceived() {
    Assertions.assertEquals(false,receipt.equals(new Receipt(10d, null, null, null)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,receipt.hashCode());
  }

  @Test
  void testHashCodeReceiptNull() {
    receipt.setOutOfStockProducts(null);
    Assertions.assertNotEquals(100,receipt.hashCode());
  }

  @Test
  void testHashCodeReceivedNull() {
    receipt.setReceivedProducts(null);
    Assertions.assertNotEquals(100,receipt.hashCode());
  }

  @Test
  void testHashCodeRemovedNull() {
    receipt.setRemovedProducts(null);
    Assertions.assertNotEquals(100,receipt.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",receipt.toString());
  }
}