import java.awt.geom.Point2D;

public class EnemyBot {
	private double bearing;
	private double distance;
	private double heading;
	private double velocity;
	private double energy;
	private boolean alive;
	private String name;
	private Point2D.Double pos;

	public double getBearing() {
		return bearing;
	}
	public double getDistance() {
		return distance;
	}
	public double getHeading() {
		return heading;
	}
	public double getVelocity() {
		return velocity;
	}
	public double getEnergy() {
		return energy;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setDead() {
		alive = false;
	}
	public String getName() {
		return name;
	}
	public Point2D.Double getPos() {
		return pos;
	}
	
	public EnemyBot (double bearing, double distance, double heading, double velocity, double energy, String name, Point2D.Double pos) {
		this.bearing = bearing;
		this.distance = distance;
		this.heading = heading;
		this.velocity = velocity;
		this.energy = energy;
		this.alive = true;
		this.name = name;
		this.pos = pos;
	}
	
	public EnemyBot (double energy, String name, Point2D.Double pos) {
		this.energy = energy;
		this.alive = true;
		this.name = name;
		this.pos = pos;
	}
	
	public EnemyBot() {
		this.alive = false;
	}
}
