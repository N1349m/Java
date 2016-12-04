
public class Body {
	private double mass = 0.0;
	private double x = 0.0;
	private double y = 0.0;
	private double vx = 0.0;
	private double vy = 0.0;
	private ThreeBody drive;

	//******************************

	public Body(double mass, double x, double y, double vx, double vy) {
		this.mass = mass;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;

		this.drive = new ThreeBody();
		drive.setVelocityX(vx);
		drive.setVelocityY(vy);
	}

	//******************************
	
	public Body() {
		
	}
	
	//******************************
	
	public double getX() {
		return x;
	}

	//******************************

	public double getY() {
		return y;
	}

	//******************************

	public double getVx() {
		return vx;
	}

	//******************************

	public double getVy() {
		return vy;
	}

	//******************************

	public double getMass() {
		return mass;
	}

	//******************************

	public ThreeBody getDrive() {
		return drive;
	}

	//******************************

	public void setDrive(ThreeBody drive) {
		this.drive = drive;
	}

	//******************************

	public void setEqual(Body otherBody) {
		this.x = otherBody.getX();
		this.y = otherBody.getY();
		this.vx = otherBody.getVx();
		this.vy = otherBody.getVy();
		this.drive = otherBody.getDrive();
	}

	//******************************

	public Body go(double timeIncr) {
		double dX, dY, dVx, dVy;
		
		dX = timeIncr * drive.getVelocityX();
		dY = timeIncr * drive.getVelocityY();
		dVx = timeIncr * drive.getAccelerationX();
		dVy = timeIncr * drive.getAccelerationY();
		
		return new Body(this.mass, x+dX, y+dY, vx+dVx, vy+dVy);
	}
}
