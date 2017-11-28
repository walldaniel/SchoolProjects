package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Tests the functionality of the different types of lemurs in the lemur database
 */
public class LemurTester {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numLemurs = -1;
		Random rand = new Random();
		ArrayList<Lemur> lemurs = new ArrayList<>();
		
		// Create the lemurs, ask user how many to put in array
		do {
			System.out.print("How many lemurs do you want to make: ");
			try {
				numLemurs = Integer.parseInt(br.readLine());
				
				if(numLemurs < 1)
					System.out.println("Enter a number greater than 1");
			} catch(NumberFormatException e) {
				System.out.println("Enter a valid number please...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(numLemurs < 1);
		
		// Add lemurs to array
		System.out.println("Creating Lemurs");
		for(int i = 0; i < numLemurs; i++) {
			switch(rand.nextInt(3)) {
			case 0:
				lemurs.add(new DesertLemur());
				break;
			case 1:
				lemurs.add(new JungleLemur());
				break;
			case 2:
				lemurs.add(new TreeLemur());
				break;
				default:
					System.out.println("Something didn't happen right");
			}
		}
		System.out.println("=========================");
		
		// Display the statistics about the lemurs
		for(int i = lemurs.size() - 1; i >= 0; i--) {
			System.out.println(lemurs.get(i).toString());
		}
		
		// Listen to the sounds of lemurs
		for(int i = lemurs.size() - 1; i >= 0; i--) {
			lemurs.get(i).speak();
		}
		System.out.println();
		
		// Say a random fact about the lemur
		for(int i = lemurs.size() - 1; i >= 0; i--) {
			if(lemurs.get(i) instanceof DesertLemur) {
				DesertLemur dl = (DesertLemur) lemurs.get(i);
				System.out.println("This desert lemur obtains water from: " + dl.getObtainWaterWhere());
			} else if(lemurs.get(i) instanceof JungleLemur) {
				JungleLemur jl = (JungleLemur) lemurs.get(i);
				String[] eats = jl.getWhatItEats();
				System.out.print("This jungle lemur eats: ");
				for(String s : eats) {
					System.out.print(s + ", ");
				}
				System.out.println();
			} else if(lemurs.get(i) instanceof TreeLemur) {
				TreeLemur tl = (TreeLemur) lemurs.get(i);
				System.out.println("It is " + tl.getEatsFruit() + " that this lemur eats fruit.");
			} else {
				System.out.println("This was not a type of lemur");
			}
		}
	}

}
