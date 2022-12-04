import java.util.*;

/**
*
*
 */
public class FindTheRedThread {

    static int player1Points = 0, player2Points = 0, numOfThreadsToPull = 0;
    static int redThread = 12; // fixed number between 1-20 for now, might change a way of determining this red
    // thread

    // constructor
    public FindTheRedThread(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player1Points;
    }

    /**
    *
    *
     */
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int numOfSpools = 0, userChoice = 0;
        // boolean found = false;

        do {
            System.out.println("Pick the number of spools: (Enter a number between 1 to 10): ");
            numOfSpools = sc.nextInt();
        } while (numOfSpools < 1 || numOfSpools > 10);

        int player = choosePlayer();
        numOfThreadsToPull = giveNumberOfThreads();

        // randomizing the numbers between 1-20, if these numbers include the
        // redThread=12, player 1
        int maxPossiblePulls = 10; // maximum possible pulls for each player

        while (maxPossiblePulls > 0) {
            // they did not specify what happens if this number is reached without computer
            // randomizing the red thread
            if (maxPossiblePulls == 0) {
                // no more threads to pull
                endGame();
            }
            if (checkForThread(numOfThreadsToPull, player)) {
                endGame();
                // did not specify what happens after this player wins, they just said go back
                // to choosing player and thread
            } else {
                // assigning a different player to play
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
                // found = checkForThread(numOfThreadsToPull, player);
            }
            maxPossiblePulls--;
        }

        // they have not specified when this game should end

    }

    /**
    *
    *
     */
    static int choosePlayer() {
        Scanner sc = new Scanner(System.in);
        int userChoice;
        System.out.println("1. User 1\n2. User 2");

        do {
            System.out.println("Please enter 1 for player 1 or 2 for player 2. Enter your choice: ");
            userChoice = sc.nextInt();
            if (userChoice == 1 || userChoice == 2) {
                return userChoice;
            }
        } while (userChoice != 1 || userChoice != 2);

        return -1;
    }

    /**
    *
    *
    */
    static int giveNumberOfThreads() {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Please enter number of threads to pull from the box (array with random values(19 blue threads and 1 Red)):");
        int numOfThreadsToPull = sc.nextInt();

        // they did not say what happens if number of threads is greater than 20

        return numOfThreadsToPull;
    }

    /**
    *
    *
    */
    static boolean checkForThread(int numThreads, int player) {
        boolean found = false;
        int index = 0;
        int min = 1, max = 20;
        while (index < numThreads) {
            int pulledThread = (int) Math.floor(Math.random() * (max - min + 1) + min); // randomizing a number btn 1-20
            System.out.print("Player " + player + " pulled thread " + pulledThread + "\n");
            if (pulledThread == redThread) {
                System.out.println("Red thread found. Player " + player + " won!");
                found = true;
                // add point to player 1
                if (player == 1) {
                    player1Points++; // wasn't defined in their use cases
                } else {
                    player2Points++; // wasn't defined in their use cases
                }
                break;
            }

            index++;
        }
        return found;
    }

    /**
    *
    *
    */
    static void endGame() {
        // update the total score baord and then
        System.exit(1);
    }
}