package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnlineShoppingAppTest {

  @Test
  void main() {
    new OnlineShoppingApp();
    OnlineShoppingApp.main(null);
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",new OnlineShoppingApp().toString());
  }
}