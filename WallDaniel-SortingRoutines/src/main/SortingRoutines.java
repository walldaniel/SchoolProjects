package main;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SortingRoutines {

	// Generates an array, of size s, with random numbers between l and u
	public static int[] generateArray(int l, int u, int s) {
		int[] arr = new int[s];

		for (int i = arr.length - 1; i >= 0; i--)
			arr[i] = ThreadLocalRandom.current().nextInt(l, u + 1);

		return arr;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		int maxNumsPerLine = 20;
		String userChoice;
		int numbersSort = 0;
		double time;

		do {
			try {
				System.out.print("Enter how many numbers to sort: ");
				numbersSort = Integer.parseInt(in.nextLine());
				
				if(numbersSort < 1)
					System.out.println("Enter a number larger than 1"); 
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid number");
			}
		} while(numbersSort < 1);
		
		do {
			// Generate random numbers
			int[] randNumbers = generateArray(0, 1000, numbersSort);

			// Get time for how long each sorting method takes
			time = System.currentTimeMillis();
			
			do {
				// Ask user what sorting routine they want
				System.out.println("What sorting routine do you want to use?: ");
				System.out.println("1 - Selection");
				System.out.println("2 - Bubble");
				System.out.println("3 - Insertion");
				System.out.println("4 - Quick");
				try {
					choice = Integer.parseInt(in.nextLine());

					// If user does not enter a number between 1 and 4, tell them
					if (choice < 1 && choice > 4)
						System.out.println("You did not enter a number between 1 and 4, try again");
				} catch (NumberFormatException e) {
					System.out.println("You did not enter a correct number.");
				}
			} while (choice < 1 || choice > 4);

			// Different program flow depending on user choice
			switch (choice) {
			case 1: // Selection sort
				SortingAlgorithms.selectionSort(randNumbers);
				break;
			case 2: // Bubble sort
				SortingAlgorithms.bubbleSort(randNumbers);
				break;
			case 3: // Insertion sort
				SortingAlgorithms.insertionSort(randNumbers);
				break;
			case 4: // Quick sort
				SortingAlgorithms.quickSort(randNumbers, 0, randNumbers.length - 1);
				break;
			}

			// Print out sorted numbers
			for (int i = 0; i < randNumbers.length; i++) {
				// Create a new line after 20 numbers
				if (i % maxNumsPerLine == 0)
					System.out.println();

				System.out.print(randNumbers[i] + " ");

				// Extra spaces between 1 and 2 digit numbers
				if (randNumbers[i] < 100) {
					System.out.print(" ");
					if (randNumbers[i] < 10)
						System.out.print(" ");
				}
			}

			// Say how long it took
			System.out.println("\nIt took " + (System.currentTimeMillis() - time) + " milliseconds.");
			
			// Ask user if they want to sort a different set of numbers
			System.out.print("Do you want to sort another set of numbers (y/n): ");
			userChoice = in.nextLine();
		} while (userChoice.charAt(0) == 'y' || userChoice.charAt(0) == 'Y');

		in.close();
	}

}
