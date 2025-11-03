// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Draws a cake in 3 dimensions via ASCII art
 * INPUT: Parameters of a cake
 * OUTPUT: You can see a 3d cake made to your specifications
 * EDGE CASE: Small cakes results in questionable ASCII art
 * EDGE CASE 2: Sometimes weird division values cause super weird offsets (most likely due to our questionable offset implementation)
 */

package edu.bhscs;

class Main {
  public static void main(String[] args) {
    date10_27();
  }

  public static void date10_27() {
    // ORIGINAL CODE:
    Baker bob = new Baker("Bob");
    Table t = new Table(3, 15);
    Cake bDay = bob.bakes(10, "Suzzie");
    bDay.draw(t);
  }
}
