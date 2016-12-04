
public class Environment {
	private double sustainableProduction;
	private double initialResources;
	private double currentResources;
	private double yieldFactor = 2.0;
	
	//*****************************
	
	public Environment(double production, double resources) {
		this.sustainableProduction = production;
		this.initialResources = resources;
		this.currentResources = resources;
	}
	
	//******************************************
	
	public double getCurrentResources() {
		return this.currentResources;
	}
	
	//******************************************
	
	public double produce(double populationFraction, double extractionExpense) {
		double extraction;
		
		extraction = this.yieldFactor * extractionExpense * 
				(this.currentResources / this.initialResources);
		this.currentResources -= extraction;
		
		return extraction + populationFraction * this.sustainableProduction;
	}
}
