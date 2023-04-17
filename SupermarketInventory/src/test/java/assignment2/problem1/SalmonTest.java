package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalmonTest {

  Salmon salmon1, salmon2;
  @BeforeEach
  void setUp() {
    salmon1 = new Salmon("M1","P1",12,3);
    salmon2 = new Salmon("M2","P2",15,4);
  }

  /**
   * Products are not replaceable as weight is less
   */
  @Test
  void isReplaceable() {
    Assertions.assertEquals(false, salmon1.isReplaceable(salmon2));
  }

  /**
   * Products are replaceable as price is cheap and weight is more
   */
  @Test
  void isReplaceableMatch() {
    salmon1.setWeight(6);
    Assertions.assertEquals(true, salmon1.isReplaceable(salmon2));
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,salmon1.equals(salmon1));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,salmon1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",salmon1.toString());
  }
}