package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Contains the data for a specific species of lemur, the tree lemur
 */
public class TreeLemur extends Lemur {

	private final boolean eatFruit = true;
	
	// Default Constructor
	public TreeLemur() {
		super();
		
		setGroupSize(GroupSize.LARGE);
		setManeType(ManeType.RED);
		setManeColour(ManeColour.OTHER);
	}

	public boolean getEatsFruit() {
		return eatFruit;
	}

	@Override
	public void speak() {
		System.out.println("eek eek... eee-aaaah");
	}

	public String toString() {
		String s = "Tree Lemur: \n";

		s += super.toString();
		s += "Food:\t\tFruit\n";
		
		return s;
	}
	
}
