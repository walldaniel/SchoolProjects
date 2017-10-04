package main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MyBankMachine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00"); // used for rounding numbers

		String name, bankName;
		float initialDeposit;

		System.out.print("Enter your name: ");
		name = in.nextLine();
		System.out.print("Enter your bank's name: ");
		bankName = in.nextLine();

		// Loop until user enters correct monetary value
		do {
			System.out.print("Enter your initial deposit: ");

			try {
				// If succesful break out of loop
				initialDeposit = Float.parseFloat(in.nextLine());

				if (initialDeposit < 0)
					System.out.println("Enter a monetary value greater than 0");
				else
					break;
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid monetary value");
			}
		} while (true);

		// Create new atm class
		ATM myAtm = new ATM(name, bankName, initialDeposit);

		// While user wants to continue using program, keep looping
		do {
			// Give user options of what to do
			System.out.println();
			System.out.println("What do you want to do?");
			System.out.println("1 - Deposit money");
			System.out.println("2 - Add interest");
			System.out.println("3 - See curent balance");
			System.out.println("4 - See past balances");

			switch (in.nextLine()) {
			case "1":
				do {
					try {
						// Ask user for variables
						System.out.print("Enter how many days since your last bank change: ");
						int days = Integer.parseInt(in.nextLine());
						System.out.print("Enter how much money you would like to deposit: ");
						float money = Float.parseFloat(in.nextLine());

						// Deposit money in myatm class
						if (myAtm.depositMoney(money, days)) {
							// If transaction went successfully break out of loop
							System.out.println("You now have: $" + myAtm.getMoney());
							break;
						} else {
							// Transaction failed
							System.out.println("Your transaction failed, try again.");
						}
					} catch (NumberFormatException e) {
						System.out.println("You did not enter a valid number, try again");
					}
				} while (true);
				break;
			case "2":
				do {
					try {
						// Ask user for details regarding option
						System.out.print("Enter how many days you want to invest for: ");
						int days = Integer.parseInt(in.nextLine());
						System.out.print("Enter the interest per year: ");
						int interest = Integer.parseInt(in.nextLine());

						// Try to apply interest to bank
						if (myAtm.calculateInterest(interest, days)) {
							// Say how much money in bank and break out of loop
							System.out.println("You now have: $" + df.format(myAtm.getMoney()));
							break;
						} else {
							// If some number inputed was negative
							System.out.println("Your transaction failed, try again.");
						}
					} catch (NumberFormatException e) {
						System.out.println("You did not enter a valid number, try again.");
					}
				} while (true);
				break;
			case "3":
				System.out.println("Right now you have: $" + df.format(myAtm.getMoney()) + " in your account");
				break;
			case "4":
				myAtm.printPastBalances();
				break;
			default:
				System.out.println("You did not enter a valid option");
			}

			// Ask user if they want to enter another option
			System.out.println("If you want to exit the program enter 'y': ");
		} while (!in.nextLine().equals("y"));

		// Print out important information
		System.out.println("\nYour bank account:");
		System.out.println(myAtm.toString());
		
		// Print past balances
		System.out.println("Your past balances are: ");
		myAtm.printPastBalances();

		// Concluding sentence
		System.out.println("\nHave a good day");

		// Close the scanner
		in.close();
	}

}
