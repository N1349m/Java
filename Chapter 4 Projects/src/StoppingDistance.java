
/* StoppingDistance.java
 * Nikhil Menon
 * 
 * Checks if tailgate distance is appropriate
 */
import java.util.Scanner;
public class StoppingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double RANGE = 40.0;
		
		System.out.print("Enter your speed (in mph): ");
		double speed = scanner.nextDouble();
		System.out.print("Enter your tailgate distance (in feet): ");
		double tailgateDistance = scanner.nextDouble();
		
		double stoppingDistance = speed * (2.25 + speed / 21);
		
		if ((stoppingDistance + RANGE/2) < tailgateDistance) {
			System.out.print("No problem.");
		} else if (stoppingDistance + RANGE/2 >= tailgateDistance && (stoppingDistance - RANGE/2)<= tailgateDistance + RANGE/2) {
			System.out.print("Minor wreak.");
		} else {
			System.out.print("Major wreak!");
		}
	}

}