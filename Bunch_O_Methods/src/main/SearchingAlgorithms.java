package main;

/*
 * Name: Daniel Wall
 * Date: 11-10-2017
 * Purpose: Bunch of different searching algorithms
 */
public class SearchingAlgorithms {
	
	public static void linearSearch(int[] arr, int num, boolean statistics) {
		int comparisons = 0;
		int counter = 0;
		
		// Search through arary
		for(int i = 0; i < arr.length; i++) {
			if(statistics) {
				counter++;
				
				if(arr[i] == num) {
					System.out.println(num + " is at index: " + i);
					comparisons++;
				}
			} else {
				if(arr[i] == num)
					System.out.println(num + " is at index: " + i);
			}
		}
		
		// Print out statistics if they want
		if(statistics) {
			System.out.println("===================================");
			System.out.println("Number of times through loop: " + counter);
			System.out.println("Number of comparisons in array: " + comparisons);
		}
	}
	
}
