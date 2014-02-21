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


/**Draws the runner object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version CS56, W14
 *
 */

public class Runner extends GeneralPathWrapper implements Shape
{

	private SpriteSequence sprite;

    private static final double X_POSITION = 500.0;
    private static final double GROUND = 300.0;
    //Set the initial y position to GROUND
    private double yPosition = GROUND;

	//Load the sprite images (soon to be a Spritesheet class)
	//private static ArrayList<BufferedImage> runningImages;
    BufferedImage running0;
    BufferedImage running1;


    /** Default Constructor makes the Runner
     */
    public Runner()
    {
		running0 = sprite.getSprite(0, 0);
		running1 = sprite.getSprite(1, 0);

    }

	/**returns the runner's x position
	*/
	public double getX()
	{
		return this.X_POSITION;
	}

	/**returns the runner's y position
	*/
	public double getY()
	{
		return this.yPosition;
	}
	/**sets the runner's y position to newY
	*/
	public void setY(double newY)
	{
		this.yPosition = newY;
	}

	/**returns the first sprite in running sequence
	*/
	public BufferedImage getRunning0()
	{
		return this.running0;
	}
	/**returns the second sprite in running sequence
	*/
	public BufferedImage getRunning1()
	{
		return this.running1;
	}

    /**moves the runner in y direction
       @param yIncrement, how much to translate by, negative moves up, positive moves down
    */
    public void translateY(double yIncrement)
    {
		GeneralPath temp = this.get();
		Shape t = ShapeTransforms.translatedCopyOf(temp, 0, yIncrement);
		this.set(new GeneralPath(t));

		this.setY(this.getY() + yIncrement);
    }

    /**Check whether the Runner is on the ground
     */
    public boolean isOnGround()
    {
		if ( this.getY() == GROUND )
		{
			return true;
		}
		return false;
    }
}


