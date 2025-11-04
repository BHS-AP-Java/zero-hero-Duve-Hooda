package edu.bhscs;

// this an interface for offsetable objects
// while I like the idea i think an abstract class would be the superior solution
// this is because i would rather implement these methods one time rather than everywhere
public interface Offsetable {
  int offset = 0; // the current offset of the object

  /**
   * Sets the offset of the current object; Negative values means that this object does not need to
   * be offset
   *
   * @param offset The value to set the offset to (negative values = 0)
   */
  public void setOffset(int offset);

  /**
   * Gets the offset from the class
   *
   * @return the offset that is currently set
   */
  public int getOffset();
}
