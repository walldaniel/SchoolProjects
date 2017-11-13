package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 10-30-2017
 * Purpose: calculates the number of ways n can fit into r
 */
public class NChooseR {

	/*
	 * Calculates the factorial of a number, e.g.: n * (n-1) * (n-2) * ... * 1. Throws a number format exception when less than 0
	 */
	public static int factorial(int n) {
		// 0! = 1
		if(n == 0)
			return 1;
		
		// Can't have a factorial of a negative number
		if (n < 0)
			throw new NumberFormatException();

		// As long as the number is greater than 1, get the factorial of 1 less than that number
		if (n > 1)
			n *= factorial(n - 1);

		return n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int objectsChosen = -1;
		int objectsTotal = -1;
		System.out
				.println("This program calculates the number of ways to choose 'r' objects from a set of 'n' objects");

		do {
			// Loops until user enters a valid number greater than 0
			do {
				try {
					System.out.print("How many objects do you want to choose: ");
					objectsChosen = Integer.parseInt(in.nextLine());

					// If number is less than 0 tell user to try again
					if (objectsChosen < 0)
						System.out.println("Number has to be greater than 0");
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid number.");
				}
			} while (objectsChosen < 0);

			// Loops until user enters a valid number greater than 0
			do {
				try {
					System.out.print("How many objects are there: ");
					objectsTotal = Integer.parseInt(in.nextLine());

					// If number is less than 0 tell user to try again
					if (objectsTotal < 0)
						System.out.println("Number has to be greater than 0");
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid number.");
				}
			} while (objectsTotal < 0);

			// Calculate using formula
			int numberWays = factorial(objectsTotal) / (factorial(objectsChosen) * factorial(objectsTotal - objectsChosen));

			// Print out the number of ways
			System.out.println("There are " + numberWays + " ways to choose " + objectsChosen + " from a set of " + objectsTotal + ".");

			// Ask user if they want to enter another value
			// As long as first character is 'y', then loop again, user could enter "yolk" and it would work
			System.out.print("Do you want to enter in new numbers? (y/n): ");
		} while (in.nextLine().charAt(0) == 'y');
		
		in.close();
	}

}
