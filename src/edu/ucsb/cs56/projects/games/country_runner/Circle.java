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
    public class Circle extends Obstacles{
    
    public Circle(double width, double height){
	super(width, height);

	Ellipse2D.Double c = 
	    new Ellipse2D.Double(getX(),getY(), width, height);

	GeneralPath r = this.get();
	r.append(c, false);
    }

    }
