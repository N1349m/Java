import java.util.Scanner;
public class PredatorPreyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PredatorPrey predator = new PredatorPrey();
		PredatorPrey prey = new PredatorPrey();
		double totalTime,timeIncrement,efficiency,change;
		
		System.out.println("\nPREDATOR PREY DYNAMICS\n");
		System.out.print("Enter time increment per step: ");
		timeIncrement = scanner.nextDouble();
		System.out.print("Prey's nourishing rate: ");
		prey.setAutoTrophicRate(scanner.nextDouble());
		System.out.print("Prey's death rate: ");
		prey.setDeathRate(scanner.nextDouble());
		System.out.print("Maximum prey population: ");
		prey.setMaxPopulation(scanner.nextDouble());
		System.out.print("Initial prey population: ");
		prey.setPopulation(scanner.nextDouble());
		System.out.print("Predator's consumption rate / prey: ");
		predator.setHeteroTrophicRate(scanner.nextDouble());
		System.out.print("Predator's maximum useful prey: ");
		predator.setMaxPrey(scanner.nextDouble());
		System.out.print("Predator's death rate: ");
		predator.setDeathRate(scanner.nextDouble());
		System.out.print("Initial predator population: ");
		predator.setPopulation(scanner.nextDouble());
		System.out.print("Predation efficiency (<1.0): ");
		efficiency  = scanner.nextDouble();
		System.out.print("Total simulation time: ");
		totalTime = scanner.nextDouble();
		
		for (int i = 1;i <= totalTime; i += timeIncrement) {
			change = predator.take(timeIncrement, prey.getPopulation());
			prey.lose(change/efficiency);
			predator.die(timeIncrement);
			prey.accept(timeIncrement);
			prey.die(timeIncrement);
			
			predator.doIt();
			prey.doIt();
			
			System.out.println("prey population = " + (int) prey.getPopulation() + ", predator population = " + (int) predator.getPopulation());
		}
	}

}
