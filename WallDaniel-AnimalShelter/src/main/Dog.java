package main;

import java.util.concurrent.ThreadLocalRandom;

public class Dog {

	public enum Breed {
		GOLDEN, LAB, BEAGLE, BULLDOG, POODLE, CHIHUAHUA
	};

	private Breed breed;
	private String name;
	private int age;
	private float weight;
	private int aggression; // Low number is not aggressive, 0 < a < 20

	// Default constructor
	public Dog() {
		breed = Breed.values()[ThreadLocalRandom.current().nextInt(Breed.values().length)];
		name = "Unknown";
		age = ThreadLocalRandom.current().nextInt(10);
		weight = ThreadLocalRandom.current().nextFloat() * 10f;
	}

	// Constructor with all fields filled in
	public Dog(Breed breed, String name, int age, int weight, int aggression) {
		this.breed = breed;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.aggression = aggression;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Breed: " + breed.toString() + "\n");
		sb.append("Name: " + name + "\n");
		sb.append("Age: " + age + " years\n");
		sb.append("Weight: " + String.format(java.util.Locale.US,"%.2f", weight) + " kg\n");
		sb.append("Aggression: " + aggression + "\n");
		
		return sb.toString();
	}

	public boolean equals(Dog dog) {
		return (this.name.equals(dog.getName()) && this.age == dog.age && this.aggression == dog.aggression
				&& this.breed == dog.breed && this.weight == dog.weight);
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getAggression() {
		return aggression;
	}
	
	public Breed getBreed() {
		return breed;
	}
	
	public float getWeight() {
		return weight;
	}
}
