package main;

import main.Dog.Breed;

public class AnimalShelterTester {

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter(2, "test");

		shelter.printOutDogs();
		Dog dog = new Dog();
		
		shelter.addDog(dog);
		shelter.removeDog(dog);
		
		shelter.printOutDogs();
	}

}
