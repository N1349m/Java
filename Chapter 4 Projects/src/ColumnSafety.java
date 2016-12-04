/* ColumnSafety.Java
 * Nikhil Menon
 * 
 * Tests if a column is safe to use
 */

import java.util.Scanner;
public class ColumnSafety {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int SLENDERNESS_LIMIT=50;
		int MODULUS_OF_ELASTICITY=1700000;
		int MAXIMUM_STRESS = 1450;
		boolean sLimitTrue;
		boolean bucklingFalse;
		boolean stressSafe;

		System.out.print("Enter column height in feet: ");
		double height = scanner.nextDouble()*12;
		System.out.print("Enter expected load in pounds: ");
		double expectedLoad = scanner.nextDouble();

		double width = 0.625;
		double area = width * width;
		sLimitTrue = (height/width <= SLENDERNESS_LIMIT);
		bucklingFalse = (expectedLoad <= (0.3 * MODULUS_OF_ELASTICITY * area) / Math.pow((height / width), 2));
		stressSafe = (expectedLoad <= area * MAXIMUM_STRESS);

		if (sLimitTrue && bucklingFalse && stressSafe) {
			System.out.print("Square column width = " + width);
		} else {
			width +=1;
			do {
				area = width * width;
				sLimitTrue = (height/width <= SLENDERNESS_LIMIT);
				bucklingFalse = (expectedLoad <= (0.3 * MODULUS_OF_ELASTICITY * area) / Math.pow((height / width), 2));
				stressSafe = (expectedLoad <= area * MAXIMUM_STRESS);

				if (sLimitTrue && bucklingFalse && stressSafe) {
					System.out.print("Square column width = " + width);
				}
				width +=2;
			} while (!(sLimitTrue && bucklingFalse && stressSafe));
		}
	}
}