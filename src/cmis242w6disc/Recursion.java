/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmis242w6disc;

// Imports
import java.util.Scanner;

/**
 * File: Recursion.java
 * Date: 4/13/2018
 * Author: Dillan Cobb
 * Purpose: To create and display recursion techniques with a number sequence,
 * as well as show iterative implementation. 
 */
public class Recursion {

    // Main class call for the technique
    public static void main(String[] args) {
        // Variables needed for the program
        int nth;
        int iterativeN;
        boolean tryAgain = true;
        
        // Constructors
        Scanner scanIn = new Scanner(System.in);
        
        // do loop to ensure the input is a valid integer
        do {
            // Exception to ensure the input into the scanner is a valid integer
            try {
                System.out.println("Input a integer greater than 0 to find its "
                        + "n-th position in the sequence:");
                // Assigns the scanner to nth and iterativeN varible as an 
                // integer
                nth = Integer.parseInt(scanIn.next());
                iterativeN = nth;
                // Custom exception to prevent the inputted number from being
                // less than or equal to 0
                if (nth <= 0)
                    throw new InvalidNumberException();
                
                // Output using recursion
                System.out.println("The " + nth + "-th number in the sequence "
                        + "was " + numSequence(nth, nth) + " using recursion.");
                // Output using iteration for loop
                for (int i = 0; i < nth; i++) {
                    iterativeN += 5;
                }
                System.out.println("The " + nth + "-th number in the sequence "
                        + "was " + iterativeN + " using iterative approach.");
                
                // Set the tryAgain boolean to false to ensure the program 
                // doesn't loop again.
                tryAgain = false;
            }
            // Catch exception for the format of the input into the scanner
            // ensures that the input is a valid integer
            catch (NumberFormatException e) {
                System.out.println("\tException: " + e.getMessage());
                System.out.println("\tInput MUST be an integer data type.");
            }
            // Catch exception for if the number is less than or equal to zero
            catch (InvalidNumberException e) {
                System.out.println("\tException: " + e.getMessage());
            }
        } while (tryAgain);
        
        
    }
    
    // Base: cnt == 0 (cnt starts from original n)
    // Recursive: n+5
    // Sequence: Add 5 to n for n amount of times.
    // Recursion method numSequence
    public static int numSequence(int n, int cnt) {        
        if (cnt == 0)
            return n;
        
        n += 5;
        
        cnt--;
        return (numSequence(n, cnt));
    }
    
}

// Custom exception class used if the integer inputted into the scanner is 
// less than or equal to zero
class InvalidNumberException extends Exception {
    public InvalidNumberException() {
        super("Integer must be greater than 0.");
    }
}
