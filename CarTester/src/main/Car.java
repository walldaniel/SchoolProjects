package main;

public class Car {

	String make;
	String model;
	String type;	// e.g.: sedan, van, coupe...
	int year;
	float price;
	float mpg;
	
	public Car() {
		make = "unknown";
		model = "unknown";
		type = "unknown";
		year = 2017;	// If unkown year set to this year
		price = 25000;
		mpg = 0;	
	}
	
	public Car(String make, String model, String type, int year, float price, float mpg) {
		this.make = make;
		this.model = model;
		this.type =type;
		this.year = year;
		this.price = price;
		this.mpg = mpg;
	}
	
	// Creates an object with the model and make
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}
}
