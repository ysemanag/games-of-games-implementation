import java.util.*;

public class GetInput {
    Scanner sc = new Scanner(System.in);
    private String inputRangeText = "Please enter an integer between %d and %d.\n";
    private String pickBetweenText = "Please enter '%s' for %s or '%s' for %s.\n";
    private String badInputText = "That is out of range!";


    public GetInput() {

    }

    /**
     * Change the text displayed when asking for an input range.
     *
     * @param s - The new text
     */
    public void setInputRangeText(String s) { inputRangeText = s; }

    /**
     * Change the text displayed when asking to pick between two options.
     *
     * @param s - The new text
     */
    public void setPickBetweentext(String s) { pickBetweenText = s; }

    /**
     * Change the text displayed when an invalid input is entered.
     *
     * @param s - The new text
     */
    public void setBadInputText(String s) { badInputText = s; }

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
            System.out.printf(inputRangeText, min, max);
            String input = sc.next();
            try {
                ans = Integer.parseInt(input);
                if(ans < min || ans > max) {
                    System.out.println(badInputText);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(badInputText);
            }
        }
        return ans;
    }

    /**
     * Ask the user to pick a positive integer.
     *
     * @return The user's inputed number
     */
    public int getPositiveInt() {
        int ans = -1;
        while(ans <= 0) {
            System.out.println("Please enter a range from 0 through: ");
            String input = sc.next();
            try {
                ans = Integer.parseInt(input);
                if(ans <= 0) {
                    System.out.println(badInputText);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(badInputText);
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
            System.out.println("Please enter positive odd number to pick the best out of the number of games: ");
            String input = sc.next();
            try {
                ans = Integer.parseInt(input);
                if(ans < 0 || ans % 2 == 0) {
                    System.out.println(badInputText);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(badInputText);
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
        while(!ans.equals(inputA) && !ans.equals(inputB)) {
            // System.out.println("Please enter '" + inputA + "' for " + optionA + " or '" + inputB + "' for " + optionB + ".");
            System.out.printf(pickBetweenText, inputA, optionA, inputB, optionB);
            ans = sc.next();
            if(!ans.equals(inputA) && !ans.equals(inputB)) {
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
