package assignment2.problem1;

import java.util.Set;

/**
 * Represents the stock item which contains a product and the quantity of product
 */
public class StockItem {
  private Product product;
  private int quantity;

  /**
   * Creates a new instance of stock item given the product and quantity
   * @param product product
   * @param quantity quantity
   */
  public StockItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Checks if the current and given stock items are same
   * @param product product
   * @return true or false
   */
  public boolean isSameStockItem(Product product){
    return(this.product.equals(product));
  }

  /**
   * Checks if the given product can be replaced with the current stock item
   * @param product product
   * @param quantity quantity
   * @return true or false
   */
  public boolean isAlternateStockItem(Product product, int quantity){
    return(this.product.isReplaceable(product)
            && this.quantity >= quantity);
  }

  /**
   * Reduce the quantity of items in a stock item
   * @param count count
   */
  public void reduceQuantity(int count){
    this.quantity = this.quantity - count;
  }

  /**
   * Increase the quantity of items in a stock item
   * @param count count
   */
  public void increaseQuantity(int count){
    this.quantity = this.quantity + count;
  }

  /**
   * Check if there are enough items in a stock item
   * @param count count
   * @return true or false
   */
  public boolean checkQuantity(int count){
    if(this.quantity < count)
      return false;
    else
      return true;
  }

  /**
   * Gives the total price of all the items in stock item
   * @return price
   */
  public double getPrice(){
    return(this.product.getPrice() * this.quantity);
  }

  /**
   * Gives  the product
   * @return product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Sets the product
   * @param product product
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * Gives the quantity of products in a stock item
   * @return quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity of products in a stock item
   * @param quantity quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * This method is used to compare two stock items.
   * It will return true only if both the stock items have same set of products
   * @param obj stock item instance to be compared
   * @return true or false which indicates whether the two stock items are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    StockItem stockItem = (StockItem) obj;
    return((this.product == null ? stockItem.getProduct() == null : this.product.equals(stockItem.getProduct())));
  }

  /**
   * This method is used to generate the hashcode for a stock item.
   * If two stock items are same, it will return the same hashcode for both of them
   * @return hashcode of the given stock item
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getProduct() == null ? 0 : this.getProduct().hashCode());
    result = 31 * result + this.getQuantity();

    return result;
  }

  /**
   * gives the string representation of stock item
   * @return string representation of stock item
   */
  @Override
  public String toString(){
    return(this.product+" : "+this.quantity);
  }
}
