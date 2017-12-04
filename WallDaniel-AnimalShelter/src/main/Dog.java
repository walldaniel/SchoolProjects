package main;

import java.io.BufferedReader;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONObject;

public class Dog {

	public enum Breed {
		GOLDEN, LAB, BEAGLE, BULLDOG, POODLE, CHIHUAHUA
	};

	private Breed breed;
	private String name;
	private int age;
	private double weight;
	private int aggression; // Low number is not aggressive, 0 < a < 20

	// Static method for getting breed
	public static Breed getBreed(BufferedReader br) {
		Breed breed = null;
		
		do {
			System.out.println("Enter the breed: ");
			
			// Print out different options
			for(int i = 0; i < Breed.values().length; i++) {
				System.out.println(i + " - " + Breed.values()[i]);
			}
			
			try {
				breed = Breed.values()[Integer.parseInt(br.readLine())];
			} catch(Exception e) {
				System.out.println("Value e");
			}
		} while(breed == null);
		
		return breed;
	}
	
	// Default constructor
	public Dog() {
		breed = Breed.values()[ThreadLocalRandom.current().nextInt(Breed.values().length)];
		name = "Unknown";
		age = ThreadLocalRandom.current().nextInt(10);
		weight = ThreadLocalRandom.current().nextFloat() * 10f;
	}

	// Constructor with all fields filled in
	public Dog(Breed breed, String name, int age, double weight, int aggression) {
		this.breed = breed;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.aggression = aggression;
	}

	// Constructor from json object
	public Dog(JSONObject obj) {
		// Try and parse json object
		try {
			breed = Breed.valueOf((String) obj.get("breed"));
			name = (String) obj.get("name");
			age = ((Long) obj.get("age")).intValue();
			weight = (double) obj.get("weight");
			aggression = ((Long) obj.get("aggression")).intValue();
		} catch (Exception e) {
			System.out.println("Error parsing dog object");
			e.printStackTrace();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Breed: " + breed.toString() + "\n");
		sb.append("Name: " + name + "\n");
		sb.append("Age: " + age + " years\n");
		sb.append("Weight: " + String.format(java.util.Locale.US, "%.2f", weight) + " kg\n");
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

	public double getWeight() {
		return weight;
	}

	// Returns dog as a json object
	public JSONObject toJson() {
		JSONObject json = new JSONObject();

		json.put("breed", breed.toString());
		json.put("name", name);
		json.put("age", age);
		json.put("weight", weight);
		json.put("aggression", aggression);

		return json;
	}
}
