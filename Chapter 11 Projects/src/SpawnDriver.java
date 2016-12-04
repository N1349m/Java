import java.util.Scanner;
public class SpawnDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char test = 't';
		System.out.println("--- SPAWN ---");
		Spawn spawn = new Spawn();
		
		while (test != 'q' & test != 'Q') {
			System.out.print("\nOptions: (n)ext, (p)rint, (l)oad grid, (e)volve, (q)uit\n"
					+ "Enter n, p, l, e, or q ==> ");
			test=scanner.next().charAt(0);
			
			switch (test) {
				case 'n': case 'N':
					spawn.nextGeneration();
					break;
				case 'p': case 'P':
					spawn.printSpecial();;
					break;
				case 'l': case 'L':
					spawn.loadGrid();
					break;
				case 'e': case 'E':
					spawn.evolve();
			} // end switch
		} // end while
	} // end main

}
