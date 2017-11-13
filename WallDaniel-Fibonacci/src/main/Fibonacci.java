package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 10-30-2017
 * Purpose: Get the value of a term of the fibonacci sequence
 */
public class Fibonacci {

	// Returns the value of a term in the fibonacci sequence
	public static int fibonacci(int i) {
		// Throws an exception if the number entered is less than zero
		if (i < 0)
			throw new NumberFormatException("Can't be less than 0");

		if (i > 2)
			return fibonacci(i - 1) + fibonacci(i - 2); // Get the value of the previous 2 terms added together
		else
			return 1; // term 1 and 2 are both 1 in fibonacci sequence
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int term;

		System.out.println("This program prints out the value of a term of the fibonacci sequence (1, 1, 2, 3, 5...).");

		do {
			// Set term to -1, for number inputting to work
			term = -1;
			
			// Loop until the user enters a valid number, that is greater than 0
			do {
				try {
					System.out.print("Enter a term of the fibonacci sequence: ");
					term = Integer.parseInt(in.nextLine());

					// If user enters a valid number less than zero, get them to enter a new number
					if (term < 0)
						System.out.println("Nubmer has to be greater than zero");
				} catch (NumberFormatException e) {
					System.out.println("You have to enter a valid number");
				}
			} while (term < 0);

			// Print out the fibonacci term value
			System.out.println("The value in the fibonacci at term " + term + " is: " + fibonacci(term));
			
			// Ask user if they want to enter another value
			// As long as first character is 'y', then loop again, user could enter "yolk" and it would work
			System.out.print("Do you want to enter another term number? (y/n): "); 
		} while (in.nextLine().charAt(0) == 'y');	
		
		in.close();
	}

}
