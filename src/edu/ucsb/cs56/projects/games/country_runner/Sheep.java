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
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
   This class makes the Sheep for the Country Runner game
   @author Mathew Glodack, Christina Morris
   @version cs56 S13 proj3
*/

public class Sheep extends Obstacles {
    


    /** Constructor for the Circle
     *@param width sets the width
     *@param height sets the height
     */

    public Sheep(double width, double height){
	super(width, height);

	Ellipse2D.Double body = 
	    new Ellipse2D.Double(getX(),getY(), width + 10 , height);
	Ellipse2D.Double head = 
	    new Ellipse2D.Double(getX() + 30, getY() , width/2 , height/2);
	Line2D.Double leftBackLeg =
            new Line2D.Double (getX() + 2.5, getY() + 18, getX() , getY() + 28);
	Line2D.Double rightBackLeg =
            new Line2D.Double (getX() + 5, getY() + 19, getX() + 7.5, getY() + 29);
	Line2D.Double leftFrontLeg =
            new Line2D.Double (getX() + 22.5, getY() + 18, getX() + 20, getY() + 28);
	Line2D.Double rightFrontLeg =
            new Line2D.Double (getX() + 25, getY() + 19, getX() + 27.5, getY() + 29);

	GeneralPath r = this.get();
	r.append(body, false);
	r.append(head, false);
	r.append(leftBackLeg, false);
	r.append(rightBackLeg, false);
	r.append(leftFrontLeg, false);
	r.append(rightFrontLeg, false);
    }

    /**This method moves the Sheep
     *@param dx amount x moves, positive moves to the right
     */
	
	public void move(double dx){
	    GeneralPath temp = this.get();
	    Shape t = ShapeTransforms.translatedCopyOf(temp, dx, 0);
	    this.set(new GeneralPath(t));
	    setX(dx);

	}

	
    }
