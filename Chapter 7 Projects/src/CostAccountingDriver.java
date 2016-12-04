
public class CostAccountingDriver {
	
	public static void main(String[] args)
	{
	  double amount;                      // a working variable

	  CostAccounting accounts = new CostAccounting();
	  Job job1;
	  Job job2;

	  // establish business
	  accounts.invest(10000.);
	  accounts.purchase(5000.);

	  // manufacture products
	  job1 = new Job(accounts, 500., 600., 200.);
	  job2 = new Job(accounts, 300., 0, 0);
	  job1.finish();
	  accounts.payWages();

	  // sell all finished products
	  if (job1.getStatus() == 'f')
	  {
	    accounts.sell(job1, 2.0);
	  }
	  if (job2.getStatus() == 'f')
	  {
	    accounts.sell(job2, 2.0);
	  }

	  // do trial balance
	  accounts.balance();

	  // work in process reconciliation
	  amount = 0;
	  if (job1.getStatus() == 'p')
	  {
	    amount += job1.findCost();
	  }
	  if (job2.getStatus() == 'p')
	  {
	    amount += job2.findCost();
	  }
	  System.out.println(
	    "\njob record of work in process = " + amount);
	} // end main

}
