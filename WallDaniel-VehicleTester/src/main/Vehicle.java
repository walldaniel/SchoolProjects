package main;

import java.text.DecimalFormat;

public class Vehicle {
	public double gasKilometrage;
	public double fuelTankSize;
	public double fuelAvailable;
	public double kilometresTravelled;

	// New variables
	public double passengerFare;
	public double fuelCost;
	public boolean carriesPassengers = false;
	public int numberOfPassengers;

	DecimalFormat df = new DecimalFormat("0.00");
	
	public Vehicle() {
		// Default Constructor
		gasKilometrage = 0;
		fuelTankSize = 0;
		fuelAvailable = 0;
		kilometresTravelled = 0;
	}

	// Vehicle without passengers
	public Vehicle(double gasKilometrage, double fuelTankSize, double fuelAvailable, double kilometresTravelled,
			double fuelCost) {

		this.gasKilometrage = gasKilometrage;
		this.fuelTankSize = fuelTankSize;
		this.fuelAvailable = fuelAvailable;
		this.kilometresTravelled = kilometresTravelled;
		this.fuelCost = fuelCost;
	}

	// Vehicle with passengers
	public Vehicle(double gasKilometrage, double fuelTankSize, double fuelAvailable, double kilometresTravelled,
			double fuelCost, double passengerFare, int initialPassengers) {

		this.gasKilometrage = gasKilometrage;
		this.fuelTankSize = fuelTankSize;
		this.fuelAvailable = fuelAvailable;
		this.kilometresTravelled = kilometresTravelled;
		this.fuelCost = fuelCost;
		this.numberOfPassengers = initialPassengers;
		this.passengerFare = passengerFare;
		carriesPassengers = true;
	}

	public void addFuel(double gas) {
		if ((fuelTankSize - fuelAvailable) >= gas) {
			fuelAvailable += gas;
			System.out.println("Added " + gas + "L of gas to the tank.");
		} else {
			System.out.println("You tried to add " + gas + "L of gas.");
			System.out.println("There is only room for " + (fuelTankSize - fuelAvailable) + "L.");
		}
	}

	public void addPassengers(int numPassengers) {
		// Make sure vehicle can carry passengers
		if (carriesPassengers) {
			System.out.println("Adding " + numPassengers + " passengers to vehicle.");
			numberOfPassengers += numPassengers;
			System.out.println("There are " + numberOfPassengers + " in vehicle.");
		} else {
			System.out.println("This vehicle doesn't carry passengers");
		}
	}

	public void removePassengers(int numPassengers) {
		// Make sure vehicle can carry passengers
		if (carriesPassengers) {
			// Check to make sure they can remove the amount of passengers
			if (numberOfPassengers < numPassengers) {
				System.out.println("You cannot remove that many passengers");
				return;
			}

			// Remove the passengers
			System.out.println(numPassengers + " passengers are leaving.");
			numberOfPassengers -= numPassengers;
			System.out.println("There are " + numberOfPassengers + " in .");
		} else {
			System.out.println("Vehicle doesn't carry passengers");
		}
	}

	public void driveVehicle(double kms) {
		// Drive the vehicle
		// ex. If the vehicle uses 9.5L/100 km then
		// litresNeeded = kms * 9.5 / 100
		System.out.println("Drive " + kms + "kms.  Start with " + fuelAvailable + "L of gas.");
		double litresNeeded = (kms * gasKilometrage) / 100.0;
		if (fuelAvailable >= litresNeeded) {
			fuelAvailable -= litresNeeded;
			kilometresTravelled += kms;
			System.out.println("Used " + litresNeeded + "L of gas.");
		} else {
			System.out.println("Ran out of fuel!");
			// Calculate how many kms were driven
			double kmsThisDrive = (fuelAvailable * 100.0) / gasKilometrage;
			kilometresTravelled += kmsThisDrive;
			fuelAvailable = 0;
			System.out.println("The vehicle drove " + kmsThisDrive + " before running out of gas.");
		}
	}

	public double revenue() {
		// Revenue = passengers * passengerfare
		return passengerFare * numberOfPassengers;
	}
	
	public double cost() {
		// Cost is the amount of litres used multiplied by the fuel cost
		return (kilometresTravelled / gasKilometrage) * fuelCost;
	}
	
	public double profit() {
		// Profit is revenue - cost
		return revenue() - cost();
	}
	
	public void changePassengerCost(double newPassengerFare) {
		// Make sure that the passenger cost is above 0
		if (newPassengerFare < 0) {
			System.out.println("Can't have fuel cost less than zero");
			return;
		}

		System.out.println("Old fuel cost was: " + passengerFare + ". New fuel cost will be: " + newPassengerFare);
		fuelCost = newPassengerFare;
	}

	public void changeFuelCost(double newFuelCost) {
		// Make sure that they don't gain money by buying fuel
		if (newFuelCost < 0) {
			System.out.println("Can't have fuel cost less than zero");
			return;
		}

		System.out.println("Old fuel cost was: " + fuelCost + ". New fuel cost will be: " + newFuelCost);
		fuelCost = newFuelCost;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Gas Kilometrage = " + gasKilometrage + "\n");
		sb.append("Fuel Tank Size = " + fuelTankSize + "\n");
		sb.append("Fuel Available = " + fuelAvailable + "\n");
		sb.append("Kilometres Driven = " + kilometresTravelled + "\n");
		sb.append("Fuel cost = $" + fuelCost + "/km\n");
		sb.append("Number of passengers" + numberOfPassengers + "\n");
		sb.append("Revenue is = $" + df.format(revenue()) + "\n");
		sb.append("Cost is = $" + df.format(cost()) + "\n");
		sb.append("Profit is = $" + df.format(profit()) + "\n");
		return sb.toString();
	}
}