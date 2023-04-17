package assignment2.problem1;

/**
 * Represents the name which contains first name and last name
 * @author resmohan
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Creates a new name given the first name and last name
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * gives the first name
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * sets the first name
   * @param firstName first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * gives the last name
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * sets the last name
   * @param lastName last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * This method is used to compare two person names.
   * It will return true only if both the persons have same first name, middle name and last name
   * @param obj name instance to be compared
   * @return true or false which indicates whether the two names are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    Name name = (Name) obj;
    return((this.firstName == null ? name.getFirstName() == null : this.firstName.equals(name.getFirstName()))
        && (this.lastName == null ? name.getLastName() == null : this.lastName.equals(name.getLastName())));
  }

  /**
   * This method is used to generate the hashcode for a name.
   * If two names are same, it will return the same hashcode for both of them
   * @return hashcode of the given name
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getFirstName() == null ? 0 : this.getFirstName().hashCode());
    result = 31 * result + (this.getLastName() == null ? 0 : this.getLastName().hashCode());

    return result;
  }

  /**
   * String representation of name
   * @return string representation
   */
  @Override
  public String toString(){
    return(this.firstName+" "+this.lastName);
  }
}
