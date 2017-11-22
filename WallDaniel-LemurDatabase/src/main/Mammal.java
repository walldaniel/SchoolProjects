package main;

public abstract class Mammal {
	public enum Gender { MALE, FEMALE };
	public enum GroupSize { SOLO, SMALL, LARGE };
	
	private int itsAge;
	private int itsWeight;
	private String breed;
	private Gender gender;
	private String classification;
	private Gender dominantGender;
	private GroupSize groupSize;

	public Mammal() {
		itsAge = 2;
		itsWeight = 5;
		
		// Random assign gender
		if(Math.random() < 0.5f)
			gender = Gender.MALE;
		else
			gender = Gender.FEMALE;
	}

	public GroupSize getGroupSize() {
		return groupSize;
	}
	
	public void setGroupSize(GroupSize groupSize) {
		this.groupSize = groupSize;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public void setDominantGender(Gender gender) {
		this.dominantGender = gender;
	}
	
	public Gender getDominantGender() {
		return dominantGender;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public int getAge() {
		return itsAge;
	}

	public int getWeight() {
		return itsWeight;
	}

	public void setAge(int newAge) {
		itsAge = newAge;
	}

	public void setWeight(int newWeight) {
		itsWeight = newWeight;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String newBreed) {
		breed = newBreed;
	}

	public abstract void speak();
	
	public String toString() {
		String s = "";
		s += "Age " + itsAge + "\n";
		s += "Weight " + itsWeight + "\n";
		s += "Gender " + gender.toString() + "\n";
		if(classification != null)
			s += "Classification " + classification + "\n";
		if(groupSize != null)
			s += "GroupSize " + groupSize.toString() + "\n";
		
		return s;
	}
}
