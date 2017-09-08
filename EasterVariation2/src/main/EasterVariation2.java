package main;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept. 6, 2017
 * Purpose: to determine the date of Easter on any given year.
 */
public class EasterVariation2 {

	public static void main(String[] args) {
		BigInteger asdf = BigInteger.valueOf(10000000 * 100000);
		System.out.println(asdf);
		Scanner sc = new Scanner(System.in);
		int year = 0;
		// Variable is true when an exception is catched
		boolean exception = false;
		
		// Runs loop until user enters a valid year
		do{
			// If the user enters an invalid string for the year, catches and tells the user to try again.
			try {
				// Reset exception to false so loop can exit if valid year is inputted.
				exception = false;
				
				// Get year from user
				System.out.print("Enter a year to find out the date of easter: ");
				year = Integer.parseInt(sc.next());
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a valid year, try again.\n");
				exception = true;
			}
		}while(exception);
		
		// Start procedure to get date of Easter.
		int a = year / 100;
		int b = year % 100;
		
		int c = (3 * (a + 25)) / 4;
		int d = (3 * (a + 25)) % 4;
		
		int q = (8 * (a + 11)) / 25;
		
		int f = (5 * a + b) % 19;
		
		int g = (19 * f + c - q) % 30;
		
		int h = (f + 11 * g) / 319;
		
		int j = (60 * (5 - d) + b) / 4;
		int k = (60 * (5 - d) + b) % 4;
		
		int n = (2 * j - k - g + h) % 7;
		
		// Month is the month in which easter takes place.
		int month = (g - h + n + 114) / 31;
		int p = (g - h + n + 114) % 31;
		
		// Day is the day of the month in which easter takes place.
		int day = p + 1;
		
		// Depending on month number display correct month name
		switch(month) {
		// month 3 is March.
		case 3:
			System.out.println("\n\nEaster is on March " + day + ", " + year + ".");
			break;
		// Month 4 is April.
		case 4:
			System.out.println("\n\nEaster is on April " + day + ", " + year + ".");
			break;
		// In case an error happens when calculating the date.
		default:
			System.out.println("\n\nAn error was encountered.");
		}
		
		// Close the scanner to avoid memory leaks.
		sc.close();
	}

}
