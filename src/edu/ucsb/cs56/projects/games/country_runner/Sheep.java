package edu.ucsb.cs56.projects.games.country_runner;


/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Sheep extends Sprite
{
	//initialXPosition goes into the super constructor
    private static final double initialXPosition = 20.0;

	//The sequence that holds the running images
	private SpriteSequence runningSequence;

    //holds score for amount of times user jumped over this object
    private int score;


    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Sheep()
    {
    	//Call super constructor
    	super(100, 50, initialXPosition, "sheepSheet");

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

	/** updateCurrentPosition
	 * Moves the sheep to left until it is off screen.
	 * Once it is, we mov it back to the left,
	 * simulating a line of sheeps
	*/
	public void updateCurrentPosition()
    {
    	//Right now, using the actual size of the window.
    	//Will want to change this later...
		this.setX(this.getX() + 10);
		if (this.getX() == 600)
		{
			this.setX(-100);
            score++;
		}
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
}


