package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept. 6, 2017
 * Purpose: compares the square of a square root of a number with the original number
 */
public class RoundingError {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num = 0;
		
		// Runs a loop until a positive number has been entered.
		do {
			try {
				// Ask for a number to find rounding error.
				System.out.print("Enter a positive number to find out the rounding error of the square of the square root: ");
				num = Double.parseDouble(sc.next());
				
				// If number is valid (above 0), then the loop is broken.
				if(num < 0) 
					System.out.println("The number you enter has to be above 0, please try again.\n");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a valid number, please try again.\n");
			}
			
			// Tell the user to enter another number if less than 0
			
		} while(true);
		
		// Calculate the square of the square root and compare to the original number.
		System.out.println("\nThe square of the square root of the number is: " + Math.pow(Math.sqrt(num), 2));
		System.out.println("The rounding error is: " + Math.abs(num - Math.pow(Math.sqrt(num), 2)));
		
		// Close scanner.
		sc.close();
	}

}
