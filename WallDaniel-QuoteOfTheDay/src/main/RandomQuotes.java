package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomQuotes {

	public static void main(String[] args) {
		BufferedReader fileReader = null;
		String filename = "poems.txt";
		ArrayList<String> poems = new ArrayList<>();
		String line;
		
		// Try to read the file and save poems in array
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			
			// Saves poems in array
			while((line = fileReader.readLine()) != null) {
				poems.add(line);
			}
		} catch(FileNotFoundException e) {
			System.out.println("The file was not found");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		
		// Print out random poem
		System.out.println("Random poem of the day:");
		String[] poemLines = poems.get(ThreadLocalRandom.current().nextInt(0, poems.size())).split(",");
		for(String s : poemLines) {
			System.out.println("\t" + s);
		}
		
		// Close the buffered reader
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
