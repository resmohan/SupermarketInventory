package assignment2.problem1;

/**
 * Represents the beer product
 * @author resmohan
 */
public class Beer extends Grocery{
  private static final int MINIMUM_AGE = 21;

  /**
   * Creates a new instance of beer given the manufacturer, product name, price and weight
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param weight weight
   */
  public Beer(String manufacturer, String productName, double price, int weight) {
    super(manufacturer, productName, price, MINIMUM_AGE, weight);
  }

  /**
   * This method determines if the given beer product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * it has a weight that is equal to or greater than the replacing product and
   * both are beer products
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    return(super.isReplaceable(product) && this.getClass().isInstance(product));
  }

  /**
   * gives the string representation of beer
   * @return string representation of beer
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two beer items.
   * It will return true only if both the beers have same values of manufacturer, name, price and minimum age
   * @param obj beer instance to be compared
   * @return true or false which indicates whether the two beers are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a beer.
   * If two beers are same, it will return the same hashcode for both of them
   * @return hashcode of the given beer
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
