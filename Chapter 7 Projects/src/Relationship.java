
public class Relationship {

	// Simulates plants doing photosynthesis

	public void synthesize(Entity atmosphere, Entity plants, double time)
	{
		double demand, transfer;

		demand = time * plants.getFixingInputRate() * plants.getMass() /
				(1 + plants.getMass() / plants.getMassMax());
		transfer = demand / (1 + plants.getMass()/atmosphere.getMass());

		atmosphere.change(-transfer);
		plants.change(transfer);
	}

	//******************************

	// Simulates animals eating plants

	public void eat(Entity plants, Entity animals, double time)
	{
		double demand, transfer;

		demand = time * animals.getEatingInputRate() * animals.getMass();
		transfer = demand / (1 + animals.getMass() / plants.getMass());

		plants.change(-transfer);
		animals.change(transfer);
	}

	//******************************

	// Simulates entities rotting

	public void rot(Entity plants, Entity animals, Entity bacteria, double time)
	{
		double transfer;

		transfer = time * plants.getRottingOutputRate() * plants.getMass();

		plants.change(-transfer);
		bacteria.change(transfer);

		transfer = time * animals.getRottingOutputRate() * animals.getMass();

		animals.change(-transfer);
		bacteria.change(transfer);
	}

	//******************************

	// Simulating carbon released through breathing

	public void breathe(Entity plants, Entity animals, Entity bacteria, Entity atmosphere, double time)
	{
		double transfer;

		transfer = time * plants.getBreathingOutputRate() * plants.getMass();

		plants.change(-transfer);
		atmosphere.change(transfer);

		transfer = time * animals.getBreathingOutputRate() * animals.getMass();

		animals.change(-transfer);
		atmosphere.change(transfer);

		transfer = time * bacteria.getBreathingOutputRate() * bacteria.getMass();

		bacteria.change(-transfer);
		atmosphere.change(transfer);

	}
}
