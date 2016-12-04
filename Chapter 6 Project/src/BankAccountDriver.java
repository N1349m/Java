import java.util.Scanner;

public class BankAccountDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount bankAccount = new BankAccount();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Customer name: ");
		bankAccount.setCustomer(scanner.nextLine());
		System.out.print("Account number: ");
		bankAccount.setAccountNum(scanner.nextInt());
		
		bankAccount.printAccountInfo();
	}

}
