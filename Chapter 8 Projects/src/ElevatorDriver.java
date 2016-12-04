import java.util.Scanner;
public class ElevatorDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Elevator elevator = new Elevator();
		char quit = 's';
		
		System.out.println("\nWelcome to John's elevator simulator!\n");
		System.out.println("Options: (s)elect a floor, (f)ire alarm, (q)uit");
		System.out.print("Enter s, f, or q ==> ");
		quit = scanner.next().charAt(0);

		while (quit != 'q' && quit != 'Q') {
			switch (quit) {
				case 's': case 'S':
					elevator.selectFloor();
					break;
				case 'f': case 'F':
					elevator.fireAlarm();
					break;
				default:
					System.out.println("\nInvalid selection.");
					break;
			} // end switch
			
			System.out.println("Options: (s)elect a floor, (f)ire alarm, (q)uit");
			System.out.print("Enter s, f, or q ==> ");
			quit = scanner.next().charAt(0);
		} // end while
		
	} // end main

}
