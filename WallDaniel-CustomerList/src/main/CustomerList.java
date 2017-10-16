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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BufferedReader fileReader;
		PrintWriter fileWriter;
		String line;
		
		// List of different 
		ArrayList<Customer> customers = new ArrayList<>();

		// Get already saved customers
		try {
			fileReader = new BufferedReader(new FileReader(FILENAME));
			
			// Read every line
			while((line = fileReader.readLine()) != null) {
				String parameters = line.split(",");
				
				for()
			}
			
			// Close the file Reader
			fileReader.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Get new customers
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
			System.out.print("Enter the customers postal code: ");
			String postalCode = in.nextLine();

			// Add customer to list
			customers.add(new Customer(name, address, city, province, postalCode));
			
			// Ask user if they want to put in more customers
			System.out.print("Enter yes to enter in another customer: ");
		} while(in.nextLine().charAt(0) == 'y');
		
		// Print out all customers to file
		System.out.println();	// Formatting
		try {
			fileWriter = new PrintWriter(new FileWriter(FILENAME));
			
			// Loop through all customers and save them to a file
			for(Customer c : customers) {
				fileWriter.append(c.toSaveFile());
				System.out.println(c.toString());
			}
			
			// Close the file writer
			fileWriter.close();
		} catch(Exception e) {
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
			return name + ", " + address + ", " + city + ", " + province + ", " + postalCode;
		}
		
		public String toSaveFile() {
			return name + ";" + address + ";" + city + ";" + province + ";" + postalCode;
		}
	}
}
