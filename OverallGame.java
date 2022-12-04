import java.util.*;

//import javax.lang.model.util.ElementScanner6;

/**
 * Master class of all the games in Game of games.
 * 
 * @author: Yves Semana Gisubizo
 * @version: 1.0.0
 */
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
        player1 = Input.getPlayerNames()[0];
        player2 = Input.getPlayerNames()[1];

        // display the scoreboard
        displayScoreBoard();

        // display the list of games
        displayGames();

        // prompt user to choose game using the Input class
        int choice = Input.getIntInRange(1, 5);

        // starting the appropriate game
        startGame(choice);

        // ask if continue "c" or quit "q" from Input
        playOrEndGame();

        // updating the score

        displayScoreBoard();

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
                FindTheRedThread thread = new FindTheRedThread();

                boolean threadStatus = thread.runGame();
                boolean found = thread.found; // only adding points for players if thread was found
                if (threadStatus && found) {
                    player1TotalScore++;
                } else if (!threadStatus && found) {
                    player2TotalScore++;
                }
                displayScoreBoard();
                playOrEndGame();
                break;
            case 2:
                // CoinFlip
                coin_flip coin = new coin_flip();
                boolean coinStatus = coin.run_game();
                if (coinStatus) {
                    player1TotalScore++;
                } else {
                    player2TotalScore++;
                }
                displayScoreBoard();
                playOrEndGame();
                break;
            case 3:
                // GuessTheNumber
                GuessTheNumber guess = new GuessTheNumber();
                boolean guessStatus = guess.run_game();
                if (guessStatus) {
                    player1TotalScore++;
                } else {
                    player2TotalScore++;
                }
                displayScoreBoard();
                playOrEndGame();
                break;
            case 4:
                // EvenOrOdd
                evenorodd even = new evenorodd();
                boolean evenStatus = even.run_game();
                if (evenStatus) {
                    player1TotalScore++;
                } else {
                    player2TotalScore++;
                    displayScoreBoard();
                    playOrEndGame();
                }
                break;
            case 5:
                // Thimble
                Thimble thimble = new Thimble();
                boolean thimbleStatus = thimble.thimbleMatch();
                if (thimbleStatus) {
                    player1TotalScore++;
                } else {
                    player2TotalScore++;
                }
                displayScoreBoard();
                playOrEndGame();
                break;
            default:
        }
    }

    /**
     *
     */
    static void displayGames() {
        System.out.println(
                "\nAvailable games\n1.Find The Red Thread\n2.Coin Flip\n3.Guess The Number\n4.Even or Odd\n5.Thimble");
    }

    /**
    *
    *
    */
    static void displayScoreBoard() {
        System.out.println(
                "\nPlayer 1 Total Score = " + player1TotalScore + "\nPlayer 2 Total Score = " + player2TotalScore);
    }

    /**
     *
     */
    static void playOrEndGame() {
        GetInput Input = new GetInput();
        if ("c".equals(Input.pickBetween("continue", "c", "quit", "q"))) {
            // ask user game choice
            displayGames();
            int choice = Input.getIntInRange(1, 5);
            startGame(choice);
        }
    }
}