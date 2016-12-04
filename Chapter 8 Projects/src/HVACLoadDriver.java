
public class HVACLoadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HVACLoad load = new HVACLoad();
		double heating, cooling;
		
		//load.getInputs();
		heating = load.findHeatingLoad();
		cooling = load.findCoolingLoad();
		load.printCapacities(heating, cooling);
	}

}
