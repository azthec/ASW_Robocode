package ruibalau;

public class GravPoint {
	public double x;
	public double y;
	public double strength;
	public long ctime;
	public long ttl;
	
	public GravPoint(double x, double y, double strength, long ctime, long ttl) {
		this.x = x;
		this.y = y;
		this.strength = strength;
		this.ctime = ctime;
		this.ttl = ttl;
	}

	 public boolean dead(long time) {
	 	return (ctime + ttl) < time;
	 }
}