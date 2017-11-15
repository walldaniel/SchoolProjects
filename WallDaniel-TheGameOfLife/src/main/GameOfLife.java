package main;


import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Daniel Wall
 * Date: 9-25-2017
 * Purpose: Recreate the game of life by John Conway
 */
public class GameOfLife {

	// Takes the array of cells and prints it out
	public static void printCells(boolean[][] cells) {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells.length; y++) {
				if (cells[x][y])
					System.out.print("$ ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}

	public static boolean[][] copyArray(boolean[][] arr) {
		return arr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = 40; // size of the game of life
		boolean[][] cells = new boolean[size][size];
		boolean[][] tempCells = cells;
		boolean[][] twoGenerationsPast; // Used to check if the program is just repeating
		int generation = 2;
		int numAlive = 0;
		int startCells = 0;
		boolean userChoice = false; // Whether the user wants to pick when the next generation happens
		boolean playing = true; // When true continue looping through generations

		// Ask if user wants to choose how next generation happens
		System.out.print("Do you want to choose when the next generation happens? (y): ");
		if (in.nextLine().equals("y"))
			userChoice = true;
		
		// Make sure the user enters a valid start number of cells
		do {
			try {
				// Asks how many cells to start with
				System.out.print("How many cells do you want to start with?");
				startCells = Integer.parseInt(in.nextLine());

				// Make sure that the number of cells is valid on the board
				if (startCells > 0 && startCells < size * size)
					break;
				else
					System.out.println("You need to enter a number that is greater than 0,"
							+ " and less than the total cells on the board.");
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a valid number.");
			}
		} while (true);

		// Spawn original cells, the average of the number of starting cells should be what the user wanted
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				if (ThreadLocalRandom.current().nextFloat() < ((float) startCells / (float) (size * size))) {
					cells[y][x] = true;
				}
			}
		}

		// print out cells of generation one
		System.out.println("Generation 1: ");
		printCells(cells);

		do {
			// Set array to tempcells to see if cells are caught in a loop
			twoGenerationsPast = copyArray(tempCells);
			// Set temp array to cells array, and reset cells array
			twoGenerationsPast = copyArray(tempCells);
			tempCells = copyArray(cells);
			cells = new boolean[size][size];

			for (int y = 0; y < cells.length; y++) {
				for (int x = 0; x < cells[y].length; x++) {
					// Reset cells that are alive around cell
					numAlive = 0;

					// Check up left
					if (x != 0 && y != 0 && tempCells[y - 1][x - 1])
						numAlive++;

					// Check up
					if (x != 0 && tempCells[y][x - 1])
						numAlive++;

					// Check up right
					if (x != 0 && y != cells[y].length - 1 && tempCells[y + 1][x - 1])
						numAlive++;

					// Check left
					if (y != 0 && tempCells[y - 1][x])
						numAlive++;

					// Check right
					if (y != tempCells[y].length - 1 && tempCells[y + 1][x])
						numAlive++;

					// Check down left
					if (x != tempCells.length - 1 && y != 0 && tempCells[y - 1][x + 1])
						numAlive++;

					// Check down
					if (x != tempCells.length - 1 && tempCells[y][x + 1])
						numAlive++;

					// Check down right
					if (y != tempCells.length - 1 && x != tempCells[y].length - 1 && tempCells[y + 1][x + 1])
						numAlive++;

					// Check how many neighbours are alive
					if (tempCells[y][x] && (numAlive == 2 || numAlive == 3))
						cells[y][x] = true;
					else if (!tempCells[y][x] && numAlive == 3)
						cells[y][x] = true;
				}
			}

			// Print out cells
			System.out.println("\n\nGeneration " + generation + ": ");
			printCells(cells);

			// After every calculation of a new generation, increase generation
			generation++;

			if (userChoice) {
				System.out.print("If you want another generation enter 'y': ");
				if (!in.nextLine().equals("y"))
					playing = false;
			} else {
				// Sleep the thread to make sure user can see each generation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// If there has been no change between this generation and last, quit loop
				if (Arrays.deepEquals(cells, twoGenerationsPast) || Arrays.deepEquals(cells, tempCells)) {
					playing = false;
					System.out.println("Game is finished.");
				}

				// Check if last generation is same as current
				if (Arrays.deepEquals(cells, tempCells) || Arrays.deepEquals(cells, twoGenerationsPast))
					break;
			}
		} while (playing);

		// Thank user for playing the game of life
		System.out.println("Thank you for playing the game of life, have an great day!");

		// Close the scanner
		in.close();
	}

}