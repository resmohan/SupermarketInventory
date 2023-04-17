package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroceryTest {

  private Grocery cheese1, cheese2;
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
  void getWeight() {
    Assertions.assertEquals(7, cheese1.getWeight());
  }

  @Test
  void setWeight() {
    cheese1.setWeight(10);
    Assertions.assertEquals(10, cheese1.getWeight());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,cheese1.equals(cheese1));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,cheese1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",cheese1.toString());
  }
}