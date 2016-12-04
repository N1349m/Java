
public class CostAccounting {
	private Account cash = new Account();
	private Account rawMaterial = new Account();
	private Account workInProcess = new Account();
	private Account finishedGoods = new Account();
	private Account wagesPayable = new Account();
	private Account equity = new Account();
	private Account sales = new Account();
	private Account materialExpense = new Account();
	private Account laborExpense = new Account();
	private Account overheadExpense = new Account();
	
	//*******************************
	
	// Returns instance variables
	
	public Account getRawMaterial()
	{
		return this.rawMaterial;
	}
	
	public Account getWorkInProcess()
	{
		return this.workInProcess;
	}
	
	public Account getFinishedGoods()
	{
		return this.finishedGoods;
	}
	
	public Account getWagesPayable()
	{
		return this.wagesPayable;
	}
	
	//*******************************
	
	// Money gained through investing
	
	public void invest(double amount)
	{
		Account account = this.cash;
		this.cash.debit(amount);
		this.equity.credit(amount);
	}
	
	//*******************************
	
	// Money spent to purchase materials
	
	public void purchase(double amount)
	{
		this.rawMaterial.debit(amount);
		this.cash.credit(amount);
	}
	
	//*******************************
	
	// Pays wages to employees
	
	public void payWages()
	{
		this.cash.credit(-this.wagesPayable.getBalance());
		this.wagesPayable.debit(-this.wagesPayable.getBalance());
	}
	
	//*******************************
	
	// Deals with accounting for a job
	
	public void sell(Job job, double factor)
	{
		job.setStatus('s');
		this.materialExpense.debit(job.getMaterial());
		this.laborExpense.debit(job.getLabor());
		this.overheadExpense.debit(job.getOverhead());
		
		this.finishedGoods.credit(job.findCost());
		this.cash.debit(job.findCost() * factor);
		this.sales.credit(job.findCost() * factor);
	}
	
	//*******************************
	
	// Displaces current accounts and balances
	
	public void balance()
	{
		String formatSpec = "   %-19s%(,21.2f\n";
		
		System.out.println("Assets");
		System.out.printf(formatSpec, "cash", this.cash.getBalance());
		System.out.printf(formatSpec, "raw material", this.rawMaterial.getBalance());
		System.out.printf(formatSpec, "work in process", this.workInProcess.getBalance());
		System.out.printf(formatSpec, "finished goods", this.finishedGoods.getBalance());
		
		System.out.println("Liabilities");
		System.out.printf(formatSpec, "wages payable", this.wagesPayable.getBalance());
		
		System.out.println("Net Worth");
		System.out.printf(formatSpec, "equity", this.equity.getBalance());
		
		System.out.println("Revenue");
		System.out.printf(formatSpec, "sales", this.sales.getBalance());
		
		System.out.println("Expenses");
		System.out.printf(formatSpec, "material expense", this.materialExpense.getBalance());
		System.out.printf(formatSpec, "labor expense", this.laborExpense.getBalance());
		System.out.printf(formatSpec, "overhead expense", this.overheadExpense.getBalance());
	}
}