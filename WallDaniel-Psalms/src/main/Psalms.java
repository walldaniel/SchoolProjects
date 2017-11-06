package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 11-06-2017
 * Purpose: to get the title of a psalm using just the chapter
 */
public class Psalms {

	// Gets a list of psalms and psalm titles from the inputed filename
	public static ArrayList<Psalm> readPsalms(String filename) {
		ArrayList<Psalm> psalms = new ArrayList<>();
		int currentChapter;
		String currentTitle;

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));

			String line;
			while ((line = fileReader.readLine()) != null) {
				// Get chapter number
				currentChapter = Integer.parseInt(line);

				// Get title
				currentTitle = fileReader.readLine();

				// Add psalm to array
				psalms.add(new Psalm(currentChapter, currentTitle));
			}

			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + filename);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return psalms;
	}

	// Sorts an array of psalms from least to greatest using bubble sort
	public static ArrayList<Psalm> sortPsalms(ArrayList<Psalm> psalms) {
		boolean changed;
		int arrSize = psalms.size() - 1;
		
		do {
			changed = false;
			
			for(int i = 0; i < arrSize; i++) {
				// If the second psalm chapter is greater than the first chapter
				if(psalms.get(i).chapter > psalms.get(i + 1).chapter) {
					// temp var
					Psalm temp = psalms.get(i);
					psalms.set(i, psalms.get(i + 1));
					psalms.set(i + 1, temp);
					changed = true;
				}
			}
		} while(changed);
		
		return psalms;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final String FILENAME = "Psalms.txt";
		int currentChapter = -1;

		// Tell user what this program does
		System.out.println("This program allows you to see the title of several psalms");

		// Get list of psalms from file, make sure it is sorted
		ArrayList<Psalm> psalms = sortPsalms(readPsalms(FILENAME));
		
		// Print out all the psalms
		for(Psalm p : psalms) {
			System.out.println(p.chapter + " : " + p.title);
		}
		
		do {
			// Loop until they enter a valid chapter number
			do {
				try {
					// Ask user for a chapter between 1 and 150
					System.out.print("Enter a psalm chapter (1 - 150): ");
					currentChapter = Integer.parseInt(in.nextLine());
					
					// Check to see if they entered an integer between 1 and 150
					if(currentChapter <= 0 || currentChapter > 150)
						System.out.println("You did not enter a number between 1 and 150.");
				} catch(NumberFormatException e) {
					System.out.println("Please enter a valid number");
				}
			}while(currentChapter > 0);
			
			
			
			// Ask user if they want to enter another number
			// Gets their answer from the first character they enter
			System.out.print("Do you want to get another psalm (y/n): ");
		} while(in.nextLine().charAt(0) == 'y' || in.nextLine().charAt(0) == 'Y');
		
		in.close();
	}

	public static class Psalm {
		int chapter;
		String title;

		public Psalm(int chapter, String title) {
			this.title = title;
			this.chapter = chapter;
		}
	}
}
