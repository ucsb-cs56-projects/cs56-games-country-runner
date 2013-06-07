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
   This class makes the JPanel for the Country Runner game
   @author Mathew Glodack, Christina Morris
   @version cs56 S13 proj3
*/

public class Circle extends Obstacles {
    
    
    
    /** Constructor for the Circle
     *@param width sets the width
     *@param height sets the height
     */
    
    public Circle(double width, double height){
	super(width, height);
	
	Ellipse2D.Double c =
	    new Ellipse2D.Double(getX(),getY(), width, height);
	
	GeneralPath r = this.get();
	r.append(c, false);
    }
    
    /**This method moves the Circle
     *@param dx amount x moves, positive moves to the right
     */
    
    public void move(double dx){
	GeneralPath temp = this.get();
	Shape t = ShapeTransforms.translatedCopyOf(temp, dx, 0);
	this.set(new GeneralPath(t));
	setX(dx);
	
    }
    
    
}
