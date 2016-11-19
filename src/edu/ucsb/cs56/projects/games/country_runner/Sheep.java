package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Sheep extends Obstacle
{
    public Sheep(int difficulty)
    {
    	//Call super constructor
    	super(100, 50, -100.0, "sheepSheet");
		switch (difficulty)
		{
			case 1: {
			    speed = 7.0;
			    occurance = 5;
			    break;
			}
			case 2: {
			    speed = 10.0;
			    occurance = 15;
			    break;
			}
			case 3: {
			    speed = 10.0;
			    occurance = 10;
			    break;
			}
		}
		waiting = true;
		counter = randomWithRange(occurance, occurance+100);

        score = 0;

    }

    /** setDifficulty
     * set speed and occurance 
     * according to difficulty
     */
    public void setDifficulty(int difficulty) {
	switch (difficulty) {
	case 1: {
	    speed = 7.0;
	    occurance = 5;
	    break;
	}
	case 2: {
	    speed = 10.0;
	    occurance = 15;
	    break;
	}
	case 3: {
	    speed = 10.0;
	    occurance = 10;
	    break;
	}
	}
	waiting = true;
	counter = randomWithRange(occurance, occurance+100);
    }
}
