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
    /** Sheep Constructor creates a sheep object
     *  based on the passed parameter difficulty
     *  @param difficulty is converted based on int
     */
    public Sheep(int difficulty)
    {
        //Call super constructor
        super(100, 50, ((Math.random()*-800.0)-100), "sheepSheet");
        switch (difficulty)
        {
            case 1: {
                speed = 7.0;
                occurance = 5;
                break;
            }
            case 2: {
                speed = 10.0;
                occurance = 10;
                break;
            }
            case 3: {
                speed = 12.0;
                occurance = 15;
                break;
            }
        }
        waiting = true;
        counter = randomWithRange(occurance, occurance+100);

        score = 0;
    }

    public void incrementScore(){
        score++;
    }
}
