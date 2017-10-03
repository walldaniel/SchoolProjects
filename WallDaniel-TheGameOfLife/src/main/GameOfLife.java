package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
		Random rand = new Random(); // Used for random generation

		int size = 5; // size of the game of life
		boolean[][] cells = new boolean[size][size]; // Used to display currently alive cells
		boolean[][] tempCells = cells; // Used to calculate which cells are alive in next generation
		boolean[][] twoGenerationsPast; // Used to find out when to end the program
		int generation = 2;
		int numAlive = 0;
		boolean userChoice = false; // Whether the user wants to pick when the next generation happens
		boolean playing = true; // When true continue looping through generations
		int startAmount = 0; // How many cells to start alive

		// Ask if user wants to choose how next generation happens
		System.out.print("Do you want to choose when the next generation happens enter 'y': ");
		if (in.nextLine().equals("y"))
			userChoice = true;

		do {
			try {
				// Ask user how many cells to start with
				System.out.print("How many cells to start with: ");
				startAmount = Integer.parseInt(in.nextLine());

				if (startAmount < 0)
					System.out.println("Enter a number larger than 0, try again");
				else if (startAmount > size * size)
					System.out.println("Enter a number that is less than the total cells");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a correct number, try again");
			}
		} while (true);

		// Spawn original cells
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				if(rand.nextInt(4 * size * size / startAmount) != 0)
					cells[y][x] = true;
			}
		}

		// print out cells of generation one
		System.out.println("Generation 1: ");
		printCells(cells);

		do {
			// Set array to tempcells to see if cells are caught in a loop
			twoGenerationsPast = copyArray(tempCells);
			// Set temp array to cells array, and reset cells array
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
				// Pause for 0.5 seconds to let user see what has happened in the game
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
			}
		} while (playing);

		// Thank user for playing the game of life
		System.out.println("Thank you for playing the game of life, have an great day!");

		// Close the scanner
		in.close();
	}

}