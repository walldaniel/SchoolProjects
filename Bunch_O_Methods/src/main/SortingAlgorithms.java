package main;

/*
 * Name: Daniel Wall
 * Date: 11-10-2017
 * Purpose: List of different sorting algorithms
 */
public class SortingAlgorithms {

	// Bubble sort
	public static void bubbleSort(int[] arr) {
		boolean changed;

		do {
			changed = false;

			for (int i = arr.length - 1; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					changed = true;
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
		} while (changed);
	}

	// Selection sort
	public static void selectionSort(int[] arr) {
		int smallest = 0;

		for (int index = 0; index < arr.length; index++) {
			smallest = index;

			// Check for smaller number in array
			for (int i = index + 1; i < arr.length; i++) {
				if (arr[i] < arr[smallest]) {
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}
		}
	}

	// Insertion sort
	public static void insertionSort(int[] arr) {
		int insert;

		for (int next = 1; next < arr.length; next++) {
			insert = arr[next];
			int moveItem = next;

			while (moveItem > 0 && arr[moveItem - 1] > insert) {
				arr[moveItem] = arr[moveItem - 1];
				moveItem--;
			}
			arr[moveItem] = insert;
		}
	}

	// Quick sort
	public static void quickSort(int[] arr, int low, int high) {
		int partitionLoc;
		if (low < high) {
			partitionLoc = partition(arr, low, high);
			quickSort(arr, low, partitionLoc - 1);
			quickSort(arr, partitionLoc + 1, high);
		}
	}

	// Used for partitioning the array into a lower and upper bound with quick sort
	public static int partition(int[] arr, int left, int right) {
		boolean moveLeft = true;
		int separator = arr[left];

		while (left < right) {
			if (moveLeft) {
				while ((arr[right] >= separator) && (left < right)) {
					right--;
				}
				arr[left] = arr[right];
				moveLeft = false;
			} else {
				while ((arr[left] <= separator) && (left < right)) {
					left++;
				}
				arr[right] = arr[left];
				moveLeft = true;
			}
		}

		arr[right] = separator;
		return left;
	}
}
