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
  int weight;
  String ingredient;

  // -- constructor --
  public Cake(String ingredient) {
    this.ingredient = ingredient;
  }

  // -- methods --
  public void Draw(int h) {
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
        result += this.ingredient;
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
  //      /\
  /*     /^\\
   *    /^^\\\
   *   /^^^\\\\
   *  /^^^^\\\\\
   *  \====/////
   *
   *
   *
   *
   */
}
