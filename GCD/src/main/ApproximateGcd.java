package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.event.CellEditorListener;

/*
 * Uses euclid method to find the approximate gcd of two numbers
 * gcd(a,b,c) = gcd(a,gcd(b,c))
 */
public class ApproximateGcd {

	public static double gcd(double p, double q) {
		if(q == 0)
			return p;
		
		return gcd(q, p % q);
	}
	
	private static boolean approximately(double p, double q) {
		
		
		return true;
	}

	public static double approxGcd(double[] arr) {
		double gcd = 0;
		
		if(arr.length > 2) {
			return gcd(arr[0], approxGcd(Arrays.copyOfRange(arr, 1, arr.length - 1)));
		} else {
			return gcd(arr[0], arr[1]);
		}
	}
	
	public static void main(String[] args) {
		double[] charge = new double[40];
		
		System.out.println(gcd(1.24, 0.25));
		
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader("charges.txt"));
//			
//			// Read first 40 lines, or until runs out of lines
//			String line;
//			for(int i = 0;i < 40 && (line = reader.readLine()) != null; i++) {
//				charge[i] = Double.parseDouble(line);
//			}
//			
//			reader.close();
//		} catch(FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch(NumberFormatException e) {
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
