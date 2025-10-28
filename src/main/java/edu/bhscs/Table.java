// Dhruv Hooda
// P2
// Zero Hero
// 10/27/25

/*
 * DESCRIPTION: A table that can be drawn
 * INPUT: width or number of legs
 * OUTPUT: a cool looking table!
 * EDGE CASE: Whenever there is an even number of width the last leg is printed slightly off of the table
*/

package edu.bhscs;

/**
 * A base table object that can be drawn to the console
 */
public class Table {
  public int legs;
  public int width;

  private String legsChar = "|";
  private String tableChar = "=";

  public Table(int legs, int width) {
    // prevent edge case of less than 2 legs
    if (legs < 2) {
      this.legs = 2;
    } else {
      this.legs = legs;
    }

    this.width = width;
  }

  public void setLegs(String legs) {
    this.legsChar = legs;
  }

  public void setTop(String top) {
    this.tableChar = top;
  }

  public void draw() {
    Console c = Console.getInstance();

    String res = "";

    int legHeight = Math.floorDiv(this.width, 4);

    int spacing = Math.floorDiv(this.width, this.legs - 1);

    System.out.println(spacing);

    // print out the top of our table
    for (int i = 0; i < this.width; i++) {
      res += this.tableChar;
    }

    res += "\n";

    // print out the legs based off the spacing of the table

    // we use a nested for loop here
    // we just go over the width of the table, legHeight times
    for (int i = 0; i < legHeight; i++) {
      // its <= so that we have a the last leg
      for (int j = 0; j <= this.width; j++) {
        if (j % spacing == 0) {
          res += this.legsChar;
        } else {
          res += " ";
        }
      }
      res += "\n";
    }


    c.println(res);
  }
  /* -----11----
   * ===========
   * |----9----|
   * |         |
   * |         |
   * |         |
   *
   */

  /* -----11----
   * ===========
   * |-4--|--4-|
   * |    |    |
   * |    |    |
   * |    |    |
   *
   *
   * ------1_5------
   * ===============
   * |--7---|---7--|
   */
}
