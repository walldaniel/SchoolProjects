package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AnimalShelter {

	private String shelterName;
	ArrayList<Dog> dogs;

	// Creates object with empty array of dogs
	public AnimalShelter() {
		dogs = new ArrayList<>();

		shelterName = "Animal Shelter";
	}

	// Creates object with however many dogs is inputted
	public AnimalShelter(int initalDogs, String shelterName) {
		dogs = new ArrayList<>();

		// Add dogs to array
		for (int i = 0; i < initalDogs; i++) {
			dogs.add(new Dog());
		}

		this.shelterName = shelterName;
	}

	// Add a dog
	public void addDog(Dog dog) {
		dogs.add(dog);
	}

	// Remove a dog by name
	public boolean removeDog(String name) {
		// Find index with the name
		int index = -1;
		for (int i = dogs.size() - 1; i >= 0; i--) {
			if (dogs.get(i).getName() == name) {
				index = i;
				break;
			}
		}

		// Remove the found index
		if (index != -1) {
			dogs.remove(index);
			return true;
		}
		return false;
	}

	public String getName() {
		return shelterName;
	}

	// Remove a dog with the exact same parameters
	public boolean removeDog(Dog dog) {
		// Find index of dog
		int index = -1;
		for (int i = dogs.size() - 1; i >= 0; i--) {
			if (dogs.get(i).equals(dog)) {
				index = i;
				break;
			}
		}

		// Remove index
		if (index != -1) {
			dogs.remove(index);
			return true;
		}
		return false;
	}

	public boolean removeDog(int index) {
		// Make sure number is in bound
		if (index < 0 || index >= dogs.size())
			return false;

		// Remove dog
		dogs.remove(index);
		return true;
	}

	public void saveFile(String filename) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

			JSONObject json = new JSONObject();

			json.put("name", shelterName);

			// Add dogs to json file
			JSONArray arr = new JSONArray();
			for (int i = dogs.size() - 1; i >= 0; i--) {
				arr.add(new JSONObject(dogs.get(i).toJson()));
			}
			json.put("dogs", arr);
			// Write to file
			bw.write(json.toString());

			// Close the file
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Prints out all of the dogs
	public void printOutDogs() {
		for (Dog d : dogs) {
			System.out.println(d.toString());
		}
	}

	// Returns object as a single string
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name: " + shelterName + "\n");

		sb.append("\nDogs:");
		// Add dogs, start with the last in the array
		for (int i = dogs.size() - 1; i >= 0; i--) {
			sb.append(dogs.get(i).toString() + "\n");
		}

		return sb.toString();
	}

	// Attempt to read from file
	public void readFile(String filename) {
		// Create object to read file
		JSONParser parser = new JSONParser();
		try {
			// Get data from file
			Object obj = parser.parse(new FileReader(filename));

			// Cast to json object
			JSONObject json = (JSONObject) obj;

			// Get data from json object
			shelterName = (String) json.get("name");

			JSONArray arr = (JSONArray) json.get("dogs");
			for (int i = arr.size() - 1; i >= 0; i--) {
				JSONObject dog = (JSONObject) arr.get(i);

				dogs.add(new Dog(dog));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Error parsing json");
		}
	}

	public void setName(String name) {
		this.shelterName = name;
	}
}
