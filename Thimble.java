
/**
 * This is able to run the game Find the Thimble.
 *
 * @author Ed Shi
 * @version 1.0
 */

import java.util.*;

public class Thimble {
    // instance variables - replace the example below with your own
    private int rounds = 0;
    private int hiddenPoints = 0;
    private int foundPoints = 0;
    private GetInput fetch = new GetInput();
    private Random r = new Random();

    /**
     * Constructor for objects of class Thimble
     */
    public Thimble() {
    }

    /**
     * Runs a full game of Find the Thimble.
     *
     * @returns true if the human player wins, false if the computer wins
     */
    public boolean thimbleMatch() {

        rounds = fetch.getBestOf();
        while (hiddenPoints < rounds / 2 + 1 && foundPoints < rounds / 2 + 1) {
            if (thimbleRound()) {
                System.out.println("Thimble found! Player wins a round."); // < i wrote this text; use cases did not specify
                foundPoints++;
            } else {
                System.out.println("Thimble not found! Computer wins a round."); // < i wrote this text; use cases did not specify
                hiddenPoints++;
            }
        }
        if (foundPoints < hiddenPoints) {
            System.out.println("Computer is *winner*");
        } else {
            System.out.println("Player is the *winner*");
        }
        return foundPoints > hiddenPoints; // true = player, false = computer;
    }

    /**
     * Runs a single iteration of Find the Thimble (one hide, one search)
     *
     * @returns true if the thimble is found, false if the thimble is not found
     */
    public boolean thimbleRound() {
        System.out.println("The computer now hides the thimble."); // < i wrote this text; use cases did not specify
        String hidden = "l";
        if (r.nextBoolean()) {
            hidden = "r";
        }
        System.out.println("The player now opens a hand."); // < i wrote this text; use cases did not specify
        String find = fetch.pickBetween("left", "l", "right", "r");
        return hidden.equals(find);
    }
}
