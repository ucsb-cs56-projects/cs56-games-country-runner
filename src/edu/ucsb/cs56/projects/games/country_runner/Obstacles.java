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

public class Obstacles extends GeneralPathWrapper implements Shape{

    private double x;
    private double y;
    private double width;
    private double height;

    public double getX(){return this.x;}
    public double getY(){return this.y;}
    
    public void move(double x){this.x+=x;}
   
    public Obstacles(double width, double height){
	this.x = 0; 
	this.y=300;
	this.width = width; 
	this.height = height;
    }

}
