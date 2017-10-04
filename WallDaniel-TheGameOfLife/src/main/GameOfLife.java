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

		int size = 12; // size of the game of life
		boolean[][] cells = new boolean[size][size];
		boolean[][] tempCells = cells;
		boolean[][] twoGenerationsPast;	// Used to check if the program is just repeating
		int generation = 2;
		int numAlive = 0;
		boolean userChoice = false; // Whether the user wants to pick when the next generation happens

		// Ask if user wants to choose how next generation happens
		System.out.print("Do you want to choose when the next generation happens enter 'y': ");
		if (in.nextLine().equals("y"))
			userChoice = true;

		// Spawn original cells, set each cell randomly to a bool
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				cells[y][x] = rand.nextBoolean();
			}
		}

		// print out cells of generation one
		System.out.println("Generation 1: ");
		printCells(cells);

		do {
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
				
				if(in.nextLine().equals("y"))
					break;
			} else {
				// Sleep the thread to make sure user can see each generation
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Check if last generation is same as current
				if(Arrays.deepEquals(cells, tempCells) || Arrays.deepEquals(cells, twoGenerationsPast))
					break;
			}
		} while (true);

		// Thank user for playing the game of life
		 System.out.println("Thank you for playing the game of life, have an great day!");

		// Close the scanner
		 in.close();
	}

}