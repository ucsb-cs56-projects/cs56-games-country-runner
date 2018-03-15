package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;

/**Draws the Sheep object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 */
public class Portal extends Obstacle
{
    /** Sheep Constructor creates a sheep object
     *  based on the passed parameter difficulty
     *  @param difficulty is converted based on int
     */
    public Portal(int appear)
    {
        //Call super constructor
        super(100, 100, "portalSheet1");
        this.setY(GROUND-230);
        occurance = 1;
        waiting = true;
        score = 0;

    }
}
