/* GameOfNIM.java
 * Nikhil Menon
 * 
 * Simulates the ancient Chinese game of NIM.
 */

import java.util.Scanner;
public class GameOfNIM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int numberOfStones, playerTurn, compTurn;
		String lastTurn = "player";
		char testChar, testContinue = 'y';

		System.out.println("\nT H E   G A M E   O F   N I M");

		do {
			System.out.print("\nEnter number of starting stones: ");
			numberOfStones = scanner.nextInt();
			while (numberOfStones <= 0) {
				System.out.print("Enter number of starting stones: ");
				numberOfStones = scanner.nextInt();
				if (numberOfStones <= 0) {
					System.out.println("You cannot start with " + numberOfStones + " stones.");
				}
			}
			System.out.print("Would you like to go first? (y/n):");
			testChar = scanner.next().charAt(0);

			if (testChar == 'y') {
				System.out.print("How many would you like to remove – 1 or 2? ");
				playerTurn = scanner.nextInt();
				while (!(playerTurn == 1 || playerTurn == 2)){
					System.out.println("You cannot remove " + playerTurn + " stones.");
					System.out.print("How many would you like to remove – 1 or 2? ");
					playerTurn = scanner.nextInt();
				}
				numberOfStones -= playerTurn;

				System.out.println("The number of stones left is " + numberOfStones + ".");
			}

			while (numberOfStones > 0) {
				if (numberOfStones % 3 ==0) {
					compTurn = 2;
				} else{
					compTurn = 1;
				}
				numberOfStones -= compTurn;
				System.out.println("The computer removes " + compTurn + " stones.");
				System.out.println("The number of stones left is " + numberOfStones + ".");
				if (numberOfStones == 0) {
					lastTurn = "comp";
					break;
				}

				System.out.print("How many would you like to remove – 1 or 2? ");
				playerTurn = scanner.nextInt();
				while (!(playerTurn == 1 || playerTurn == 2)){
					System.out.println("You cannot remove " + playerTurn + " stones.");
					System.out.print("How many would you like to remove – 1 or 2? ");
					playerTurn = scanner.nextInt();
				}
				numberOfStones -= playerTurn;
				System.out.println("The number of stones left is " + numberOfStones + ".");
				if (numberOfStones == 0) {
					lastTurn = "player";
					break;
				}
			}

			if (lastTurn == "player") {
				System.out.println("The computer wins!");
			} else {
				System.out.println("You win!");
			}
			System.out.println("Do you want to play again? (y/n): ");
			testContinue = scanner.next().charAt(0);
		} while (testContinue == 'y');
	}
}
