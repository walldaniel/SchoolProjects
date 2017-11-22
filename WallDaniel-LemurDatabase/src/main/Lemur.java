package main;

public abstract class Lemur extends Mammal {

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

		setClassification("Prosimians");
		setDominantGender(Gender.FEMALE);

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
		s += "Dominant gender" + getDominantGender().toString() + "\n";
		if(maneColour != null)
			s += "Mane colour " + maneColour.toString() + "\n";
		if(maneType != null)
			s += "Mane type " + maneType.toString() + "\n";
		s += "Has fur " + true + "\n";
		
		return s;
	}
}
