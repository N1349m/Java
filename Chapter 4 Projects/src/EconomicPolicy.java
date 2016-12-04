/* EconomicPolicy.java
 * Nikhil Menon
 * 
 * Determines economic policy based on inflation and annual growth rate
 */

import java.util.Scanner;
public class EconomicPolicy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String policy;
		System.out.print("Enter annual growth rate as a percent: ");
		double annualGrowthRate = scanner.nextDouble();
		System.out.print("Enter inflation rate as a percent: ");
		double inflationRate = scanner.nextDouble();

		if (annualGrowthRate < 1) {
			if (inflationRate < 1) {
				policy = "Increase welfare spending, "
						+ "reduce personal taxes, and "
						+ "decrease discount rate.";
			} else {
				policy = "Reduce business taxes";
			}
		} else if (annualGrowthRate > 4) {
			if (inflationRate < 1) {
				policy = "Increase personal and business taxes, "
						+ "and decrease discount rate.";
			} else if (inflationRate > 3) {
				policy = "Increase discount rate.";
			} else {
				policy = "No change in economic policy";
			}
		} else {
			policy = "No change in economic policy";
		}
		System.out.print("Recommended economic policy: " + policy);
	}
}