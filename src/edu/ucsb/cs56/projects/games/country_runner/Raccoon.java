package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @author William Huang, Ray Ouyang
 * @version cs56, F16, proj2
 *
 */
public class Raccoon extends Obstacle
{
    /** Default Constructor makes the Sheep.
     * sets up the spriteSheet and fills the
     * sequences with images from it with the given
     * difficulty
     * @param difficulty
     */
    public Raccoon(int difficulty)
    {
        //Call super constructor
        super(100, 109, ((Math.random()*-800.0)-100), "raccoonSheet");
        switch (difficulty)
        {
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
        score = 0;
    }
    /** incrementScore increments the score by 1
     */
    public void incrementScore(){
        score++;
    }
}
