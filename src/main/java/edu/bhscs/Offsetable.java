package edu.bhscs;

// this an interface for offsetable objects
// while I like the idea i think an abstract class would be the superior solution
// this is because i would rather implement these methods one time rather than everywhere
public interface Offsetable {
  public int getWidth();

  // Default centering logic — always clamps to 0 so alignment never goes negative.
  // this code is not used 99% of the time as we already have MathHelpers.calculateOffset();
  default int getOffset(Offsetable below) {
    if (below == null)
      return 0;
    return Math.max(0, (below.getWidth() - this.getWidth()) / 2);
  }

  // Each Offsetable thing knows how to draw itself
  // relative to whatever is beneath it.
  public void draw(Offsetable below);

  // expansion to Offsetable (so that it works with previous-related code)
  public void setOffset(int offset);
  public int getOffset();

  // objects must be able to be drawn without an offsetable
  public void draw();
}
