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

	public Dog() {
		breed = Breed.values()[ThreadLocalRandom.current().nextInt(Breed.values().length)];
		String name = "Unknown";
		age = ThreadLocalRandom.current().nextInt(10);
		weight = ThreadLocalRandom.current().nextFloat() * 10f;
	}

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
}
