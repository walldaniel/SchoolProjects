
/*
 * 
 */
public class Date {

	private int month;
	private int day;
	private int year;
	
	// Default constructor
	public Date() {
		this.setMonth(1);
		this.setDay(1);
		this.setYear(2000);
	}
	
	// Constructor where client enters values
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	// Display the date, M/D/Y
	public void displayDate() {
		System.out.println(month + "//" + day + "//" + year);
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
