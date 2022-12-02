import java.util.*;

public class GetInput {
    Scanner sc = new Scanner(System.in);

    /**
     * Ask the user to pick an integer between a range, inclusive.
     *
     * @param min - The mininum pickable number
     * @param max - The maximum pickable number
     * @return The user's inputed number
     */
    public int getIntInRange(int min, int max) {
        int ans = min - 1;
        while(ans < min || ans > max) {
            System.out.println("Please enter an integer between " + min + " and " + max + ".");
            ans = sc.nextInt();
            if(ans < min || ans > max) {
                System.out.println("That is out of range!");
            }
        }
        return ans;
    }

    /**
     * Ask the user to pick a "best of" integer, which will be positive and odd.
     *
     * @return The user's inputed number
     */
    public int getBestOf() {
        int ans = -1;
        while(ans < 0 || ans % 2 == 0) {
            System.out.println("Please enter a positive odd integer.");
            ans = sc.nextInt();
            if(ans < 0 || ans % 2 == 0) {
                System.out.println("That is not a positive odd integer!");
            }
        }
        return ans;
    }

    /**
     * Choose between two items.
     *
     * @param optionA - The label of the first option (e.g. "Heads")
     * @param inputA  - What the user inputs to choose optionA (e.g. "H")
     * @param optionB - The label of the second option (e.g. "Tails")
     * @param inputB  - What the user inputs to choose optionB (e.g. "T")
     *
     * @return Either inputA or inputB, depending on what the user enters.
     */
    public String pickBetween(String optionA, String inputA, String optionB, String inputB) {
        String ans = "";
        while(!ans.equals(inputA) || !ans.equals(inputB)) {
            System.out.println("Please enter '" + inputA + "' for " + optionA + " or '" + inputB + "' for " + optionB + ".");
            if(!ans.equals(inputA) || !ans.equals(inputB)) {
                System.out.println("That's not one of the choices!");
            }
        }
        return ans;
    }

    /**
     * Get two player names.
     *
     * @return An array of size two, with each element as a name of a player
     */
    public String[] getPlayerNames() {
        System.out.println("Enter player names");
        String a = sc.next();
        String b = sc.next();
        String[] res = new String[] {a, b};
        return res;
    }
}
