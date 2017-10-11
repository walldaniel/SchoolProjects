package main;

import java.util.concurrent.ThreadLocalRandom;

public class ComboLock {
	private int[] combo = new int[3];

	// Generate combo between 1 and 9
	public ComboLock() {
		for (int i = 0; i < combo.length; i++) {
			combo[i] = ThreadLocalRandom.current().nextInt(1, 10);
		}
	}
	
	// Generate combo with the maxNumber as one higher than the highest number
	public ComboLock(int maxNumber) {
		for (int i = 0; i < combo.length; i++) {
			combo[i] = ThreadLocalRandom.current().nextInt(1, maxNumber);
		}
	}

	public String toString() {
		return combo[0] + ", " + combo[1] + ", " + combo[2];
	}

	// Returns true if the parameters entered are the combo
	public boolean tryLock(int first, int second, int third) {
		if(combo[0] == (first) && combo[1] == second && combo[2] == (third))
			return true;
		
		return false;
	}
}
