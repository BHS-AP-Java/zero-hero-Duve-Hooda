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

public class Cake implements Offsetable {
  // -- fields & props --
  String ingredient;
  String ingredient2;
  String name;
  int age;

  int offset = 0;

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

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
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



  /**
   * Draw a cake based on a height value (automatically finds offset)
   *
   * @param height The height of the cake to draw
   */
  public void draw(int height) {
    String cakeRendered = "";

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

  /**
   * Draws the cake using a table to be placed on
   * Really it just calls table.draw(offset) and cake.draw(offset)
   * Just with some extra steps
   *
   * @param table The table to place the cake on
   */
  public void draw(Table table) {
    Console.getInstance().println(
        "Making a cake for: `" + this.name + "` who is: `" + this.age + "` years old!");
    this.ingredient = "#";
    this.ingredient2 = "@";

    // we double our age since the cake width is age * 2
    int offset = MathHelpers.calculateOffset(table.width, this.age * 2);

    // attempting to use an interface here...

    // table recieves a negated version bc our calculation is diff from table to cake
    // (offset = how much cake should move over)

    // i think we should change this because this still feels like
    // "cake is the one who controls table"
    // which shouldn't be the way it works...
    table.setOffset(-offset);
    this.setOffset(offset);

    this.draw(this.age);
    table.draw();
  }
  /*      /\
   *     /^\\
   *    /^^\\\
   *   /^^^\\\\
   *  /^^^^\\\\\
   *  \====/////
   */
}
