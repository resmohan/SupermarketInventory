package assignment2.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the receipt object created after processing an order
 * @author  resmohan
 */
public class Receipt {
  private double totalPrice;
  private List<Product> receivedProducts;
  private List<Product> outOfStockProducts;
  private List<Product> removedProducts;

  /**
   * Creates a new receipt, when the processing of an order starts
   */
  public Receipt(){
    this.receivedProducts = new ArrayList<Product>();
    this.outOfStockProducts = new ArrayList<Product>();
    this.removedProducts = new ArrayList<Product>();
    this.totalPrice = 0d;
  }

  /**
   * Creates a new receipt, given the total price, list of received products,
   * list of out of stock products and list of removed products
   * @param totalPrice total price paid
   * @param receivedProducts list of received products
   * @param outOfStockProducts list of out of stock products
   * @param removedProducts list of removed products
   */
  public Receipt(double totalPrice, List<Product> receivedProducts,
      List<Product> outOfStockProducts,
      List<Product> removedProducts) {
    this.totalPrice = totalPrice;
    this.receivedProducts = receivedProducts;
    this.outOfStockProducts = outOfStockProducts;
    this.removedProducts = removedProducts;
  }

  /**
   * Add a product to the list of received products
   * @param product product
   */
  public void addReceivedProduct(Product product){
    this.receivedProducts.add(product);
  }

  /**
   * Add a product to the list of out of stock products
   * @param product product
   */
  public void addOutOfStockProduct(Product product){
    this.outOfStockProducts.add(product);
  }

  /**
   * Add a product to the list of removed products
   * @param product product
   */
  public void addRemovedProduct(Product product){
    this.removedProducts.add(product);
  }

  /**
   * Add price of product to total price
   * @param price price of product
   */
  public void addTotalPrice(double price){
    this.totalPrice += price;
  }

  /**
   * String representation of receipt object
   * @return string representation
   */
  @Override
  public String toString(){
    return "Total price : "+this.totalPrice+"\nList of products received : "+this.receivedProducts+
        "\nList of out of stock products : "+this.outOfStockProducts+
        "\nList of removed products : "+this.removedProducts;
  }

  /**
   * Gives the total price
   * @return total price
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * Sets the total price
   * @param totalPrice total price
   */
  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Gives the list of received products
   * @return list of received products
   */
  public List<Product> getReceivedProducts() {
    return receivedProducts;
  }

  /**
   * Sets the list of received products
   * @param receivedProducts list of received products
   */
  public void setReceivedProducts(List<Product> receivedProducts) {
    this.receivedProducts = receivedProducts;
  }

  /**
   * Gives the list of out of stock products
   * @return list of out of stock products
   */
  public List<Product> getOutOfStockProducts() {
    return outOfStockProducts;
  }

  /**
   * Sets the list of out of stock products
   * @param outOfStockProducts list of out of stock products
   */
  public void setOutOfStockProducts(List<Product> outOfStockProducts) {
    this.outOfStockProducts = outOfStockProducts;
  }

  /**
   * Gives the list of removed products
   * @return list of removed products
   */
  public List<Product> getRemovedProducts() {
    return removedProducts;
  }

  /**
   * Sets the list of removed products
   * @param removedProducts list of removed products
   */
  public void setRemovedProducts(List<Product> removedProducts) {
    this.removedProducts = removedProducts;
  }

  /**
   * This method is used to compare two receipts.
   * It will return true only if both the receipts have same set of data
   * @param obj receipt instance to be compared
   * @return true or false which indicates whether the two receipts are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    Receipt receipt = (Receipt) obj;
    return(this.totalPrice == receipt.getTotalPrice()
            && this.receivedProducts== null ? receipt.getReceivedProducts() ==null : this.receivedProducts.equals(receipt.getReceivedProducts())
            && this.outOfStockProducts== null ? receipt.getOutOfStockProducts() ==null : this.outOfStockProducts.equals(receipt.getOutOfStockProducts())
            && this.removedProducts== null ? receipt.getRemovedProducts() ==null : this.removedProducts.equals(receipt.getRemovedProducts()));
  }

  /**
   * This method is used to generate the hashcode for a receipt.
   * If two receipts are same, it will return the same hashcode for both of them
   * @return hashcode of the given receipt
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (int)this.totalPrice;
    result = 31 * result + (this.getReceivedProducts() == null ? 0 : this.getReceivedProducts().hashCode());
    result = 31 * result + (this.getOutOfStockProducts() == null ? 0 : this.getOutOfStockProducts().hashCode());
    result = 31 * result + (this.getRemovedProducts() == null ? 0 : this.getRemovedProducts().hashCode());

    return result;
  }
}
