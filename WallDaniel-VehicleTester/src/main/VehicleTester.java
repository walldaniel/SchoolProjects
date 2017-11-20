package main;

public class VehicleTester {

	public static void main(String[] args) {
		Vehicle car1 = new Vehicle(7.5, 60.0, 60.0, 0.0, 10, 240, 1);
		// Show Vehicle Info
		System.out.println(car1);

		// Remove passenger
		car1.removePassengers(1);
		System.out.println(car1);

		// Add 5 passengers
		car1.addPassengers(5);
		System.out.println(car1);
		
		// Drive car for 100km
		car1.driveVehicle(100.0);
		System.out.println(car1);

		// Drive car for 450 kms
		car1.driveVehicle(450.0);
		System.out.println(car1);

		// Try to drive 1000 km - runs out of gas
		car1.driveVehicle(1000.0);
		System.out.println(car1);

		// Add 25L of gas
		car1.addFuel(25.0);
		System.out.println(car1);

		// Try to add 100 L of gas
		car1.addFuel(100.0);
		System.out.println(car1);

		// Change fuel cost
		car1.changeFuelCost(12.5);
		System.out.println(car1);

		// Calculate fuel cost
		car1.profit();
	}

}
