/***************************************
 * PredatorPrey.java
 * Nikhil Menon
 *
 * Models either a predator or a prey population.
 **************************************/
public class PredatorPrey {
	private double autoTrophicRate; // Rate at which prey nourishes itself 
	private double heteroTrophicRate; // Rate at which predators eat prey
	private double maxPrey = 1.0e100; // Maximum population of prey
	private double deathRate; // Rate at which the population dies
	private double maxPopulation = 1.0e100; // Maximum allowed population
	private double population; // Current population
	private double populationChange; // Change in population
	
	//*************************************
	
	// Assigns a value to autoTrophicRate
	
	public void setAutoTrophicRate(double rate)
	{
		this.autoTrophicRate = rate;
	}

	//*************************************
	
	// Assigns a value to heteroTrophicRate
	
	public void setHeteroTrophicRate(double ratePerPrey)
	{
		this.heteroTrophicRate = ratePerPrey;
	}

	//*************************************
	
	// Assigns a value to maxPrey
	
	public void setMaxPrey(double rate)
	{
		this.maxPrey = rate;
	}

	//*************************************
	
	// Assigns a value to deathRate
	
	public void setDeathRate(double rate)
	{
		this.deathRate = rate;
	}

	//*************************************
	
	// Assigns a value to maxPopulation
	
	public void setMaxPopulation(double population)
	{
		this.maxPopulation = population;
	}

	//*************************************
	
	// Assigns a value to population
	
	public void setPopulation(double population) // Check here for errors with population not being integers
	{
		this.population = population;
	}

	//*************************************
	
	// Returns population
	
	public double getPopulation()
	{
		return this.population;
	}

	//*************************************
	
	// Simulates predator action
	
	public double take(double time, double prey)
	{
		double change;
		change = time * this.heteroTrophicRate * this.population * prey / (1 + prey / maxPrey); 
		this.populationChange += change;
		return change;
	}
	
	//*************************************
	
	// Simulates loss of energy through energy transfers
		
	public void lose(double loss)
	{
		this.populationChange -= loss;
	}
	
	//*************************************
	
	// Simulates prey reception of outside actions
		
	public void accept(double time)
	{
		this.populationChange += time * this.population * this.autoTrophicRate * (1.0 - this.population/this.maxPopulation);
	}
	
	//*************************************
	
	// Simulates death of population
	
	public void die(double time)
	{
		this.populationChange -= time * this.population * this.deathRate;
	}
	
	//*************************************
	
	// Applies change to population and resets change
	
	public void doIt()
	{
		this.population += this.populationChange;
		this.populationChange = 0;
	}
}
