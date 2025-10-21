package edu.bhscs;

public class User {

  // fields and props
  private String name;

  // constructor
  public User(String name) {
    this.name = name;
  }


  // methods

  public String getName() {
    return this.name;
  }

  public Cake askForCake() {
    Console c = Console.getInstance();

    c.print("do you want cake? (y/n)\n> ");

    String ans = c.readLine();

    if (ans.equals("y")) {
      return new Cake("~");
    }

    return null;
  }

  public String giveAnswer(String question) {
    return "This is an answer!";
  }
}
