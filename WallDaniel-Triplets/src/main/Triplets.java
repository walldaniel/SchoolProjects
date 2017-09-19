package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Daniel Wall
 * Date: 9-18-2017
 * Purpose: Randomly generate poem triplets
 */
public class Triplets {

	public static void main(String[] args) {
		// Create objects for rhyme lines
		ArrayList<String> rhymeA = new ArrayList<>();
		ArrayList<String> rhymeB = new ArrayList<>();
		
		// Add rhyme a lines
		rhymeA.add("Football is the game for me");
		rhymeA.add("The stadium is a great place to be");
		rhymeA.add("Touchdowns are what I like to see");
		rhymeA.add("The candy is all free");
		rhymeA.add("He hit a soccer ball with his knee");
		rhymeA.add("To enter he had to pay a fee");
		rhymeA.add("His name was zee");
		rhymeA.add("To go through the door you need a key");
		
		// Add rhyme b lines
		rhymeB.add("He had a mouse");
		rhymeB.add("I'm a minion xd");
		rhymeB.add("My name is danny wall");
		rhymeB.add("The minions got doused");
		rhymeB.add("They haz to meet at the courthouse");
		rhymeB.add("Peter came from Laos");
		rhymeB.add("The pig was in his house");
		rhymeB.add("Mickey Mouse went to his clubhouse");
		rhymeB.add("In the middle was a house");
		
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
				line1 = rhymeA.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));

				// Make sure that random generated lines are not duplicated
				do {
					line2 = rhymeA.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));
				} while (line2.equals(line1));
				do {
					line3 = rhymeA.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));
				} while (line3.equals(line1) || line3.equals(line2));

				// Print out poem
				System.out.println(line1);
				System.out.println(line2);
				System.out.println(line3);
				break;
			case 1:
				// Initialize lines of code.
				line1 = rhymeA.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));
				line2 = rhymeB.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));

				// Make sure random generated lines are not duplicates
				do {
					line3 = rhymeA.get(ThreadLocalRandom.current().nextInt(0, rhymeA.size()));
				} while (line3.equals(line1));

				// Print out poem
				System.out.println(line1);
				System.out.println(line2);
				System.out.println(line3);
				break;
			}
		}
		
		// Close the scanner
		in.close();
	}

}
