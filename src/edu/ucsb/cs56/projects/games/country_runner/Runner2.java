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

/**
 * @author Christina Morris, Mathew Glodack
 * @version CS56, S13, project3
 * Draws the runner object on the screen
 */

public class Runner2 extends GeneralPathWrapper implements Shape {

    private static final double x = 500.0;
    private double y = 300.0;

    /** Default Constructor makes the Runner2
     */

    public Runner2(){

	Ellipse2D.Double head = new Ellipse2D.Double(x-5, y, 10, 10);
	Line2D.Double body =
            new Line2D.Double (x, y + 10, x , y + 30);
	Line2D.Double upperLeftArm =
            new Line2D.Double (x, y + 15, x + 2.5 , y + 22.5);
		Line2D.Double lowerLeftArm =
	 new Line2D.Double (x + 2.5, y + 22.5, x-5 , y + 25);
		//Line2D.Double upperRightArm =
		//new Line2D.Double (x, y + 15, x + 5 , y + 20);
		//Line2D.Double lowerRightArm =
		//new Line2D.Double (x + 5, y + 20, x , y + 25);
		//Line2D.Double upperLeftLeg =
		//new Line2D.Double (x, y + 30, x-5 , y + 40);
		//Line2D.Double lowerLeftLeg =
		//new Line2D.Double (x -5, y + 40, x , y + 50);
Line2D.Double upperRightLeg =
            new Line2D.Double (x, y + 30, x - 2.5 , y + 40);
Line2D.Double lowerRightLeg =
            new Line2D.Double (x  -2.5, y + 40, x + 2.5 , y + 50);
	
	GeneralPath r = this.get();
	r.append(head, false);
	r.append(body, false);
	r.append(upperLeftArm, false);
	r.append(lowerLeftArm, false);
	r.append(upperRightLeg, false);
	r.append(lowerRightLeg, false);
    }
	public double getX(){ return this.x;}
	public double getY(){ return this.y;}

    /**
       @param dy delta y, how much to jump by, negative moves up, positive mves down
    */

    public void jump(double dy){
	GeneralPath temp = this.get();
	Shape t = ShapeTransforms.translatedCopyOf(temp, 0, dy);
	this.set(new GeneralPath(t));

	System.out.println("got into the jump");
	this.y = y+dy;
	System.out.println("y is: " + y);
    }

    /**As soon as the runner gets jumps up
     * it must jump back down to it normal running position
     * @param dy changes the position of the runner back to its normal
     * position
     */
    
    public boolean onGround(){
	if ( this.y == 300.0 )
	    return true;
	return false;
    } 

}
