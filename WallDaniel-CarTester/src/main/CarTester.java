package main;

import java.util.Scanner;

public class CarTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Ask user for first car

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter data for car " + i);
			
			String make, model, type;
			int year;
			float price, mpg;
			
			// Loop until user enters correct data
			do {
				System.out.print("Enter car make: ");
				make = in.next();
				System.out.print("Enter car model: ");
				model = in.nextLine();
				System.out.println("Enter car body type: ");
				type = in.nextLine();
				
				try {
					
				} catch(NumberFormatException e) {
					System.out.println("You did not enter a correct value, try again.");
				}
			} while(true);
		}
	}

}
