import java.util.Scanner;

public class MapleTree {
	private double height;
	private String plantDate;
	private String heightDate;
	private Scanner scanner = new Scanner(System.in);
	
	//*****************************
	
	//Assigns plant date
	
	public void plant() 
	{
		System.out.print("Enter plant date (dd/mm/yyyy): ");
		this.plantDate = scanner.next();
	}
	
	//*****************************
	
	//Assigns height and date of height measurement
	
	public void germinate()
	{
		System.out.print("Enter germination date (dd/mm/yyyy): ");
		this.heightDate = scanner.next();
		System.out.print("Enter observed height in meters: ");
		this.height = scanner.nextDouble();
	}
	
	//******************************
	
	//Outputs all instance variables
	
	public void dumpData()
	{
		System.out.println("Plant date = " + plantDate);
		System.out.println("Germinate date = " + heightDate);
		System.out.println("Initial height = " + height + " meters");
	}
}
