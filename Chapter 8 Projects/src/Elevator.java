import java.util.Scanner;
public class Elevator {
	private int currentFloor = 1;

	//***********************************

	// Allows user to move to a new floor

	public void selectFloor() {
		Scanner scanner = new Scanner(System.in);
		int floor;

		System.out.print("Enter the floor that you'd like to go to ==> ");
		floor = scanner.nextInt();
		if (floor > 100 || floor < 1) {
			System.out.println("Invalid floor selection - must be between 1 and 100");
		} else {
			move(floor);
		}
	}

	//***********************************

	// Simulates a fire alarm, sending elevator down to 1st floor

	public void fireAlarm() {
		System.out.println("Danger! You must exit the building now");
		if (currentFloor != 1) {
			move(1);
		}
	}

	//***********************************

	// Moves elevator

	private void move(int floor) {
		boolean greater = floor > currentFloor;

		if (greater) {
			System.out.print("Going up..");
			for (int i=currentFloor+1; i<=floor; i++) {
				System.out.print(i + "..");
			}
		} else {
			System.out.print("Going down..");
			for (int i=currentFloor-1; i>=floor; i--) {
				System.out.print(i + "..");
			}
		}

		System.out.println("Ding!");
		currentFloor = floor;
	}
}
