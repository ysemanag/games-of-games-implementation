import java.util.*;

public class GuessTheNumber_bug {

       int range;

       GetInput g = new GetInput();
       coin_flip c = new coin_flip();

       public GuessTheNumber_bug() {
       }

       public void run_game() {
              int current_guess_num = 1;
              int num_to_guess, guess;
              int num_of_guesses, range;
              boolean correct = false;

              range = g.getPositiveInt("Enter Range for 0 through: ");
              System.out.println();

              g.setInputRangeText("Enter number of guesses: ");
              num_of_guesses = g.getIntInRange(0, range);
              System.out.println();

              while (current_guess_num <= num_of_guesses && !correct) {
                     System.out.println("Guess " + current_guess_num + "\n");

                     num_to_guess = c.random_flip(range + 1);

                     System.out.println("Number to guess is " + num_to_guess + ".\n");

                     g.setInputRangeText("Pick a number between %d and %d: ");
                     guess = g.getIntInRange(0, range + 1000);
                     System.out.println();

                     if (guess == num_to_guess) {
                            System.out.println("Player's guess is correct\n");
                            correct = true;
                     } else {
                            System.out.println("Player's guess is incorrect\n");
                     }

                     current_guess_num++;
              }

              if (correct) {
                     System.out.println("Computer wins the game\n");
              } else {
                     System.out.println("Player wins the game\n");
              }
       }

       public static void main(String args[]) {

              GuessTheNumber_bug game = new GuessTheNumber_bug();

              game.run_game();
       }
}
