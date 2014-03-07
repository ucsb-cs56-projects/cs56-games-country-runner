package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

//imports for the images
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

	private static BufferedImage spriteSheet;
	BufferedImage currentImage;
	public int tileSize;
	//---------------------------------------------------------------------
	//Every class that inherites from this class will have some number of
	//arraylists for animation.  They will be loaded from the spriteSheet
	//and the getNextImage will cycle through them, using a saved index
	//value.  It  will look like this:
		//ArrayList<BufferedImage>sequenceName;
		//Integer currentSequenceNameIndex = 0;
	//---------------------------------------------------------------------


	/** Constuctor for the Sprite
	*	creates a generic sprite instance at an initial (x,y) position
	*	and the name of the sprite sheet it uses.
	* 	Loads and manages a sprite sheet
	*	cause we aren't sure ahead of tiem how many images
	*	each sprite will have
	*/
	public Sprite(double x, double y, String sheetName)
	{
		this.xPosition = x;
		this.yPosition = y;

		//If we ever need a bigger Sprite, make a 2nd constructor that take
		//this as param and you choose the tile size.
		//The size of the sheet is YOUR job to not derp up.
		//Sheet dimensions HAVE to be divisible by tilesize
		tileSize = 64;
		try {
			spriteSheet = ImageIO.read(new File("res/" + sheetName + ".png"));
		}
	    catch (IOException e) {
	        //e.printStackTrace();

	        //While testing, use this so that testing objects
	        //do not have to be initialized to an actual image
	        if(sheetName == null)
	        {
	            return;
	        }
		}
	}

	/** Returns a single image, pulled
	* from the sprite sheet
  	*/
    public BufferedImage getSubImage(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * tileSize, yGrid * tileSize, tileSize, tileSize);
    }

    /** getNextImage
	 * retrieves the next image from whatever sequence
	 * the sprite is looping through.  Makes this image
	 * the currentSprite
	 */
	public BufferedImage getNextImage(ArrayList<BufferedImage>sequence, Integer currentSequenceIndex)
	{
		//Fancy auto-unboxing
		int nextIndex = currentSequenceIndex + 1;
		if (nextIndex == sequence.size()) nextIndex = 0;

		nextIndex = 0;

		BufferedImage nextImage = sequence.get(nextIndex);

		//Fancy auto-boxing
		currentSequenceIndex = nextIndex;
		return nextImage;
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

	/** @return returns the sprite's current Image that is
	*	that is ready to be displayed
	*/
	public BufferedImage getCurrentImage()
	{
		return this.currentImage;
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

	/** sets the sprite's current Image that is
	*	that is ready to be displayed
	*/
	public void setCurrentImage(BufferedImage newImage)
	{
		this.currentImage = newImage;
	}

}