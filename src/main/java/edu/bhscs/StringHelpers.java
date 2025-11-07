package edu.bhscs;

public class StringHelpers {
  /**
   * Returns a string with x amount of a character
   *
   * @param amt The amount of characters to put
   * @param character The character itself
   * @return A string containing the character repeated x times
   */
  public static String putChars(int amt, String character) {
    String res = "";
    for (int i = 0; i < amt; i++) {
      res += character;
    }

    return res;
  }
}
