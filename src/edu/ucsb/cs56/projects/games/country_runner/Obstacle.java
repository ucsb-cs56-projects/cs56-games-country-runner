package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Obstacle extends Sprite
{
    //The sequence that holds the running images
    private SpriteSequence runningSequence;
    //holds score for amount of times user jumped over this object
    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    int score;
    public Obstacle(int xInit, 
			    	int yInit, 
			    	double initialXPosition, 
			    	String sheet)
    {
    	//Call super constructor
    	super(xInit, yInit, initialXPosition, sheet);
		//Initilize the sequence
		runningSequence = new SpriteSequence();

		//Fill the sequence
		//NOTE: we have to explicitly say the number of
		//images in the sequence
		int numImages = 4;
    	for (int i = 0; i < numImages; i++)
		{
			this.runningSequence.addImage(getSubImage(i, 0));
		}
        score = 0;
    }

	/** updateCurrentImage
	 * Moves to the next image in the running sequence
     */
	public void updateCurrentImage()
	{
		setCurrentImage(runningSequence.getNextImage());
	}

    public int getScore() {
        return score;
    }

    int randomWithRange(int min, int max)
    {
	int range = (max - min) + 1;     
	return (int)(Math.random() * range) + min;
    }
    
}

