package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Contains the data for a a lemur, which is a type of mammal
 */
public abstract class Lemur extends Mammal {

	// Enums so that printing out the data on the lemurs is easier
	public enum ManeType {
		NONE, RED, OTHER
	};
	public enum ManeColour {
		BLACK, BLUE, WHITE, OTHER
	};

	private final String location = "Madagascar";
	private final boolean hasFur;
	private final boolean canGroomWithTeeth;
	private ManeType maneType;
	private ManeColour maneColour;

	public Lemur() {
		super();

		// Set the values for the private variables from the mammal class
		setClassification("Prosimians");
		setDominantGender(Gender.FEMALE);

		// Set variables that are specific to a lemur
		hasFur = true;
		canGroomWithTeeth = true;
	}

	public void setManeType(ManeType maneType) {
		this.maneType = maneType;
	}

	public ManeType getManeType() {
		return maneType;
	}

	public String getLocation() {
		return location;
	}

	public boolean hasFur() {
		return hasFur;
	}

	public boolean getCanGroomWithTeeth() {
		return canGroomWithTeeth;
	}

	@Override
	public void speak() {
		System.out.println("Zoboomafoo");
	}

	public ManeColour getManeColour() {
		return maneColour;
	}

	public void setManeColour(ManeColour maneColour) {
		this.maneColour = maneColour;
	}

	public String toString() {
		String s = super.toString();
		s += "Dominant gender:" + getDominantGender().toString() + "\n";
		if(maneColour != null)
			s += "Mane colour:\t" + maneColour.toString() + "\n";
		if(maneType != null)
			s += "Mane type:\t" + maneType.toString() + "\n";
		s += "Has fur:\t" + true + "\n";
		
		return s;
	}
}
