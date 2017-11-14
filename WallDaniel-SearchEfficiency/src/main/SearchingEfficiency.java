package main;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Daniel Wall
 * Date: 11-10-2017
 * Purpose:  See different statistics on different searching algorithms
 */
public class SearchingEfficiency {

	public static int[] generateArray(int lower, int upper, int size) {
		int[] arr = new int[size];

		// Generate random numbers
		for (int i = 0; i < size; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(lower, upper + 1);
		}

		return arr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberToGenerate = 0;
		int numToSearch = 0;

		// Tell user what the
		System.out.println("This program outputs statistics on different searching algorithms");

		// Get how many numbers to generate from user
		do {
			try {
				System.out.print("Enter the number of random numbers you want to generate: ");
				numberToGenerate = Integer.parseInt(in.nextLine());

				if (numberToGenerate < 1)
					System.out.println("Please enter a number over 1 ");
			} catch (NumberFormatException e) {
				System.out.println("You did not output a valid number");
			}
		} while (numberToGenerate < 1);

		// Get number to search for from user
		do {
			try {
				// Ask user what number they want to look for
				System.out.println("Enter a number you want to search for: ");
				numToSearch = Integer.parseInt(in.nextLine());

				if (numToSearch < 0)
					System.out.println("You have to enter in a number less then 0");
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number please");
			}
		} while (numToSearch < 0);

		// Generate list of random numbers
		int[] randNums = generateArray(0, 1000, numberToGenerate);

		// Print out the list of random numbers
		for (int i = 0; i < numberToGenerate; i++) {
			System.out.print(randNums[i] + " ");

			// Add a space if the number is only two digits, and 2 spaces if one digit
			if (randNums[i] < 100) {
				System.out.print(" ");
				if (randNums[i] < 10)
					System.out.print(" ");
			}

			// Print out a new line every 20 numbers
			if (i % 15 == 0)
				System.out.println();
		}

		// unsorted Linear search
		System.out.println("\nUnsorted Linear Search");
		SearchingAlgorithms.linearSearch(randNums, numToSearch, true);
		// Sort the array
		SortingAlgorithms.quickSort(randNums, 0, randNums.length - 1);
		// Sorted linear search
		System.out.println("Sorted Linear Search");
		SearchingAlgorithms.linearSearch(randNums, numToSearch, true);
		// Binary Search
		System.out.println("Binary Search");
		SearchingAlgorithms.binarySearch(randNums, numToSearch, true);

		in.close();
	}
}
