
public class Entity {
	private double fixingInputRate = 0;
	private double eatingInputRate = 0;
	private double rottingOutputRate = 0;
	private double breathingOutputRate = 0;
	private double massMax = 1.0e100;
	private double mass;
	private double accumulation = 0;
	
	//*************************************
	
	// Assign values to instance variables
	
	public void setMass(double amount)
	{
		this.mass = amount;
	}
	
	public void setMassMax(double amount)
	{
		this.massMax = amount;
	}
	
	public void setFixingInputRate(double rate)
	{
		this.fixingInputRate = rate;
	}
	
	public void setEatingInputRate(double rate)
	{
		this.eatingInputRate = rate;
	}
	
	public void setRottingOutputRate(double rate)
	{
		this.rottingOutputRate = rate;
	}
	
	public void setBreathingOutputRate(double rate)
	{
		this.breathingOutputRate = rate;
	}
	
	//***************************************
	
	// Retrieve instance variable values
	
	public double getMass()
	{
		return this.mass;
	}
	
	public double getMassMax()
	{
		return this.massMax;
	}
	
	public double getFixingInputRate()
	{
		return this.fixingInputRate;
	}
	
	public double getEatingInputRate()
	{
		return this.eatingInputRate;
	}
	
	public double getRottingOutputRate()
	{
		return this.rottingOutputRate;
	}
	
	public double getBreathingOutputRate()
	{
		return this.breathingOutputRate;
	}
	
	//*****************************************
	
	// Calculates increase or decrease in mass
	
	public void change(double increment)
	{
		this.accumulation += increment;
	}
	
	//*****************************************
	
	// Applies increase or decrease in mass
	
	public void doIt()
	{
		this.mass += this.accumulation;
		if (this.mass < 0) {
			this.mass = 0;
		}
		this.accumulation = 0;
	}
}