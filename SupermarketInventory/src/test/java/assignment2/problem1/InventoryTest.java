package assignment2.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {

  private Inventory inventory;
  private Product cheese, paperTowel;

  @BeforeEach
  void setUp() {
    inventory = Inventory.getInstance();
    cheese = new Cheese("M1","P1",10,5);
    paperTowel = new PaperTowel("M2","P2",10,5);
  }

  @Test
  void addStock() {
    inventory.addStock(cheese, 3);
    Assertions.assertEquals(30,inventory.getTotalPrice());
    inventory.reduceStock(cheese,3);//resetting back; so that it won't affect other flows
  }

  @Test
  void reduceStock() {
    inventory.addStock(cheese, 5);
    inventory.reduceStock(cheese, 1);
    Assertions.assertEquals(40,inventory.getTotalPrice());
    inventory.reduceStock(cheese,4);//resetting back; so that it won't affect other flows
  }

  @Test
  void isValidQuantity() {
    Assertions.assertEquals(false, inventory.isValidQuantity(cheese, 2));
  }

  @Test
  void getAlternateProduct() {
    Assertions.assertNull(inventory.getAlternateProduct(cheese,2));
  }

  @Test
  void getAlternateCheeseProduct() {
    Product cheese1 = new Cheese("M3","P3",7,7);
    inventory.addStock(cheese1, 9);
    Assertions.assertEquals(cheese1, inventory.getAlternateProduct(cheese,2));
    inventory.reduceStock(cheese1,9);//resetting back; so that it won't affect other flows
  }

  @Test
  void getTotalPrice() {
    inventory.addStock(paperTowel, 2);
    Assertions.assertEquals(20,inventory.getTotalPrice());
    inventory.reduceStock(paperTowel,2);//resetting back; so that it won't affect other flows
  }

  @Test
  void getTotalPriceOfGroceryStock() {
    Assertions.assertEquals(0,inventory.getTotalPriceOfStock(inventory.getGroceryStock()));
  }

  @Test
  void getTotalPriceOfHouseholdStock() {
    Assertions.assertEquals(0,inventory.getTotalPriceOfStock(inventory.getHouseholdStock()));
  }

  @Test
  void setGroceryStock(){
    List<StockItem> groceryStock = new ArrayList<StockItem>();
    inventory.setGroceryStock(groceryStock);
    Assertions.assertEquals(groceryStock, inventory.getGroceryStock());
  }

  @Test
  void setHouseholdStock(){
    List<StockItem> householdStock = new ArrayList<StockItem>();
    inventory.setHouseholdStock(householdStock);
    Assertions.assertEquals(householdStock, inventory.getHouseholdStock());
  }

  @Test
  void testToString(){
    Assertions.assertNotEquals("Test",inventory.toString());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,inventory.equals(inventory));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,inventory.equals(null));
  }

  @Test
  void testEqualsDiffObject() {
    Assertions.assertEquals(true,inventory.equals(Inventory.getInstance()));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,inventory.hashCode());
  }
 }