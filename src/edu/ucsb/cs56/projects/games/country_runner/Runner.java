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
    private static final double X_POSITION = 500.0;
    private static final double GROUND = 300.0;
    //Set the initial y position to GROUND
    private double yPosition = GROUND;

	private RunnerImageManager runnerImageManager;
	private boolean running;
	private boolean jumping;

	private BufferedImage currentSprite;


    /** Default Constructor makes the Runner
     */
    public Runner()
    {
		runnerImageManager = new RunnerImageManager("runnerSheet");
    }

	public void updateCurrentSprite()
	{
		currentSprite = runnerImageManager.getNextRunningImage();

	}

    public BufferedImage getCurrentSprite()
    {
	    return currentSprite;
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


