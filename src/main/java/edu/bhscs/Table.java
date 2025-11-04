// Dhruv Hooda
// P2
// Zero Hero
// 10/27/25

/*
 * DESCRIPTION: A table that can be drawn
 * INPUT: width or number of legs
 * OUTPUT: a cool looking table!
 * EDGE CASE: Whenever there is an even number of width the last leg is printed slightly off of the
 * table. Also if the legs are beyond a certain size the table will start drawing extremely weirdly
 */

package edu.bhscs;

/** A base table object that can be drawn to the console */
public class Table implements Offsetable {
  // -- fields and props --
  public int legs;
  public int width;

  private int offset = 0;

  private String legsChar = "|";
  private String tableChar = "=";

  // -- constructor

  public Table(int legs, int width) {
    // prevent edge case of less than 2 legs
    if (legs < 2) {
      this.legs = 2;
    } else {
      this.legs = legs;
    }

    this.width = width;
  }

  // -- methods --

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  /**
   * Sets the character for each leg
   *
   * @param legs The String for the leg of the table
   */
  public void setLeg(String legs) {
    this.legsChar = legs;
  }

  /**
   * Sets the top character of the table
   *
   * @param top The String for the top of the table
   */
  public void setTop(String top) {
    this.tableChar = top;
  }

  /**
   * Renders our table before sending it to be drawn to the console
   *
   * @return The Rendered String of the table
   */
  public String render() {
    String res = "";

    int legHeight = Math.floorDiv(this.width, 4);

    int spacing = Math.floorDiv(this.width, this.legs - 1);

    // to help make our spacing more accurate based on the size of our leg
    spacing -= (this.legsChar.length() - 1);

    // print out the top of our table
    // notice how isntead of i++, i use this.tableChar.length() meaning that i increases based on
    // the chars added
    // pretty cool man
    for (int i = 0; i < this.width; i += this.tableChar.length()) {
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

  /** Draw a table to the console (automatically resolves offset) */
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

  /*
     *     /\
          /@\\
         /@#\\\
        /@#@\\\\
       /@#@#\\\\\
      /@#@#@\\\\\\
     /@#@#@#\\\\\\\
    /@#@#@#@\\\\\\\\
   /@#@#@#@#\\\\\\\\\
  /@#@#@#@#@\\\\\\\\\\
  \=========//////////
     */
}
