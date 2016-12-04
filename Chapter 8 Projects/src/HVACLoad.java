/***********************
 * HVACLoad.java
 * Nikhil Menon
 * 
 * Makes an object for calculating HVAC Load
 **********************/

import java.util.Scanner;
public class HVACLoad {
	private double roofArea = 1500.0;
	private double perimeter = 140.0;
	private double height = 18.0;
	private double windowArea = 400.0;
	private double westWindowArea = 80.0;
	private double roofU = 0.04; // heat flow through roof
	private double wallU = 0.1; // heat flow through wall
	private double windowU = 0.5; // heat flow through window
	private double winterOutdoorTemperature = 2.0;
	private double summerOutdoorTemperature = 100;
	private double summerOutdoorHumidity = 0.013;
	private double infiltration = 200;
	private double people = 3;
	private double electrical = 1500;
	
	//*************************************
	
	// Sets all instance variables
	
	public void getInputs() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter total roof area in square ft: ");
		roofArea = scanner.nextDouble();
		System.out.print("Enter building perimeter in ft: ");
		perimeter = scanner.nextDouble();
		System.out.print("Enter building height in ft: ");
		height = scanner.nextDouble();
		System.out.print("Enter total window area in square ft: ");
		windowArea = scanner.nextDouble();
		System.out.print("Enter west window area in square ft: ");
		westWindowArea = scanner.nextDouble();
		
		System.out.print("Enter roof U-value: ");
		roofU = scanner.nextDouble();
		System.out.print("Enter wall U-value: ");
		wallU = scanner.nextDouble();
		System.out.print("Enter window U-value: ");
		windowU = scanner.nextDouble();
		
		System.out.print("Enter winter outdoor temperature in deg F: ");
		winterOutdoorTemperature = scanner.nextDouble();
		System.out.print("Enter summer outdoor temperature in deg F: ");
		summerOutdoorTemperature = scanner.nextDouble();
		System.out.print("Enter summer outdoor humidity ratio: ");
		summerOutdoorHumidity = scanner.nextDouble();
		
		System.out.print("Enter infiltration in CFM: ");
		infiltration = scanner.nextDouble();
		System.out.print("Enter number of people present: ");
		people = scanner.nextDouble();
		System.out.print("Enter electrical use in Watts: ");
		electrical = scanner.nextDouble();
	}

	//*************************************
	
	public double findHeatingLoad() {
		double heating;
		double roofLoad, windowLoad, wallLoad, infiltrationLoad;
		double winterIndoorTemperature = 72;
		double winterTemperatureDifference = winterIndoorTemperature - 
			winterOutdoorTemperature;
		
		roofLoad = roofArea * roofU * winterTemperatureDifference;
		windowLoad = windowArea * windowU * winterTemperatureDifference;
		wallLoad = netWallArea() * wallU * winterTemperatureDifference;
		infiltrationLoad = infiltration * 1.08 * winterTemperatureDifference;
		
		heating = roofLoad + windowLoad + wallLoad + infiltrationLoad;
		return heating;
	}

	//*************************************
	
	public double findCoolingLoad() {
		double cooling;
		
		cooling = findCoolingLatentLoad() ;
		cooling  		+= findCoolingSensibleLoad();
		return cooling;
	}
	
	//*************************************
	
	public double findCoolingSensibleLoad() {
		double cooling;
		double roofLoad, windowLoad, wallLoad, infiltrationTemperatureLoad;
		double solarLoad, electricalLoad, peopleTemperatureLoad;
		double summerIndoorTemperature = 76;
		double westSolarHeatGain = 193;
		double summerTemperatureDifference = summerOutdoorTemperature - 
			summerIndoorTemperature;
		
		roofLoad = roofArea * roofU * summerTemperatureDifference;
		windowLoad = windowArea * windowU * summerTemperatureDifference;
		wallLoad = netWallArea() * wallU * summerTemperatureDifference;
		infiltrationTemperatureLoad = infiltration * 1.08 * summerTemperatureDifference;
		solarLoad = westSolarHeatGain * westWindowArea;
		electricalLoad = 3.416 * electrical;
		peopleTemperatureLoad = 250 * people;
		
		cooling = roofLoad + windowLoad + wallLoad + infiltrationTemperatureLoad +
				solarLoad + electricalLoad + peopleTemperatureLoad;
		return cooling;
	}

	//*************************************
	
	// Displays final heating and cooling loads
	
	public void printCapacities(double heating, double cooling) {
		double tons = Math.round(cooling * 1.1/12000);
		
		System.out.println("\nHeating Load = " + heating * 1.3 + " BTU per hour");
		System.out.printf("Cooling Load = %.1f BTU per hour", cooling * 1.1);
		System.out.println("\n\tor approximately " + tons + " tons");
	}

	//*************************************
	
	private double findCoolingLatentLoad() {
		double cooling;
		double infiltrationHumidityLoad, peopleHumidityLoad;
		double summerIndoorHumidity = .01;
		double summerHumidityDifference  = summerOutdoorHumidity - summerIndoorHumidity; 
		
		infiltrationHumidityLoad = infiltration * 4675 * summerHumidityDifference;
		peopleHumidityLoad = 200 * people;
		
		cooling = infiltrationHumidityLoad + peopleHumidityLoad;
		return cooling;
	}

	//*************************************
	
	// Calculates total wall area
	
	private double netWallArea() {
		return perimeter * height - windowArea;
	}
}

