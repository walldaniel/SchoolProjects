package main;

import java.util.Scanner;

public class MyBankMachine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

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
				
				if(initialDeposit < 0)
					System.out.println("Enter a monetary value greater than 0");
				else 
					break;
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid monetary value");
			}
		} while (true);
		
		// Create new atm class
		ATM myAtm = new ATM(name, bankName, initialDeposit);
		
		myAtm.depositMoney(100, 5);
		myAtm.depositMoney(50, 1);
		myAtm.depositMoney(150, 50);
		
		myAtm.printPastBalances();
	}

}
