package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

//imports for the sprites
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**Sprite an abstract class form which all particular sprites inherit.
 * @author Sidney Rhoads, Tom Craig
 * @version CS56, W14
 */

public class Sprite extends GeneralPathWrapper implements Shape
{
	double xPosition;
	double yPosition;
	BufferedImage currentImage;
	ImageManager spriteImageManager; 
	
	/** Constuctor for the Sprite
	*	creates a generic sprite instance at an initial (x,y) position
	*	and the name of the sprite sheet it uses
	*/	
	public Sprite(double x, double y, String sheetName)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.spriteImageManager = new ImageManager(sheetName);
	}
	/** @return returns the sprite's current x position on JPanel
	* 	
	*/
	public double getX()
	{
		return this.xPosition;
	}
	/** @return returns the sprite's current y position on JPanel
	* 	
	*/
	public double getY()
	{
		return this.yPosition;
	}
	
	/** sets the sprite's current x position on JPanel
	* 	
	*/
	public void setX(double newXPosition)
	{
		this.xPosition = newXPosition;
	}
	/** sets the sprite's current y position on JPanel
	* 	
	*/
	public void setY(double newYPosition)
	{
		this.yPosition = newYPosition;
	}
	
	/** @return returns the sprite's current Image that is 
	*	that is ready to be displayed  
	*/
	public BufferedImage getCurrentImage()
	{
		return this.currentImage;
	}
	
	/** sets the sprite's current Image that is 
	*	that is ready to be displayed  
	*/
	public void setCurrentImage(BufferedImage newImage)
	{
		this.currentImage = newImage;
	}
	
}