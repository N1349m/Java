public class Job {
	private CostAccounting accounts;
	private double material = 0.0;
	private double labor = 0.0;
	private double overhead = 0.0;
	private char status = 'p';
	
	//**********************************
	
	// Construct an instance of the object
	
	public Job(CostAccounting accounts, double material, double labor, double overhead)
	{
		this.accounts = accounts;
		this.material = material;
		this.labor = labor;
		this.overhead = overhead;
		
		this.accounts.getWorkInProcess().debit(this.material);
		this.accounts.getRawMaterial().credit(this.material);
		
		this.accounts.getWorkInProcess().debit(this.labor + this.overhead);
		this.accounts.getWagesPayable().credit(this.labor + this.overhead);
	}
	
	//**********************************
	
	// Return instance variables
	
	public double getMaterial()
	{
		return this.material;
	}

	public double getLabor()
	{
		return this.labor;
	}
	
	public double getOverhead()
	{
		return this.overhead;
	}
	
	public char getStatus()
	{
		return this.status;
	}
	
	//**********************************
	
	//
	
	public void finish()
	{
		this.accounts.getWorkInProcess().credit(this.findCost());
		this.accounts.getFinishedGoods().debit(this.findCost());
		this.setStatus('f');
	}
	
	//**********************************
	
	//
		
	public double findCost()
	{
			return this.labor + this.material + this.overhead;
	}
	
	//**********************************
	
	// Sets status of job
		
	public void setStatus(char status)
	{
			this.status = status;
	}
}
