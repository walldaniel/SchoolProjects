package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept. 8, 2017
 * Purpose: To determine if words in a sentence are palindromes.
 */
public class Palindrome2 {

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
			System.out.print("\nEnter a sentence to check for palindromes: ");
			// Splits the string entered into different words
			String[] words = sc.nextLine().split(" ");

			// Counts how many palindromes
			int numPalindr = 0;
			System.out.print("The palindromes are: ");
			// Loops through every word checking for palindromes
			for (String s : words) {
				// Checks to see if the word entered is a palindrome
				if (isPalindrome(s)) {
					// Formatting of list of palindromes, after first word adds commas.
					if(numPalindr > 0)
						System.out.print(", " + s);
					else
						System.out.print(s);
					
					numPalindr++;
				}

			}
			// Formatting of text
			System.out.println(".");

			// Tells the user how many palindromes in the sentence there were
			System.out.println("\nThere were: " + numPalindr + " palindromes.");

			// Asks user if they want to enter another palindrome.
			System.out.print("\nIf you want to enter more palindromes type in '1':");
		} while (sc.nextLine().equals("1"));

		// Close the scanner.
		sc.close();
	}
}
