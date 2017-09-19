package main;

import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: Sept 11, 2017
 * Purpose: To turn a message into morse code.
 */
public class MorseCode {

	public static String[] morseCodeLetters = {  ".-", "-...", "-.-.",
			"-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
			".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--.." };
	public static String[] morseCodeDigits = { "-----", ".----", "..---",
			"...--", "....-", ".....", "-....", "--...",
			"---..", "----."};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Tells user what program does
		System.out.println("This program turns your message into morse code.");
		
		// Asks user for message
		System.out.print("Enter your message");
		String message = sc.nextLine();
		
		// Convert message into lower cases so it is easier to turn into morse code
		// and loop through every character individually
		for(char c : message.toLowerCase().toCharArray()) {
			if(Character.isAlphabetic(c))
				System.out.print(morseCodeLetters[c - 'a'] + "   ");
			else if(Character.isDigit(c)) 
				System.out.print(morseCodeDigits[c - '0'] + "   ");
			else
				System.out.print(c + "   ");
		}
		
		// close the scanner
		sc.close();
	}

}
