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
 * @version CS56, W14, proj2
 */
public abstract class Sprite extends GeneralPathWrapper implements Shape
{
    //The GROUND, where the sprites rest. Note
    //that this is also defined in the JPanel
    //x and y positions that every sprite needs
    final double GROUND = 366.0;
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

    /*
      --------------------------------------------------------------------
      IMPLEMENTATION NOTE:
      Every class that inherites from this class will have some number of
      SpriteSequences for animation.  The sprite sequence class is
      essentially an arrayList and a saved index.
      Later on, the sprites will call the getNextImage() method to
      update the sequences.  The runner for example has this object:
      [runningSequence = new SpriteSequence();]
      --------------------------------------------------------------------
    */


    /** Constuctor
     * creates a generic sprite instance at an initial (x,y) position
     * and the name of the sprite sheet it uses.
     * Loads and manages a sprite sheet
     * cause we aren't sure ahead of time how many images
     * each sprite will have
     * Different sprites can have different tile sizes,
     * so we take the tile size as an input
     */
    public Sprite(int xTileSize, int yTileSize, double x, String sheetName)
    {
	//Setting up tile sizes and position
	this.xTileSize = xTileSize;
	this.yTileSize = yTileSize;
	this.xPosition = x;
	//They always start at the ground
	this.yPosition = GROUND - this.getHeight();

	//Loading the spriteSheet
	try
	    {
		spriteSheet = ImageIO.read(new File("res/" + sheetName + ".png"));
	    }
	catch (IOException e)
	    {
	    	//This line for testing...
	        //e.printStackTrace();

	        //While testing, use this so that testing objects
	        //do not have to be initialized to an actual image
	        if(sheetName == null)
		    {
			return;
		    }
	    }
    }
    //constructor for sprites without spritesheet
    public Sprite(int xTileSize, int yTileSize, double x, double y)
    {
	//setting up tile and sizes and position
	this.xTileSize = xTileSize;
	this.yTileSize = yTileSize;
	this.xPosition = x;
	this.yPosition = y;
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
    public abstract int getScore();
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

    /** getSubImage
     * Returns a single image, pulled
     * from the sprite sheet
     */
    public BufferedImage getSubImage(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * xTileSize, yGrid * yTileSize, xTileSize, yTileSize);
    }

    /** getX
     * @return returns the sprite's current x position on JPanel
     *
     */
    public double getX()
    {
	return this.xPosition;
    }
    /** getY
     * @return returns the sprite's current y position on JPanel
     *
     */
    public double getY()
    {
	return this.yPosition;
    }

    /** getCurrentImage
     * returns the sprite's current Image that is
     *	that is ready to be displayed
     */
    public BufferedImage getCurrentImage()
    {
	return this.currentImage;
    }

    /** setX
     * sets the sprite's current
     * x position on JPanel
     */
    public void setX(double newXPosition)
    {
	this.xPosition = newXPosition;
    }

    /** setY
     * sets the sprite's current y position on JPanel
     */
    public void setY(double newYPosition)
    {
	this.yPosition = newYPosition;
    }

    /** setCurrentImage
     * sets the sprite's current Image that is
     *	that is ready to be displayed
     */
    public void setCurrentImage(BufferedImage newImage)
    {
	this.currentImage = newImage;
    }
}
