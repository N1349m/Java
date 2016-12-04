
public class SolarDriver {
	public static void main(String[] args) {
		Solar glass;
		
		Solar.setPlace(40, 95, 'C');
		Solar.setTime(2004, 0, 21, 9, 00);
		
		glass = new Solar(60.0, 0.0, 100.0, 0.90, 0.20);
		
		System.out.println("altitude degrees= " + Math.round(Solar.getAltitude()));
		System.out.println("azmuth degrees= " + Math.round(Solar.getAzmuth()));
		System.out.println("direct normal BTU/hr/sqft= " + Math.round(Solar.getDirectNormal()));
		glass.getIncidenceAngle();
		System.out.println("transmitted BTU/hr= " + Math.round(glass.getTransmitted()));
	}
}
