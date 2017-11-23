package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalShelter {

	ArrayList<Dog> dogs;

	public AnimalShelter() {
		dogs = new ArrayList<>();

		for (int i = ThreadLocalRandom.current().nextInt(1, 10); i > 0; i--) {
			dogs.add(new Dog());
		}
	}

	public AnimalShelter(int initalDogs) {
		dogs = new ArrayList<>();

		for (int i = 0; i < initalDogs; i++) {
			dogs.add(new Dog());
		}
	}

	public void printOutDogs() {
		for (Dog d : dogs) {
			System.out.println(d.toString());
		}
	}
}
