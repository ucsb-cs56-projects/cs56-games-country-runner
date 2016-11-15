package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Raccoon extends Obstacle
{
    //initialXPosition goes into the super constructor
    private static final double initialXPosition = -100.0;

    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Raccoon(int difficulty)
    {
    	//Call super constructor
    	super(100, 109, initialXPosition, "raccoonSheet");
		switch (difficulty) {
		    case 1: {
			speed = 0.0;
			occurance = -1;
			break;
		    }
		    case 2: {
			speed = 20.0;
			occurance = 30;
			break;
		    }
		    case 3: {
			speed = 30.0;
			occurance = 60;
			break;
		    }
	    }
	    waiting = true;
	    counter = randomWithRange(occurance, occurance+100);
    }
}


