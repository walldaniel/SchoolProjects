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

		String[] schools = { "Catholic Central", "Holy Cross", "John Paul II", "Mother Teresa", "REgina Mundi",
				"St. Joseph", "St. Mary", "St. Thomas Aquinas", "Sacred Heart" };
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
						System.out.print("Enter donation amount: ");

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
			
			for(String s : schools) {
				System.out.print(s.substring(0, 6) + " ");
			}
			// Formatting
			System.out.println();
			
			for(double[] dArr : fundRaising) {
				for(double d : dArr) {
					System.out.print(d + "\t- ");
				}
				System.out.println();
			}
			
		} while (false);
		
		// Close the scanner
		in.close();
	}

}
