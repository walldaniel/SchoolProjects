package main;

import main.Lemur.ManeColour;
import main.Lemur.ManeType;

public class JungleLemur extends Lemur {

	private String[] eatWhat;

	public JungleLemur() {
		super();

		setManeType(ManeType.NONE);
		setGroupSize(GroupSize.SMALL);
		eatWhat = new String[] {"mice","snhails","insects"};

		if (Math.random() < 0.5f)
			setManeColour(ManeColour.BLACK);
		else
			setManeColour(ManeColour.BLUE);
	}
	
	public String[] getWhatItEats() {
		return eatWhat;
	}

	public String toString() {
		String s = "Jungle Lemur: \n";

		s += super.toString();
		s += "Eats: ";
		for(String str : getWhatItEats()) {
			s += str + " ";
		}
		s += "\n";
		
		return s;
	}
}
