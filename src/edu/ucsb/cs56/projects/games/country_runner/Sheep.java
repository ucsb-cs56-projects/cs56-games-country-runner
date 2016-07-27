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
    private static final double initialXPosition = -120.0;

    //depends on difficulty level
    private static double speed = 10.0;
    private static double occurance = -100.0;
    
    //The sequence that holds the running images
    private SpriteSequence runningSequence;

    //holds score for amount of times user jumped over this object
    private int score;


    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Sheep(int difficulty)
    {
    	//Call super constructor
    	super(100, 50, initialXPosition, "sheepSheet");

	//initialize
        score = 0;
	setDifficulty(difficulty);

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

	/** setDifficulty
	 * set speed and occurance 
	 * according to difficulty
	*/
	public void setDifficulty(int difficulty) {
	    switch (difficulty) {
	    case 1: {
		speed = 10.0;
		occurance = -400.0;
		break;
	    }
	    case 2: {
		speed = 10.0;
		occurance = -200.0;
		break;
	    }
	    case 3: {
		speed = 20.0;
		occurance = -100.0;
		break;
	    }
	    }
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
		this.setX(this.getX() + speed);
		if (this.getX() == 600)
		{
			this.setX(occurance);
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


