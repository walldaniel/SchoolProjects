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
		
		do {

			System.out.print("Do you want to change any values (y/n): ");
			if (in.nextLine().equals("y")) {
				do {
					try {
						System.out.print("Which dog do you want to change?: ");
						int dog = Integer.parseInt(in.nextLine());

						// Check to see if they entered an actual dog
						if (dog > 0 && dog <= dogs.length) {
							System.out.println("Which stat do you want to change?");
							System.out.println("1 - age");
							System.out.println("2 - hunger");
							System.out.println("3 - aggression");
							int stat = Integer.parseInt(in.nextLine());
							if (stat > 0 && stat <= 3) {
								System.out.print("What is the new value (0 - 10): ");
								switch (stat) {
								case 1:
									if (dogs[dog].setAge(in.nextInt()))
										statChanged = true;
									break;
								case 2:
									if (dogs[dog].setHunger(in.nextInt()))
										statChanged = true;
									break;
								case 3:
									if (dogs[dog].setAggression(in.nextInt()))
										statChanged = true;
									break;
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

			System.out.print("Do you want to change more values?");
			// Formatting
			System.out.println();
		} while (true);
	}

}
