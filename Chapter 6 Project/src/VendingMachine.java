import java.util.Scanner;

public class VendingMachine {
	private double paymentSum; // Amount customer has put into machine

	//***************************

	//

	public void insertMoney()
	{
		Scanner scanner = new Scanner(System.in);
		double amount; //amount customer inserts into machine

		System.out.print("Amount of money inserted: ");
		amount = scanner.nextDouble();
		while (amount < 0) {
			System.out.println("Invalid payment. Must enter a positive number.");
			System.out.print("Amount of money inserted: ");
			amount = scanner.nextDouble();
		}
		this.paymentSum += amount;
	}

	//***************************

	//

	public void selectItem()
	{
		Scanner scanner = new Scanner(System.in);
		double itemPrice; // Price of selected item
		double finalSum; // Final total after deducting price of item
		int quarters,dimes,nickels,pennies; // Amount of change for each coin
		if (this.paymentSum == 0){
			System.out.println("Sorry, you can't select since you haven't inserted money yet.");
		} else {
			System.out.print("Selected item's price: ");
			itemPrice = scanner.nextDouble();

			while (itemPrice > this.paymentSum) {
				System.out.println("Invalid selection. Price exceeds payment.");
				System.out.print("Selected item's price: ");
				itemPrice = scanner.nextDouble();
			} 
			while (itemPrice <=0) {
				System.out.println("Invalid payment. Must enter a positive number.");
				System.out.print("Selected item's price: ");
				itemPrice = scanner.nextDouble();
			} 
			finalSum = this.paymentSum - itemPrice;

			quarters = (int) (finalSum/.25);
			finalSum -= quarters*.25;
			dimes = (int) (finalSum/.1);
			finalSum -= dimes*.1;
			nickels = (int) (finalSum/.05);
			finalSum -= nickels*.05;
			pennies = (int) (finalSum/.01);

			System.out.println("\nYour change is: ");
			System.out.print(quarters + " quarter(s)\n");
			System.out.print(dimes + " dime(s)\n");
			System.out.print(nickels + " nickel(s)\n");
			System.out.print(pennies + " penny(ies)\n\n");
		}
	}
}
