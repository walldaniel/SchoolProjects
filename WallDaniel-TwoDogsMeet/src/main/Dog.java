package main;

import java.util.Random;

public class Dog {

	private final int maxAge = 10;
	private final int maxHunger = 10;
	private final int maxAggression = 10;
	private int age, hunger, aggression;

	Random rand = new Random();
	
	// Set doggo with random properties
	public Dog() {
		age = rand.nextInt(maxAge);
		hunger = rand.nextInt(maxHunger);
		aggression = rand.nextInt(maxAggression);
	}
	
	// Set doggo with user defined parameters
	public Dog(int age, int hunger, int aggression) {
		this.age = age;
		this.hunger = hunger;
		this.aggression = aggression;
	}
	
	// Simulated meeting between two dogs, returns true if friendly
	public boolean friendlyMeeting(Dog doggo) {
		if(doggo.getHunger() + doggo.getAggression() * 2 + this.hunger + this.aggression * 2 > 34) 
			return false;
			
		return true;
	}
	
	// Return a string of the dogs properties
	public String toString() {
		return "age: " + age + ", hunger: " + hunger + ", aggression: " + aggression;
	}
	
	// Gettters for variables
	public int getAge() {
		return age;
	}
	public int getHunger() {
		return hunger;
	}
	public int getAggression() {
		return aggression;
	}
	
	// Setters for variables, but make sure the stats are within a range
	public boolean setAge(int age) {
		if(age <= maxAge && age >= 0) {
			this.age = age;
			return true;
		}
		
		return false;
	}
	public boolean setHunger(int hunger) {
		if(hunger <= maxHunger && hunger >= 0) {
			this.hunger = hunger;
			return true;
		}
		
		return false;
	}
	public boolean setAggression(int aggression) {
		if(aggression <= maxAggression && aggression >= 0) {
			this.aggression = aggression;
			return true;
		}
		
		return false;
		
	}
}
