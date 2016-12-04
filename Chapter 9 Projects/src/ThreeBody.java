
public class ThreeBody {
	public static final double G = 6.673e-11;
	private static double scale;
	private double velocityX;
	private double velocityY;
	private double accelerationX;
	private double accelerationY;

	//********************************

	public static void setScale(double scale) {
		ThreeBody.scale = scale;
	}

	//********************************

	public double getVelocityX() {
		return velocityX;
	}

	//********************************

	public double getVelocityY() {
		return velocityY;
	}

	//********************************

	public double getAccelerationX() {
		return accelerationX;
	}

	//********************************

	public double getAccelerationY() {
		return accelerationY;
	}

	//********************************

	public void setVelocityX(double velocity) {
		this.velocityX = velocity;
	}

	//********************************

	public void setVelocityY(double velocity) {
		this.velocityY = velocity;
	}

	//********************************

	public void setAcceleration(Body driven, Body otherA, Body otherB) {
		double rA, xDiff, yDiff;

		this.accelerationX = 0;
		this.accelerationY = 0;

		if (otherA != null) {
			xDiff = otherA.getX() - driven.getX();
			yDiff = otherA.getY() - driven.getY();
			rA = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
			this.accelerationX += ThreeBody.G * otherA.getMass() * xDiff / rA / (rA * rA);
			this.accelerationY += ThreeBody.G * otherA.getMass() * yDiff / rA / (rA * rA);
		}
		
		if (otherB != null) {
			xDiff = otherB.getX() - driven.getX();
			yDiff = otherB.getY() - driven.getY();
			rA = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
			this.accelerationX += ThreeBody.G * otherB.getMass() * xDiff / rA / (rA * rA);
			this.accelerationY += ThreeBody.G * otherB.getMass() * yDiff / rA / (rA * rA);
		}
		
		
	}

	//********************************

	public static void go(Body bodyA, Body bodyB, Body bodyC, double timeIncr) {
		Body bodyAm = new Body();
		bodyAm.setEqual(bodyA);
		Body bodyBm = new Body();
		bodyBm.setEqual(bodyB);
		Body bodyCm = new Body();
		bodyCm.setEqual(bodyC);
		
		/*if (bodyA != null)
		{
		  bodyA.getDrive().setAcceleration(bodyA, bodyB, bodyC);
		  bodyA.setEqual(bodyA.go(timeIncr));
		}
		
		if (bodyB != null)
		{
		  bodyB.getDrive().setAcceleration(bodyB, bodyA, bodyC);
		  bodyB.setEqual(bodyB.go(timeIncr));
		}
		
		if (bodyC != null)
		{
		  bodyC.getDrive().setAcceleration(bodyC, bodyA, bodyB);
		  bodyC.setEqual(bodyC.go(timeIncr));
		}*/
		
		if (bodyA != null)
		{
		  bodyA.getDrive().setAcceleration(bodyA, bodyB, bodyC);
		  bodyAm = bodyA.go(0.5 * timeIncr);
		}
		if (bodyB != null)
		{
		  bodyB.getDrive().setAcceleration(bodyB, bodyA, bodyC);
		  bodyBm = bodyB.go(0.5 * timeIncr);
		}
		if (bodyC != null)
		{
			bodyC.getDrive().setAcceleration(bodyC, bodyB, bodyA);
			bodyCm = bodyC.go(0.5 * timeIncr);
		}

		if (bodyA != null && bodyAm != null)
		{
		  bodyAm.getDrive().setAcceleration(bodyAm, bodyBm, bodyCm);
		  bodyA.setDrive(bodyAm.getDrive());
		  bodyA.setEqual(bodyA.go(timeIncr));
		}
		if (bodyB != null && bodyBm != null)
		{
		  bodyBm.getDrive().setAcceleration(bodyBm, bodyAm, bodyCm);
		  bodyB.setDrive(bodyBm.getDrive());
		  bodyB.setEqual(bodyB.go(timeIncr));
		}
		if (bodyC != null && bodyCm != null)
		{
		  bodyCm.getDrive().setAcceleration(bodyCm, bodyBm, bodyAm);
		  bodyC.setDrive(bodyCm.getDrive());
		  bodyC.setEqual(bodyC.go(timeIncr));
		}

	}

	//********************************

	public static void print(Body bodyA, Body bodyB, Body bodyC, double time) {
		String formatSpec = "%-8.0f%-7.1f %-7.1f%-7.1f%-7.1f%-7.1f%-7.1f\n";
		double aX, aY, bX, bY, cX, cY;
		
		aX = Math.round(bodyA.getX() * ThreeBody.scale);
		aY = Math.round(bodyA.getY() * ThreeBody.scale);
		bX = Math.round(bodyB.getX() * ThreeBody.scale);
		bY = Math.round(bodyB.getY() * ThreeBody.scale);
		cX = Math.round(bodyC.getX() * ThreeBody.scale);
		cY = Math.round(bodyC.getY() * ThreeBody.scale);
		
		System.out.printf(formatSpec, time, aX, aY,	bX, bY,	cX, cY);
	}
}
