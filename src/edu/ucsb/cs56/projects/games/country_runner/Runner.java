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
    private static final double GROUND = 300.0;
    private static final double TOP_OF_JUMP = 200;
    private double yPosition = GROUND;

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
	//These are the arrayLists that hold all the images for the runner's
	//animation sequences.  They are loaded by reading from the super's
	//spriteSheet (Sprite class)
	//---------------------------------------------------------------------
	//private ArrayList<BufferedImage> runningSequence;  //4 images
	//private Integer currentRunningSequenceIndex = 0;
	private ArrayList<BufferedImage> jumpingSequence;  //? images
	private Integer currentJumpingSequenceIndex = 0;

	private SpriteSequence runningSequence;

    /** Default Constructor makes the Runner
     * sets up the RunnerImageManager with the
     * appropriate resource image
     */
    public Runner()
    {
    	super(X_POSITION, GROUND, "runnerSheet");

		//runningSequence = new ArrayList<BufferedImage>();
		runningSequence = new SpriteSequence();

		//Works
    	for (int i = 0; i < 4; i++)
		{
			this.runningSequence.addImage(getSubImage(i, 0));
		}

    }

	/** updateCurrentSprite
	 * Changes the currentSprite instance variable,
	 * dependent upon the boolean we defined above
	 * This takes needless logic out of the JPanel, because
	 * it will mostly call only this method on the runner
	 * and the runner himself will decide what his image
	 * should be
     */
	public void updateCurrentSprite()
	{
		if (jumpingUp)
		{
			//currentSprite = runnerImageManager.getNextJumpingImage();
			//updateJumpingUp();
		}

		else if (fallingDown)
		{
			//currentSprite = runnerImageManager.getNextJumpingImage();
			//updateFallingDown();
		}

		else
		{
			//currentSprite = runnerImageManager.getNextRunningImage();
		}

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

    /**translateY
     * moves the runner in y direction
     * @param yIncrement, how much to translate by, negative moves up, positive moves down
     */
    public void translateY(double yIncrement)
    {
		GeneralPath temp = this.get();
		Shape t = ShapeTransforms.translatedCopyOf(temp, 0, yIncrement);
		this.set(new GeneralPath(t));

		this.setY(this.getY() + yIncrement);
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