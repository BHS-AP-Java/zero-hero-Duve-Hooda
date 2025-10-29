// Dhruv Hooda
// P2
// Zero Hero
// 10/13/25

/*
 * DESCRIPTION: A cake that can be rendered to the display
 * INPUT: ingredients and weights provided in the constructor
 * OUTPUT: the return of the display object
 * EDGE CASE: if you use some raelly small numbers, the cake will look weird
 */

package edu.bhscs;

public class Cake {
  // -- fields & props --
  String ingredient;
  String ingredient2;
  String name;
  int age;

  // -- constructors --
  public Cake(String ingredient, String ingredient2) {
    this.ingredient = ingredient;
    this.ingredient2 = ingredient2;
  }

  public Cake() {
    this.ingredient = "a";
    this.ingredient2 = "b";
  }

  public Cake(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // -- methods --
  public void draw(int h) {
    String cakeRendered = "";

    cakeRendered += RenderMiddle(h);
    cakeRendered += RenderBottom(h);

    Console.getInstance().print(cakeRendered);
  }

  public String RenderTop(int width) {
    String result = "";

    if ((width % 2) == 1) {
      // odd width
      result += "_\n"; //  _
    }

    return result;
  }

  public String RenderMiddle(int height) {
    String result = "";

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < height - i; j++) {
        result += " ";
      }

      result += "/";
      String additional = "";

      for (int j = 0; j < i; j++) {
        if (j % 2 == 0) {
          result += this.ingredient2;
        } else {
          result += this.ingredient;
        }

        additional += "\\";
      }

      result += additional + "\\\n";
    }

    return result;
  }

  public String RenderBottom(int height) {
    String result = "";

    int width = height - 1;

    result += " \\";
    String amount = "";
    for (int i = 0; i < width; i++) {
      result += "=";
      amount += "/";
    }

    result += amount + "/";

    return result;
  }

  /**
   * Draws a cake based on a provided name and age
   *
   * @param name The name of the player
   * @param age The age of the player, also used for setting the height
   */
  public void draw(String name, String age) {
    System.out.println("Making a cake for: `" + name + "` who is: `" + age + "` years old!");
    this.draw(Integer.valueOf(age));
  }

  public void draw(int height, int offset) {
    String cakeRendered = "";

    // this means that CAKE is bigger than TABLE
    if (offset < 0) {
      // so we don't gotta move our cake duh
      offset = 0;
    }

    // middle aligned test code, but we will not use that currently
    String[] middleLines = RenderMiddle(height).split("\n");
    for (int i = 0; i < middleLines.length; i++) {
      cakeRendered += StringHelpers.putChars(offset, " ") + middleLines[i] + "\n";
    }

    String[] bottomLines = RenderBottom(height).split("\n");
    for (int i = 0; i < bottomLines.length; i++) {
      cakeRendered += StringHelpers.putChars(offset, " ") + bottomLines[i] + "\n";
    }

    Console.getInstance().print(cakeRendered);
  }

  public void draw(Table table) {
    System.out.println(
        "Making a cake for: `" + this.name + "` who is: `" + this.age + "` years old!");
    this.ingredient = "#";
    this.ingredient2 = "@";

    int offset = (table.width - (this.age * 2)) / 2;

    System.out.println(offset);

    this.draw(this.age, offset);
    table.draw(offset);
  }
  /*      /\
   *     /^\\
   *    /^^\\\
   *   /^^^\\\\
   *  /^^^^\\\\\
   *  \====/////
   */
}
