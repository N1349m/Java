
public class SavingsAccount {
	private static double annualInterestRate;
	private final int ACCOUNT_NUMBER;
	private double balance;

	//***************************

	public SavingsAccount(int number, double balance) {
		ACCOUNT_NUMBER = number;
		this.balance = balance;
	}

	//***************************

	public static void setInterestRate(double rate) {
		annualInterestRate = rate/100;
	}

	//***************************

	public int getAccountNumber() {
		return this.ACCOUNT_NUMBER;
	}

	//***************************

	public double getBalance() {
		return this.balance;
	}
	
	//***************************
	
	public void addMonthlyInterest() {
		balance += balance * annualInterestRate / 12;
	}
}
