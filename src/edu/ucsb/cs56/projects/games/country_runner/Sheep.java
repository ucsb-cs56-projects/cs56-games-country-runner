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


/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version CS56, W14
 *
 */
public class Sheep extends Sprite
{
	//---------------------------------------------------------------------
	//The X_POSITION - pos. of the Sheep
	//GROUND - the position of the ground, where the Sheep rests
	//TOP_OF_JUMP - How high the Sheep jumps
	//These are values are specific to the window
	//
    //Set the initial y position of the Sheep to GROUND
	//---------------------------------------------------------------------
    private static final double X_POSITION = 20.0;
    private static final double GROUND = 300.0;
    private double yPosition = GROUND;

	//---------------------------------------------------------------------
	//Several booleans that help determine his current image
	//
	//The jumpIncrement may need to be refactored out, but it
	//is how much the Sheep moves in his jump loop
	//---------------------------------------------------------------------
	private boolean running;
	private int jumpIncrement = 1;

	//---------------------------------------------------------------------
	//These are the sequences (arrays) that hold all the images for a
	//specific sequence (running, jumping, etc)
	//---------------------------------------------------------------------
	private SpriteSequence runningSequence;


    /** Default Constructor makes the Sheep
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Sheep()
    {
    	//Open the spriteSheet
    	super(X_POSITION, GROUND, "sheepSheet");

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
	 * it will mostly call only this method on the Sheep
	 * and the Sheep himself will decide what his image
	 * should be
     */
	public void updateCurrentImage()
	{
		setCurrentImage(runningSequence.getNextImage());
	}


}
