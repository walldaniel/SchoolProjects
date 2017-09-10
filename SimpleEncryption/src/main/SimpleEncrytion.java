package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept 10, 2017
 * Purpose: Simple encryption program that works by rotating alphabet characters.
 */
public class SimpleEncrytion {

	// Takes a string and rotates the letters in it.
	public static String rotateCharacters(String s, int rotationAmount) {
		// New string that will have encrypted message.
		String encrypted = "";

		for (char c : s.toCharArray()) {
			// If letter is z switch to a, if it is a letter increase it by rotation
			// amount, else if it is punctution/etc just leave it the same.
			if (c >= (char) 'z' - rotationAmount + 1)
				encrypted += Character.toString((char) (c + rotationAmount - 26));
			else if (c == 'Z' - rotationAmount + 1)
				encrypted += Character.toString('A');
			else if (Character.isLetter(c))
				encrypted += Character.toString((char) (c + rotationAmount));
			else
				encrypted += c;
		}

		return encrypted;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rotation = 0; // How many letters is the message encrypted by
		int option = 0; // Whether user wants to encrypt or decipher

		// Tells user what program does
		System.out.println("Welcome to an encrytion software.");

		// If user wants to enter multiple words, allows them to loop
		do {
			// Loops until user selects a valid option
			do {
				try {
					// Ask whether the user wants to encrypt or decipher
					System.out.println("\nWhat do you want to do?");
					System.out.println("1 - Encrypt");
					System.out.println("2 - Decipher");
					option = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Not a valid option try again");
				}

				// If user enters valid option exit loop.
				if (option == 1 || option == 2) {
					break;
				} else {
					System.out.println("Not a valid option, try again");
				}
			} while (true);

			// Loops through until the user enters a number between 1 and 25
			do {
				try {
					// Asks user for number and stores number,
					// shows a different message depending on option selected
					if (option == 1) {
						System.out.print("Enter the rotation amount to move the letters: ");
					} else {
						System.out.print("Enter the rotation amount that the message was encrypted by: ");
					}
					rotation = Integer.parseInt(sc.nextLine());

					// If number is not between 1 and 25 tell them to try again.
					if (!(rotation >= 1 && rotation <= 25))
						System.out.println("You did not enter a valid number try again.");
				} catch (NumberFormatException e) {
					System.out.println("You did not a valid number try again.");
				}

			} while (!(rotation >= 1 && rotation <= 25));

			switch (option) {
			case 1:
				// Asks user for message
				System.out.print("Enter a message: ");

				System.out.println(rotateCharacters(sc.nextLine(), rotation));

				break;
			case 2:
				// Asks user for message
				System.out.print("Enter encrypted message: ");

				// In order to decipher, the characters are rotated forward 26-rotation amount
				System.out.println(rotateCharacters(sc.nextLine(), 26 - rotation));
			}
			
			// Asks user if they want to enter another message
			System.out.println("\nIf you want to enter another word enter '1'.");
		} while (sc.nextLine().equals("1"));

		// Close the scanner
		sc.close();
	}

}
