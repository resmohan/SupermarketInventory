package assignment2.problem1;

/**
 * Represents the cheese product
 * @author resmohan
 */
public class Cheese extends Grocery{

  /**
   * Creates a new instance of cheese given the manufacturer, product name, price and weight
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param weight weight
   */
  public Cheese(String manufacturer, String productName, double price, int weight) {
    super(manufacturer, productName, price, weight);
  }

  /**
   * This method determines if the given cheese product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * it has a weight that is equal to or greater than the replacing product and
   * both are cheese products
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    return(super.isReplaceable(product) && this.getClass().isInstance(product));
  }

  /**
   * gives the string representation of cheese
   * @return string representation of cheese
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two cheese items.
   * It will return true only if both the cheeses have same values of manufacturer, name, price and minimum age
   * @param obj cheese instance to be compared
   * @return true or false which indicates whether the two cheeses are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a cheese.
   * If two cheeses are same, it will return the same hashcode for both of them
   * @return hashcode of the given cheese
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
