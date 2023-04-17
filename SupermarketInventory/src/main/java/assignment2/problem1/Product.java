package assignment2.problem1;

/**
 * Represents the Product which tracks the manufacturer, product name, price and minimum age for buying a product
 * @author resmohan
 */
public abstract class Product {
  private String manufacturer;
  private String productName;
  private double price;
  private int minimumAge;

  /**
   * Creates a new instance of product given the manufacturer, product name and price
   * @param manufacturer manufacturer of the product
   * @param productName name of the product
   * @param price price of the product
   */
  public Product(String manufacturer, String productName, double price) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = 0;
  }

  /**
   * Creates a new instance of product given the manufacturer, product name, price and minimum age
   * @param manufacturer manufacturer of the product
   * @param productName name of the product
   * @param price price of the product
   * @param minimumAge minimum age to buy this product
   */
  public Product(String manufacturer, String productName, double price, int minimumAge) {
    this.manufacturer = manufacturer;
    this.productName = productName;
    this.price = price;
    this.minimumAge = minimumAge;
  }

  /**
   * Checks if the given product is replaceable with the current product
   * @param product product
   * @return true or false
   */
  public abstract boolean isReplaceable(Product product);

  /**
   * gives the manufacturer of the product
   * @return manufacturer of the product
   */
   public String getManufacturer() {
    return manufacturer;
  }

  /**
   * sets the manufacturer of the product
   * @param manufacturer manufacturer of the product
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * gives the name of the product
   * @return name of the product
   */
  public String getProductName() {
    return productName;
  }

  /**
   * sets the name of the product
   * @param productName name of the product
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * gives the price of the product
   * @return price of the product
   */
  public double getPrice() {
    return price;
  }

  /**
   * sets the price of the product
   * @param price price of the product
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * gives the minimum age to buy the product
   * @return minimum age to buy the product
   */
  public int getMinimumAge() {
    return minimumAge;
  }

  /**
   * sets the minimum age to buy the product
   * @param minimumAge minimum age to buy the product
   */
  public void setMinimumAge(int minimumAge) {
    this.minimumAge = minimumAge;
  }

  /**
   * gives the string representation of product
   * @return string representation of product
   */
  @Override
  public String toString(){
    return(productName);
  }

  /**
   * This method is used to compare two product items.
   * It will return true only if both the products have same values of manufacturer, name, price and minimum age
   * @param obj product instance to be compared
   * @return true or false which indicates whether the two products are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    Product product = (Product) obj;
    return((this.manufacturer == null ? product.getManufacturer() == null : this.manufacturer.equals(product.getManufacturer()))
        && (this.productName == null ? product.getProductName() == null : this.productName.equals(product.getProductName()))
        && (this.price == product.getPrice())
        && (this.minimumAge == product.getMinimumAge()));
  }

  /**
   * This method is used to generate the hashcode for a product.
   * If two products are same, it will return the same hashcode for both of them
   * @return hashcode of the given product
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getManufacturer() == null ? 0 : this.getManufacturer().hashCode());
    result = 31 * result + (this.getProductName() == null ? 0 : this.getProductName().hashCode());
    result = 31 * result + (int)this.getPrice();
    result = 31 * result + this.getMinimumAge();

    return result;
  }
}
