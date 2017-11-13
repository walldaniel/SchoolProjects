package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReader {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BufferedReader fileReader; // Used to read file
		String line;	// Used to store the current line the file reader is reading
		
		// Ask user for file name
		do {
			System.out.println("Enter a file name to read");
			try {
				// Create new file reader with inputed file name
				fileReader = new BufferedReader(new FileReader(in.nextLine()));
				
				break;
			} catch (FileNotFoundException e) {
				System.out.println("You did not enter a valid file name, try again");
			}
		} while (true);

		// Print out file with line numbers
		try {
			for(int i = 1; (line = fileReader.readLine()) != null; i++) {
				System.out.println(i + " - " + line);
			}
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		
		// Tell user you are done 
		System.out.println("\nDone reading file");
		
		// Close scanner and reader
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	}

}
