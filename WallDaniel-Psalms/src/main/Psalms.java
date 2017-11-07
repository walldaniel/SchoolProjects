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
 * Purpose: to get the title of a psalm using just the chapter and a binary search
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
	
	/*
	 *  Searches through the database using the binary search method,
	 *  Binary search uses a sorted array, starts in the middle of the two bounds
	 *  If the index is correct it returns true, if it is incorrect is eliminates half of the array
	 *  depending on whether the index is greater or smaller than the one it wants to find
	 */
	public static boolean binarySearch(ArrayList<Psalm> arr, int left, int right, int chapter) {
	    if (left > right) {
	      return false;
	    }
	    
	    // Get the middle of the left and right part of the array
		int middle;
	    middle = (left + right) / 2;
	    
	    // If the element selected is the correct one print out title and return true
	    if (arr.get(middle).getChapter() == chapter) {
	    	System.out.println(arr.get(middle).getTitle());
	      return true;
	    }
	    
	    // Check to see if the selected element is too large or small
	    if (arr.get(middle).getChapter() > chapter) {
	      return binarySearch(arr, left, middle - 1,
	        chapter);
	    } else {
	      return binarySearch(arr, middle + 1, right,
	        chapter);
	    }
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final String FILENAME = "Psalms.txt";
		int currentChapter = -1;
		String title;

		// Tell user what this program does
		System.out.println("This program allows you to see the title of several psalms");

		// Get list of psalms from file, make sure it is sorted
		ArrayList<Psalm> psalms = sortPsalms(readPsalms(FILENAME));
		
		// Print out all the psalms
		for(Psalm p : psalms) {
			System.out.println(p.chapter + " : " + p.title);
		}
		
		do {
			// Reset title string to blank
			title = "";
			
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
			}while(currentChapter < 1 || currentChapter > 150);
			
			// Find the title from the sorted arrays of psalms
			// If the binary search retruns false then that psalm is not in the list of psalms
			if(!binarySearch(psalms, 0, psalms.size(), currentChapter))
				System.out.println("That psalm is not in the database");
			
			// Ask user if they want to enter another number
			// Gets their answer from the first character they enter
			System.out.print("Do you want to get another psalm (y/n): ");
		} while(in.nextLine().charAt(0) == 'y' || in.nextLine().charAt(0) == 'Y');
		
		in.close();
	}

	// Class for a chapter of psalms, contains the chapter number and the title
	public static class Psalm {
		private int chapter;
		private String title;

		public Psalm(int chapter, String title) {
			this.title = title;
			this.chapter = chapter;
		}
		
		public int getChapter() {
			return chapter;
		}
		public String getTitle() {
			return title;
		}
	}
}
