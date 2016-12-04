
public class Person {
	public static int numOfPeople = 0;
	private String first, last;

	//***********************************

	public Person() {
		first = "John";
		last = "Doe";
		Person.numOfPeople += 1;
	}

	//************************************

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
		Person.numOfPeople += 1;
	}

	//************************************

	public void setFirst(String first) {
		this.first = first;
	}

	//*************************************

	public void setLast(String last) {
		this.last = last;
	}

	//*************************************

	public static int getNumOfPeople() {
		return Person.numOfPeople;
	}
	
	//*************************************
	
	public void printFullName() {
		System.out.println(first + " " + last);
	}
}
