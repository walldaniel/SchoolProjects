package main;

/*
 * Name: Daniel Wall
 * Date: 11-15-2017
 * Purpose: Different sorting methods that display statistics on them
 */
public class SortingAlgorithms {

	public static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		System.out.println(sb.toString());
	}

	// Bubble sort
	public static void bubbleSort(int[] arr) {
		boolean changed;
		long count = 0;
		long comparison = 0;
		long shiftCounter = 0;
		long time = System.currentTimeMillis();

		do {
			changed = false;
			count++;

			for (int i = arr.length - 1; i > 0; i--) {
				// Increase loop counter
				count++;
				comparison++;

				if (arr[i] < arr[i - 1]) {
					shiftCounter++;

					changed = true;
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
		} while (changed);

		// Print out statistics on sorting algorithm
		System.out.println("\n==================");
		System.out.println("Bubble Sort:");
		System.out.println("Processing time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Loop counter: " + count);
		System.out.println("Comparison counter: " + comparison);
		System.out.println("Shift counter: " + shiftCounter);
	}

	// Selection sort
	public static void selectionSort(int[] arr) {
		long count = 0;
		long comparison = 0;
		long shiftCounter = 0;
		long time = System.currentTimeMillis();
		int smallest = 0;

		for (int index = 0; index < arr.length; index++) {
			smallest = index;
			count++;

			// Check for smaller number in array
			for (int i = index + 1; i < arr.length; i++) {
				count++;
				comparison++;

				if (arr[i] < arr[smallest]) {
					shiftCounter++;
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}

		// Print out statistics on sorting algorithm
		System.out.println("\n==================");
		System.out.println("Selection Sort:");
		System.out.println("Processing time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Loop counter: " + count);
		System.out.println("Comparison counter: " + comparison);
		System.out.println("Shift counter: " + shiftCounter);
	}

	// Insertion sort
	public static void insertionSort(int[] arr) {
		long count = 0;
		long comparison = 0;
		long shiftCounter = 0;
		long time = System.currentTimeMillis();
		int insert;

		for (int next = 1; next < arr.length; next++) {
			count++;

			insert = arr[next];
			int moveItem = next;

			while (moveItem > 0 && arr[moveItem - 1] > insert) {
				count++;
				comparison++;
				shiftCounter++;

				arr[moveItem] = arr[moveItem - 1];
				moveItem--;
			}
			arr[moveItem] = insert;
		}

		// Print out statistics on sorting algorithm
		System.out.println("\n==================");
		System.out.println("Insertion Sort:");
		System.out.println("Processing time: " + (System.currentTimeMillis() - time) + "ms");
		System.out.println("Loop counter: " + count);
		System.out.println("Comparison counter: " + comparison);
		System.out.println("Shift counter: " + shiftCounter);
	}

	// Quick sort
	public static Statistics quickSort(int[] arr, int low, int high, Statistics statistics) {
		if(statistics == null)
			statistics = new Statistics();

		int partitionLoc;
		if (low < high) {
			statistics.count++;
			partitionLoc = partition(arr, low, high, statistics);
			quickSort(arr, low, partitionLoc - 1, statistics);
			quickSort(arr, partitionLoc + 1, high, statistics);
		}
		
		return statistics;
	}

	// Used for partitioning the array into a lower and upper bound with quick sort
	public static int partition(int[] arr, int left, int right, Statistics statistics) {
		boolean moveLeft = true;
		int separator = arr[left];

		while (left < right) {
			statistics.count++;
			statistics.comparison++;
			
			if (moveLeft) {
				while ((arr[right] >= separator) && (left < right)) {
					statistics.count++;
					statistics.comparison++;
					statistics.shiftCounter++;
					right--;
				}
				arr[left] = arr[right];
				moveLeft = false;
			} else {
				while ((arr[left] <= separator) && (left < right)) {
					statistics.count++;
					statistics.comparison++;
					statistics.shiftCounter++;
					left++;
				}
				arr[right] = arr[left];
				statistics.shiftCounter++;
				moveLeft = true;
			}
		}

		arr[right] = separator;
		return left;
	}
	
	public static class Statistics {
		public long count;
		public long comparison;
		public long shiftCounter;
		public long time;
		
		public Statistics() {
			count = 0;
			comparison = 0;
			shiftCounter = 0;
			time = System.currentTimeMillis();
		}
	}

}
