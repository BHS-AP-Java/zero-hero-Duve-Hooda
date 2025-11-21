package edu.bhscs;

public class Baker {
  // -- fields and props --
  private String name;

  // -- constructor --
  /**
   * Creates a default baker with a name
   *
   * @param name The name of the baker
   */
  public Baker(String name) {
    this.name = name;
  }

  // -- methods --
  /**
   * Creates a new cake that takes the age and name as constructor
   *
   * @param age the "age" of the player
   * @param name the "name" of the player
   * @return a new cake that has these two props
   */
  public Cake bakes(int age, String name) {
    return new Cake(name, age);
  }

  /**
   * Returns the name of the baker
   *
   * @return The name of the baker
   */
  public String getName() {
    return name;
  }
}
