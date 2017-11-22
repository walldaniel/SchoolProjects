package main;

public class TreeLemur extends Lemur {

	private boolean eatFruit;
	
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

	public void setEatFruit(boolean eatFruit) {
		this.eatFruit = eatFruit;
	}

	public String toString() {
		String s = "Tree Lemur: \n";

		s += super.toString();
		s += "Food = Fruit\n";
		
		return s;
	}
	
}
