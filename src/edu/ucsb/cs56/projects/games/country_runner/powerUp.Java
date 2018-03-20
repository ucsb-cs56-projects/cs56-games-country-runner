package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**Represents the powerUp object on the CountryRunnerJPanel
 * @author Anna Lee
 * @version cs56, F17
 *
 */
public class powerUp extends Obstacle
{
    //initialXPosition goes into the super constructor
    private static double initialX;
    private static int xPosition;
    private static int yPosition;
    private double t; //time
    //the speed of powerUp object
    private static final double speed = 10.0;
    //the amount of time that powerUp is in effect
    private static final int powerUpInterval = 1000;
    //holds the start time of the powerUp
    private static int startTime = 0;
    
    
    /** Default Constructor makes a powerUp object.
     * sets up the spriteSheet and fills the
     * sequences with images from it, takes difficulty
     * as parameter
     * @param difficulty
     */
    public powerUp(int difficulty)
    {
        //x&y dimensions, sheet name are placeholders, will add sheet later
        super(50, 50, -100, "invincibleSheet");
        this.setY(GROUND - 280); //to be tested once spritesheet is uploaded
        switch (difficulty)
        {
            case 1: {
                occurance = 50;
                break;
            }
            case 2: {
                occurance = 40;
                break;
            }
            case 3: {
                occurance = 30;
                break;
            }
        }
        waiting = true;
        counter = randomWithRange(occurance, occurance + 100);
        score = 0;
    }
    
    /** public boolean powerUpOver()
     * determines if you can die based on
     * the last powerUp that was obtained and the powerUpInterval
     */
    public boolean powerUpOver()
    {
        if((int)System.currentTimeMillis() - startTime > powerUpInterval)
            return true;
        return false;
    }
    
    /** getScore
     *  returns 0. Probably shouldn't. lol
     */
    public int getScore()
    {
        return 0;
    }
    
    /** updateCurrentPosition
     * Moves the bullet to left until it is off screen.
     */
    public void updateCurrentPosition()
    {
        if(!offTheScreen())
            xPosition = xPosition + (int)speed;
        this.setX(xPosition);
        t++;
    }
    
    /** public boolean offTheScreen()
     * checks if the bullet is off the screen
     */
    public boolean offTheScreen()
    {
        if((int)this.getX() > 0 || xPosition > 0)
            return true;
        return false;
    }
}
