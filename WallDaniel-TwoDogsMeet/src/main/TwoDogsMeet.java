package main;

import java.util.Scanner;

public class TwoDogsMeet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean statChanged = false;

		// Create dog objects and construct them
		Dog[] dogs = new Dog[2];
		for (int i = 0; i < dogs.length; i++)
			dogs[i] = new Dog();

		// Print out dog stats
		for (int i = 0; i < dogs.length; i++) {
			System.out.println("Dog " + (i + 1) + ": " + dogs[i].toString());
		}

		// Loops while the user wants to continue to change the dogs
		do {

			System.out.print("Do you want to change any values (y/n): ");
			if (in.nextLine().equals("y")) {
				// Loop until the user enters a valid option
				do {
					try {
						System.out.print("Which dog do you want to change?: ");
						int dog = Integer.parseInt(in.nextLine());

						// Check to see if they entered an actual dog
						if (dog > 0 && dog <= dogs.length) {
							// Asks user to enter a stat
							System.out.println("Which stat do you want to change?");
							System.out.println("1 - age");
							System.out.println("2 - hunger");
							System.out.println("3 - aggression");
							
							// Make sure the user enters a stat between 1 and 3
							int stat = Integer.parseInt(in.nextLine());
							if (stat > 0 && stat <= 3) {
								// Sets the new stat to whatever the user chooses
								System.out.print("What is the new value (0 - 10): ");
								if (stat >= 0 && stat <= 10) {
									switch (stat) {
									case 1:
										if (dogs[dog].setAge(Integer.parseInt(in.nextLine())))
											statChanged = true;
										break;
									case 2:
										if (dogs[dog].setHunger(Integer.parseInt(in.nextLine())))
											statChanged = true;
										break;
									case 3:
										if (dogs[dog].setAggression(Integer.parseInt(in.nextLine())))
											statChanged = true;
										break;
									}
									
									// If stat wasn't changed inform user that it didn't get changed
									if(!statChanged)
										System.out.println("You did not enter a valid number, try again.");
								} else {
									System.out.println("You did not eneter a valid stat try again");
								}
							} else {
								System.out.println("You did not enter a valid stat option, try again");
							}
						} else {
							System.out.println("You did not enter an actual dog, try again");
						}
					} catch (NumberFormatException e) {
						System.out.println("You did not enter an actual number try again.");
					}
				} while (!statChanged);
			} else {
				break;
			}

			// Check to see if user wants to change more values
			System.out.print("Do you want to change more values? (y/n): ");
			if(in.nextLine().equals("y"))
				break;
			
			// Formatting
			System.out.println();
		} while (true);
		
		// Check to see what happens when the two dogs meet
		if(dogs[0].friendlyMeeting(dogs[1])) {
			System.out.println("The dogs have a friendly meeting");
		} else {
			System.out.println("Bark, bark! The dogs are not friendly.");
		}
	}

}
