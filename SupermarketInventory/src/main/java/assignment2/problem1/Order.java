package assignment2.problem1;

import java.util.Map;
import java.util.Set;

/**
 * Represents the order made by a customer
 * @author resmohan
 */
public class Order {
  private Customer customer;
  private ShoppingCart shoppingCart;
  private Receipt receipt;

  /**
   * Creates a new instance of order given the customer and shopping cart details
   * @param customer customer details
   * @param shoppingCart shopping cart
   */
  public Order(Customer customer, ShoppingCart shoppingCart) {
    this.customer = customer;
    this.shoppingCart = shoppingCart;
    this.receipt = new Receipt();
  }

  /**
   * Processes and order made by customer and returns the receipt
   * @return receipt of order
   */
  public Receipt processOrder(){
    Map<Product,Integer> cartItemsMap = this.shoppingCart.getCartItemsMap();
    Set<Product> productSet = cartItemsMap.keySet();

    //iterate through the products in shopping cart
    for(Product product : productSet){
      boolean isValid = validateAgeRestrictions(product);//check if the customer is old enough to buy the product
      if(!isValid){//can't buy this product; add it to the list of removed products
        receipt.addRemovedProduct(product);
        continue;
      }

      int quantity = cartItemsMap.get(product);
      Inventory inventory = Inventory.getInstance();

      //check if there are enough quantities of the purchased product in inventory
      if(!Inventory.getInstance().isValidQuantity(product, quantity)){
        //not enough items in inventory; look for an alternate product
        Product alternateProduct = inventory.getAlternateProduct(product,quantity);
        if(alternateProduct == null){//no alternate products available; add it to out of stock products list
          receipt.addOutOfStockProduct(product);
          continue;
        }
        product = alternateProduct;//alternate product available; will replace with that
      }

      inventory.reduceStock(product, quantity);//reduce the stock from inventory
      receipt.addReceivedProduct(product);//add it to the list of received products
      receipt.addTotalPrice(product.getPrice() * quantity);//add the price
    }

    this.shoppingCart = null;//after processing order, empty the shopping cart

    return(this.receipt);//return the receipt
  }

  /**
   * Determines if customer is old enough to buy the product
   * @param product product
   * @return true or false
   */
  private boolean validateAgeRestrictions(Product product){
    if(product.getMinimumAge() > customer.getAge()){
      return false;
    }else{
      return true;
    }
  }

  /**
   * gives the customer details
   * @return customer details
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * sets the customer details
   * @param customer customer details
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  /**
   * gives the shopping cart
   * @return shopping cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * sets the shopping cart
   * @param shoppingCart shopping cart
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  /**
   * This method is used to compare two orders.
   * It will return true only if both the orders have same customer and shopping cart
   * @param obj order instance to be compared
   * @return true or false which indicates whether the two orders are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    Order order = (Order) obj;
    return((this.customer == null ? order.getCustomer() == null : this.customer.equals(order.getCustomer()))
        && (this.shoppingCart == null ? order.getShoppingCart() == null : this.shoppingCart.equals(order.getShoppingCart())));
  }

  /**
   * This method is used to generate the hashcode for an order.
   * If two orders are same, it will return the same hashcode for both of them
   * @return hashcode of the given order
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getCustomer() == null ? 0 : this.getCustomer().hashCode());
    result = 31 * result + (this.getShoppingCart() == null ? 0 : this.getShoppingCart().hashCode());

    return result;
  }

  /**
   * Gives the string representation of order
   * @return string representation of order
   */
  @Override
  public String toString(){
    return(this.customer+"\n"+this.shoppingCart);
  }
}
