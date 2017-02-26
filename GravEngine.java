package ruibalau;

import java.util.Vector;
import ruibalau.GravPoint;
import robocode.util.Utils;

/**
 * Force attraction formula is +- gravity
 * Points attraction decay at a power of 2 and walls at a power of 3 (meaning walls decay faster)
 *
 */

public class GravEngine {

	protected Vector<GravPoint> gravPoints = new Vector<GravPoint>();

	protected double width;
	protected double height;

	protected double xForce = 0.0;
	protected double yForce = 0.0;
	
	public GravEngine(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void addPoint(GravPoint g) {
		gravPoints.add(g);
	}
	
	public void update(double curX, double curY, long time) {
		xForce = 0.0;
		yForce = 0.0;
		Vector deadPoints = new Vector();
		GravPoint g;
		double force;
		double angle;
		for(int i=0;i<gravPoints.size();i++) {
			g = (GravPoint) gravPoints.elementAt(i);
			if(g.dead(time)) {
				deadPoints.add(g);
				continue;
			}
			force = g.strength/Math.pow(
								Math.sqrt(Math.pow((curX-g.x), 2) + Math.pow((curY-g.y), 2)),
								2.0);		
			angle = Utils.normalAbsoluteAngle(Math.atan2(g.x-curX,g.y-curY));
			xForce += force * Math.sin(angle);
			yForce += force * Math.cos(angle);
		}
		xForce += 5d/Math.pow(curX, 3.0);
	    xForce -= 5d/Math.pow(width-curX, 3.0);
	    yForce -= 5d/Math.pow(height-curY, 3.0);
	    yForce += 5d/Math.pow(curY, 3.0);
		
		for(int i=0;i<deadPoints.size();i++) {
			gravPoints.remove(deadPoints.elementAt(i));
		}
	}
	
	public double getXForce() {
		return xForce;
	}

	public double getYForce() {
		return yForce;
	}	
	
	// if a bearing is not within the -pi to pi range, alters it to provide the
	// shortest angle
	double normaliseBearing(double ang) {
		if (ang > Math.PI)
			ang -= 2 * Math.PI;
		if (ang < -Math.PI)
			ang += 2 * Math.PI;
		return (ang);
	}
	
}