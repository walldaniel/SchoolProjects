package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 11-03-2017
 * Purpose: Program creates a word program with the string entered
 */
public class WordPyramid {

	// Displays a word in a pyramid, calls itself until string is under length 2
	public static void wordPyramid(String s, int origLength) {
		// If the word is more than two characters call method with first and last char removed
		if(s.length() > 2) 
			wordPyramid(s.substring(1, s.length() - 1), origLength);
		
		// Display spaces to make an actual pyramid, instead of a triangle
		for(int i = 0; i < (origLength - s.length()) / 2; i++)
			System.out.print(" ");
		
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// Tell user what the program does
		System.out.println("This program creates a word pyramid with the string you enter.");
		
		do {
			// Ask user for word
			System.out.print("Enter the word you want to create a pyramid out of: ");
			String word = in.nextLine();
			
			// Call word pyramid program
			wordPyramid(word, word.length());
			
			// Ask user if they want to enter another word
			System.out.print("Do you want to enter another word? (y/n): ");
		} while(in.nextLine().charAt(0) == 'y');
		
		in.close();
	}
}