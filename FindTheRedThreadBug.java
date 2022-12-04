import java.util.*;

public class FindTheRedThreadBug {
    static int player1Points = 0, player2Points = 0, numOfThreadsToPull = 0;
    static int redThread = 12; // fixed number between 1-20 for now, might change a way of determining this red
    static boolean winStatus = false; // returns true if player wins and false if computer/player2 wins
    public static boolean found = false;
    // thread

    // constructor
    public FindTheRedThreadBug() {
    }

    /**
    *
    *
     */

    public static boolean runGame() {
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
        int maxPossiblePulls = 10; // maximum possible pulls for each player

        while (maxPossiblePulls >= 0) { // BUG 1: ALLOWING USERS TO PULL THREADS WHEN THERE ARE NO MORE THREADS LEFT
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
                // found = checkForThread(numOfThreadsToPull, player);
            }
            maxPossiblePulls--;
        }

        // they have not specified when this game should end

        return winStatus;

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
            // BUG 2: MISMATCHING THE USER CHOICES
            System.out.println("Please enter 2 for player 1 or 1 for player 2. Enter your choice: ");
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
                "Please enter number of threads to pull from the box (The red thread is number 12)):");
        int numOfThreadsToPull = sc.nextInt();

        // they did not say what happens if number of threads is greater than 20

        return numOfThreadsToPull;
    }

    /**
    *
    *
    */
    static boolean checkForThread(int numThreads, int player) {
        // boolean found = false;
        Scanner sc = new Scanner(System.in);
        int index = 0;
        // int min = 1, max = 20;
        while (index < numThreads) {
            // int pulledThread = (int) Math.floor(Math.random() * (max - min + 1) + min);
            // // randomizing a number btn 1-20
            System.out.println("Pick a thread by entering a number btn 1-20 (Red Thread is 12): ");
            int pulledThread = sc.nextInt();
            System.out.print("Player " + player + " pulled thread " + pulledThread + "\n");
            if (pulledThread == redThread) {
                System.out.println("Red thread found. Player " + player + " won!");
                // found = true; //BUG 3: FORGETTING TO UPDATE FOUND STATUS
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
    public static void main(String args[]) {

        FindTheRedThread redthread = new FindTheRedThread();
        redthread.runGame();
    }
}
