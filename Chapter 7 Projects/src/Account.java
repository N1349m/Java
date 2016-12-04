
public class Account {
	private double balance = 0;
	
	//****************************
	
	//
	
	public void debit(double amount)
	{
		this.balance += amount;
	}
	
	//****************************
	
	//
	
	public void credit(double amount)
	{
		this.balance -= amount;
	}
	
	//*****************************
	
	// Returns the value of balance
	
	public double getBalance()
	{
		return this.balance;
	}
}
