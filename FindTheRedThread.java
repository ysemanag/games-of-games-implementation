
/**
 * FindTheRedThread class used to play the game of finding the red thread among
 * all the other blue threads by pulling a certain numbrof threads at every
 * round
 * 
 * @author: Yves Semana Gisubizo
 * @version: 1.0.0
 *
 */
public class FindTheRedThread {

    static int numOfThreadsToPull = 0;
    static int redThread = 12; // fixed the red thread to be this number between 1-20
    static boolean winStatus = false; // returns true if player wins and false if computer/player2 wins
    static boolean found = false;
    // thread

    // constructor
    public FindTheRedThread() {
    }

    /**
     * runGame method containing all the necessary running tools for this game
     * 
     * @return boolean: true if Player 1 wins this game and false if player 1 or
     *         computer wins
     */

    public static boolean runGame() {
        GetInput SpoolsInput = new GetInput();
        int numOfSpools = 0;

        do {
            numOfSpools = SpoolsInput.getPositiveInt("\nPick the number of spools: (Enter a number between 1 to 10):");
        } while (numOfSpools < 1 || numOfSpools > 10);

        int player = choosePlayer();
        numOfThreadsToPull = giveNumberOfThreads();

        // randomizing the numbers between 1-20, if these numbers include the
        int maxPossiblePulls = 10; // maximum possible pulls for each player

        while (maxPossiblePulls > 0) {
            // they did not specify what happens if this number is reached without computer
            // randomizing the red thread
            if (maxPossiblePulls == 0) {
                // no more threads to pull
                if (player == 1) {
                    winStatus = true;
                } else {
                    winStatus = false;
                }
                return winStatus;
            }
            if (checkForThread(numOfThreadsToPull, player)) {
                if (player == 1) {
                    winStatus = true;
                } else {
                    winStatus = false;
                }
                return winStatus;
                // did not specify what happens after this player wins, they just said go back
                // to choosing player and thread
            } else {
                // assigning a different player to play
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }
            maxPossiblePulls--;
        }

        // they have not specified when this game should end

        return winStatus;

    }

    /**
     * choosePlayer method chooses between the players alternatively for every round
     * 
     * @return int: 1 for player 1 or 2 for player 2/computer
     */
    static int choosePlayer() {
        GetInput UserInput = new GetInput();
        int userChoice;
        System.out.println("1. User 1\n2. User 2");

        do {
            userChoice = Integer.parseInt(UserInput.pickBetween("User 1", "1", "User 2", "2"));
            if (userChoice == 1 || userChoice == 2) {
                return userChoice;
            }
        } while (userChoice != 1 || userChoice != 2);

        return -1;
    }

    /**
     * giveNumberOfThreads method used to get the total number of threads to be
     * pulled from the box
     * 
     * @return int: the entered total number of threads
     */
    static int giveNumberOfThreads() {
        GetInput ThreadNumberInput = new GetInput();
        int numOfThreadsToPull = ThreadNumberInput.getPositiveInt(
                "\nPlease enter number of threads to pull from the box (array with random values(19 blue threads and 1 Red)):");
        // they did not say what happens if number of threads is greater than 20

        return numOfThreadsToPull;
    }

    /**
     * checkForThread method checks if the thread pulled by the player is red or not
     * 
     * @return boolean: true if the thread was found and false if all threads have
     *         been pulled without pulling the red thread. In this case, they did
     *         not specify whay happens, so I just continue without giving points to
     *         any player
     * 
     */
    static boolean checkForThread(int numThreads, int player) {
        int index = 0;
        int min = 1, max = 20;
        while (index < numThreads) {
            int pulledThread = (int) Math.floor(Math.random() * (max - min + 1) + min); // randomizing a number btn 1-20
            System.out.print("Player " + player + " pulled thread " + pulledThread + "\n");
            if (pulledThread == redThread) {
                System.out.println("Red thread found. Player " + player + " won!");
                found = true;
                break;
            }

            index++;
        }
        return found;
    }

    public static void main(String args[]) {

        FindTheRedThread redthread = new FindTheRedThread();
        redthread.runGame();
    }

}