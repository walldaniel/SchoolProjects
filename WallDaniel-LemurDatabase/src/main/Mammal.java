package main;

/*
 * Name: Daniel Wall
 * Date: 11-23-2017
 * Purpose: Contains the data for an abstract mammal, which is a type of animal
 */
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
		s += "Age:\t\t" + itsAge + "\n";
		s += "Weight:\t\t" + itsWeight + "\n";
		s += "Gender:\t\t" + gender.toString() + "\n";
		if(classification != null)
			s += "Classification:\t" + classification + "\n";
		if(groupSize != null)
			s += "GroupSize:\t" + groupSize.toString() + "\n";
		
		return s;
	}
}
