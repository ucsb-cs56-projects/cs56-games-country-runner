package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Platform object on screen
 * @author Kitty Fung, Priscilla Lee
 * @version cs56, S18
 *
 */
public class Ghost extends Obstacle {
    public Ghost(int difficulty) {
        super(100, 50, -94, "ghostSheet");
	this.setY(GROUND - 180);
        switch (difficulty)
        {
            case 1: {
                speed = 10.0;
                occurance = 30;
                break;
            }
            case 2: {
                speed = 11.0;
                occurance = 30;
                break;
            }
            case 3: {
                speed = 12.0;
                occurance = 40;
                break;
            }
        }
        waiting = true;
        counter = randomWithRange(occurance, occurance + 100); //change to +10 to test
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
	            occurance = 30;
	            break;
	        }
	        case 2: {
	            speed = 11.0;
	            occurance = 30;
	            break;
	        }
	        case 3: {
	            speed = 12.0;
	            occurance = 40;
	            break;
	        }
	    }
	    waiting = true;
	    counter = randomWithRange(occurance, occurance + 100);
    }
    
    /** incrementScore increments the score by one
     */
    public void incrementScore() {
	    score++;
    }

}
