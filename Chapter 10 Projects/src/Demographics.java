/*************************************************************
* Demographics.java
* Dean & Dean
*
* Population effects on resources and income.
*************************************************************/

import java.util.Scanner;

public class Demographics
{
  public static final int YOUNGEST_ADULT = 20;
  public static final int YOUNGEST_SENIOR = 60;
  public static final int MAXIMUM_AGE = 100;
  public static final double TAX_RATE = 0.3;
  public static final double LOSS_RATE = 0.3; // by government
  public static final double SUSTAINABLE_PRODUCTION = 25.0E12;
  public static final double INITIAL_RESOURCES = 2.0E15;

  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    double adultExtractionExpense;
    int years;                       // simulation steps
    int outputYear;                  // first output step
    People youth;
    People adults;
    People seniors;
    Government government;
    Environment environment;

    People.initialize(MAXIMUM_AGE);
    System.out.print("Each adult's annual unsustainable " +
     "extraction in dollars(3000?): ");
    adultExtractionExpense = stdIn.nextDouble();

    // create and initialize objects
    youth = new People(0, TAX_RATE, 0.0);
    adults = new People(YOUNGEST_ADULT, TAX_RATE,
      adultExtractionExpense);
    seniors = new People(YOUNGEST_SENIOR, TAX_RATE, 0.0);
    government = new Government(LOSS_RATE);
    environment = new Environment(
      SUSTAINABLE_PRODUCTION, INITIAL_RESOURCES);

    // input simulation parameters
    System.out.print("Enter number of years to simulate: ");
    years = stdIn.nextInt();
    System.out.print(
      "Enter first year to output economics: ");
    outputYear = stdIn.nextInt();

    // simulate
    for (int year=0; year<years; year++)
    {
      People.simulate(youth, adults, seniors);
      government.govern(youth, adults, seniors, environment);
      if (year >= outputYear)                // print output
      {
        System.out.println("year " + year);
        System.out.printf("youth= %.1f billion\n",
          youth.getPopulation() / 1.E9);
        System.out.printf("adults= %.1f billion\n",
          adults.getPopulation() / 1.E9);
        System.out.printf("seniors= %.1f billion\n",
          seniors.getPopulation() / 1.E9);
        System.out.printf("total= %.1f billion\n",
          People.getTotalPopulation() / 1.E9);
        System.out.printf("Consumption: $%,.0f trillion\n",
          (youth.getIncome() + adults.getIncome() +
          seniors.getIncome())/1.E12);
        System.out.printf("Taxes: $%,.0f trillion\n",
          government.getTaxes()/1.E12);
        System.out.printf("Resources: $%,.0f trillion\n",
          environment.getCurrentResources()/1.E12);
      }
    } // end for year
  } // end main
} // end class Demographics