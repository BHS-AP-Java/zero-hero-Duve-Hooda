package edu.bhscs;

public class MathHelpers {
  /**
   * Gives the offset by taking the int FARTHEST from zero
   *
   * @param LeftWidth the width of the left object
   * @param RightWidth the width of the right object
   * @return The offset
   */
  public static int calculateOffset(int LeftWidth, int RightWidth) {
    // yes this looks quite bad, doing division with ints just doesnt work, so im converting
    // when you divide with ints it gives a float thats rounded, we do NOT want that
    // i believe there is actually a better way than this but I am unsure on how to implement it
    float float_LeftWidth = (float) (LeftWidth);
    float float_RightWidth = (float) (RightWidth);

    // just runs the float implementation
    return calculateOffset(float_LeftWidth, float_RightWidth);
  }

  /**
   * Gives the offset using the FARTHEST value from zero (float version)
   *
   * @param LeftWidth The width of the left object (float)
   * @param RightWidth The width of the right object (float)
   * @return The offset
   */
  public static int calculateOffset(float LeftWidth, float RightWidth) {
    // (15 - (10 * 2)) / 2
    // (15 - 20) / 2
    // 5 / 2
    // 2.5
    float division = (LeftWidth - RightWidth) / 2;
    float absDivision = Math.abs(division);

    float sign = Math.signum(division);

    return (int) (Math.ceil(absDivision) * sign);
  }
}
