package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Panda extends Obstacle
{
    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Panda(int difficulty)
    {
    	//Call super constructor
    	super(100, 100, -100.0 , "pandaSheet");			
	    /** setDifficulty
	     * set speed and occurance 
	     * according to difficulty
	     */	    
		switch (difficulty) 
		{
			case 1: {
			    speed = 0.0;
			    occurance = -1;
			    break;
			}
			case 2: {
			    speed = 0.0;
			    occurance = -1;
			    break;
			}
			case 3: {
			    speed = 20.0;
			    occurance = 120;
			    break;
			}
		}
		waiting = true;
		counter = randomWithRange(occurance, occurance+100);
        score = 0;
    }
}

