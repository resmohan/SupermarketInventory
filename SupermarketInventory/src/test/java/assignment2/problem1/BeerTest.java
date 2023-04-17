package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeerTest {

  Beer beer1, beer2;
  @BeforeEach
  void setUp() {
    beer1 = new Beer("M1","P1",10,10);
    beer2 = new Beer("M2","P2",10,10);
  }

  /**
   * Products are replaceable as they have same price and weight
   */
  @Test
  void isReplaceable() {
    Assertions.assertEquals(true,beer1.isReplaceable(beer2));
  }

  /**
   * Products are not replaceable as replacing product has less weight
   */
  @Test
  void isReplaceableLessWeight() {
    beer2.setWeight(15);
    Assertions.assertEquals(false,beer1.isReplaceable(beer2));
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,beer1.equals(beer1));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,beer1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",beer1.toString());
  }
}