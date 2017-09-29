package main;

public class Car {

	String make;
	String model;
	String type; // e.g.: sedan, van, coupe...
	int year;
	float price;
	float mpg;

	public Car() {
		make = "unknown";
		model = "unknown";
		type = "unknown";
		year = 2017; // If unkown year set to this year
		price = 25000;
		mpg = 0;
	}

	public Car(String make, String model, String type, int year, float price, float mpg) {
		this.make = make;
		this.model = model;
		this.type = type;
		this.year = year;
		this.price = price;
		this.mpg = mpg;
	}

	// Creates an object with the model and make
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}

	// Returns the Car object in a string
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		// Only add the information to the string if it has been initialized
		if(year != 0) 
			s.append(year + ", ");
		if(make != null)
			s.append(make + " ");
		if(model != null)
			s.append(model + ", ");
		if(price != 0)
			s.append("costs: " + price + ", ");
		if(mpg != 0)
			s.append("and gets: " + mpg + "mpg.");
		
		return s.toString();
	}
}
