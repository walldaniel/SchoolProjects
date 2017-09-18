import java.util.Scanner;

/*
 * Name: Daniel Wall
 * Date: 9-18-2017
 * Purpose: Calculates the sum, difference, product and quotient of two numbers.
 */
public class test {

	public static void main(String[] args) {
		String s = "Java is open-sourced";
		System.out.println(s.substring(13));
		
		Scanner in = new Scanner(System.in);
		
		// Ask user for numbers
		System.out.println("Please enter two numbers");
		
		// Store two numbers as doubles
		double d1 = in.nextDouble();
		double d2 = in.nextDouble();
		
		// Addition
		System.out.println(d1 + " + " + d2 + " = " + (d1 + d2));
		// Subtraction
		System.out.println(d1 + " - " + d2 + " = " + (d1 - d2));
		// Multiplication
		System.out.println(d1 + " * " + d2 + " = " + (d1 * d2));
		// Division
		System.out.println(d1 + " / " + d2 + " = " + (d1 / d2));
		
		// Concluding thought
		System.out.println("Have a good day!");
		
		// Close scanner
		in.nextLine();
	}

}
