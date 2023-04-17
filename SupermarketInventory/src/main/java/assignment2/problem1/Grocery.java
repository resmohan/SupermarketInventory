package assignment2.problem1;

/**
 * Represents the Grocery product which tracks the weight and unit in which weight is measured
 * @author resmohan
 */
public abstract class Grocery extends Product{
  private int weight;

  /**
   * Creates a new instance of grocery given the manufacturer, product name, price and weight
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param weight weight
   */
  public Grocery(String manufacturer, String productName, double price, int weight) {
    super(manufacturer, productName, price);
    this.weight = weight;
  }

  /**
   * Creates a new instance of grocery given the manufacturer, product name, price, minimum age and weight
   * @param manufacturer manufacturer
   * @param productName product name
   * @param price price
   * @param minimumAge minimum age
   * @param weight weight
   */
  public Grocery(String manufacturer, String productName, double price, int minimumAge,
      int weight) {
    super(manufacturer, productName, price, minimumAge);
    this.weight = weight;
  }

  /**
   * This method determines if the given grocery product can be replaced with the current one
   * The replacement is possible only if the current product is cheaper,
   * and it has a weight that is equal to or greater than the replacing product
   * @param product product to be replaced
   * @return true or false which indicates whether the product can be replaced or not
   */
  public boolean isReplaceable(Product product){
    Grocery groceryProduct = (Grocery) product;

    return(groceryProduct.getPrice() >= this.getPrice()
        && groceryProduct.getWeight() <= this.getWeight());
  }

  /**
   * gives the weight of the product
   * @return weight of the product
   */
  public int getWeight() {
    return weight;
  }

  /**
   * sets the weight of the product
   * @param weight weight of the product
   */
  public void setWeight(int weight) {
    this.weight = weight;
  }

  /**
   * gives the string representation of grocery
   * @return string representation of grocery
   */
  @Override
  public String toString(){
    return(super.toString());
  }

  /**
   * This method is used to compare two grocery items.
   * It will return true only if both the groceries have same values of manufacturer, name, price and minimum age
   * @param obj product instance to be compared
   * @return true or false which indicates whether the two groceries are same or not
   */
  @Override
  public boolean equals(Object obj){
    return(super.equals(obj));
  }

  /**
   * This method is used to generate the hashcode for a grocery.
   * If two groceries are same, it will return the same hashcode for both of them
   * @return hashcode of the given grocery
   */
  @Override
  public int hashCode(){
    return(super.hashCode());
  }
}
