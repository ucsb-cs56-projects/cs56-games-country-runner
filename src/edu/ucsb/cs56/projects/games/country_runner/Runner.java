package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**Draws the runner object on the screen
 * @author Christina Morris, Mathew Glodack
 * @version CS56, S13, project3
 *
 */

public class Runner extends GeneralPathWrapper implements Shape {

    private static final double x = 500.0;
    private double y = 300.0;
    private static final double GROUND = 300.0;

    /** Default Constructor makes the Runner
     */
    public Runner(){

	Ellipse2D.Double head = new Ellipse2D.Double(x-5, y, 10, 10);
	Line2D.Double body =
            new Line2D.Double (x, y + 10, x , y + 30);
	Line2D.Double upperLeftArm =
            new Line2D.Double (x, y + 15, x -5 , y + 20);
	Line2D.Double lowerLeftArm =
            new Line2D.Double (x - 5, y + 20, x-10 , y + 15);
	Line2D.Double upperRightArm =
            new Line2D.Double (x, y + 15, x + 5 , y + 20);
	Line2D.Double lowerRightArm =
            new Line2D.Double (x + 5, y + 20, x , y + 25);
	Line2D.Double upperLeftLeg =
            new Line2D.Double (x, y + 30, x-5 , y + 40);
Line2D.Double lowerLeftLeg =
            new Line2D.Double (x -5, y + 40, x , y + 50);
Line2D.Double upperRightLeg =
            new Line2D.Double (x, y + 30, x + 5 , y + 40);
Line2D.Double lowerRightLeg =
            new Line2D.Double (x + 5, y + 40, x + 15 , y + 45);

	GeneralPath r = this.get();
	r.append(head, false);
	r.append(body, false);
	r.append(upperLeftArm, false);
	r.append(lowerLeftArm, false);
	r.append(upperRightArm, false);
	r.append(lowerRightArm, false);
	r.append(upperLeftLeg, false);
	r.append(lowerLeftLeg, false);
	r.append(upperRightLeg, false);
	r.append(lowerRightLeg, false);
    }
	public double getX(){ return this.x;}
	public double getY(){ return this.y;}

    /**
       @param dy delta y, how much to translateY by, negative moves up, positive moves down
    */
    public void translateY(double dy)
    {
		GeneralPath temp = this.get();
		Shape t = ShapeTransforms.translatedCopyOf(temp, 0, dy);
		this.set(new GeneralPath(t));

		this.y = y+dy;
    }

    /**Check whether the Runner is on the ground
     */
    public boolean isOnGround()
    {
		if ( this.y == GROUND )
		{
			return true;
		}
		return false;
    }
}


