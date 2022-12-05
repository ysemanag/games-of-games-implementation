//Author: Benny Simoes
//Version: 3.0

import java.util.*;

public class coin_flip {

	private int total_rounds, round_num;
	private int guesser_points = 0;
	private int computer_points = 0;
	private String guess, flipC;
	private boolean p_wins;

	GetInput g = new GetInput();
	
	//Constructor
	public coin_flip() {
		round_num = 0;
	}

	//Displays description of the game
	private static void display_description() {
		System.out.println(
				"Coin flip is the practice of throwing a coin in the air and checking which side is showing when it lands, in order to choose between two alternatives, heads or tails. It is a form of sortition which inherently has two possible outcomes. The guesser calls the side that is facing up when the coin lands and the flipper flips the coin, if the coin lands on the guesser’s guess,then the guesser gets the point. If the guesser is incorrect, then the flipper gets the point. They play until one of their scores reaches the best out of the number divided by 2 plus 1.");
		System.out.println();
	}

	//flips the coin to check if user picked the right side or not.
	public int random_flip(int range) {
		Random flip = new Random();
		int rand_num = flip.nextInt(range);
		return rand_num;
	}

	//displays the scoreboard containing the scores of the player and the computer.
	private void display_scoreboard() {                                          //undefined label
		System.out.println("SCOREBOARD");
		System.out.println("Guesser: " + guesser_points + " points.");
		System.out.println("Computer: " + computer_points + " points.\n");
	}

	//converts the random number generated when computer flips the coin into an ‘H’ or ‘T’ 
	private void conversion(int flip) {
		if (flip == 0) {
			flipC = "H";
		} else {
			flipC = "T";
		}
	}

	//determines and displays who wins the round and updates the score of winner.
	private void determine_winner_of_round() {
		if (guess.equals(flipC)) {
			System.out.println("Guesser won the round.\n");
			guesser_points++;
		} else {
			System.out.println("Computer won the round.\n");
			computer_points++;
		}
	}

	//determines and displays who wins the game.
	private void determine_winner_of_game() {
		if (guesser_points > total_rounds / 2) {
			System.out.println("Guesser won the coin flip game.\n");
			p_wins = true;
		} else if (computer_points > total_rounds / 2) {
			System.out.println("Computer won the coin flip game.\n");
			p_wins = false;
		}
	}

	//uns all the methods in order for the user to play the game.
	public boolean run_game() {
		int flip;

		display_description();

		total_rounds = g.getBestOf();
		System.out.println();

		System.out.println("The game is going to play best out of " + total_rounds + " rounds.\n");

		System.out.println("You are the guesser, the computer is the flipper.\n");

		while (guesser_points <= total_rounds / 2 && computer_points <= total_rounds / 2) {
			round_num++;
			System.out.println("Round " + round_num + " out of " + total_rounds + " rounds.\n");
			g.setPickBetweentext("Enter %s for %s or %s for %s: ");
			g.setBadInputText("Invalid input, please only enter ‘H’ or ‘T’.");
			guess = g.pickBetween("picking heads", "H", "picking tails", "T");
			System.out.println();
			flip = random_flip(2);
			conversion(flip);
			System.out.println("You have guessed " + guess + ", and the coin landed on " + flipC + ".\n");
			determine_winner_of_round();
			display_scoreboard();
			determine_winner_of_game();
		}
		return p_wins;
	}

	public static void main(String args[]) {

		coin_flip game = new coin_flip();

		game.run_game();
	}
}
