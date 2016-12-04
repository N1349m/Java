/* BankBalance.java
 * Nikhil Menon
 * 
 * Describes First National Bank of Parksville's new banking program
 */
import java.util.Scanner;
public class BankBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter starting balance: ");
		int startingBalance = scanner.nextInt();
		
		int time100000 = (int) Math.ceil((Math.log(100000)
				-Math.log(startingBalance))/Math.log(2));
		int time1000000 = (int) Math.ceil((Math.log(1000000)
				-Math.log(startingBalance))/Math.log(2));
		
		System.out.println("It takes "+ time100000 + 
				" years to reach $100,000.");
		System.out.print("It takes "+ time1000000 + 
				" years to reach $1,000,000.");
	}

}
