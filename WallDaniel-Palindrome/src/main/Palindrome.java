package main;

import java.util.Scanner;


/*
 * Name: Daniel Wall
 * Date: Sept. 8, 2017
 * Purpose: To determine if a word entered is a palindrome.
 */
public class Palindrome {

	// If the string is a palindrome then return true, otherwise returns false
	public static boolean isPalindrome(String s) {
		// Loops through the first half of the string.
		for (int i = 0; i < s.length() / 2 + 1; i++) {
			// Checks the first character with the last character and so on...
			// if one of the checks fails, then it is not a palindrome and the
			// method returns false
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}

		// If the string got through the loop, then the string is a palindrome.
		return true;
	}

	// Prints the string entered backwards
	public static void printBackwards(String s) {
		// Loops through the string and prints characters, starting with last.
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(s.length() - i - 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// If the user wants to enter multiple strings, loops through again.
		do {
			// Ask user for a string
			System.out.print("\nEnter a word to check if it is a palindrome: ");
			String word = sc.nextLine();

			// Print string entered backwards
			printBackwards(word);

			// Checks to see if the word entered is a palindrome
			if (isPalindrome(word))
				System.out.println("\nThe string you entered is a palindrome.");
			else
				System.out.println("\nThe string you entered is not a palindrome.");

			//	Asks user if they want to enter another palindrome.
			System.out.println("\nIf you want to enter another palindrome type in '1'.");
		} while (sc.nextLine().equals("1"));

		// Close the scanner.
		sc.close();
	}
}
