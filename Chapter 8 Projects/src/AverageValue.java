/************************************
 * AverageValue.java
 * Nikhil Menon
 *
 *Calculates the average of a series of provided numbers
 ************************************/

import java.util.Scanner;
public class AverageValue {
	private double cumulativeValue = 0; // total sum of all provided number
	private int count = 0; // number of provided numbers
	
	//**************************************
	
	// Increases cumulativeValue and count appropriately
	
	public void accumulate() {
		final double MIN = 0.5;
		final double MAX = 5;
		
		count += 1;
		System.out.println("Item number " + count + ":");
		cumulativeValue += inputValue(MIN, MAX);
	}
	
	//**************************************
	
	// Displays final average
	
	public void printAverage() {
		System.out.println("Average value = " + cumulativeValue/count);
	}
	
	//**************************************
	
	// Gets an input value and checks if it is appropriate
	
	private double inputValue(double MIN, double MAX) {
		Scanner scanner = new Scanner(System.in);
		double value;
		
		System.out.print("Enter value (" + MIN + " < value < " + 
				MAX + "): ");
		value = scanner.nextDouble();
		while (value <= MIN || value >= MAX) {
			System.out.print("Enter value (" + MIN + " < value < " + 
					MAX + "): ");
			value = scanner.nextDouble();
		}
		return value;
	}
}
