package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Cancer {

	public static enum cellState {
		HEALYTHY, CANCER, FOUND
	};

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
						grid[x][y] = cellState.HEALYTHY;
						break;
					case '-':
						grid[x][y] = cellState.CANCER;
						break;
					default:
						throw new Exception();
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + FILENAME);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return grid;
	}

	public static void displayArr(cellState[][] arr) {
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				switch (arr[x][y]) {
				case HEALYTHY:
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

	public static boolean floodFill(cellState[][] arr, int row, int col, cellState newState) {
		if (arr[row][col].equals(cellState.CANCER)) {
			arr[row][col] = newState;
			floodFill(arr, row - 1, col - 1, newState);
			floodFill(arr, row - 1, col, newState);
			floodFill(arr, row - 1, col + 1, newState);
			floodFill(arr, row, col - 1, newState);
			floodFill(arr, row, col + 1, newState);
			floodFill(arr, row + 1, col - 1, newState);
			floodFill(arr, row + 1, col, newState);
			floodFill(arr, row + 1, col + 1, newState);

			return true;
		}

		return false;
	}

	public static void fillCancer(cellState[][] arr, float chance, int row, int col) {
		if(arr[row][col].equals(cellState.HEALYTHY) && ) {
		}
	}
	
	public static cellState[][] randomlyGenerateCells(int size, int cellBlobs) {
		cellState[][] arr = new cellState[size][size];
		
		// Fill array with all healthy
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length; y++) {
				arr[x][y] = cellState.HEALYTHY;
				
			}
		}
		
		// Make blobs of cancer cells
		for(int i = 0; i < cellBlobs; i++) {
			int x = ThreadLocalRandom.current().nextInt(0, size);
			int y = ThreadLocalRandom.current().nextInt(0, size);
			float chance = 1.0f;
			arr[x][y] = cellState.CANCER;
		}
		
		return arr;
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
			cellGrid = randomlyGenerateCells(15, ThreadLocalRandom.current().nextInt(1,4));
		}

		displayArr(cellGrid);

		for (int x = 0; x < cellGrid.length; x++) {
			for (int y = 0; y < cellGrid[x].length; y++) {
				if (floodFill(cellGrid, x, y, cellState.FOUND))
					cancerBlobs++;
			}
		}

		// Display how many cancer cells, and grid with '-'s taken out.
		System.out.println("There are " + cancerBlobs + " cancer blobs.");
		displayArr(cellGrid);
		
		in.close();
	}

}
