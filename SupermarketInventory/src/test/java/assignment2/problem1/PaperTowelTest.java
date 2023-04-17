package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaperTowelTest {

  PaperTowel paperTowel1, paperTowel2;
  @BeforeEach
  void setUp() {
    paperTowel1 = new PaperTowel("Presto", "Flex Paper Towels", 10, 6);
    paperTowel2 = new PaperTowel("Presto1", "Flex Paper Towels1", 5, 6);
  }

  /**
   * Testcase to compare two paper towel products, where replacement is possible as product is cheaper and quantity is same
   */
  @Test
  void isReplaceable() {
    Assertions.assertEquals(true,paperTowel2.isReplaceable(paperTowel1));
  }

  /**
   * Testcase to compare two paper towel products, where replacement is not possible as product quantity is less
   */
  @Test
  void isReplaceableLessQuantity() {
    paperTowel2.setQuantity(1);
    Assertions.assertEquals(false,paperTowel2.isReplaceable(paperTowel1));
  }

  /**
   * Testcase to compare two paper towel products, where replacement is not possible as product quantity is less
   */
  @Test
  void isReplaceableDiffProduct() {
    Assertions.assertEquals(false, new Shampoo("Sunsilk","Hair Shampoo",10,12).isReplaceable(paperTowel1));
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,paperTowel1.equals(paperTowel1));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,paperTowel1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",paperTowel1.toString());
  }
}