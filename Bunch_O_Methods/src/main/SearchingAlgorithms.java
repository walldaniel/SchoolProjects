package main;

/*
 * Name: Daniel Wall
 * Date: 11-10-2017
 * Purpose: Bunch of different searching algorithms
 */
public class SearchingAlgorithms {

	// Finds all occurences of a number, by looking at every single number
	public static int linearSearch(int[] arr, int num, boolean statistics) {
		int comparisons = 0;
		int counter = 0;
		int indexOfNumber = 0;
		long time = System.currentTimeMillis();

		// Search through arary
		for (int i = 0; i < arr.length; i++) {
			if (statistics) {
				counter++;

				if (arr[i] == num) {
					comparisons++;
					indexOfNumber = i;
				}
			} else {
				// As soon as number is found return that index
				if (arr[i] == num)
					return i;
			}
		}

		// Print out statistics if they want
		if (statistics) {
			System.out.println("Number of times through loop: " + counter);
			System.out.println("Number of comparisons in array: " + comparisons);
			System.out.println("Time to complete is: " + (System.currentTimeMillis() - time));
			System.out.println("===================================");
		}
		
		return indexOfNumber;
	}

	// Finds all occurences of a number in an array using the binary search algorithm
	public static int binarySearch(int[] arr, int num, boolean statistics) {
		int comparisons = 0;
		long time = System.currentTimeMillis();
		int counter = 0;
		int low = 0;
		int high = arr.length;
		int mid = 0;
		boolean searching = true;

		// Search through the loop
		while (low <= high && searching) {
			// If statistics are enabled then count how many times through loop
			if (statistics)
				counter++;

			mid = (low + high) / 2;
			if (arr[mid] < num) {
				low = mid + 1;
			} else if (arr[mid] > num) {
				high = mid - 1;
			} else {
				// If statistics is enabled then count how many of the index there is
				// Else just return the index of where the number is
				if (statistics) {
					comparisons++;
					searching = false;
				} else {
					return mid;
				}
			}
		}

		// Search up and down from the index found only if statistics is true
		if (statistics) {
			int index = mid - 1;
			while (arr[index] == num) {
				comparisons++;
				counter++;
				index--;
			}
			index = mid + 1;
			while (arr[index] == num) {
				counter++;
				comparisons++;
				index++;
			}
		}

		// Print out statistics if they want
		if (statistics) {
			System.out.println("Number of times through loop: " + counter);
			System.out.println("Number of comparisons in array: " + comparisons);
			System.out.println("Time to complete is: " + (System.currentTimeMillis() - time));
			System.out.println("===================================");
		}
		
		return mid;
	}

}
