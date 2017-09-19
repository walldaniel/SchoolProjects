package main;

/*
 * Name: Daniel Wall
 * Date: Sept. 19, 2017
 * Purpose: Determine first 1000 primes
 */
public class Eratosthenes {

	public static void main(String[] args) {
		// Tell user about program
		System.out.println("This program prints the primes under 1000\n");
		
		// Array of size 1000, false means prime and true means prime
		boolean[] notPrimes = new boolean[1000];
		
		// Sets 0 and 1 as not prime
		notPrimes[0] = true;
		notPrimes[1] = true;
		
		// Loops through all multiples of numbers and sets them as not prime
		for(int x = 2; x < 500; x++) {
			for(int y = x * 2; y < 1000; y += x) {
				notPrimes[y] = true;
			}
		}
		
		// Variable so that numbers don't get written off screen
		int formatting = 0;
		
		// Lists all primes
		for(int i = 0; i < 1000; i++) {
			// If index i of array is false, then number is prime
			if(!notPrimes[i]) {
				// Print out prime number with a space for formatting
				System.out.print(i + " ");
				formatting++;
				// If number is under 100 add a space, and if under 10 add two spaces for formatting
				if(i < 100) {
					if(i < 10)
						System.out.print(" ");
					System.out.print(" ");
				}
			}
			
			// Once 16 numbers have been printed go down a line and reset counter to 0
			if(formatting > 15) {
				System.out.println();
				formatting = 0;
			}
		}
	}

}
