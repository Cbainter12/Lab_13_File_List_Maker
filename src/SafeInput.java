import java.util.Scanner;

public class SafeInput
{
    /**
     * Returns a String input by the user that must be at least one character
     * @param pipe the scanner to use for the input
     * @param prompt the msg for the user telling them what to input
     * @return a String of at least one character
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        boolean done = false;
        String response = "";
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();

            if (response.length() > 0) {
                done = true;
            }
            else {
                System.out.println("\nYou must enter at least one character!");
            }

        }while (!done);

        return response;
    }
    /**
     * gets an int val from the user with no constraints
     * @param pipe Scanner to use for the input
     * @param prompt msg to user for what to enter
     * @return
     */
    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        int value = 0;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        }while (!done);

        return value;
    }
    /**
     * returns an unconstrained double value
     * @param pipe scanner to use for input
     * @param prompt msg to tell user what to input
     * @return an uunconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        String trash = "";
        double value = 0;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        }while (!done);

        return value;
    }
    /**
     * gets an int val from the user with a range
     * @param pipe Scanner to use for the input
     * @param prompt msg to user for what to enter
     * @param low the bottom value for the inclusive range
     * @param high the top value for the inclusive range
     * @return a value within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        String trash = "";
        int value = 0;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                if (value >= low && value <= high) {
                    done = true;
                }
                else {
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }
        }while (!done);

        return value;
    }
    /**
     * gets an double val from the user with a range
     * @param pipe Scanner to use for the input
     * @param prompt msg to user for what to enter
     * @param low the bottom value for the inclusive range
     * @param high the top value for the inclusive range
     * @return a double within the range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        String trash = "";
        double value = 0;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                if (value >= low && value <= high) {
                    done = true;
                }
                else {
                    System.out.println("\nYou must enter a value within the range [" + low + " - " + high + "]");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }
        }while (!done);

        return value;
    }

    /**
     * RETURNS A TRUE FALSE VALUE FOR YES OR NO INPUT [YN]
     * @param pipe Scanner to use for the input
     * @param prompt msg to user for what to enter
     * @return a boolean value for yes or no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    { boolean done = false;
        String response = "";
        boolean retVal = false;
        do {
            System.out.print(prompt + " [YyNn]: ");
            response = pipe.nextLine();

            if (response.toUpperCase().matches("[YN]")) {
                done = true;
                if (response.equalsIgnoreCase("Y")) {
                    retVal = true;}
                else {
                    retVal = false;
                }
            }
            else {
                System.out.println("\nYou must enter a [y/n]!");

            }

        }while(!done);
        return retVal;
    }


    /**
     * takes a regEx String and returns a valid match
     * @param pipe the scanner used
     * @param prompt the prompt told to the user
     * @param regEx the string to match against
     * @return a string from the user that matches the regEx
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean done = false;
        String response = "";
        do {
            System.out.print(prompt + ": [" + regEx + "] : ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                done = true;}
            else {
                System.out.println("\nYou must enter a String that matches the pattern [" + regEx + "] !");}
        }while(!done);
        return response;

    }

    public static void prettyHeader(String msg) {
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("**");
        int spaceGap = (56 - msg.length())/2;
        for (int i = 0; i < spaceGap; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < spaceGap; i++) {
            System.out.print(" "); }
        if ((msg.length() % 2) == 1) {
            System.out.print(" ");
        }
        System.out.println("**");
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();


    }
}
