package main;


public abstract class Vehicle {

	private double fuelEfficiency;
	
	public Vehicle(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	public double getDistance(double gas) {
		return gas / fuelEfficiency * 100;
	}
	
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	
}
