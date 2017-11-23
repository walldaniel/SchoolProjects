package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Contains the data for a specific species of lemur, the tree lemur
 */
public class TreeLemur extends Lemur {

	private boolean eatFruit;
	
	// Default Constructor
	public TreeLemur() {
		super();
		
		setGroupSize(GroupSize.LARGE);
		setEatFruit(true);
		setManeType(ManeType.RED);
		setManeColour(ManeColour.OTHER);
	}

	public boolean isEatFruit() {
		return eatFruit;
	}

	@Override
	public void speak() {
		System.out.println("eek eek... eee-aaaah");
	}
	
	public void setEatFruit(boolean eatFruit) {
		this.eatFruit = eatFruit;
	}

	public String toString() {
		String s = "Tree Lemur: \n";

		s += super.toString();
		s += "Food:\t\tFruit\n";
		
		return s;
	}
	
}
