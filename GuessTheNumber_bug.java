//Author: Benny Simoes
//Version: 1.0

import java.util.*;

public class GuessTheNumber_bug {

       private int range;
       private boolean p_wins;
       

       GetInput g = new GetInput();
       coin_flip c = new coin_flip();

	// constructor
       public GuessTheNumber_bug() {
       }

	// runs all the methods in order for the user to play the game.
       public boolean run_game() {
              int current_guess_num = 1;
              int num_to_guess, guess;
              int num_of_guesses, range;
              boolean correct = false;

              range = g.getPositiveInt("Enter Range for 0 through: ");
              System.out.println();

              g.setInputRangeText("Enter number of guesses: ");
              g.setBadInputText("That is out of range!");   //undefined label
              num_of_guesses = g.getIntInRange(0, range);
              System.out.println();
              
              num_to_guess = c.random_flip(range + 1);

              while (current_guess_num <= num_of_guesses && !correct) {
                     System.out.println("Guess " + current_guess_num + "\n");

                     System.out.println("Number to guess is " + num_to_guess + ".\n");   //undefined label

                     g.setInputRangeText("Pick a number between %d and %d: ");   //undefined label
                     guess = g.getIntInRange(0, range + 1000);
                     System.out.println();

                     if (guess == num_to_guess) {
                            System.out.println("Player's guess is correct\n");   //undefined label
                            correct = true;
                     } else {
                            System.out.println("Player's guess is incorrect\n");   //undefined label
                     }

                     current_guess_num++;
              }

              if (correct) {
                     System.out.println("Computer wins the game\n");   //undefined label
                     p_wins = true;
              } else {
                     System.out.println("Player wins the game\n");   //undefined label
                     p_wins = false;
              }
              return p_wins;
       }

       public static void main(String args[]) {

              GuessTheNumber_bug game = new GuessTheNumber_bug();

              game.run_game();
       }
}
