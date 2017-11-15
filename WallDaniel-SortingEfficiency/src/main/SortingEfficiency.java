package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import main.SortingAlgorithms.Statistics;

public class SortingEfficiency {

	// Returns a copy opf the original array 
	public static int[] copyArray(int[] arr) {
		return arr;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = 0;
		
		// Ask user for how many numbers to generate in array
		do {
			try {
				System.out.print("Enter how many numbers to generate in the array: ");
				arraySize = Integer.parseInt(br.readLine());
				
				if(arraySize < 1)
					System.out.println("Please enter a number greater than 0");
			} catch(NumberFormatException e) {
				System.out.println("Please entetr a valid number");
			}
		} while(arraySize < 1);
		
		// Create array with random numbers between 0 and 999
		int[] arr = new int[arraySize];
		for(int i = 0; i < arr.length; i++) 
			arr[i] = ThreadLocalRandom.current().nextInt(0, 1000);
		
		// Print out the array
		SortingAlgorithms.printArray(arr);
		
		// Bubble search
		SortingAlgorithms.bubbleSort(arr.clone());

		// Selection Sort
		SortingAlgorithms.selectionSort(arr.clone());
		
		// Insertion Sort
		SortingAlgorithms.insertionSort(arr.clone());
		
		// Quick Sort
		Statistics statistics = SortingAlgorithms.quickSort(arr, 0, arr.length - 1, null);
		System.out.println("\n==================");
		System.out.println("Quick Sort:");
		System.out.println("Processing time: " + (System.currentTimeMillis() - statistics.time) + "ms");
		System.out.println("Loop counter: " + statistics.count);
		System.out.println("Comparison counter: " + statistics.comparison);
		System.out.println("Shift counter: " + statistics.shiftCounter);
		
		br.close();
	}

}
