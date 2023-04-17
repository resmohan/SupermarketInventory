package assignment2.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents the shopping cart
 * @author resmohan
 */
public class ShoppingCart {
  private Map<Product,Integer> cartItemsMap;

  private static final String NOT_ENOUGH_ITEMS_MSG = "You are trying to add more than available quantity of the product '%s'";

  /**
   * Creates a new instance of shopping cart
   */
  public ShoppingCart() {
    this.cartItemsMap = new HashMap<Product,Integer>();
  }

  /**
   * Add a product to shopping cart
   * @param product product
   */
  public void addProduct(Product product){
    this.cartItemsMap.put(product, 1);
  }

  /**
   * Add a product of given quantity to shopping cart
   * @param product product
   * @param quantity number of items
   */
  public void addProduct(Product product, int quantity){
    if(!isValidQuantity(product, quantity)) {
      return;
    }

    this.cartItemsMap.put(product, quantity);
  }

  /**
   * Remove a product from shopping cart
   * @param product product
   */
  public void removeProduct(Product product){
    this.cartItemsMap.remove(product);
  }

  /**
   * Increase the count of a product in shopping cart
   * @param product product
   * @param quantity number of items
   */
  public void increaseQuantity(Product product, int quantity){
    if(!this.cartItemsMap.containsKey(product))
      return;

    if(!isValidQuantity(product, quantity)){
      return;
    }

    int existingQuantity = this.cartItemsMap.get(product);
    this.cartItemsMap.put(product, existingQuantity + quantity);
  }

  /**
   * Decrease the count of a product in shopping cart
   * @param product product
   * @param quantity number of items
   */
  public void decreaseQuantity(Product product, int quantity){
    if(!this.cartItemsMap.containsKey(product))
      return;

    int existingQuantity = this.cartItemsMap.get(product);
    this.cartItemsMap.put(product, existingQuantity - quantity);
  }

  /**
   * Gives the total price of all the items in shopping cart
   * @return total price
   */
  public double getTotalPrice(){
    double totalPrice = 0d;

    Set<Product> productSet = this.getCartItemsMap().keySet();
    for(Product product : productSet){
      totalPrice += product.getPrice() * getCartItemsMap().get(product);
    }

    return totalPrice;
  }

  /**
   * Check if there are enough items of a given product
   * @param product product
   * @param quantity number of items
   * @return true or false
   */
  private boolean isValidQuantity(Product product, int quantity){
    boolean isValid = false;
    try {
      isValid = Inventory.getInstance().isValidQuantity(product, quantity);

      if (!isValid) {
        throw new RuntimeException(String.format(NOT_ENOUGH_ITEMS_MSG,product));
      }
    }catch(RuntimeException exception){
      Logger logger = Logger.getAnonymousLogger();
      logger.log(Level.SEVERE, String.format(NOT_ENOUGH_ITEMS_MSG,product));
    }

    return isValid;
  }

  /**
   * Gives the product details in the shopping cart
   * @return map of item to count
   */
  public Map<Product, Integer> getCartItemsMap() {
    return cartItemsMap;
  }

  /**
   * Sets the product details in the shopping cart
   * @param cartItemsMap map of item to count
   */
  public void setCartItemsMap(Map<Product, Integer> cartItemsMap) {
    this.cartItemsMap = cartItemsMap;
  }

  /**
   * This method is used to compare two shopping carts.
   * It will return true only if both the shopping carts have same set of products
   * @param obj shopping cart instance to be compared
   * @return true or false which indicates whether the two shopping carts are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    ShoppingCart shoppingCart = (ShoppingCart) obj;
    return((this.cartItemsMap == null ? shoppingCart.getCartItemsMap() == null : this.cartItemsMap.equals(shoppingCart.getCartItemsMap())));
  }

  /**
   * This method is used to generate the hashcode for a shopping cart.
   * If two shopping carts are same, it will return the same hashcode for both of them
   * @return hashcode of the given shopping cart
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getCartItemsMap() == null ? 0 : this.getCartItemsMap().hashCode());

    return result;
  }

  /**
   * gives the string representation of shopping cart
   * @return string representation of shopping cart
   */
  @Override
  public String toString(){
    StringBuffer result = new StringBuffer();
    Set<Product> ProductSet = this.cartItemsMap.keySet();
    for(Product product:ProductSet){
      result.append(product).append(" : ").append(this.cartItemsMap.get(product)).append("\n");
    }
    return(result.toString());
  }
}
