import java.util.*;

/**
*
*
 */
// public class OverallGame extends GetInput {
public class OverallGame {
    static String player1, player2;
    static int player1TotalScore = 0, player2TotalScore = 0;

    public OverallGame() {
    }

    /**
    *
    *
    */
    public static void main(String args[]) {
        GetInput Input = new GetInput();
        // getting player names
        player1 = Players.getPlayerNames()[0];
        player2 = Players.getPlayerNames()[1];

        // display the scoreboard
        displayScoreBoard();

        // display the list of games
        displayGames();

        // prompt user to choose game using the Input class
        int choice = Input.getGameChoice();

        // starting the appropriate game
        startGame(choice);

        // ask if continue "c" or quit "q" from Input
        if (c) {
            // ask user game choice
            startGame(choice);
        }

        // updating the score

        this.displayScoreBoard();

        // player with greater points wins the game, but they did not specify a message
        // to be printed

    }

    /**
    *
    *
    */
    static void startGame(int choice) {
        switch (choice) {
            case 1:
                // FindTheRedThread
                FindTheRedThread thread = new FindTheRedThread(0, 0);

                int threadTemp1 = thread.player1Points;
                int threadTemp2 = thread.player2Points;
                player1TotalScore += threadTemp1;
                player2TotalScore += threadTemp2;
                break;
            case 2:
                // CoinFlip
                coin_flip coin = new coin_flip(0, 0);
                int coinTemp1 = coin.player1Points;
                int coinTemp2 = coin.player2Points;
                player1TotalScore += coinTemp1;
                player2TotalScore += coinTemp2;
                break;
            case 3:
                // GuessTheNumber
                GuessTheNumber guess = new GuessTheNumber(0, 0);
                int guessTemp1 = guess.player1Points;
                int guessTemp2 = guess.player2Points;
                player1TotalScore += guessTemp1;
                player2TotalScore += guessTemp2;
                break;
            case 4:
                // EvenOrOdd
                evenorodd even = new evenorodd(0, 0);
                int evenTemp1 = even.player1Points;
                int evenTemp2 = even.player2Points;
                player1TotalScore += evenTemp1;
                player2TotalScore += evenTemp2;
                break;
            case 5:
                // Thimble
                Thimble thimble = new Thimble(0, 0);
                int thimbleTemp1 = thimble.player1Points;
                int thimbleTemp2 = thimble.player2Points;
                player1TotalScore += thimbleTemp1;
                player2TotalScore += thimbleTemp1;
                break;
            default:
        }
    }

    /**
     *
     */
    static void displayGames() {
        System.out.println("1.Find The Red Thread\n2.Coin Flip\n3.Guess The Number\n4.Even or Odd\n5.Thimble");
    }

    /**
    *
    *
    */
    static int displayScoreBoard() {
        System.out.println(
                "Player 1 Total Score = " + player1TotalScore + "\n Player 2 Total Score = " + player2TotalScore);
    }
}