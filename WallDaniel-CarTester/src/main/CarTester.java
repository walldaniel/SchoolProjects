package main;

import java.util.Scanner;

public class CarTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Car[] cars = new Car[3]; // Stores the 3 cars

		// Vars for creating the car
		String make, model, type;
		int year;
		float price, mpg;

		// Ask user for first car
		System.out.println("Enter data for the first car:");

		// Loop until user enters correct data
		do {
			System.out.print("Enter car make: ");
			make = in.nextLine();
			System.out.print("Enter car model: ");
			model = in.nextLine();
			System.out.print("Enter car body type: ");
			type = in.nextLine();

			try {
				System.out.print("Enter the year: ");
				year = Integer.parseInt(in.nextLine());
				System.out.print("Enter the price: ");
				price = Float.parseFloat(in.nextLine());
				System.out.print("Enter the mpg: ");
				mpg = Float.parseFloat(in.nextLine());

				// Make new car
				cars[0] = new Car(make, model, type, year, price, mpg);
				
				// If program got to here means user entered correct data
				break;
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a correct value, try again.");
			}
		} while (true);

		// Ask user for second car, only make and model
		System.out.println("\nEnter the make and model of the second car.");
		
		System.out.print("Enter the car make: ");
		make = in.nextLine();
		System.out.print("Enter the car model: ");
		model = in.nextLine();

		// Add second car to array of cars
		cars[1] = new Car(make, model);

		// Default constructor for 3rd car
		System.out.println("Final car is the default car.");
		cars[2] = new Car();

		// Print out the cars
		System.out.println();
		for (Car c : cars) {
			System.out.println(c.toString());
		}
		
		// Close the scanner
		in.close();
	}

}
