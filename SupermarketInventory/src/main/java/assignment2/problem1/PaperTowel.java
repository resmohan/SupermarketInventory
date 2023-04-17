package assignment2.problem1;

/**
 * Represents the paper towel product
 * @author resmohan
 */
public class PaperTowel extends HouseHold{

  /**
   * Creates a new instance of paper towel product given the manufacturer, product name, price and quantity
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param quantity quantity
   */
  public PaperTowel(String manufacturer, String productName, double price, int quantity) {
    super(manufacturer, productName, price, quantity);
  }

  /**
   * This method determines if the given paper towel product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * it has a weight that is equal to or greater than the replacing product and
   * both are paper towel products
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    return(super.isReplaceable(product) && this.getClass().isInstance(product));
  }

  /**
   * gives the string representation of paper towel
   * @return string representation of paper towel
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two paper towels.
   * It will return true only if both the paper towels have same values of manufacturer, name, price and minimum age
   * @param obj paper towel instance to be compared
   * @return true or false which indicates whether the two paper towels are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a paper towel.
   * If two paper towels are same, it will return the same hashcode for both of them
   * @return hashcode of the given paper towel
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
