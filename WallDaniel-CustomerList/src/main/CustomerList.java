package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList {

	public static String FILENAME = "customerList.txt";

	public static boolean isPostalCode(String s) {
		// Make sure the postal code is 6 characters long
		if (s.length() != 6)
			return false;

		// Check to make sure the postal code is L#L#L#
		for (int i = 0; i < 6; i += 2) {
			if (!Character.isAlphabetic(s.charAt(i)))
				return false;
		}
		for (int i = 1; i < 6; i += 2) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}

		// If all checks return true then is postal code
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BufferedReader fileReader;
		FileWriter fileWriter;
		String line;

		// List of different
		ArrayList<Customer> oldCustomers = new ArrayList<>();
		ArrayList<Customer> newCustomers = new ArrayList<>();

		// Tell user about program
		System.out.println("This program allows you to store data about customers.");
		
		// Get already saved customers
		System.out.println("\nYour current customers: ");
		try {
			fileReader = new BufferedReader(new FileReader(FILENAME));

			// Read every line
			for (int i = 0; (line = fileReader.readLine()) != null; i++) {
				String[] params = line.split(";");

				// Try and add line to the old customers array
				try {
					oldCustomers.add(new Customer(params[0], params[1], params[2], params[3], params[4]));
					System.out.println("Customer " + (i + 1) + ": " + oldCustomers.get(i).toString());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error reading file on line: " + i);
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}

			}

			// Close the file Reader
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get new customers
		System.out.println("\nAdd your new customers");
		do {
			// Ask user for details about customer
			System.out.print("Enter the customers name: ");
			String name = in.nextLine();
			System.out.print("Enter the customers address: ");
			String address = in.nextLine();
			System.out.print("Enter the customers city: ");
			String city = in.nextLine();
			System.out.print("Enter the customers province: ");
			String province = in.nextLine();

			String postalCode;
			// Make sure that they enter a valid canadian postal code
			do {
				System.out.print("Enter the customers postal code: ");
				postalCode = in.nextLine().replaceAll("\\s", ""); // Get rid of all spaces that the user enters

				// If the user enters a valid postal code, exit out of loop
				if (isPostalCode(postalCode))
					break;
				else
					System.out.println("You did not enter a valid postal code, try again.");
			} while (true);

			// Add customer to list
			newCustomers.add(new Customer(name, address, city, province, postalCode));

			// Ask user if they want to put in more customers
			System.out.print("Enter yes to enter in another customer: ");
		} while (in.nextLine().charAt(0) == 'y');

		// Print out all customers to file
		System.out.println("Saving customers to: ");
		try {
			fileWriter = new FileWriter((FILENAME), true);

			// Add a line to the file
			// fileWriter.append("\n");

			// Loop through all customers and save them to a file
			for (Customer c : newCustomers) {
				fileWriter.append(c.toSaveFile() + "\n");
				System.out.println(c.toString());
			}

			// Close the file writer
			fileWriter.close();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	public static class Customer {
		private String name, address, city, province, postalCode;

		public Customer(String name, String address, String city, String province, String postalCode) {
			this.name = name;
			this.address = address;
			this.city = city;
			this.province = province;
			this.postalCode = postalCode;
		}

		public String toString() {
			return "name: " + name + ",\taddress: " + address + ",\tcity: " + city + ",\tprovince: " + province + ",\tpostal code:" + postalCode;
		}

		public String toSaveFile() {
			return name + ";" + address + ";" + city + ";" + province + ";" + postalCode;
		}
	}
}
