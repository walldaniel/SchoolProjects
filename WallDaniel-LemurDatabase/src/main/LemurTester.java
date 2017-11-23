package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Tests the functionality of the different types of lemurs in the lemur database
 */
public class LemurTester {

	public static void main(String[] args) {
		// Create the lemurs
		System.out.println("Creating Lemurs");
		TreeLemur treeLemur = new TreeLemur();
		DesertLemur desertLemur = new DesertLemur();
		JungleLemur jungleLemur = new JungleLemur();
		System.out.println("=========================");
		
		// Display the statistics about the lemurs
		System.out.println(treeLemur.toString());
		System.out.println(desertLemur.toString());
		System.out.println(jungleLemur.toString());
		
		// Listen to the sounds of lemurs
		System.out.print("The sounds of a tree lemur: ");
		treeLemur.speak();
		System.out.print("The sounds of a desert lemur: ");
		desertLemur.speak();
		System.out.print("The sounds of a jungle lemur: ");
		jungleLemur.speak();
	}

}
