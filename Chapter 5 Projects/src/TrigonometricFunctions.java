import java.util.Scanner;
public class TrigonometricFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String function;
		double ratio,angle;

		System.out.print("Select ArcSin(as), ArcCos(ac), or ArcTan(at): ");
		function = scanner.next();
		
		if (!(function.equals("as") || function.equals("ac") || function.equals("at"))) {
			System.out.println("Not an allowed function");
			System.out.println("Angle in degrees = NaN");
			
		} else {
			System.out.print("Enter a trigonometric ratio: ");
			ratio = scanner.nextDouble();

			if ((function.equals("as") || function.equals("ac")) && ratio > 1) {
				System.out.println("Magnitude must not be greater than unity.");
			} else {
				if (function.equals("as")) {
					angle = Math.asin(ratio);
				} else if (function.equals("ac")) {
					angle = Math.acos(ratio);
				} else {
					angle = Math.atan(ratio);
				}

				System.out.println("Angle in degrees = " + angle *180/Math.PI);
			}
		}
	} // end main
} // end class
