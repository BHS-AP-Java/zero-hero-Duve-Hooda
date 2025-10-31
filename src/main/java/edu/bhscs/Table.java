// Dhruv Hooda
// P2
// Zero Hero
// 10/27/25

/*
 * DESCRIPTION: A table that can be drawn INPUT: width or number of legs OUTPUT: a cool looking table! EDGE CASE: Whenever there is an even number of width the last leg is printed slightly off of the
 * table
 */

package edu.bhscs;

/** A base table object that can be drawn to the console */
public class Table implements Offsetable {
  public int legs;
  public int width;

  private int offset = 0;

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

  public String render() {
    String res = "";

    int legHeight = Math.floorDiv(this.width, 4);

    int spacing = Math.floorDiv(this.width, this.legs - 1);

    // print out the top of our table
    for (int i = 0; i < this.width; i++) {
      res += this.tableChar;
    }

    res += "\n";

    // print out the legs based off the spacing of the table

    String legRow = "";

    // we use a nested for loop here
    // we just go over the width of the table, legHeight times
    // its <= so that we have a the last leg
    for (int j = 0; j <= this.width; j++) {
      if (j % spacing == 0) {
        legRow += this.legsChar;
      } else {
        legRow += " ";
      }
    }

    if (legRow.length() > width) {
      legRow = legRow.substring(0, width - this.legsChar.length());
      legRow += this.legsChar;
    }

    for (int i = 0; i < legHeight; i++) {
      res += legRow + "\n";
    }

    return res;
  }

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void draw() {
    String res = render();

    String finalResult = "";

    String[] lines = res.split("\n");
    for (int i = 0; i < lines.length; i++) {
      finalResult += StringHelpers.putChars(offset, " ") + lines[i] + "\n";
    }

    Console.getInstance().print(finalResult);
  }

  /*
   * -----11----
   * ===========
   * |----9----|
   * |         |
   *
   */

  /*
   * -----11----
   * ===========
   * |-4--|--4-|
   * |    |    |
   * |    |    |
   *
   * -----12-----
   * ============
   * |----10----|
   * |--5--|--4-|
   *
   *
   * ------1_5------
   * ===============
   * |--7---|---7--|
   */
}
