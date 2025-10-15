package edu.bhscs;

public class User {

  private String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public Cake askForCake() {
    Console c = Console.getInstance();

    c.print("do you want cake? (y/n)\n> ");

    String ans = c.readLine();

    if (ans.equals("y")) {
      return new Cake();
    }

    return null;
  }
}
