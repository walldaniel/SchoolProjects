package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 10-31-2017
 * Purpose: To determine the reduced fraction of a fraction
 */
public class ReduceFraction {

	// Finds greatest common multiple of a number with recursion
	public static int greatestCommonFactorRec(int numer, int denom) {
		if(denom != 0)
			return greatestCommonFactorRec(denom, numer % denom);
		else 
			return numer;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numerator = 0;
		int denominator = 0;

		// Tell user what program does
		System.out.println("This program reduces a fraction to the lowest terms");

		// Loop for if user wants to enter mmultiple fractions
		do {
			// Get first and second number
			do {
				try {
					System.out.print("Enter the numerator: ");
					numerator = Integer.parseInt(in.nextLine());

					// Won't be able to reduce fraction if the numerator is zero
					if (numerator == 0)
						System.out.println("Cannot reduce fraction if numerator is 0.");
				} catch (NumberFormatException e) {
					System.out.println("You have to enter a valid number");
				}
			} while (numerator == 0);

			do {
				try {
					System.out.print("Enter the denominator: ");
					denominator = Integer.parseInt(in.nextLine());

					// Cannot have a fraction with the denom 0
					if (denominator == 0)
						System.out.println("Fraction with a denominator of 0 is invalid.");
				} catch (NumberFormatException e) {
					System.out.println("You have to enter a valid number");
				}
			} while (denominator == 0);

			// Get the GCD
			int gcd = greatestCommonFactorRec(numerator, denominator);

			// Multiply both top and bottom by GCD
			denominator /= gcd;
			numerator /= gcd;

			// Print out new fraction
			System.out.println("The reduced fraction is: " + numerator + "/" + denominator + ".");
			
			// Ask user if they want to enter another number
			// As long as first character is 'y', then loop again, user could enter "yolk" and it would work
			System.out.print("Do you want to enter another fraction (y/n): ");
		} while (in.nextLine().charAt(0) == 'y');
		
		in.close();
	}

}
