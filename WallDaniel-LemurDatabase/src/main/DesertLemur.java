package main;

import main.Lemur.ManeColour;
import main.Lemur.ManeType;

public class DesertLemur extends Lemur {

	private String obtainWaterWhere;
	private float babyDeathRate;
	
	public DesertLemur() {
		super();
		
		setObtainWaterWhere("cactus");
		setManeColour(ManeColour.WHITE);
		setManeType(ManeType.OTHER);
		setPercentBabiesDieFromCactus(0.67f);
	}

	public String getObtainWaterWhere() {
		return obtainWaterWhere;
	}

	public void setObtainWaterWhere(String obtainWaterWhere) {
		this.obtainWaterWhere = obtainWaterWhere;
	}

	public float getPercentBabiesDieFromCactus() {
		return babyDeathRate;
	}

	public void setPercentBabiesDieFromCactus(float percentBabiesDieFromCactus) {
		this.babyDeathRate = percentBabiesDieFromCactus;
	}

	public String toString() {
		String s = "Desert Lemur: \n";

		s += super.toString();

		s += "Obtains water from = cactus\n";
		s += "Baby death rate = " + babyDeathRate + "\n";
		
		return s;
	}
	
}
