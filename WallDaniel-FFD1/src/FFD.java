import java.util.Scanner;

public class FFD {
	public static int power(int base, int exponent) {
		if(exponent > 1)
			return base * power(base, exponent - 1);
		else 
			return base;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] numbers = in.nextLine().split(" ");
		int x = Integer.parseInt(numbers[0]);
		int answer = 0;
		for(int i = numbers.length - 1; i > 0; i--) {
			if(i == numbers.length - 1)
				answer += Integer.parseInt(numbers[i]);
			else if(Integer.parseInt(numbers[i]) != 0)
				answer += Integer.parseInt(numbers[i]) * power(x, numbers.length - i - 1);
		}
		System.out.println(answer);
	}
}