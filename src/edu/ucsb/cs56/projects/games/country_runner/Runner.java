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
public class Runner extends Sprite
{
	//---------------------------------------------------------------------
	//The X_POSITION - pos. of the runner
	//GROUND - the position of the ground, where the runner rests
	//TOP_OF_JUMP - How high the runner jumps
	//These are values are specific to the window
	//
    //Set the initial y position of the runner to GROUND
	//---------------------------------------------------------------------
    private static final double X_POSITION = 500.0;
    private static final double TOP_OF_JUMP = 200;
    private double yPosition;

	//---------------------------------------------------------------------
	//Several booleans that help determine his current image
	//
	//The jumpIncrement may need to be refactored out, but it
	//is how much the runner moves in his jump loop
	//---------------------------------------------------------------------
	private boolean running;
	private boolean jumpingUp;
	private boolean fallingDown;
	private int jumpIncrement = 1;

	//---------------------------------------------------------------------
	//These are the sequences (arrays) that hold all the images for a
	//specific sequence (running, jumping, etc)
	//---------------------------------------------------------------------
	private SpriteSequence runningSequence;


    /** Default Constructor makes the Runner
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Runner()
    {
    	//Open the spriteSheet
    	super(X_POSITION, "runnerSheet");

		//Initilize the sequences
		runningSequence = new SpriteSequence();

		//Fill the sequences
		//NOTE: we have to explicitly say the number of
		//images in the sequence
		int numImages = 4;
    	for (int i = 0; i < numImages; i++)
		{
			this.runningSequence.addImage(getSubImage(i, 0));
		}

    }

	/** updateCurrentImage
	 * Uses the state values (booleans) to figure out
	 * what the guy should do next.
	 * This takes needless logic out of the JPanel, because
	 * it will mostly call only this method on the runner
	 * and the runner himself will decide what his image
	 * should be
     */
	public void updateCurrentImage()
	{
		/*TESTING THE WITH THE BOOLEANS WILL HAPPEN HERE*/
		//For now, we make him run
		//Could be any number of
		setCurrentImage(runningSequence.getNextImage());
	}

	/** updateJumpingUp
	 * this is called to make the jump happen
	 * NOTE: This is not currently in use, but should
	 * be used when the JPanel multhreading is replaced
	 * with proper timing calculations
	 */
	public void updateJumpingUp()
	{
		this.setY(this.getY() - jumpIncrement);
		if (this.getY() <= TOP_OF_JUMP)
		{
			jumpingUp = false;
			fallingDown = true;
		}
	}

	/** updateFallingDown
	 * (as per above function)
	 * this is called to make the jump happen
	 * NOTE: This is not currently in use, but should
	 * be used when the JPanel multhreading is replaced
	 * with proper timing calculations
	 */
	public void updateFallingDown()
	{
		this.setY(this.getY() + jumpIncrement);
		if (this.getY() >= GROUND)
		{
			jumpingUp = false;
			fallingDown = false;
		}
	}

    /** isOnGround
     * Check whether the Runner is on the ground
     * Just checks if the runner position is the same
     * as the predefined ground coordinate
     */
    public boolean isOnGround()
    {


		if ( this.getY() >= GROUND )
		{
			this.setY(GROUND);
			return true;
		}
		return false;
    }
}