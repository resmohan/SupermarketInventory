package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name name;
  @BeforeEach
  void setUp() {
    name = new Name("John","Mathew");
  }

  @Test
  void getFirstName() {
    name.setFirstName("John1");
    Assertions.assertEquals("John1",name.getFirstName());
  }

  @Test
  void getLastName() {
    name.setLastName("Mathew1");
    Assertions.assertEquals("Mathew1",name.getLastName());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(new Name("John","Mathew"),name);
  }

  @Test
  void testEqualsSame() {
    Assertions.assertEquals(true,name.equals(name));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,name.equals(null));
  }

  @Test
  void testEqualsString() {
    Assertions.assertEquals(false,name.equals("null"));
  }

  @Test
  void testEqualsFnameNull() {
    Assertions.assertEquals(false,name.equals(new Name(null,"LN")));
  }
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,name.hashCode());
  }

  @Test
  void testHashCodeFirstNameNull() {
    name.setFirstName(null);
    Assertions.assertNotEquals(100,name.hashCode());
  }

  @Test
  void testHashCodeLastNameNull() {
    name.setLastName(null);
    Assertions.assertNotEquals(100,name.hashCode());
  }
}