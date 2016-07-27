package edu.ucsb.cs56.projects.games.country_runner;


/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Snail extends Sprite
{
    //initialXPosition goes into the super constructor
    private static final double initialXPosition = -100.0;

    //speed and occruance depends on difficulty level
    private static double speed = 10.0;
    /*occurance and counter are used for timing, 
     *negative occurance indicates this obstacle will not present
      need better implementation for more precise timing */
    private static int occurance = 12;
    private static int counter;
    private static Boolean waiting;
    
    //The sequence that holds the running images
    private SpriteSequence runningSequence;

    //holds score for amount of times user jumped over this object
    private int score;


    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Snail(int difficulty)
    {
    	//Call super constructor
    	super(100, 50, initialXPosition, "snailSheet");

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
		occurance = 140;
		break;
	    }
	    case 2: {
		speed = 14.0;
		occurance = 90;
		break;
	    }
	    case 3: {
		speed = 14.0;
		occurance = 30;
		break;
	    }
	    }
	    waiting = true;
	    counter = occurance;
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
	//todo: factor timer function out; make it more time precise 
	if (occurance > 0) {
	    if (waiting) {
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
			    counter = occurance;
			    waiting = true;
			}
		}
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


