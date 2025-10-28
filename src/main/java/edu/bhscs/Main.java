// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Draws a cake in 3 dimensions via ASCII art
 * INPUT: Parameters of a cake
 * OUTPUT: You can see a 3d cake made to your specifications
 * EDGE CASE: Small cakes results in questionable ASCII art
 */

package edu.bhscs;

class Main {
  public static void main(String[] args) {
    // new Cake("y", "a").draw(2);

    // Console.getInstance().println("\n\n--------------\n\n");

    // new Cake().draw(5);

    date10_27();
  }

  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(3, 14);
    Cake bDay = bob.bakes(5, "Suzzie");
    bDay.draw(t);
  }
}
