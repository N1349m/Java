/************************************************************
 * RecipeDriver.java
 * Dean & Dean
 *
 * This demonstrates creation and use of a list of recipes.
 ************************************************************/

import java.util.Scanner;

public class RecipeDriver
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		Recipe recipes;   // list header
		Recipe before, current;  // previous and current objects
		Recipe recipe1;
		Recipe recipe2;
		Recipe recipe3;
		Recipe recipe4;
		String name;

		recipes = new Recipe();  // a header is required!

		recipe1 = new Recipe("milk",
				"milk a cow" +
				"\npour milk into a bottle" +
				"\nput bottle into a refrigerator",recipes);
		
		recipe2 = new Recipe("cake",
				"roll it up, roll it up, throw it in a pan" +
				"\nbake it in the oven as fast as you can",recipes);
		
		recipe3 = new Recipe("beans",
				"fill pan with water" +
				"\nadd beans" +
				"\nboil until done and pour off water",recipes);
		
		recipe4 = new Recipe("junkfood",
				"go to a store" +
				"\nbuy something at the checkout counter",recipes);

		recipes.initialize("myRecipes", "A Balanced Diet");

		recipes.listNames();

		do
		{
			System.out.print("\nExtract recipe name: ");
			name = stdIn.nextLine();
			before = recipes.findBefore(name);
		} while (before == null);
		System.out.println("The name before that is: " +
				before.getName());
		current = before.removeNext();
		System.out.println("The name removed is: " +
				current.getName());
		System.out.println("The recipe is:\n" +
				current.getRecipe());

		recipes.listNames();

		do
		{
			System.out.print("\nInsert after recipe name: ");
			name = stdIn.nextLine();
			before = recipes.find(name);
		} while (before == null);
		current.insertAfter(before);

		recipes.listNames(); 
	} // end main
} // end class RecipeDriver