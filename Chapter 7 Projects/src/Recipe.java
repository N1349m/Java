
public class Recipe {
	private String name; // name of food
	private String recipe; // recipe to make food
	private Recipe next; // next recipe in list

	//******************************

	//

	public Recipe(String name, String recipe,Recipe header)
	{ 
		this.initialize(name, recipe);
		this.insertAfter(header);
	}

	//******************************

	//

	public Recipe()
	{
		this.next = null;
	}

	//******************************

	// Initializes values for recipe and name

	public void initialize(String name, String recipe)
	{
		this.name = name;
		this.recipe = recipe;
	}

	//*******************************

	// Methods for returning instance variables

	public String getName()
	{
		return this.name;
	}

	public String getRecipe()
	{
		return this.recipe;
	}

	public Recipe getNext()
	{
		return this.next;
	}

	//*******************************

	// Lists name of every object in list, including header

	public void listNames()
	{
		Recipe recipe = this;

		System.out.println("\nNames:");

		do {		
			System.out.println(recipe.name);
			recipe = recipe.next;
		} while (recipe != null);
		}

		//*******************************

		// Retrieves object whose name is the same as the argument

		public Recipe find(String name)
		{
			Recipe recipe = this;

			while (recipe != null && !recipe.name.equals(name)) {
				recipe = recipe.next;
			}
			return recipe;
		}

		//*******************************

		// Retrieves object before object with given name

		public Recipe findBefore(String name)
		{
			Recipe recipe = this;
			Recipe nextRecipe = this.next;

			while (!nextRecipe.name.equals(name)) {
				recipe = recipe.next;
				nextRecipe = recipe.next;
				if (nextRecipe == null) {
					recipe = null;
					break;
				}
			}
			return recipe;
		}

		//*******************************

		// Removes object after given object from list, returning reference to removed object

		public Recipe removeNext()
		{
			Recipe recipe = this.next;
			this.next = recipe.next;
			return recipe;
		}

		//*******************************

		// Inserts this object after given object

		public void insertAfter(Recipe previous)
		{
			this.next = previous.next;
			previous.next = this;
		}
	}
