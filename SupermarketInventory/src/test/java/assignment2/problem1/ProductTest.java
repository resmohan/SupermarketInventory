package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

  private Product cheese1, cheese2;
  @BeforeEach
  void setUp() {
    cheese1 = new Cheese("Emmi Roth", "Mozarella Shred", 8.99d, 7);
    cheese2 = new Cheese("Cabot", "Cheddar Cheese", 12.99d, 6);
  }

  @Test
  void isReplaceable() {
    Assertions.assertEquals(true,cheese1.isReplaceable(cheese2));
  }

  @Test
  void getManufacturer() {
    Assertions.assertEquals("Emmi Roth", cheese1.getManufacturer());
  }

  @Test
  void setManufacturer() {
    cheese1.setManufacturer("Emmi Roth1");
    Assertions.assertEquals("Emmi Roth1", cheese1.getManufacturer());
  }

  @Test
  void getProductName() {
    Assertions.assertEquals("Mozarella Shred", cheese1.getProductName());
  }

  @Test
  void setProductName() {
    cheese1.setProductName("Mozarella Shred1");
    Assertions.assertEquals("Mozarella Shred1", cheese1.getProductName());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(8.99d, cheese1.getPrice());
  }

  @Test
  void setPrice() {
    cheese1.setPrice(8);
    Assertions.assertEquals(8, cheese1.getPrice());
  }

  @Test
  void getMinimumAge() {
    Assertions.assertEquals(0, cheese1.getMinimumAge());
  }

  @Test
  void setMinimumAge() {
    cheese1.setMinimumAge(5);
    Assertions.assertEquals(5, cheese1.getMinimumAge());
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,cheese1.equals(null));
  }

  @Test
  void testEqualsNullManufacturer() {
    Assertions.assertEquals(false,new Cheese(null, null, 8.99d, 7).equals(new Cheese(null, "Mozarella Shred", 8.99d, 7)));
  }
  @Test
  void testHashCode() {
    cheese1.setManufacturer(null);
    Assertions.assertNotEquals(100,cheese1.hashCode());
  }

  @Test
  void testHashCodeProductNull() {
    cheese1.setProductName(null);
    Assertions.assertNotEquals(100,cheese1.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Mozarella Shred", cheese1.toString());
  }
}