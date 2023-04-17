package assignment2.problem1;

/**
 * Represents the Household product which tracks the quantity and unit in which quantity is measured
 * @author resmohan
 */
public abstract class HouseHold extends Product{
  private int quantity;

  /**
   * Creates a new instance of household product given the manufacturer, product name, price and quantity
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param quantity quantity
   */
  public HouseHold(String manufacturer, String productName, double price, int quantity) {
    super(manufacturer, productName, price);
    this.quantity = quantity;
  }

  /**
   * This method determines if the given household product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * and it has a quantity that is equal to or greater than the replacing product
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    HouseHold householdProduct = (HouseHold) product;
    return(householdProduct.getPrice() >= this.getPrice()
        && householdProduct.getQuantity() <= this.getQuantity());
  }

  /**
   * gives the quantity of product
   * @return quantity of product
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * sets the quantity of product
   * @param quantity quantity of product
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * gives the string representation of household
   * @return string representation of household
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two household items.
   * It will return true only if both the households have same values of manufacturer, name, price and minimum age
   * @param obj household instance to be compared
   * @return true or false which indicates whether the two households are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a household.
   * If two households are same, it will return the same hashcode for both of them
   * @return hashcode of the given household
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
