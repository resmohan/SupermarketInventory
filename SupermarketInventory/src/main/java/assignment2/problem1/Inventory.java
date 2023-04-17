package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents the inventory which stores the stock items available for all products
 * @author resmohan
 */
public class Inventory {

  private static Inventory inventory;

  private List<StockItem> groceryStock = new ArrayList<StockItem>();
  private List<StockItem> householdStock = new ArrayList<StockItem>();

  /**
   * Instance of inventory should be created only once
   */
  private Inventory(){}

  /**
   * Ensures that an inventory instance is created only once
   * This helps to add or remove stocks at the same place
   * @return inventory instance
   */
  public static Inventory getInstance(){
    if(inventory == null) {
      synchronized (Inventory.class) {
        if(inventory == null)
          inventory = new Inventory();
      }
    }
    return inventory;
  }

  /**
   * Creates or updates the items in a stock
   * @param product product to be added to stock
   * @param quantity quantity of product to be added
   */
  public void addStock(Product product, int quantity){
    StockItem stockItem = getStockItem(product);
    stockItem.increaseQuantity(quantity);
  }

  /**
   * Remove a stock from inventory
   * @param product product to be removed
   */
  public void removeStock(Product product){
    List<StockItem> stockItemsList = getStockItemList(product);
    StockItem stockItem = getStockItem(stockItemsList, product);
    stockItemsList.remove(stockItem);
  }

  /**
   * Reduce the number of items in a stock
   * @param product product
   * @param quantity no of items to be reduced
   */
  public void reduceStock(Product product, int quantity){
    StockItem stockItem = getStockItem(product);
    stockItem.reduceQuantity(quantity);
  }

  /**
   * Checks if there are enough items in a stock
   * @param product product
   * @param quantity number of items
   * @return true or false
   */
  public boolean isValidQuantity(Product product, int quantity){
    StockItem stockItem = getStockItem(product);
    return (stockItem.checkQuantity(quantity));
  }

  /**
   * Find the alternate product with a specified quantity
   * @param product product to be replaced
   * @param quantity number of items needed
   * @return alternate product available in stock
   */
  public Product getAlternateProduct(Product product, int quantity){
    List<StockItem> stockItemsList = getStockItemList(product);
    StockItem stockItem = getAlternateStockItem(stockItemsList, product, quantity);

    if(stockItem != null)
      return stockItem.getProduct();

    return null;
  }

  /**
   * Gives the total price of all the items in inventory
   * @return total price
   */
  public double getTotalPrice(){
    double totalPrice = 0d;

    for(StockItem groceryStockItem : groceryStock)
      totalPrice += groceryStockItem.getPrice();

    for(StockItem householdStockItem : householdStock)
      totalPrice += householdStockItem.getPrice();

    return totalPrice;
  }

  /**
   * Gives the total proce of all the items in a stock
   * @param stockItemsList the stock for which price should be calculated
   * @return total price
   */
  public double getTotalPriceOfStock(List<StockItem> stockItemsList){
    double totalPrice = 0d;

    for(StockItem stockItem : stockItemsList)
      totalPrice += stockItem.getPrice();

    return totalPrice;
  }

  /**
   * Gives the stock item of a particular product
   * @param product product
   * @return stock item
   */
  private StockItem getStockItem(Product product){
    List<StockItem> stockItemsList = getStockItemList(product);
    StockItem stockItem = getStockItem(stockItemsList, product);

    return stockItem;
  }

  /**
   * Gives the stock item list where a product's stock item is stored
   * @param product product
   * @return list of stock items
   */
  private List<StockItem> getStockItemList(Product product){
    if(product instanceof Grocery)
      return groceryStock;
    else
      return householdStock;
  }

  /**
   * Checks if a product is already in stock. If so, returns that stock item
   * Otherwise creates a new stock item
   * @param stockItemsList
   * @param product
   * @return
   */
  private StockItem getStockItem(List<StockItem> stockItemsList, Product product){
    Optional<StockItem> stockItemVal = stockItemsList.stream()
        .filter(stockItem -> stockItem.isSameStockItem(product))
        .findFirst();

    if(stockItemVal.isPresent())
      return(stockItemVal.get());

    StockItem stockItem = new StockItem(product, 0);
    stockItemsList.add(stockItem);
    return stockItem;
  }

  /**
   * Given a stock item list, finds the alternate for a particular product which is in stock
   * @param stockItemsList
   * @param product
   * @param quantity
   * @return
   */
  private StockItem getAlternateStockItem(List<StockItem> stockItemsList, Product product, int quantity){
    Optional<StockItem> stockItemVal = stockItemsList.stream()
        .filter(stockItem -> stockItem.isAlternateStockItem(product, quantity))
        .findFirst();

    if(stockItemVal.isPresent())
      return(stockItemVal.get());

    return null;
  }

  /**
   * Gives the grocery stock
   * @return list of grocery stock items
   */
  public List<StockItem> getGroceryStock() {
    return groceryStock;
  }

  /**
   *
   * Sets the grocery stock
   * @param groceryStock list of grocery stock items
   */
  public void setGroceryStock(List<StockItem> groceryStock) {
    this.groceryStock = groceryStock;
  }

  /**
   * Gives the household stock
   * @return list of household stock items
   */
  public List<StockItem> getHouseholdStock() {
    return householdStock;
  }

  /**
   * Sets the household stock
   * @param householdStock list of household stock items
   */
  public void setHouseholdStock(List<StockItem> householdStock) {
    this.householdStock = householdStock;
  }

  /**
   * gives the string representation of inventory
   * @return string representation of inventory
   */
  @Override
  public String toString(){
    return("Grocery : \n"+this.groceryStock+"\nHousehold : \n"+this.householdStock);
  }

  /**
   * This method is used to compare inventory class.
   * @param o instance of inventory class to be compared
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) o;
    return Objects.equals(groceryStock, inventory.groceryStock) && Objects.equals(
        householdStock, inventory.householdStock);
  }

  /**
   * This method is used to generate the hashcode for inventory class.
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(groceryStock, householdStock);
  }
}