package edu.bhscs;

public class Table {
  public int legs;
  public int size;

  public Table(int legs, int size) {
    this.legs = legs;
    this.size = size;
  }

  public void draw() {
    Console c = Console.getInstance();

    String res = "";

    int spacing = size / legs;

    int leg_size = spacing - 1;

    for (int i = 0; i < size; i++) {
      res += "=";
    }

    res += "\n";

    for (int i = 0; i < leg_size; i++) {
      for (int j = spacing/2 + 1; j <= size; j++) {
        if (j % spacing == 0) {
          res += "|";
        } else {
          res += " ";
        }
      }
      res += "\n";
    }

    c.println(res);
  }
}
