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
	//The X_POSITION - pos. of the runner
	//The yPosition will get set to GROUND in the
	//super constructor
    private static final double X_POSITION = 500.0;
    private double yPosition;

	//Several booleans that help determine his current
	//image and position
	//This constitutes the runner's "state"
	private boolean running;
	private boolean jumping;
	private boolean falling;
	private double jumpDistance;

	//These are the sequences (arrays) that hold all the
	//images for a specific sequence (running, jumping, etc)
	private SpriteSequence runningSequence;


    /** Default Constructor makes the Runner
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Runner()
    {
    	//Open the spriteSheet
    	super(X_POSITION, "runnerSheet");

		//Set up his initial state
    	this.running = true;
    	this.jumping = false;
    	this.falling = false;
    	this.jumpDistance = 20.0;

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

	/** updateCurrentPosition
	 * Unlike the sheep, the runner will only ever move
	 * up and down (if he is jumping/falling).  We can call
	 * updateJumpPosition because it will test if he is
	 * jumping or falling internally.
     */
    public void updateCurrentPosition()
    {
		updateJumpPosition(100);
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
		if (this.running)
		{
			setCurrentImage(runningSequence.getNextImage());
		}

		//When the sprites sheets are all done, these will
		//actual update with the jumping and falling sequences
		else if (this.jumping)
		{
			setCurrentImage(runningSequence.getNextImage());
		}
		else if (this.falling)
		{
			setCurrentImage(runningSequence.getNextImage());
		}
	}

	/** startJump
	 * Called by the JPanel, changes the runner's state so he
	 * knows he should be jumping when the image gets updated
	 */
	public void startJump()
	{
		this.jumping = true;
		this.running = false;
	}

	/** updateJumpPosition
	 * this is called by updateCurrentPosition
	 * to make the jump happen.  It detemrines the current
	 * position of the runner and moves him approriately.
	 */
	public void updateJumpPosition(int topOfJump)
	{
		//If he is moving updward, and not at the
		//peak of his jump, move him more up
		if (this.jumping)
		{
			//If he is at the top, change
			//state appropriately
			if (this.getY() <= topOfJump)
		    {
			    this.jumping = false;
			    this.falling = true;
		    }
		    else
		    {
		    	this.jumpDistance -= .30;
				this.setY((this.getY() - this.jumpDistance));
			}
		}

		//If he is falling down, and not at the
		//ground, keep moving down
		else if (this.falling)
		{
			//If he is at the ground, change
			//state appropriately
			if (this.isOnGround())
		    {
		    	this.jumpDistance = 15.0;
			    this.falling = false;
			    this.running = true;
		    }
		    else
		    {
		    	this.jumpDistance += .30;
				this.setY((this.getY() + this.jumpDistance));
		    }
		}
    }

    /** isOnGround
     * Check whether the Runner is on the ground
     * Just checks if the runner position is the same
     * as the predefined ground coordinate (From sprite)
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