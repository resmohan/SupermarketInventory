package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseHoldTest {

  HouseHold paperTowel1, paperTowel2;
  @BeforeEach
  void setUp() {
    paperTowel1 = new PaperTowel("Presto", "Flex Paper Towels", 10, 6);
    paperTowel2 = new PaperTowel("Presto1", "Flex Paper Towels1", 5, 6);
  }

  @Test
  void isReplaceable() {
    Assertions.assertEquals(false,paperTowel1.isReplaceable(paperTowel2));
  }

  @Test
  void getQuantity() {
    Assertions.assertEquals(6,paperTowel1.getQuantity());
  }

  @Test
  void setQuantity() {
    paperTowel1.setQuantity(3);
    Assertions.assertEquals(3,paperTowel1.getQuantity());
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