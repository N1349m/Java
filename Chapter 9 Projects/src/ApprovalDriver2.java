import java.util.*;
public class ApprovalDriver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Approval poll = new Approval();;
		double populationMean, left = 0, right = 0;
		double sample, diffSquared = 0, variance;
		Scanner scanner = new Scanner(System.in);
		int polls,samples;
		
		Approval.setPopulationMean();
		populationMean = Approval.getPopulationMean();
		
		System.out.println("PopulationMean = " + populationMean);
		System.out.print("\nEnter number of polls: ");
		polls = scanner.nextInt();
		System.out.print("\nEnter number of samples per poll: ");
		samples = scanner.nextInt();
		
		for (int i=1; i<=polls; i++) {
			double value = 0, valueSquared = 0;
			for (int j=1; j<=samples; j++) {
				sample = Approval.getSample();
				value += sample;
				valueSquared += sample * sample;
			}
			
			left += (value/samples - populationMean) * (value/samples - populationMean);
			variance = valueSquared/samples - value/samples * value/samples;
			right += variance; 
		}
		
		left /= polls;
		right /= polls;
		System.out.println("samplesMinusOne = " + right/left);
	}

}
