package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept.19, 2017
 * Purpose: determine fund raising by ottawa high schools
 */
public class FundRaising {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] schools = { "Central", "Holy Cross", "John Paul II", "Mother Teresa", "Regina Mundi",
				"St Joseph", "St. Mary", "St Thomas", "Sacred Heart" };
		double[] donation = { 0.25, 0.50, 1.00, 2.00 };

		double[][] fundRaising = new double[donation.length][schools.length]; // How many people are giving each amount

		int currentHighSchool = 0;
		int currentDonation = 0;

		// Allows the user to enter as much information as needed
		do {
			// Print out all high schools
			System.out.println("High schools are: ");
			for (int i = 0; i < schools.length; i++) {
				System.out.println(i + " - " + schools[i]);
			}

			try {
				currentHighSchool = Integer.parseInt(in.nextLine());

				if (currentHighSchool >= 0 && currentHighSchool <= schools.length) {
					do {
						// Ask for donation amount
						System.out.println("Enter donation amount");

						for (int i = 0; i < donation.length; i++) {
							System.out.println(i + " - " + donation[i]);
						}
						currentDonation = Integer.parseInt(in.nextLine());
						
						// If user inputs valid number continue, else get them to enter a new number
						if(currentDonation >= 0 && currentDonation <= 4)
							break;
						
						System.out.println("You did not enter a correct number, try again");
					} while (true);

					// Ask for population
					System.out.print("Enter population of school: ");
					
					// Put donation amount / population in array
					fundRaising[currentHighSchool][currentDonation] = Integer.parseInt(in.nextLine());
				} else {
					System.out.println("You did not enter a valid number, try again");
				}
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a valid option");
			}
			
			// Print out donation table
			System.out.print("\t+ ");
			
			// Print out school names
			for(String s : schools) {
				if(s.equals(schools[schools.length - 1]))
					System.out.println(s);
				else if(s.length() < 12)
					System.out.print(s + "\t| ");
				else
					System.out.print(s.substring(0,  12) + "\t| ");
			}
			
			// Print out donation amount population
			for(int x = 0; x < fundRaising.length; x++) {
				System.out.print(donation[x] + "\t|\t");
				for(int y = 0; y < fundRaising[x].length ; y++) {
					if(y == fundRaising[x].length - 1)
						System.out.print((int) fundRaising[x][y]);
					else
						System.out.print((int) fundRaising[x][y] + "\t|\t");
				}
				System.out.println();
			}
			
			// Print out total donation amount
			
		} while (false);
		
		// Close the scanner
		in.close();
	}

}
