package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Snail extends Obstacle
{

    private static final double initialXPosition = -100.0;

    //holds score for amount of times user jumped over this object

    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Snail(int difficulty)
    {
    	//Call super constructor
    	super(100, 50, initialXPosition, "snailSheet");
		switch (difficulty) {
		    case 1: {
			speed = 10.0;
			occurance = 70;
			break;
		    }
		    case 2: {
			speed = 14.0;
			occurance = 50;
			break;
		    }
		    case 3: {
			speed = 10.0;
			occurance = 35;
			break;
		    }
	    }
	    waiting = true;
	    counter = randomWithRange(occurance, occurance+100);
    }
}


