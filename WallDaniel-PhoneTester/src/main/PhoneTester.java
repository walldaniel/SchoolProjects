package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneTester {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Create phone object
		System.out.println("Creating new phone...");
		CellPhone cell = new CellPhone();
		
		System.out.print("Enter the Carrier: ");
		cell.setCarrier(br.readLine());
		System.out.print("Enter the model: ");
		cell.setType(br.readLine());
		
		// Get the values that could result in error
		double speed = -1;
		double memory = -1;
		int numApps = -1;
		do {
			try {
				System.out.print("Enter the speed of phone in GHz: ");
				speed = Double.parseDouble(br.readLine());
				
				if(speed <= 0)
					System.out.println("Enter a value greater than 0");
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid number");
			}
		} while(speed <= 0);
		cell.setSpeed(speed);
		
		// Get the memory of phone
		do {
			try {
				System.out.print("Enter the memory of phone in GBs: ");
				memory = Double.parseDouble(br.readLine());
				
				if(memory <= 0)
					System.out.println("Enter a value greater than 0");
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid number");
			}
		} while(memory <= 0);
		cell.setMemory(memory);
		
		// Get the number of apps on phone
		do {
			try {
				System.out.print("Enter the number of apps on the phone: ");
				numApps = Integer.parseInt(br.readLine());
				
				if(numApps <= 0)
					System.out.println("Enter a value greater than 0");
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid number");
			}
		} while(numApps <= 0);
		cell.setNumApps(numApps);

		// Print out the stat of the phones
		System.out.println("=====================");
		System.out.println("The stats of your phone are: ");
		System.out.println("Carrier = " + cell.getCarrier());
		System.out.println("Type of phone = " + cell.getType());
		System.out.println("Speed of phone = " + cell.getSpeed() + "Ghz");
		System.out.println("Memory = " + cell.getMemory() + "Gb");
		System.out.println("Number of Apps = " + cell.getNumApps());
		
		// Close the scanner
		br.close();
	}

}
