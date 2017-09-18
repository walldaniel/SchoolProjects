package main;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Daniel Wall
 * Date: 9-18-2017
 * Purpose: Randomly generate poem triplets
 */
public class Triplets {

	public static String rhymeB() {
		switch (ThreadLocalRandom.current().nextInt(0, 9)) {
		case 1:
			return "In the middle was a house";
		case 2:
			return "Mickey Mouse went to his clubhouse";
		case 3:
			return "The pig was in a slaughter house";
		case 4:
			return "Peter came from Laos";
		case 5:
			return "They haz to meet at the courthouse";
		case 6:
			return "The minions got doused";
		case 7:
			return "I'm a minion xd";
		case 8:
			return "My name is danny wall";
		default:
			return "He had a mouse";
		}
	}

	// Returns a random string ending in rhyme patter A
	public static String rhymeA() {
		switch (ThreadLocalRandom.current().nextInt(0, 8)) {
		case 0:
			return "Football is the game for me";
		case 1:
			return "The stadium is a great place to be";
		case 2:
			return "Touchdowns are what I like to see";
		case 3:
			return "The candy is all free";
		case 4:
			return "He hit a soccer ball with his knee";
		case 5:
			return "To enter he had to pay a fee";
		case 6:
			return "His name was zee";
		default:
			return "To go through the door you need a key";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberPoems = 0;

		// Tell user what the program does
		System.out.println("This program generates random poems in either an 'AAA' or 'ABA' pattern.\n");

		do {

			try {
				// Ask how many random poems user wants to enter
				System.out.print("How many poems do you want to generate: ");
				numberPoems = Integer.parseInt(in.nextLine());

				if (numberPoems > 0)
					break;
				else
					System.out.println("You did not enter a valid number");
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a correct number try again");
			}

		} while (true);

		// Initializes variables
		String line1;
		String line2;
		String line3;

		for (int i = 0; i < numberPoems; i++) {
			// Formating
			System.out.println();
			
			// Chooses either AAA or ABA pattern
			switch (ThreadLocalRandom.current().nextInt(0, 2)) {
			case 0:
				// Initialize lines of code.
				line1 = rhymeA();

				// Make sure that random generated lines are not duplicated
				do {
					line2 = rhymeA();
				} while (line2.equals(line1));
				do {
					line3 = rhymeA();
				} while (line3.equals(line1) || line3.equals(line2));

				// Print out poem
				System.out.println(rhymeA());
				System.out.println(rhymeA());
				System.out.println(rhymeA());
				break;
			case 1:
				// Initialize lines of code.
				line1 = rhymeA();
				line2 = rhymeB();

				// Make sure random generated lines are not duplicates
				do {
					line3 = rhymeA();
				} while (!line3.equals(line1));

				// Print out poem
				System.out.println(rhymeA());
				System.out.println(rhymeB());
				System.out.println(rhymeA());
				break;
			}
		}
	}

}
