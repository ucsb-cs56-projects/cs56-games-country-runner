package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// next five imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
// end of list of imports needed for implementing Shape


/**
Because GeneralPath is declared as "final", we can't extend it.
That's inconvenient, because if we can declare shapes that
extend GeneralPath, we get all of the methods of GeneralPath that
implement the Shape interface.

That allows us to do graphics transformations like
translating, rotating and scaling (the Affine transforms).

So, GeneralPathWrapper is a wrapper around a GeneralPath object
that we can extend
* @author P. Conrad
* @author Christina Morris, Mathew Glodack
* @version CS56, S13
*/

public class GeneralPathWrapper implements Shape
{
    private GeneralPath gp;
    
    public GeneralPathWrapper() {gp = new GeneralPath();}

    /** If we already have a GeneralPath, we can wrap it. */
    public GeneralPathWrapper(GeneralPath gp) {this.gp = gp;}

    /**
Tests if the specified coordinates are inside the boundary of the
Shape.
*/
   
    public GeneralPath get() {return gp;}
    public void set(GeneralPath gp) {this.gp = gp;}

    public boolean contains(double x, double y) { return gp.contains(x,y); }
    
    /** Tests if the interior of the Shape entirely contains the
* specified rectangular area.
*/

    public boolean contains(double x, double y, double w, double h) { return gp.contains(x,y,w,h); }
    
    /** Tests if a specified Point2D is inside the boundary of
* the Shape.
*/

    public boolean contains(Point2D p) { return gp.contains(p); }
    
    /**
Tests if the interior of the Shape entirely contains the
specified Rectangle2D.
*/
    
    public boolean contains(Rectangle2D r) { return gp.contains(r); }
 
    /** Returns an integer Rectangle that completely encloses the
* Shape.
*/

    public Rectangle getBounds() { return gp.getBounds(); }
    
    /** Returns a high precision and more accurate bounding box
* of the Shape than the getBounds method.
*/

    public Rectangle2D getBounds2D() { return gp.getBounds2D(); }

    /** Returns an iterator object that iterates along the
* Shape boundary and provides access to the geometry of
* the Shape outline.
*/

    public PathIterator getPathIterator(AffineTransform at) { return gp.getPathIterator( at); }
    
    /** Returns an iterator object that iterates along the
* Shape boundary and provides access to a flattened view
* of the Shape outline geometry.
*/
    
    public PathIterator getPathIterator(AffineTransform at, double flatness) { return gp.getPathIterator( at, flatness); }

    /** Tests if the interior of the Shape intersects the
* interior of a specified rectangular area.
*/

    public boolean intersects(double x, double y, double w, double h) { return gp.intersects(x, y, w, h);}

    /** Tests if the interior of the Shape intersects the interior of
* a specified Rectangle2D.
*/

    public boolean intersects(Rectangle2D r) { return gp.intersects(r); }
    
    


}
