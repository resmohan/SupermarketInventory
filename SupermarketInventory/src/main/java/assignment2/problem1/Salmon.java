package assignment2.problem1;

/**
 * Represents the salmon product
 * @author resmohan
 */
public class Salmon extends Grocery{

  /**
   * Creates a new instance of salmon given the manufacturer, product name, price and weight
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param weight weight
   */
  public Salmon(String manufacturer, String productName, double price, int weight) {
    super(manufacturer, productName, price, weight);
  }

  /**
   * This method determines if the given salmon product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * it has a weight that is equal to or greater than the replacing product and
   * both are salmon products
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    return(super.isReplaceable(product) && this.getClass().isInstance(product));
  }

  /**
   * gives the string representation of salmon
   * @return string representation of salmon
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two salmon items.
   * It will return true only if both the salmons have same values of manufacturer, name, price and minimum age
   * @param obj salmon instance to be compared
   * @return true or false which indicates whether the two salmons are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a salmon.
   * If two salmons are same, it will return the same hashcode for both of them
   * @return hashcode of the given salmon
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
