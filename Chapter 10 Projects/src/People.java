import java.util.*;
public class People {
	private static final double M0 = 0.015;
	private static final double M1 = 0.05;
	private static final double M4 = 0.22;
	private static int youngestChildBearingAge = 15;
	private static int oldestChildBearingAge = 40;
	private static double primeFertility = 0.16;
	private static long[] population;
	private static long totalPopulation;
	private int youngest;
	private double taxRate;
	private double individualExtractionExpense;
	private double income;
	private long groupPopulation;
	private double populationFraction;
	
	//******************************************
	
	public People(int youngest, double taxRate, double extractionExpense) {
		this.youngest = youngest;
		this.taxRate = taxRate;
		this.individualExtractionExpense = extractionExpense;
	}
	
	//******************************************
	
	public long getPopulation() {
		return this.groupPopulation;
	}
	
	//******************************************
	
	public double getPopulationFraction() {
		return this.populationFraction;
	}
	
	//******************************************
	
	public double earn(double distribution, Environment environment) {
		double extractionExpense, totalProduction;
		
		extractionExpense = this.individualExtractionExpense * this.groupPopulation;
		totalProduction = environment.produce(this.populationFraction, extractionExpense);
		
		return totalProduction * taxRate; // Come back to this one
	}
	
	//******************************************
	
	public double getIncome() {
		return this.income;
	}
	
	//******************************************
	
	public static long getTotalPopulation() {
		return People.totalPopulation;
	}
	
	//******************************************
	
	public static void initialize(int maxAge) {
		People.population = new long[maxAge];
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<=maxAge; i++) {
			if (i < maxAge / 2) {
				population[i] = (long) (long) ((1.0 - 0.02 * i) * 2 * Math.pow(10,8));
			} else {
				population[i] = 0;
			}
			
			People.totalPopulation += People.population[i];
		}
		
		System.out.print("Youngest child-bearing age (15?): ");
		People.youngestChildBearingAge = scanner.nextInt();
		System.out.print("Oldest child-bearing age (40?): ");
		People.oldestChildBearingAge = scanner.nextInt();
		System.out.print("Children per year in child-bearing years (0.16?): ");
	}
	
	//******************************************
	
	public static void simulate(People youth, People adults, People seniors) {
		double ageFactor, mortality;
		
		for ( int age=People.population.length; age>=1; age--) {
		ageFactor = age / 100;
		mortality = M0 + M1 * ageFactor + M4 * Math.pow(ageFactor, 4);
		People.population[age] = (long) ((double) People.population[age - 1] * 
				(1.0 - mortality));
		}
		
		People.population[0] = 0;
		for ( int i = People.youngestChildBearingAge; 
				i <= People.oldestChildBearingAge; i++) {
			People.population[0] += 0.5 * 
					(double) People.population[i] * People.primeFertility;
		}
		
	}
	
}
