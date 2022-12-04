
/**
 * Write a description of class Thimble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class ThimbleTest
{
    // instance variables - replace the example below with your own
    private int rounds = 0;
    private int hiddenPoints = 0;
    private int foundPoints = 0;
    private GetInput fetch = new GetInput();
    private Random r = new Random();

    /**
     * Constructor for objects of class Thimble
     */
    public ThimbleTest()
    {
    }

    public boolean thimbleMatch() {
        rounds = fetch.getBestOf();
        while(hiddenPoints < rounds / 2 + 1 && foundPoints < rounds / 2 + 1) {
            if(thimbleRound()) {
                System.out.println("Thimble found! Player wins a round.");
                foundPoints++;
            } else {
                System.out.println("Thimble not found! Computer wins a round.");
                hiddenPoints++;
            }

            System.out.println("[TEST MODE: CURRENT SCORE: Computer " + hiddenPoints + " - " + foundPoints + " Player]");
        }
        if(foundPoints < hiddenPoints) {
            System.out.println("The computer is the winner!");
        } else {
            System.out.println("The player is the winner!");
        }
        return foundPoints > hiddenPoints; // true = player 1, false = player 2;
    }

    public boolean thimbleRound() {
        System.out.println("The computer now hides the thimble.");
        String hidden = "l";
        if(r.nextBoolean()) {
            hidden = "r";
        }
        System.out.printf("[TEST MODE: Computer's thimble hand is: %s]\n", hidden);
        System.out.println("The player now opens a hand.");
        String find = fetch.pickBetween("left", "l", "right", "r");
        return hidden.equals(find);
    }
}
