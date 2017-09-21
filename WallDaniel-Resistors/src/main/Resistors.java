package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept 19, 2017
 * Purpose: User enters a resistor code and gives ohm value
 */
public class Resistors {

	public static String[] colours = { "BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET", "GREY", "WHITE" };
	
	// Returns the number of the colour of the resistor colour inputted
	// Throws an exception if they did not enter a correct colour
	public static int getIndex(String s) throws Exception {
		for(int i = 0; i < colours.length; i++) {
			if(s.equals(colours[i]))
				return i;
		}
		
		throw new Exception();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		// Loops until the user enters a correct resistor code.
		do {
			// Ask user for resistor code, with hyphens in between
			System.out.print("Enter a 3 colour resistor code, with hyphens in between each colour: ");
			
			// Ask for resistor code
			String[] resCode = in.nextLine().toUpperCase().split("-");

			// Checks to make sure they entered 3 colours with hyphens in between
			// If not tell them to enter a different value.
			if (resCode.length == 3) {
				try {
					// Calculates resistor values and prints it out
					double resValue = ((getIndex(resCode[0])) * 10 + getIndex(resCode[1])) * Math.pow(10, getIndex(resCode[2]));
					System.out.println("The resistor value is: " +  (long) resValue + " ohms.");

					// If works correctly, then break out of loop
					break;
				} catch (Exception e) {
					System.out.println("You did not enter valid resistor codes");
				}
			} else {
				System.out.println("You did not enter a valid code");
			}
		} while (true);
		
		// Concluding sentence
		System.out.println("\nHave a great day!");
		
		// Close the scanner
		in.close();
	}

}
