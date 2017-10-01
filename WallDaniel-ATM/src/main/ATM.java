package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ATM {
	
	DecimalFormat df = new DecimalFormat("0.00");

	private float balance;
	private String name;
	private String bankName;
	int date = 0;	// Days since bank account created
	
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
		this.balance = initialBalance;
	}
	
	// Returns true if successful, or false if failed
	public boolean depositMoney(float money, int days) {
		if(money < 0)
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
	
	// Calculates interest 
	public void calculateInterest(int compounds, float interestPerCompound, int days) {
		// Make sure that 
		if(compounds < 0 || interestPerCompound < 0)
			return;
		
		// Add past balance to array
		pastBalances.add(new pastBalance(balance, date));
		
		// Calculate interest
		balance += balance * Math.pow((1 + interestPerCompound), compounds);
		
		// Add days to date
		date += days;
	}
	
	// Print out the past balances
	public void printPastBalances() {
		
		
		// Print out balances with dates
		for(pastBalance pb : pastBalances) {
			System.out.println("   " + pb.date + "\t| " + pb.balance);
		}
		
		// Print out current balance
		System.out.println("   " + date + "\t| " + balance);
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
}
