package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Contains the data for a specific species of lemur, the jungle lemur
 */
public class JungleLemur extends Lemur {

	private String[] eatWhat;

	public JungleLemur() {
		super();

		setManeType(ManeType.NONE);
		setGroupSize(GroupSize.SMALL);
		eatWhat = new String[] {"mice","shhnails","insects"};

		if (Math.random() < 0.5f)
			setManeColour(ManeColour.BLACK);
		else
			setManeColour(ManeColour.BLUE);
	}
	
	public String[] getWhatItEats() {
		return eatWhat;
	}

	// Overide the lemurs method to make one specific sound to this type of lemur
	@Override
	public void speak() {
		System.out.println("ack-ack-ack-ackawoooo-ack-ack-ack");
	}
	
	public String toString() {
		String s = "Jungle Lemur: \n";

		s += super.toString();
		s += "Eats:\t\t";
		for(String str : getWhatItEats()) {
			s += str + ", ";
		}
		s += "\n";
		
		return s;
	}
}
