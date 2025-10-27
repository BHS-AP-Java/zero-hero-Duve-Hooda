package edu.bhscs;

public class Baker {
  private String name;

  public Baker(String name) {
    this.name = name;
  }

  public Cake bakes(int age, String name) {

    return new Cake(name, age);
  }

  public String getName() {
    return name;
  }
}
