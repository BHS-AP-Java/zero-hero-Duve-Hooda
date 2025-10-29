package edu.bhscs;

public class StringHelpers {
  public static String putChars(int amt, String character) {
    String res = "";
    for (int i = 0; i < amt; i++) {
      res += character;
    }

    return res;
  }
}
