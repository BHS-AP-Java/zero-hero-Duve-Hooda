package edu.bhscs;

public class Player {
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String giveAnswer(String question) {
    Console c = Console.getInstance();

    c.print(question + "\n> ");
    return c.readLine();
  }
}
