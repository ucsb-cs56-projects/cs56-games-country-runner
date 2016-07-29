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



/** Runner
 * Draws the runner object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Runner extends Sprite
{
	//The X_POSITION - pos. of the runner
	//The yPosition will get set to GROUND in the
	//super constructor
    private double xPosition = 380.0;
    private double yPosition = 10;
    public double xVel = 0;
	//Several booleans that help determine his current
	//image and position
	//This constitutes the runner's "state"
	private boolean running;
	private boolean jumping;

	//Testing physics equations
	//These are for calculating the runner's jump
	//He has an jump velocity that can be set, and
	//gravity can be changed as well, if needed
	//jumpTime is just incremented in the
	//updateJumpPosition formula to calculate
	//the new position
	private double v;
	private double a;
	private double t;

	//These are the sequences (arrays) that hold all the
	//images for a specific sequence (running, jumping, etc)
	private SpriteSequence runningSequence;


    /** Default Constructor makes the Runner
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Runner(String avatar)
    {
    	//Open the spriteSheet
    	super(100, 109, 480, avatar);

		//Set up his initial state
    	this.running = true;
    	this.jumping = false;
        this.xVel=0;         
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
	 * up and down (if he is jumping).  We can call
	 * updateJumpPosition because it will test if he is
	 * jumping internally.
     */
    public void updateCurrentPosition()
    {
		updateJumpPosition();
                updateMovePosition();
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
		//actual update with the jumping sequences
		else if (this.jumping)
		{
			setCurrentImage(runningSequence.getNextImage());
		}
	}

	/** startJump
	 * Called by the JPanel, changes the runner's state so he
	 * knows he should be jumping when the image gets updated
	 * We set the jumpDistance to be 30, and it will be
	 * reduced as the jump progresses.  This constant can
	 * be altered later
	 */
	public void startJump()
	{
		//If the runnign is in the middle of a jump, no
		//need to change anything about his state
		if (!this.isOnGround())
		{
			return;
		}
	  	//Setting up values for jump
		//this.a=-16;
		//this.v=80;
    	        this.v = 70;
		this.a = -9.8;
		this.t = 0;
		//Setting up boolean for jump
		this.jumping = true;
		this.running = false;
	}
      /**
        called by the jpanel, changes the runner's state so he 
        knows  he should be super jumping when the image gets updated
        we set the jumpDistance to be 60.
      */
    public void superJump()
    { if (!this.isOnGround())
	    return;
	this.a=-16;
        this.v=80;
	this.t=0;
        this.jumping= true;
        this.running=false;
    }

    public void move1()
    { this.xVel=7;}

    public void move2()
    {this.xVel=-9;}
    public void stop()
    {this.xVel=0;}
	/** updateJumpPosition
	 * this is called by updateCurrentPosition
	 * to make the jump happen.  It uses a formula
	 * to move the runner appropriately, and stops
	 * him from jupming if he hits the ground
	 */
	public void updateJumpPosition()
	{
		//Stand back... physics.  This is the position
		//equation: y = y_0 + v_0 + .5*g*t^2, which I
		//hope you learnd in physics 1.  It just finds
		//his correct position, to move him up/down
		double newYPos = 0 + this.v*this.t + .5*this.a*(Math.pow(this.t,2));
		this.setY(this.GROUND - this.getHeight() - newYPos);
		this.t++;

		if (this.isOnGround())
	    {
	    	this.jumping = false;
		this.running = true;
	    }

		//If he happens to fall farther than the ground, this pulls him up the ground
	    else if (this.getY() > (GROUND - this.getHeight()))
		{
			this.setY(GROUND - this.getHeight());
			this.jumping = false;
		    this.running = true;
		}

    }

    /** isOnGround
     * Check whether the Runner is on the ground
     * Just checks if the runner position is the same
     * as the predefined ground coordinate (From sprite)
     */
    public boolean isOnGround()
    {
		if (this.getY() == (GROUND - this.getHeight()))
		{
			return true;
		}
		return false;
    }




public void updateMovePosition()
	{
      	    double newXPos = this.xPosition+this.xVel;
            this.xPosition=newXPos;
	    this.setX(newXPos);
	     

    }
}








