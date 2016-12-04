import java.util.Scanner;
public class AverageValueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		AverageValue avg = new AverageValue();
		char more = 'y';
		
		while (more == 'y') {
			avg.accumulate();
			System.out.print("more? (y/n)");
			more = scanner.next().charAt(0);
		}
		
		avg.printAverage();
		
	}

}
