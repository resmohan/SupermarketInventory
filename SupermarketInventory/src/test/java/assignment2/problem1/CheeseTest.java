package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheeseTest {

  private Cheese cheese1, cheese2;
  @BeforeEach
  void setUp() {
    cheese1 = new Cheese("Emmi Roth", "Mozarella Shred", 8.99d, 7);
    cheese2 = new Cheese("Cabot", "Cheddar Cheese", 12.99d, 6);
  }

  /**
   * Testcase to compare two cheese products where product is not replaceable as price is higher and quantity is less
   */
  @Test
  void isReplaceable() {
    Assertions.assertEquals(false, cheese2.isReplaceable(cheese1));
  }

  /**
   * Testcase to compare two cheese products where product is not replaceable as price is cheaper but weight does not qualify
   */
  @Test
  void isReplaceableLessWeight() {
    cheese1.setWeight(4);
    Assertions.assertEquals(false, cheese1.isReplaceable(cheese2));
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