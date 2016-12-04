import java.util.Scanner;

public class NetPercentValueCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int presentYear,cashFlowYear,netCashFlowAmount;
		double discountRate,netPresentValue = 0;
		char testContinue = 'y';
		
		System.out.print("Enter present year: ");
		presentYear = scanner.nextInt();
		System.out.print("Enter discount rate as a fraction: ");
		discountRate = scanner.nextDouble();
		
		while (testContinue == 'y') {
			System.out.print("Enter year of net cash flow: ");
			cashFlowYear = scanner.nextInt();
			System.out.print("Enter net cash flow: ");
			netCashFlowAmount = scanner.nextInt();
			
			netPresentValue += netCashFlowAmount/Math.pow(1 + discountRate, cashFlowYear - presentYear);
			
			System.out.print("Any more cash flows (y/n)? ");
			testContinue = scanner.next().charAt(0);
		}
		System.out.printf("Net present value = %+,.2f", netPresentValue);
	}

}
