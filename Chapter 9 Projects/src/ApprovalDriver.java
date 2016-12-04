import java.util.Scanner;
public class ApprovalDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Approval poll = new Approval();
		Scanner scanner = new Scanner(System.in);
		int samples;
		double populationMean;
		
		Approval.verifyModel();
		Approval.setPopulationMean();
		
		System.out.print("\nEnter number of samples in poll: ");
		samples = scanner.nextInt();
		
		poll.doPoll(samples);
		populationMean = Approval.getPopulationMean();
		
		System.out.println("\npopulation average = " + (int) (populationMean * 100) + "%");
	}

}
