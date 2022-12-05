
/**
 * Master class used to play different games Game of games.
 *
 * @author: Yves Semana Gisubizo
 * @version: 1.0.0
 */
public class PlayGamesBug {
    static String player1, player2;
    static int player1TotalScore = 0, player2TotalScore = 0;

    public PlayGamesBug() {
    }

    public static void main(String args[]) {
        GetInput Input = new GetInput();
        // getting player names
        String players[] = Input.getPlayerNames();
        player1 = players[0];
        player2 = players[1];

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

        // player with greater points wins Game of games, but they did not specify a
        // message to be printed. I personally added amde this up
        if (player1TotalScore > player2TotalScore) {
            System.out.println("Player 1 won Game of games. Congratulations " + player1 + "!");
        } else {
            System.out.println("Player 2/Computer won Game of games. Congratulations " + player1 + "!");
        }

    }

    /**
     * startGame mtheod that starts whichever game is chosed by the players
     *
     */
    static void startGame(int choice) {
        switch (choice) {
            case 1:
                // FindTheRedThread
                FindTheRedThreadBug thread = new FindTheRedThreadBug();

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
                coin_flip_bug coin = new coin_flip_bug();
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
                GuessTheNumber_bug guess = new GuessTheNumber_bug();
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
                evenorodd_bug even = new evenorodd_bug();
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
                ThimbleBug thimble = new ThimbleBug();
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
     * displayGames method displays all the 5 games whenever required
     */
    static void displayGames() {
        System.out.println(
                "\nAvailable games\n1.Find The Red Thread\n2.Coin Flip\n3.Guess The Number\n4.Even or Odd\n5.Thimble");
    }

    /**
     * displayScoreBoard method displays the updated scored board for the players
     * whenever required
     *
     */
    static void displayScoreBoard() {
        System.out.println(
                "\nPlayer 1 Total Score = " + player1TotalScore + "\nPlayer 2/Computer Total Score = "
                        + player2TotalScore + "\n");
    }

    /**
     * playOrEndGame method allows players to continue playring or quit the Game of
     * Games. Displays the overall final score board
     */
    static void playOrEndGame() {
        GetInput Input = new GetInput();
        String choice = Input.pickBetween("continue", "c", "quit", "q");
        if (choice.equals("c")) {
            // ask user game choice
            displayGames();
            int gameChoice = Input.getIntInRange(1, 5);
            startGame(gameChoice);
        } else if (choice.equals("q")) {
            displayScoreBoard();
            System.exit(1);
        }
    }
}
