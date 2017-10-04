package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ATM {

	DecimalFormat balanceFormatter = new DecimalFormat("0.00");

	private float balance;
	private String name;
	private String bankName;
	int date = 0; // Days since bank account created

	// Stores the balance of the bank account in the past
	ArrayList<pastBalance> pastBalances = new ArrayList<>();

	// Default constructor
	public ATM() {
		balance = 0;
		name = "unknown";
		bankName = "TD Canada";
	}

	// Constructor with every value filled in
	public ATM(String name, String bankName, float initialBalance) {
		this.name = name;
		this.bankName = bankName;

		if (initialBalance > 0) {
			this.balance = initialBalance;
		} else {
			System.out.println("You did not enter a correct initial balance, setting to 0");
			this.balance = 0;
		}
	}

	// Returns true if successful, or false if failed
	public boolean depositMoney(float money, int days) {
		if (money < 0 || days < 0)
			return false;

		// Add past balance
		pastBalances.add(new pastBalance(balance, date));

		// Add date
		date += days;

		// Add money to balance
		this.balance += money;

		return true;
	}

	// Return balance amount
	public float getMoney() {
		return balance;
	}

	// Calculates interest, assumes daily interest compounding
	public boolean calculateInterest(float interestPerYear, int days) {
		// If values entered are false, return false
		if (interestPerYear < 0 || days < 0)
			return false;

		// Add past balance to array
		pastBalances.add(new pastBalance(balance, date));

		// Calculate interest
		balance *= Math.pow((1 + (interestPerYear / 100 / 365)), days);

		// Add days to date
		date += days;

		return true;
	}

	// Print out the past balances
	public void printPastBalances() {
		System.out.println("Your past balances are: \n");
		
		// Create table header
		System.out.println(" days\t| balance");
		System.out.println("--------+---------");
		
		// Print out balances with dates
		for (pastBalance pb : pastBalances) {
			System.out.println("   " + pb.date + "\t| $" + balanceFormatter.format(pb.balance));
		}

		// Print out current balance
		System.out.println("   " + date + "\t| $" + balanceFormatter.format(balance));
	}

	// Class that holds the balance and date of a past balance
	private class pastBalance {
		float balance;
		int date;

		public pastBalance(float balance, int date) {
			this.balance = balance;
			this.date = date;
		}
	}
	
	// Return important information about class in one string
	public String toString() {
		return "Name: " + name + ", Bank name: " + bankName + ", Current balance: $" + balanceFormatter.format(balance);
	}
}
