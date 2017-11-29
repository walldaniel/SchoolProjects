package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Dog.Breed;

public class AnimalShelterTester {

	public static final String FILENAME = "animalShelter.txt";

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Dog.getBreed(br));

		AnimalShelter shelter = new AnimalShelter();

		// Try to read the file
		shelter.readFile(FILENAME);

		// Ask is user wants to rename shelter
		System.out.println("The current shelter name is: " + shelter.getName());
		System.out.print("Do you want to rename the shelter? (yes):");
		if (br.readLine().charAt(0) == 'y') {
			System.out.print("Enter in the new animal shelter name: ");

			// Set new name
			shelter.setName(br.readLine());
		}

		// Ask user what they want to do
		String option;
		do {
			// Display the list of options]
			System.out.println("What do you want to do?:");
			System.out.println("1 - Add a dog");
			System.out.println("2 - Remove a dog");
			System.out.println("3 - Exit program");
			option = br.readLine();

			try {
				// Program flows differently based on user input
				switch (Integer.parseInt(option)) {
				case 1 :
					System.out.println("Do you want to add a random dog? (y)");
					
					// Add a random dog
					if(br.readLine().charAt(0) == 'y') {
						shelter.addDog(new Dog());
					} else {	// Add dog that user enters stats for
						System.out.print("Enter the name of the dog: ");
						String name = br.readLine();
						Breed breed = Dog.getBreed(br);
					}
					break;
				case 2:
					break;
				default:
					System.out.println("You did not enter a valid number, try again");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}

		} while (Integer.parseInt(option) != 3);

		shelter.saveFile(FILENAME);
	}

}
