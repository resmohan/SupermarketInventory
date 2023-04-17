package assignment2.problem1;

/**
 * Represents the shampoo product
 * @author resmohan
 */
public class Shampoo extends HouseHold{

  /**
   * Creates a new instance of shampoo product given the manufacturer, product name, price and quantity
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param quantity quantity
   */
  public Shampoo(String manufacturer, String productName, double price, int quantity) {
    super(manufacturer, productName, price, quantity);
  }

  /**
   * This method determines if the given shampoo product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * it has a weight that is equal to or greater than the replacing product and
   * both are shampoo products
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    return(super.isReplaceable(product) && this.getClass().isInstance(product));
  }

  /**
   * gives the string representation of shampoo
   * @return string representation of shampoo
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two shampoo items.
   * It will return true only if both the shampoos have same values of manufacturer, name, price and minimum age
   * @param obj shampoo instance to be compared
   * @return true or false which indicates whether the two shampoos are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a shampoo.
   * If two shampoos are same, it will return the same hashcode for both of them
   * @return hashcode of the given shampoo
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
