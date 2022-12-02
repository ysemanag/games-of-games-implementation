
/**
 * Write a description of class Thimble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Thimble
{
    // instance variables - replace the example below with your own
    private int rounds = 0;
    private int hiddenPoints = 0;
    private int foundPoints = 0;
    private GetInput fetch = new GetInput();

    /**
     * Constructor for objects of class Thimble
     */
    public Thimble()
    {
    }

    public boolean thimbleMatch() {
        rounds = fetch.getBestOf();
        while(hiddenPoints < rounds / 2 + 1 && foundPoints < rounds / 2 + 1) {
            if(thimbleRound()) {
                System.out.println("Thimble found! Player 2 wins a round.");
                foundPoints++;
            } else {
                System.out.println("Thimble not found! Player 1 wins a round.");
                hiddenPoints++;
            }

            System.out.println("Player 1 (hider) " + hiddenPoints + " - " + foundPoints + " Player 2 (finder)");
        }
        if(foundPoints < hiddenPoints) {
            System.out.println("Player 1 is the winner!");
        } else {
            System.out.println("Player 2 is the winner!");
        }
        return foundPoints > hiddenPoints; // true = player 1, false = player 2;
    }

    public boolean thimbleRound() {

        System.out.println("Player 1 now hides the thimble.");
        String hidden = fetch.pickBetween("left", "l", "right", "r");
        System.out.println("Player 2 now opens a hand.");
        String find = fetch.pickBetween("left", "l", "right", "r");
        return hidden.equals(find);
    }
}
