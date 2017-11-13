package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 10-11-2017
 * Purpose: Combo Lock program
 */
public class ComboLockDriver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Create new combo
		int maxNumber = 3;	// Max number that the combo can be
		ComboLock combo = new ComboLock(maxNumber + 1);
		int[] guesses = new int[3];
		int maxGuesses = 3;	// How many tries the user has to guess the combo
		int numGuesses = 1;	// How many tries the user has used to guess the combo

		// Tell user about the program
		System.out.println("Try to solve the combo! The numbers are between 1 and " + maxNumber + ".");

		// Loop until max guesses is reached or
		do {
			System.out.println("\nTry and guess the combo...\n");
			// Get user to enter lock combination guess
			for (int i = 0; i < guesses.length; i++) {
				do {
					try {
						System.out.print("Enter number " + (i + 1) + " (1-" + maxNumber + "): ");
						guesses[i] = Integer.parseInt(in.nextLine());

						// If they entered a valid number, between 0 and 9, exit the do while loop.
						if (guesses[i] > 0 && guesses[i] < maxNumber + 1)
							break;
						else
							System.out.println("You did not enter a number between 1 and " + maxNumber + ", try again.");
					} catch (NumberFormatException e) {
						System.out.println("You did not enter a valid number");
					}
				} while (true);
			}
			
			// Increase number of tries
			numGuesses++;
			
			// If the user has gone over the max number of guesses, exit loop
			if(numGuesses > maxGuesses)
				break;
		} while (!combo.tryLock(guesses[0], guesses[1], guesses[2]));

		// Print out whether the user got the combo right or wrong
		if(combo.tryLock(guesses[0], guesses[1], guesses[2])) {
			System.out.println("The combo was: " + combo.toString());
			System.out.println("You got the combo right");
		} else {
			System.out.println("The combo was: " + combo.toString());
			System.out.println("You got the combo wrong");
		}
		
		// Give the user a combo, and ask them for the combo back to unlock the lock
		System.out.println("\nNow you will get a combination, you then can try and get into your lock.");
		combo = new ComboLock();
		System.out.println("Your new lock combination is: " + combo.toString());
		
		// Ask user for his/her guess to the combination
		for(int i = 0; i < guesses.length; i++) {
			do {
				try {
					System.out.print("Enter number " + (i + 1) + " (1-9): ");
					guesses[i] = Integer.parseInt(in.nextLine());
					
					// If they entered a valid number, between 0 and 9, exit the do while loop.
					if (guesses[i] > 0 && guesses[i] < 10)
						break;
					else
						System.out.println("You did not enter a number between 1 and 9, try again.");
				} catch(NumberFormatException e ) {
					System.out.println("Enter a valid number, try again");
				}
			} while(true);
		}
		
		// Print out whether they got the combo right or not
		if(combo.tryLock(guesses[0], guesses[1], guesses[2]))
			System.out.println("The combination worked, you are in");
		else
			System.out.println("The combo did not work");
		
		// Say goodbye to user
		System.out.println("\nThank you for using this program, have an amazing day!");
		
		// Close the scanner
		in.close();
	}

}
