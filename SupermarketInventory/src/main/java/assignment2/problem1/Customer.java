package assignment2.problem1;

/**
 * Represents the customer which tracks name and age
 * @author resmohan
 */
public class Customer {
  private Name name;
  private int age;
  ShoppingCart shoppingCart;

  /**
   * Creates a new instance of customer given the name and age
   * @param name name of the customer
   * @param age age of customer
   */
  public Customer(Name name, int age) {
    this.name = name;
    this.age = age;
  }

  /**
   * When customer starts shopping, a new shopping cart is created
   * @return shopping cart
   */
  public ShoppingCart startShopping(){
    this.shoppingCart = new ShoppingCart();
    return this.shoppingCart;
  }

  /**
   * gives the name of the customer
   * @return name
   */
  public Name getName() {
    return name;
  }

  /**
   * sets the name of the customer
   * @param name name
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * gives the age of the customer
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * sets the age of the customer
   * @param age age
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * gives the shopping cart
   * @return shopping cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * sets the shopping cart
   * @param shoppingCart shopping cart
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  /**
   * This method is used to compare two customers.
   * It will return true only if both the customers have same name and age
   * @param obj name instance to be compared
   * @return true or false which indicates whether the two customers are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    Customer customer = (Customer) obj;
    return((this.name == null ? customer.getName()  == null : this.name.equals(customer.getName()))
        && (this.age == customer.getAge()));
  }

  /**
   * This method is used to generate the hashcode for a customer.
   * If two customers are same, it will return the same hashcode for both of them
   * @return hashcode of the given customer
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
    result = 31 * result + (this.getAge());

    return result;
  }

  /**
   * String representation of Customer
   * @return string representation
   */
  @Override
  public String toString(){
    return("Name : "+this.name+"\nAge : "+this.age);
  }
}
