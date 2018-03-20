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
    /** Snail Constructor that creates a new Snail object
     *  , which calls the Obstacle constructor,
     *  and bases difciculty based on the int passed
     *  @param difficulty determines speed and occurance
     */
    public Snail(int difficulty)
    {
        //Call super constructor
        super(100, 50, ((Math.random()*-800.0)-100), "snailSheet");
        //initialize
        switch (difficulty) {
            case 1: {
                speed = 10.0;
                occurance = 70;
                break;
            }
            case 2: {
                speed = 14.0;
                occurance = 35;
                break;
            }
            case 3: {
                speed = 17.0;
                occurance = 35;
                break;
            }
        }
        waiting = true;
        counter = randomWithRange(occurance, occurance+100);
        score = 0;
    }
    /** incrementScore increments the score by 1
     */
    public void incrementScore(){
        score++;
    }
}


