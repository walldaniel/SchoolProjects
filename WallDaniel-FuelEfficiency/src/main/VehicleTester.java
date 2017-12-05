package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VehicleTester {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double litres = -1;
		String anotherTry = "";

		do {
			do {
				System.out.print("Enter the amount of gas(L): ");
				try {
					litres = Double.parseDouble(br.readLine());

					if (litres < 0)
						System.out.println("Enter a number greater than 0");
				} catch (NumberFormatException e) {
					System.out.println("Enter a valid amount of gas");
				}
			} while (litres < 0);

			// Print out the distance for each car
			System.out.println("\nOn " + litres + "L of gas these vehicles can run: ");
			System.out.println("Car: " + new Car().getDistance(litres));
			System.out.println("Truck: " + new Truck().getDistance(litres));
			System.out.println("Hybrid car: " + new HybridCar().getDistance(litres));
			System.out.println("Motorcycle: " + new Motorcycle().getDistance(litres));
			
			// Ask user if they want to go again
			System.out.println("Do you want to enter another amount?(y/n): ");
			anotherTry = br.readLine();
		} while (anotherTry.charAt(0)== 'y' || anotherTry.charAt(0) == 'Y');

		br.close();
	}

}
