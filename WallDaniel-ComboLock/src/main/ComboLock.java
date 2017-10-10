package main;

import java.util.concurrent.ThreadLocalRandom;

public class ComboLock {
	private int[] combo = new int[3];
	
	public ComboLock() {
		for(int i : combo) {
			i = ThreadLocalRandom.current().nextInt(0, 10);
		}
	}
	
	public String toString() {
		return combo[0] + ", " + combo[1] + ", " + combo[2];
	}
}
