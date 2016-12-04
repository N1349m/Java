/*************************************************************
* CarbonCycleDriver.java
* Dean & Dean
*
* This drives Entities who are members of a food web.
* All Relationships are some kind of carbon transfer:
* (1) photosynthesis: plants take from atmosphere
* (2) eating: animals take from plants
* (3) rotting: plants & animals give to bacteria
* (4) breathing: plants, animals, bacteria give to atmosphere
*************************************************************/

import java.util.Scanner;

public class CarbonCycleDriver
{
  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    int steps;          // total number of simulation steps
    double timeStep;    // time increment in each step
    double demand;      // amount demanded in particular step
    double transfer;    // amount transferred between entities

    Relationship carbon = new Relationship();
    Entity atmosphere = new Entity();
    Entity plants = new Entity();
    Entity animals = new Entity();
    Entity bacteria = new Entity();

    // configure and initialize system

    // initialize causal per unit rate parameters
    plants.setFixingInputRate(0.02);
    plants.setRottingOutputRate(0.005);
    plants.setBreathingOutputRate(0.005);
    animals.setEatingInputRate(0.021);
    animals.setRottingOutputRate(0.01);
    animals.setBreathingOutputRate(0.01);
    bacteria.setBreathingOutputRate(0.05);

    // initialize entity constraint and state variables
    plants.setMassMax(5000.0);
    atmosphere.setMass(1000.0);
    plants.setMass(1000.0);
    animals.setMass(10.0);
    bacteria.setMass(100.0);

    // set up simulation
    System.out.print("Enter size of time step (0.1 to 30): ");
    timeStep = stdIn.nextDouble();
    System.out.print("Enter total number of steps: ");
    steps = stdIn.nextInt();

    // do simulation
    for (int step=0; step<steps; step++)
    {
      // evaluate inter-entity transfers based on old states

      // (1) plants take from atmosphere, as available
      carbon.synthesize(atmosphere, plants, timeStep);

      // (2) animals take from plants, as available
      carbon.eat(plants, animals, timeStep);

      // (3) plants and animals give to bacteria
      carbon.rot(plants, animals, bacteria, timeStep);

      // (4) plants animals and bacteria give to atmosphere
      carbon.breathe(plants, animals, bacteria, atmosphere,
        timeStep);

      // update entity states with accumulated changes
      atmosphere.doIt();
      plants.doIt();
      animals.doIt();
      bacteria.doIt();

      // output as int for readability
      System.out.println(
        "atmosphere= " + (int) atmosphere.getMass() +
        "  plants= " + (int) plants.getMass() +
        "  animals= " + (int) animals.getMass() +
        "  bacteria= " + (int) bacteria.getMass());
    } // end for
  } // end main
} // end class CarbonCycleDriver
