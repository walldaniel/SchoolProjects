package main;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Daniel Wall
 * Date: Sept. 6, 2017
 * Purpose: finds the area of a scalene triangle
 */
public class AreaTriangle {
	
	public static void main(String[] args) {
		double area = 0;
		Scanner sc = new Scanner(System.in);
		boolean retry = false;	// boolean to tell the loop to redo

		System.out.println("This program calculates the area of a scalene triangle using its side lengths.");

		do {
			// Loop will end unless user enters something wrong
			retry = false;
			
			// Ask the user what they know about the triangle
			System.out.println("Enter the option for what you know about your triangle: ");
			System.out.println("a - 3 side lengths");
			System.out.println("b - 2 side lengths and 1 angle");
			
			switch (sc.next()) {
			case "a":
				// Continues to loop until the user enters the side lengths of a valid triangle.
				do {
					try {
						// Ask user for sides of triangles and store in vars.
						System.out.print("First side length: ");
						double a = Double.parseDouble(sc.next());
						System.out.print("Second side length: ");
						double b = Double.parseDouble(sc.next());
						System.out.print("Third side length: ");
						double c = Double.parseDouble(sc.next());

						// Calculate area of triangle.
						double s = (a + b + c) / 2;
						area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
					} catch (NumberFormatException e) {
						System.out.println("That was not a valid number please try again.");
					}

					// If the side lengths don't form a triangle tell the user to try again
					if (Double.isNaN(area)) {
						System.out.println("You did not enter valid side lengths for a triangle, please try again");
					}
				} while (Double.isNaN(area));

				break;
			case "b":
				// No loop because all numbers they enter will be valid
				try {
					// Ask user for sides of triangles and store in vars.
					System.out.print("First side length: ");
					double a = Double.parseDouble(sc.next());
					System.out.print("Second side length: ");
					double b = Double.parseDouble(sc.next());
					System.out.print("Angle size: ");
					double c = Double.parseDouble(sc.next());

					// Calculate area of triangle.
					area = (a * b * Math.sin(c * Math.PI / 180)) / 2;
				} catch (NumberFormatException e) {
					System.out.println("That was not a valid number please try again.");
				}

				// If the side lengths don't form a triangle tell the user to try again
				if (Double.isNaN(area)) {
					System.out.println("You did not enter valid side lengths for a triangle, please try again");
				}

				break;
			default:
				System.out.println("You did not enter a valid option, try again");
				retry = true;
			}
		} while (retry);
		
		// Print out the area of the triangle to the user
		System.out.println("\nTherefore the area of the triangle is: " + area);
		
		// Closes the scanner to avoid memory leaks.
		sc.close();
	}

}
