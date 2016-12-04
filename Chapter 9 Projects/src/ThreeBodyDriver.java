import java.util.Scanner;
public class ThreeBodyDriver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Body earth = new Body(6.0e24, 0, -4.5e6, 12, -14);
		Body moon = new Body(7.4e22, 0, 3.84e8, -1005, 0);
		Body anotherMoon = new Body(7.4e22, 2.7e8, 0, 0, 1180);
		double timeIncrement;
		int numberOfSteps;
		
		System.out.print("Enter time increment in sec (3600?): ");
		timeIncrement = scanner.nextDouble();
		System.out.print("Enter number of steps (1500?): ");
		numberOfSteps = scanner.nextInt();
		System.out.print("Enter scale factor (1.e-6?): ");
		ThreeBody.setScale(scanner.nextDouble());
		
		timeIncrement = 3600;
		numberOfSteps = 10;
		ThreeBody.setScale(1e-6);
		
		for (int i=1; i<=numberOfSteps; i++) {
			ThreeBody.go(earth, moon, anotherMoon, timeIncrement);
			ThreeBody.print(earth, moon, anotherMoon, i);
		} // end for
	}
}
