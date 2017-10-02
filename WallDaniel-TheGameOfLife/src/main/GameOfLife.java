package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
					System.out.print("1, ");
				else
					System.out.print("., ");
			}
			System.out.println();
		}
	}
	
//	public static Object clone(Object copyObject) {
//	    try {
//	      ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
//	      ObjectOutputStream oos = new ObjectOutputStream(baos);
//	      oos.writeObject(copyObject);
//	      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//	      ObjectPutStream ois = new ObjectputStream(bais);
//	      Object deepCopy = ois.readObject();
//	      return deepCopy;
//	    } catch (IOException e) {
//	      e.printStackTrace();
//	    } catch(ClassNotFoundException e) {
//	      e.printStackTrace();
//	    }
//	    return null;
//	  }

	// Returns the status of a cell based on its neighbours
	public static boolean checkAlive(boolean cellCondition, boolean up, boolean left, boolean down, boolean right) {
		// Counts how many cells near it are still alive
		int numAlive = 0;
		if(up)
			numAlive++;
		if(left)
			numAlive++;
		if(down)
			numAlive++;
		if(right)
			numAlive++;
		
		// Return what the status of life is of the cell in next generation
		if(cellCondition && (numAlive == 2 || numAlive == 3))
			return true;
		else if(numAlive == 3)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();	// Used for random generation

		int size = 8;	// size of the game of life
		boolean[][] cells = new boolean[size][size];
		boolean up, down, left, right;
		boolean[][] tempCells = cells;
		int generation = 2;

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
			// Set temp array to cells array, used to make sure cells aren't deleted before they are checked by other cells
			for(int i = 0; i < cells.length; i++)
				tempCells[i] = cells[i].clone();
			
			
			for (int y = 0; y < cells.length; y++) {
				for (int x = 0; x < cells[y].length; x++) {
					// Check if on first row
					if (y == 0) {
						up = false;
					} else {
						up = tempCells[x][y - 1];
					}
					
					// Check if on last row
					if (y == cells.length - 1) {
						down = false;
					} else {
						down = tempCells[x][y + 1];
					}
					
					// Check if on first column
					if(x == 0) {
						left = false;
					} else {
						left = tempCells[x - 1][y];
					}
					
					// Check if on last column
					if(x == cells[x].length - 1) {
						right = false;
					} else {
						right = tempCells[x + 1][y];
					}
					
					// Checks and stores the future cell value, based on its neighbours
					cells[x][y] = checkAlive(cells[x][y], up, left, down, right);
				}
				System.out.println(y);
				printCells(tempCells);
			}
			
			
			// Print out cells 
			System.out.println("\n\nGeneration " + generation + ": ");
			printCells(cells);
			
			// After every calculation of a new generation, increase generation
			generation++;
			
			System.out.print("If you want another generation enter 'y': ");
		} while (in.nextLine().equals("y"));
		
		// Thank user for playing the game of life
		System.out.println("Thank  you for playing the game of life, have an great day!");
		
		// Close the scanner
		in.close();
	}

}