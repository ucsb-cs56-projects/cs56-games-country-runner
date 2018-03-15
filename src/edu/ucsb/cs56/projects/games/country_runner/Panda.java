package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * Obstacles have a score but if you want to,
 * you can create a static int score, which will be
 * easier to maintain and thus easier to load scores
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @author William Huang, Ray Ouyang
 * @version cs56, F16, proj2
 *
 */
public class Panda extends Obstacle
{
    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it with a certain difficulty
     * @param int difficulty
     */
    public Panda(int difficulty)
    {
    	//Call super constructor
    	super(100, 100, ((Math.random()*-800.0)-100) , "pandaSheet");
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
    /** incrementScore increments the Panda's score by 1
     */
    public void incrementScore(){
	score++;
    }
}
