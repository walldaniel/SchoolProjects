package main;

import java.util.Scanner;

public class WordJumble {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String letters;

		// Tell user what program is about
		System.out.println("This program displays all possible combinations from a set of letters");

		do {
			// Ask user for letters
			System.out.print("Enter in your letters: ");
			letters = in.nextLine();

			// Display all possible letter combinations
			jumbleWords(letters, "");

			// Ask user if they want to enter more letters
			// As long as first character is 'y', then loop again, user could enter "yolk" and it would work
			System.out.print("Do you want to enter in new numbers? (y/n): ");
		} while (in.nextLine().charAt(0) == 'y');

		in.close();
	}

	public static void jumbleWords(String word, String jumbLet) {
		int pos;
		String remainingLetters;
		String origWord = word;
		String origJumbledLetters = jumbLet;
		if (word.length() == 1) {
			System.out.println(jumbLet + word);
		} else {
			for (pos = 0; pos < origWord.length(); pos++) {
				remainingLetters = origWord.substring(0, pos) + origWord.substring(pos + 1, origWord.length());
				// recursive call to jumbleWords()
				jumbleWords(remainingLetters, origJumbledLetters + origWord.charAt(pos));
			}
		}
	}
}
