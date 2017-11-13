package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Cancer {

	// The state of each cell
	public static enum cellState {
		HEALTHY, CANCER, FOUND
	};

	// Reads the file and returns it in a grid of cell states, either healthy or cancerous
	public static cellState[][] readCancerFile(String FILENAME, int size) throws Exception {
		cellState[][] grid = new cellState[size][size];

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME));

			// Reads every line in the file
			String line;
			for (int x = 0; (line = fileReader.readLine()) != null; x++) {
				for (int y = 0; y < line.length(); y++) {
					// Check every character in the line for '+' healthy or '-' cancerous,
					// If character not +/- then throw an exception
					switch (line.charAt(y)) {
					case '+':
						grid[x][y] = cellState.HEALTHY;
						break;
					case '-':
						grid[x][y] = cellState.CANCER;
						break;
					default:
						throw new Exception();
					}
				}
			}

			// Close the file reader
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return grid;
	}

	// Displays the cells, '+' for healthy, '-' for cancer, and ' ' for found
	public static void displayArr(cellState[][] arr) {
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				switch (arr[x][y]) {
				case HEALTHY:
					System.out.print("+");
					break;
				case CANCER:
					System.out.print("-");
					break;
				case FOUND:
					System.out.print(" ");
					break;
				}
			}
			System.out.println();
		}
	}

	// Method that replaces all cancerous cells with empty
	// Checks all around every cell that is found cancerous
	public static boolean floodFill(cellState[][] arr, int row, int col) {
		if (arr[row][col].equals(cellState.CANCER)) {
			arr[row][col] = cellState.FOUND;
			floodFill(arr, row - 1, col - 1);
			floodFill(arr, row - 1, col);
			floodFill(arr, row - 1, col + 1);
			floodFill(arr, row, col - 1);
			floodFill(arr, row, col + 1);
			floodFill(arr, row + 1, col - 1);
			floodFill(arr, row + 1, col);
			floodFill(arr, row + 1, col + 1);

			return true;
		}

		return false;
	}

	// Makes the cell at row and col cancerous depending on chance
	public static void fillCancer(cellState[][] arr, float chance, int row, int col) {
		// Make sure row and column isn't last
		if (row > 1 && row < arr.length - 1 && col > 0 && col < arr.length - 1) {
			if (arr[row][col].equals(cellState.HEALTHY) && ThreadLocalRandom.current().nextFloat() < chance) {
				arr[row][col] = cellState.CANCER;
				fillCancer(arr, (float) (chance * 0.4), row - 1, col - 1);
				fillCancer(arr, (float) (chance * 0.82), row - 1, col);
				fillCancer(arr, (float) (chance * 0.35), row - 1, col + 1);
				fillCancer(arr, (float) (chance * 0.65), row, col - 1);
				fillCancer(arr, (float) (chance * 0.35), row, col + 1);
				fillCancer(arr, (float) (chance * 0.55), row + 1, col - 1);
				fillCancer(arr, (float) (chance * 0.6), row + 1, col);
				fillCancer(arr, (float) (chance * 0.15), row + 1, col + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		cellState[][] cellGrid = null;
		int cancerBlobs = 0;

		// Introduce user to program
		System.out.println("This program finds the number of blobs of cancerous cells");

		// Asks if user wants to get a random cellblobs, or from file
		System.out.println("Enter a 'y' to get cells from file, else will randomly generate cells");
		if (in.nextLine().equals("y")) {
			// Read grid
			try {
				cellGrid = readCancerFile("cells.txt", 15);
			} catch (Exception e) {
				System.out.println("The file is corrupt");
			}
		} else {
			// Randomly generates cell
			cellGrid = new cellState[15][15];

			// Fill array with all healthy
			for (int x = 0; x < cellGrid.length; x++) {
				for (int y = 0; y < cellGrid.length; y++) {
					cellGrid[x][y] = cellState.HEALTHY;

				}
			}

			// Make blobs of cancer cells
			for (int i = 0; i < ThreadLocalRandom.current().nextInt(2, 5); i++) {
				// Choose random coordinates that aren't on the edge
				int x = ThreadLocalRandom.current().nextInt(1, 14);
				int y = ThreadLocalRandom.current().nextInt(1, 14);
				cellGrid[x][y] = cellState.CANCER;
				fillCancer(cellGrid, 1.0f, x + 1, y);
			}
		}

		displayArr(cellGrid);

		// Counts how many cancer blobs are present
		for (int x = 0; x < cellGrid.length; x++) {
			for (int y = 0; y < cellGrid[x].length; y++) {
				if (floodFill(cellGrid, x, y))
					cancerBlobs++;
			}
		}

		// Display how many cancer cells, and grid with '-'s taken out.
		System.out.println("There are " + cancerBlobs + " cancer blobs.");
		displayArr(cellGrid);

		in.close();
	}

}
