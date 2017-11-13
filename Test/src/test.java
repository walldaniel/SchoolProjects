
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Arrays;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class test {

	public static long getChunk(int chunk, int num) {
		// Get rid of numbers before
		num %= Math.pow(10, chunk * 5);
		// Get rid of numbers after chunk
		num /= Math.pow(10, (chunk - 1) * 5);

		return num;
	}

	public static String arrayToString(int[] arr) {
		if (arr == null)
			return "null";
		int iMax = arr.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(arr[i] + " ");
			if (i == iMax)
				return b.toString();
		}
	}

	public static void mergesort(int[] arr, int low, int high, int chunks) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(arr, low, middle, chunks);
            // Sort the right side of the array
            mergesort(arr, middle + 1, high, chunks);
            // Combine them both
            merge(arr, low, middle, high, chunks);
        }
    }
	
	public static void merge(int[] arr, int low, int middle, int high, int chunks) {
		int[] helper = new int[arr.length];
		
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (getChunk(chunks, helper[i]) <= getChunk(chunks, helper[j])) {
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            arr[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] lines = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(lines[i]);
		}

		double time;
		
		boolean nextChunk;
		int chunk = 1;
		do {
			nextChunk = false;
			time = System.currentTimeMillis();
			mergesort(a, 0, a.length - 1, chunk);
			System.out.println(System.currentTimeMillis() - time);
			// for(int i = 0; i < n; i++) {
			// int temp = a[i];
			// int j = i;
			//
			// while(j > 0 && getChunk(chunk, temp) < getChunk(chunk, a[j - 1])) {
			// a[j] = a[j - 1];
			// j--;
			// }
			// a[j] = temp;
			// }

			// print out number
			time = System.currentTimeMillis();
			System.out.println(arrayToString(a));
			System.out.println(System.currentTimeMillis() - time);

			// Check if the numbers have digits in the next chunk
			time = System.currentTimeMillis();
			chunk++;
			for (int i : a) {
				if (getChunk(chunk, i) > 0) {
					nextChunk = true;
					break;
				}
			}
			System.out.println(System.currentTimeMillis() - time);
		} while (nextChunk);
	}
}