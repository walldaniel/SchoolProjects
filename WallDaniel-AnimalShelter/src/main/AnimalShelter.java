package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalShelter {

	private String shelterName;
	ArrayList<Dog> dogs;

	// Creates object with empty  array of dogs
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
	public void removeDog(String name) {
		// Find index with the name
		int index = -1;
		for(int i = dogs.size() - 1; i >= 0; i++) {
			if(dogs.get(i).getName() == name) {
				index = i;
				break;
			}
		}
		
		// Remove the found index
		dogs.remove(index);
	}
	
	// Remove a dog with the exact same parameters
	public void removeDog(Dog dog) {
		// Find index of dog
		int index = -1;
		for(int i = dogs.size() - 1; i >= 0; i--) {
			if(dogs.get(i).equals(dog)) {
				index = i;
				break;
			}
		}
		
		// Remove index
		dogs.remove(index);
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
		sb.append(shelterName + "\n");
		
		// Add dogs, start with the last in the array
		for(int i = dogs.size() - 1; i >= 0; i--) {
			sb.append(dogs.get(i).toString() + "\n");
		}
		
		return sb.toString();
	}
}
