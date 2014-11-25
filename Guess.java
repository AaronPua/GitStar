package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>Prompts the user guess a number between 1 and 100.
 * Hints are given along the way to help the user. The user
 * can quit halfway or continue guessing until they get the 
 * right answer. After that, the user is given the choice to play
 * again or stop.</p>
 *
 * @author Aaron Pua
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //The user's guess(s).
        int guess;
        //Number range from 1 to 100 when randomly generated.
        final int num = 100;
        //The correct number which is randomly generated for the user to guess.
        int correctNum;
        //The number of times the user guessed wrongly.
        int count = 0;
        //Condition to continue guessing if the user wants to play again.
        boolean again = true;
        //"Yes" or "no" input from the user.
        String input;
        //The maximum number that the user can enter.
        final int hundred = 100;
        
        Scanner scan = new Scanner(System.in);

        //Loop to get user to guess the number until they guessed it right.
        while (again) {
            //Randomly generates the correct answer that user will guess.
            Random generate = new Random();
            correctNum = generate.nextInt(num) + 1;
            
            //Prompts the user to enter a number within the range.
            System.out.print("Please enter a number between "
                                + "1 and 100(inclusive): ");
            guess = scan.nextInt();
            count++;
            
           
            
            //Keep going as long as the number is wrong or user does not quit.
            while (guess != 0) {               
                if (guess < 0 || guess > hundred) {
                    throw new IllegalArgumentException("Enter only values "
                                                    + "between 1 and 100.");
                }
                
                //Gives the user a clue to the relative 
                //location of answer.                
                if (guess > correctNum) {
                    System.out.print("Your guess is wrong. " 
                                    + "The number is too high. "
                                    + "\nGuess again or enter \"0\" to quit: ");
                    guess = scan.nextInt();
                    count++;
                } else if (guess < correctNum) {
                    System.out.print("Your guess is wrong. " 
                            + "The number is too low. "
                            + "\nGuess again or enter \"0\" to quit: ");
                    guess = scan.nextInt();
                    count++;
                } else {
                    System.out.println("\nYour guess is right."
                                        + "In total, it took " + count 
                                        + " guesses.");
                    guess = 0;
                }
                
            }     
            //Prompts the user to play again or stop.
            System.out.println("Type \"No\" to stop "
                                + "or type anything else to play again.");
            input = scan.next();
            if (input.equalsIgnoreCase("No")) {
                again = false;            
            }
        } 
        
        System.out.println("Question two was called and ran sucessfully.");
    }

};
