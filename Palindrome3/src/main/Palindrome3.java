package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept. 8, 2017
 * Purpose: To determine if a sentence is a palindrome.
 */
public class Palindrome3 {

	// Removes all whitespaces in strings
	public static String removeWhitespaces(String s) {
		// Replaces all white spaces in string with nothing.
		return s.replaceAll("\\s", "");
	}

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// If the user wants to enter multiple strings, loops through again.
		do {
			// Ask user for a string
			System.out.print("\nEnter a sentence to check if it is a palindrome: ");
			// Splits the string entered into different words
			String phrase = sc.nextLine();

			// Determines if the phrase entered is a palindrome if the whitespaces are removed
			if(isPalindrome(removeWhitespaces(phrase)))
				System.out.println("\n" + phrase + " is a palindrome.");
			else
				System.out.println("\n" + phrase + " is not a palindrome.");

			// Asks user if they want to enter another palindrome.
			System.out.print("\nIf you want to enter more palindromes type in '1':");
		} while (sc.nextLine().equals("1"));

		// Terminating sentence
		System.out.println("\nHave a good day.");
		
		// Close the scanner.
		sc.close();
	}
}
