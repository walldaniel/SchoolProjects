package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Dnaiel Wall
 * Date: 9-25-2017
 * Purpose: be able to play the game of hangman
 */
public class Hangman {

	// Takes a string and returns the char array with all alphabetical character
	// replaced with '-'
	public static char[] deleteLetters(String s) {
		char[] newString = new char[s.length()];

		// Iterates over string entered, if character is alphabetical replaces it with a
		// '-', else stays the same
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)))
				newString[i] += '-';
			else
				newString[i] += s.charAt(i);
		}

		return newString;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String hangman = "¯\\_☺_/¯";
		int life = 0; // How much lives left
		String[] categories = { "books", "tv and movies", "countries" };
		String[][] words = {  { "HARRY POTTER", "SHAKESPEARE", "BOOK" },
				{ "THE EMOJI MOVIE", "BIRDEMIC", "DOCTOR WHO" },
				{ "CANADA", "SOUTH SUDAN", "MOLDOVA" } };
		String hiddenWord;
		char[] guess;
		char currentGuess;
		boolean letterCorrect = false;
		ArrayList<Character> lettersGuessed = new ArrayList<>();

		// Welcome user to hangman
		System.out.println("This program allows you to play hangman");

		// Game loop, allows user to play multiple times
		do {
			// Choose random word
			int randomCategory = ThreadLocalRandom.current().nextInt(0, words.length);
			int randomWord = ThreadLocalRandom.current().nextInt(0, words[randomCategory].length);
			hiddenWord = words[randomCategory][randomWord];
			guess = deleteLetters(hiddenWord);

			do {
				// Reset check to see if they entered a correct letter
				letterCorrect = false;
				
				// Print out what category
				System.out.println("The category is: " + categories[randomCategory]);
				
				// Print out how many lives are left
				System.out.println();
				System.out.println(hangman.substring(0, life));

				// Print out letters guessed so far and ask for new letters
				System.out.println("Letters so far: " + new String(guess));
				do {
					System.out.print("Enter a new letter: ");
					String s = in.nextLine().toUpperCase(); // Tests to see if user entered valid character

					// If they only enter one letter than good, else get them to try again
					if (s.length() != 1)
						System.out.println("Only enter one character!");
					else if (!Character.isAlphabetic(s.charAt(0)))
						System.out.println("Enter an alphabetical character");
					else if(lettersGuessed.contains(s.charAt(0))) {	// If the user has already entered that character don't take it as a guess
						System.out.println("You have already tried entering that letter");
					}else {
						currentGuess = s.charAt(0);
						break;
					}
				} while (true);
				
				// Check if any character is correct
				for(int i = 0; i < hiddenWord.length(); i++) {
					if(hiddenWord.charAt(i) == currentGuess) {
						// If they got the letter correct, don't decrease their life left
						letterCorrect = true;
						// Replace the '-' in the guessed letters with the correct letter
						guess[i] = currentGuess;
					}
				}
				
				// Add the current guess to the list of guessed character
				lettersGuessed.add(currentGuess);
				
				// Check to see if they got a letter correct
				if(!letterCorrect) {
					System.out.println("Oh noes! you lost a life... D:");
					life++;
					// If they have lost all lives then quit loop
					if(life > 7)
						break;
				}
			} while (!hiddenWord.equals(new String(guess)));

			// Display different messages if they one or lost
			if(life > 7) {
				System.out.println("You lost. The game.");
			} else {
				System.out.println("Yay! you won..");
				System.out.println("\nThe word was: " + hiddenWord);
			}
			
			// Asks user if they want to try again
			System.out.print("\nEnter 'y' to try another game of hangman: ");
		} while (in.nextLine().equals("y"));

		// Close the scanner
		in.close();
	}

}
