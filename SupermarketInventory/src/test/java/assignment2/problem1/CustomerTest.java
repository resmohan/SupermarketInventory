package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

  private Customer customer;
  @BeforeEach
  void setUp() {
    customer = new Customer(new Name("John","Mathew"),18);
  }

  @Test
  void startShopping() {
    ShoppingCart sc = customer.startShopping();
    Assertions.assertEquals(sc,customer.getShoppingCart());
  }

  @Test
  void getName() {
    Assertions.assertEquals(new Name("John","Mathew"),customer.getName());
  }

  @Test
  void setName() {
    customer.setName(new Name("John1","Mathew1"));
    Assertions.assertEquals(new Name("John1","Mathew1"),customer.getName());
  }

   @Test
  void getAge() {
    Assertions.assertEquals(18,customer.getAge());
  }

  @Test
  void setAge() {
    customer.setAge(20);
    Assertions.assertEquals(20,customer.getAge());
  }

  @Test
  void getShoppingCart() {
    Assertions.assertNull(customer.getShoppingCart());
  }

  @Test
  void setShoppingCart() {
    ShoppingCart sc = new ShoppingCart();
    customer.setShoppingCart(sc);
    Assertions.assertEquals(sc,customer.getShoppingCart());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,customer.equals(customer));
  }

  @Test
  void testEqualsDifferent() {
    Assertions.assertEquals(false,customer.equals(new Customer(new Name("John","Mathew1"),18)));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,customer.equals(null));
  }

  @Test
  void testEqualsString() {
    Assertions.assertEquals(false,customer.equals("null"));
  }

  @Test
  void testEqualsNameNull() {
    Assertions.assertEquals(false,new Customer(null,3).equals(new Customer(null,2)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,customer.hashCode());
  }

  @Test
  void testHashCodeCustomerNull() {
    customer.setName(null);
    Assertions.assertNotEquals(100,customer.hashCode());
  }
}