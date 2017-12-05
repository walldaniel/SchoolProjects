package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Dog.Breed;

public class AnimalShelterTester {

	public static final String FILENAME = "animalShelter.txt";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			System.out.println("3 - See all the dogs");
			System.out.println("4 - Cost to run shelter per day");
			System.out.println("5 - Exit program");
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
						
						// Get age
						int age = -1, aggression = -1;
						float weight = -1f;
						do {
							System.out.print("Enter the age of the dog: ");
							try {
								age = Integer.parseInt(br.readLine());
								
								if(age < 0)
									System.out.println("Please enter a valid age.");
							} catch (NumberFormatException e) {
								System.out.println("Please enter a valid integer");
							}
						} while(age < 0);
						
						// Get aggression
						do {
							System.out.print("Enter the aggression of dog(0-20): "); 
							try {
								aggression = Integer.parseInt(br.readLine());
								
								if(aggression < 0 || aggression > 20)
									System.out.println("Enter an aggression between 0 and 20");
							} catch(NumberFormatException e) {
								System.out.println("Enter a valid aggression value");
							}
						} while(aggression < 0);
						
						// Get weight
						do {
							System.out.print("Enter a weight value(bushels of wheat): ");
							try {
								weight = Float.parseFloat(br.readLine());
								
								if(weight <= 0f)
									System.out.println("Enter a value that is greater than 0");
							} catch(NumberFormatException e) {
								System.out.println("You did not enter a valid weight");
							}
						} while(weight < 0f);
						
						shelter.addDog(new Dog(breed, name, age, weight, aggression));
					}
					break;
				case 2:
					// Remove a dog
					boolean success = true;	// Used to tell if the removal was successful
					do {
						success = true;
						System.out.println("Enter the name of the dog, or index");
						String name = br.readLine();
						
						// If number delete by index, else delete by name
						try {
							int index = Integer.parseInt(name);
							if(!shelter.removeDog(index)) {
								success = false;
								System.out.println("You did not enter a valid number");
							}
						} catch(NumberFormatException e) {
							if(!shelter.removeDog(name)) {
								System.out.println("You did not enter a valid name");
								success = false;
							}
						}
					} while(!success);
					
					break;
				case 3:
					// List all the dogs
					System.out.println(shelter.toString());
					
					// Pause the screen so user can see dogs
					System.out.print("Press enter to continue: ");
					br.readLine();
					break;
				case 4:
					// Cost of running shelter is $15 * number of dogs
					System.out.println("Cost of running shelter is: " + (shelter.dogs.size() * 15));
					break;
				case 5:
					System.out.println("Saving shelter to file...");

					// Save file
					shelter.saveFile(FILENAME);
					break;
				default:
					System.out.println("You did not enter a valid number, try again");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}

		} while (Integer.parseInt(option) != 5);

		System.out.println("\n\nThank you for using the animal shelter program, have a good day?");
		
		// Close the buffered reader
		br.close();
	}

}
