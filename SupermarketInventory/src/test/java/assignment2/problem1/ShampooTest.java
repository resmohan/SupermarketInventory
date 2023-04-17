package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShampooTest {

  Shampoo shampoo1, shampoo2;
  @BeforeEach
  void setUp() {
    shampoo1 = new Shampoo("Sunsilk","Hair Shampoo",10,2);
    shampoo2 = new Shampoo("Medimix","Silk Shampoo",5,12);
  }

  @Test
  void isReplaceable() {
    Assertions.assertEquals(false,shampoo1.isReplaceable(shampoo2));
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,shampoo1.equals(shampoo1));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,shampoo1.hashCode());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",shampoo1.toString());
  }
}