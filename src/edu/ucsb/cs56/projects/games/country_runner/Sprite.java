package edu.ucsb.cs56.projects.games.country_runner;

// combinations of lines and curves
import java.awt.geom.GeneralPath;
// translation, rotation, scale
import java.awt.geom.AffineTransform;
// general class for shapes
import java.awt.Shape;

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
public abstract class Sprite extends GeneralPathWrapper implements Shape
{
	//The ground, where the sprites rest
	//x and y positions that every sprite needs
    final double GROUND = 375.0;
	double xPosition;
	double yPosition;

	//The sheet for the sprite and the current
	//image that is pulled from the sheet
	private static BufferedImage spriteSheet;
	BufferedImage currentImage;
	//Tile size is the size of the subimages in
	//the sprite sheet. The tiles size is YOUR
	//job to not fuck up.  You must make sheets
	//with the proper dimensions that are divisible
	//by the tile sizes
	public int xTileSize;
	public int yTileSize;

	//---------------------------------------------------------------------
	//Every class that inherites from this class will have some number of
	//SpriteSequences for animation.  The sprite sequence class is
	//essentially an arrayList and a saved index.
	//Later on, the sprites will call the getNextImage() method to
	//update the sequences.  The runner for example has this object:
		//runningSequence = new SpriteSequence();
	//---------------------------------------------------------------------


	/** Constuctor for the Sprite
	*	creates a generic sprite instance at an initial (x,y) position
	*	and the name of the sprite sheet it uses.
	* 	Loads and manages a sprite sheet
	*	cause we aren't sure ahead of tiem how many images
	*	each sprite will have
	*/
	public Sprite(int xTileSize, int yTileSize, double x, String sheetName)
	{
		this.xTileSize = xTileSize;
		this.yTileSize = yTileSize;

		this.xPosition = x;
		//They always start at the ground
		this.yPosition = GROUND;

		try
		{
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

	/** updateCurrentPosition
	 * Each class that ISA sprite will have
	 * its own way of updating its position
	 */
	public void updateCurrentPosition()
	{
		//STUB.  This is a placeholder,
		//each subclass will implement this differently
	}

	/** updateCurrentImage
	 * Each class that ISA sprite will have
	 * its own way of updating its image
	 */
	public void updateCurrentImage()
	{
		//STUB.  This is a placeholder,
		//each subclass will implement this differently
	}

	/** getHeight
	 * Returns the yTileSize, which is
	 * synonymous with height
	 */
	public double getHeight()
	{
		return this.yTileSize;
	}

	/** getWidth
	 * Returns the xTileSize, which is
	 * synonymous with width
	 */
	public double getWidth()
	{
		return this.xTileSize;
	}

	/** Returns a single image, pulled
	* from the sprite sheet
  	*/
    public BufferedImage getSubImage(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * xTileSize, yGrid * yTileSize, xTileSize, yTileSize);
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