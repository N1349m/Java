import java.util.*;
public class Solar {
	private static final double RAD = Math.PI / 180;
	private static double latitude;
	private static double longitude;
	private static char timeZone;
	private static double yearPhase;
	private static double altitude;
	private static double azmuth;
	private static Calendar calendar = Calendar.getInstance();
	private double tilt;
	private double normalAzmuth;
	private double area;
	private double transmission = 0.88;
	private double groundReflection = 0.2;
	private double incidenceAngle;

	//***********************************

	public Solar(double tilt, double normalAzmuth, 
			double sqft, double transmission, double groundReflection) {
		this.tilt = tilt;
		this.normalAzmuth = normalAzmuth;
		this.area = sqft;
		this.transmission = transmission;
		this.groundReflection = groundReflection;
		
		this.setIncidenceAngle();
	}

	//***********************************

	public void move(double tilt, double azmuth) {
		this.tilt = tilt;
		Solar.azmuth = azmuth;
		
		setIncidenceAngle();
	}

	//************************************

	public void setIncidenceAngle() {
		this.incidenceAngle = Math.acos( Math.cos(Solar.altitude * RAD) *
				Math.cos((Solar.azmuth - this.normalAzmuth) * RAD) * Math.sin(tilt * RAD) +
				Math.sin(Solar.altitude * RAD) * Math.cos(tilt * RAD)) / RAD;
	}

	//***********************************

	public void getIncidenceAngle() {
		System.out.println("incidenceAngle= " + Math.round(incidenceAngle));
	}

	//***********************************

	public double getDirect() {
		if (incidenceAngle < 90)
			return area * getDirectNormal() * Math.cos(incidenceAngle * RAD);
		else
			return 0;
	}

	//***********************************

	public double getDiffuse() {
		double c, y, diffuseSky, diffuseGround;
		double fss, fsg, cosI;
		
		c = 0.09033 - 0.04104 * Math.cos(yearPhase - 0.10);
		fss = Math.cos(tilt * RAD);
		fsg = 1 - fss;
		y = 0.45;
		cosI = Math.cos(incidenceAngle * RAD);
		if (cosI > -0.2)
			y = 0.55 + 0.437*cosI + 0.313*cosI*cosI;
		
		diffuseSky = fss * getDirectNormal() * c;
		diffuseGround = fsg * getDirectNormal() *
				  (c * y + 0.5 * groundReflection * (c + Math.sin(altitude * RAD)));

		
		return area * (diffuseSky + diffuseGround);
	}

	//***********************************

	public double getTransmitted() {
		double cosI, transmitted;
		
		cosI = Math.cos(incidenceAngle * RAD);
		transmitted = (transmission / 0.87917) * 2.71235 * cosI * (1 - 
				0.22881 * cosI * (1 + 11.39714 * cosI * (1 - 1.37983 * cosI * (1 -
				0.39951*cosI)))) * getDirect() + 0.9189 * transmission * getDiffuse();
		
		return transmitted;
	}

	//***********************************

	public static void setPlace(double latitude, double longitude, char timeZone) {
		Solar.latitude = latitude;
		Solar.longitude = longitude;
		Solar.timeZone = timeZone;
	}

	//***********************************

	public static void setTime(int year, int month, int monthDay, int hour, int minute)
	{
		double declination, solarTime;

		calendar.set(year, month, monthDay, hour, minute);

		yearPhase = calendar.get(Calendar.DAY_OF_YEAR) * 2 * Math.PI / 365.25;
		//System.out.println(yearPhase);
		declination = 0.28 - 23.19 * Math.cos(yearPhase + 0.153);
		//System.out.println(declination);
		
		solarTime = getSolarTime(hour, minute);
		//System.out.println(solarTime);
		Solar.setAltitude(declination, 0.25 * solarTime);
		Solar.setAzmuth(declination, 0.25 * solarTime);
	}

	//***********************************

	public static double getAltitude() {
		return altitude;
	}

	//***********************************

	public static double getAzmuth() {
		return azmuth;
	}

	//***********************************

	public static double getDirectNormal() {
		double a, b;
		
		a = 361.367 + 25.177 * Math.cos(yearPhase - 0.0862);
		b = 0.1716 - 0.03466 * Math.cos(yearPhase - 0.1406);
		
		if (altitude > 0)
			return a * Math.exp(-b / Math.sin(altitude * RAD));
		else
			return 1;
	}

	//***********************************

	private static double getSolarTime(int hour, int minute) {
		int minutesAfterNoon;
		double correction, standardLongitude;

		minutesAfterNoon = 60 * hour + (minute - 60 * 12);
		correction = 0.008 + 7.669 * Math.cos(Solar.yearPhase + 1.533) -
				9.714 * Math.cos(2 * Solar.yearPhase - 1.245);

		switch (Solar.timeZone) {
			case 'A':
				standardLongitude = 60;
				break;
			case 'E':
				standardLongitude = 75;
				break;
			case 'C':
				standardLongitude = 90;
				break;
			case 'M':
				standardLongitude = 105;
				break;
			case 'P':
				standardLongitude = 120;
				break;
			case 'Y':
				standardLongitude = 135;
				break;
			case 'H':
				standardLongitude = 150;
				break;
			default:
				standardLongitude = 0;
		} // end switch
		
		return minutesAfterNoon + correction + 4 * (standardLongitude - longitude);
	}

	//***********************************

	private static void setAltitude(double declination, double hourAngle) {
		double sinAltitude;
		
		sinAltitude = Math.cos(latitude * RAD) * Math.cos(declination * RAD) * 
				Math.cos(hourAngle * RAD) + Math.sin(latitude * RAD) 
				* Math.sin(declination * RAD);
		Solar.altitude = Math.asin(sinAltitude) / RAD;
		//Solar.altitude = 12.6;
	}

	//***********************************

	private static void setAzmuth(double declination, double hourAngle) {
		double cosAzmuth, sign;
		
		cosAzmuth = (Math.sin(altitude * RAD) * Math.sin(latitude * RAD) -
		            Math.sin(declination * RAD)) / (Math.cos(altitude * RAD) * 
		            Math.cos(latitude * RAD));
		sign = hourAngle/Math.abs(hourAngle);
		
		azmuth = sign * Math.acos(cosAzmuth) / RAD;
	}

}
