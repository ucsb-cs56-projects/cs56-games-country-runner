
package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors

/**
   Some static methods for transforming objects that implement
   the java.awt.Shape interface
   
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   @see java.awt.Shape
*/

public class ShapeTransforms
{  
    /** A static method to flip a shape horizontally
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @return A copy of the Shape, flipped vertically
     */
    public static Shape horizontallyFlippedCopyOf(Shape s) 
    { return scaledCopyOf(s, -1, 1);}

    /** A static method to flip a shape horizontally
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @return A copy of the Shape, flipped vertically
     */

    public static Shape verticallyFlippedCopyOf(Shape s) 
    {  return scaledCopyOf(s, 1, -1); }

    /** A static method to translate a shape
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @param tx how far to translate in x direction
     * @param ty how far to translate in y direction
     * @return A copy of the Shape, translated
     */

    public static Shape translatedCopyOf(Shape s, double tx, double ty) 
    { 
	AffineTransform af = new AffineTransform();   
	af.translate(tx, ty);
	return af.createTransformedShape(s);         
    }
     
    /** A static method to scale a shape with respect to the upper left hand corner of its bounding box.
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @return A copy of the Shape, scaled with respect to its upper left corner    */

    public static Shape scaledCopyOf(Shape s, double sx, double sy)
    {       
	AffineTransform af = new AffineTransform();   
	Rectangle2D box = s.getBounds2D(); 
       
	double x = box.getX();
	double y = box.getY();

	// Note: the transformations get applied IN REVERSE ORDER!
	af.translate(x,y);
	af.scale(sx, sy);
	af.translate(-x, -y);
             
	return af.createTransformedShape(s);
    }


    /** A static method to scale a shape with respect to the lower left hand corner of its bounding box.
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @return A copy of the Shape, scaled with respect to its upper left corner    */

    public static Shape scaledCopyOfLL(Shape s, double sx, double sy)
    {       
	AffineTransform af = new AffineTransform();   
	Rectangle2D box = s.getBounds2D(); 
       
	double x = box.getX(); 
	double y = box.getY() + box.getHeight();

	// Note: the transformations get applied IN REVERSE ORDER!
	af.translate(x,y);
	af.scale(sx, sy);
	af.translate(-x, -y);
             
	return af.createTransformedShape(s);
    }


    /** A static method to rotate a shape around its center 
     *
     * @param s  A shape (could be a Rectangle, GeneralPath, etc.--anything
     *    that implements the Shape interface )
     * @return A copy of the Shape, rotated around its center     */

    public static Shape rotatedCopyOf(Shape s, double angleInRadians)
    {
	AffineTransform af = new AffineTransform();   
	Rectangle2D box = s.getBounds2D(); 
       
	double cx = box.getCenterX();
	double cy = box.getCenterY();

	// NOTE: The transformations get applied IN REVERSE ORDER
	af.translate(cx,cy);
	af.rotate(angleInRadians);
	af.translate(-cx, -cy);
             
	return af.createTransformedShape(s);
    }
  
}