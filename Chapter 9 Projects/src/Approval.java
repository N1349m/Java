
public class Approval {
	private static double populationMean;
	private double mean;
	private double variance;
	
	//***********************************
	
	public void doPoll(int samples) {
		double value = 0, valueSquared = 0, sample, mean, variance;
		
		for (int i=1; i<=samples; i++) {
			sample = Approval.getSample();
			value += sample;
			valueSquared += Math.pow(sample, 2);
		}
		
		mean = value/samples;
		variance = valueSquared/samples - value/samples * value/samples;
		System.out.println("poll's average = " + (int) (mean * 100)  + "%");
		System.out.println("poll's standard deviation = " + 
				(int) (Math.sqrt(variance/(samples - 1)) * 100) + "%");
	}
	
	//***********************************
	
	public double getMean() {
		return mean;
	}
	
	//***********************************
	
	public double getVariance() {
		return variance;
	}
	
	//***********************************
	
	public static void setPopulationMean() {
		Approval.populationMean = Math.random();
	}
	
	//***********************************
	
	public static double getPopulationMean() {
		return Approval.populationMean;
	}
	
	//***********************************
	
	public static double getSample() {
		double sample = Math.random();
		double where = Math.random();
		
		if (where < Approval.populationMean) {
			sample = Approval.populationMean + (1 - Approval.populationMean) * sample;
		} else {
			sample = Approval.populationMean - Approval.populationMean * sample;
		}
		
		return sample;
	}
	
	//***********************************
	
	public static void verifyModel() {
		double sample, min = 1, max = 0, avg = 0;
		
		Approval.setPopulationMean();
		for (int i=1; i<1000000; i++) {
			sample = Approval.getSample();
			
			if (sample < min)
				min = sample;
			if (sample > max)
				max = sample;
			
			avg += sample;
		}
		
		System.out.println("populationMean = " + populationMean + " for 1000000 samples");
		System.out.println("maxValue = " + max);
		System.out.println("minValue = " + min);
		System.out.println("avgValue = " + avg/1000000);
	}
	
	
}
