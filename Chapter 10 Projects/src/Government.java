
public class Government {
	private double lostFraction;
	private double taxes;
	private double distribution;
	
	//******************************************
	
	public Government(double lostFraction) {
		this.lostFraction = lostFraction;
	}
	
	//******************************************
	
	public double getTaxes() {
		return this.taxes;
	}
	
	//******************************************
	
	public void govern(People youth, People adults, People seniors, Environment environment) {
		double youthDistribution, adultDistribution, seniorDistribution;
		double youthTax, adultsTax, seniorsTax;
		
		youthDistribution = distribution * youth.getPopulationFraction();
		adultDistribution = distribution * adults.getPopulationFraction();
		seniorDistribution = distribution * seniors.getPopulationFraction();
		
		youthTax = youth.earn(youthDistribution, environment);
		adultsTax = adults.earn(adultDistribution, environment);
		seniorsTax = seniors.earn(seniorDistribution, environment);
		
		this.taxes = youthTax + adultsTax + seniorsTax;
		this.distribution = taxes * (1 - this.lostFraction);
		
	}
}
