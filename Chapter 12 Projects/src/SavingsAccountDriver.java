
public class SavingsAccountDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount saver1 = new SavingsAccount(10002, 2000);
		SavingsAccount saver2 = new SavingsAccount(10003, 3000);
		String formatSpec = "%5d %9d   %7.2f %9d   %7.2f\n";
		SavingsAccount.setInterestRate(5);

		System.out.println("Month Account #   Balance Account #   Balance");
		System.out.println("----- ---------   ------- ---------   -------");

		for(int t=0; t<13; t++) {
			System.out.printf(formatSpec, t, saver1.getAccountNumber(),
					saver1.getBalance(), saver2.getAccountNumber(),
					saver2.getBalance());
			saver1.addMonthlyInterest();
			saver2.addMonthlyInterest();
		}

		System.out.printf("\nFinal balance of both accounts combined: %.2f",
				(saver1.getBalance() + saver2.getBalance()));
	}

}