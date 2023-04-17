package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockItemTest {

  StockItem stockItem1, stockItem2;
  @BeforeEach
  void setUp() {
    stockItem1 = new StockItem(new Cheese("Emmi Roth", "Mozarella Shred", 8.0d, 7),10);
    stockItem2 = new StockItem(new Cheese("Cabot", "Cheddar Cheese", 12.0d, 6),3);
  }

  @Test
  void isSameStockItem() {
    Assertions.assertEquals(true,stockItem1.isSameStockItem(stockItem1.getProduct()));
  }

  @Test
  void isAlternateStockItem() {
    Assertions.assertEquals(true,stockItem1.isAlternateStockItem(stockItem2.getProduct(), 5));
  }

  @Test
  void reduceQuantity() {
    stockItem1.reduceQuantity(1);
    Assertions.assertEquals(9,stockItem1.getQuantity());
  }

  @Test
  void increaseQuantity() {
    stockItem1.increaseQuantity(3);
    Assertions.assertEquals(13,stockItem1.getQuantity());
  }

  @Test
  void checkQuantity() {
    Assertions.assertEquals(true, stockItem1.checkQuantity(4));
  }

  @Test
  void checkMoreQuantity() {
    Assertions.assertEquals(false, stockItem1.checkQuantity(40));
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(80,stockItem1.getPrice());
  }

  @Test
  void getProduct() {
    Assertions.assertEquals(new Cheese("Emmi Roth", "Mozarella Shred", 8.0d, 7), stockItem1.getProduct());
  }

  @Test
  void setProduct() {
    stockItem1.setProduct(stockItem2.getProduct());
    Assertions.assertEquals(stockItem2.getProduct(), stockItem1.getProduct());
  }

  @Test
  void getQuantity() {
    Assertions.assertEquals(10,stockItem1.getQuantity());
  }

  @Test
  void setQuantity() {
    stockItem1.setQuantity(20);
    Assertions.assertEquals(20,stockItem1.getQuantity());
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,stockItem1.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,stockItem1.hashCode());
  }

  @Test
  void testHashCodeProductNull() {
    stockItem1.setProduct(null);
    Assertions.assertNotEquals(100,stockItem1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",stockItem1.toString());
  }
}