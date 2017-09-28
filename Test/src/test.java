import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 9-18-2017
 * Purpose: Displays 8 queens on a chest board.
 */
public class test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Chestboard array
		int[][] chessBoard = new int[8][8];

		// Tell user what this program does
		System.out.println("This program displays the location of 8 queens on a chess board (8x8)\n");

		for (int i = 0; i < 8; i++) {
			int x, y; // Vars for coordinates of current queen

			// Loop until the user enters a valid location
			do {
				try {
					// Ask user for where the queens are
					System.out.print("Enter the coordinates of the next queen (\"x,y\"): ");

					// Get input from user and parse for two numbers
					String[] coords = in.nextLine().split(",");
					x = Integer.parseInt(coords[0]);
					y = Integer.parseInt(coords[1]);

					// Check if they already entered that location
					if (chessBoard[x - 1][y - 1] == 0) {
						// Set the location on board to a queen
						// Start the board at 1,1
						chessBoard[x - 1][y - 1] = 1;

						// Break out of loop
						break;
					} else {
						System.out.println("You already entered that location");
					}
				} catch (NumberFormatException e) {
					System.out.println("\nYou did not enter a correct set of coordinates");
					System.out.println("Type first number, comma, then second number(no spaces or brackets)\n");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("You entered a location that is not on the board");
				}
			} while (true);
		}

		// Print out board
		for (int x = 0; x < chessBoard.length; x++) {
			for (int y = 0; y < chessBoard[x].length; y++) {
				System.out.print(chessBoard[x][y] + " ");
			}
			// Add a line for formatting
			System.out.println();
		}

		// Close the scanner
		in.close();
	}

}
