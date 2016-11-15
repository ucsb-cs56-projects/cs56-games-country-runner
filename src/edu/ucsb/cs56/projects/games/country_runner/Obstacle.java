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
        //speed and occruance depends on difficulty level
    protected double speed = 10.0;
    /*occurance and counter are used for timing, 
     *negative occurance indicates this obstacle will not present
      need better implementation for more precise timing */
    protected int occurance = 12;
    protected int counter;
    protected Boolean waiting;
    //The sequence that holds the running images
    protected SpriteSequence runningSequence;
    protected double initialXPosition;
    //holds score for amount of times user jumped over this object
    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    int score;
    
    public Obstacle(int xInit, 
			    	int yInit, 
			    	double initialXPosition1, 
			    	String sheet)
    {
    	//Call super constructor
    	super(xInit, yInit, initialXPosition1, sheet);
		//Initilize the sequence
		runningSequence = new SpriteSequence();

        initialXPosition = initialXPosition1;
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

    public void updateCurrentPosition()
    {
        //Right now, using the actual size of the window.
        //Will want to change this later...
    //todo: factor timer function out; make it more time precise 
        if (occurance > 0)
        {
            if (waiting)
            {
                if (counter > 0)
                    counter--;
                else
                    waiting = false;
            }
            else
            {
                this.setX(this.getX() + speed);
                if (this.getX() == 600)
                {
                    this.setX(initialXPosition);
                    score++;
                    counter = randomWithRange(occurance, occurance+100);
                    waiting = true;
                }
            }
        }
    }
}

