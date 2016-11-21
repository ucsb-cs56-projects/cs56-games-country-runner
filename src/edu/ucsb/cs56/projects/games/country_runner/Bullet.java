package edu.ucsb.cs56.projects.games.country_runner;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
/**Draws the Bullet object on the screen
 * @author Christina Morris, Mathew Glodack
 * @author Sidney Rhoads, Tom Craig
 * @author William Huang, Ray Ouyang
 * @version cs56, F16, proj2
 *
 */
public class Bullet extends Obstacle
{
    //initialXPosition goes into the super constructor
    private static double initialXPosition;
    private static int xPosition;
    private static int yPosition;
    private double t;
    //the speed of bullet 
    private static final double speed = 15.0;
    //the amount of time that each bullet can be fired in milliseconds
    private static final int fireInterval = 10;
    //holds the time of when a bullet was last fired
    private static int lastFire = 0; 
    
    
    /** Default Constructor makes a Bullet.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Bullet(Runner runner)
    {
	//reference a runner so one can get the position from where the bullet is to be shot
	super(290/4,88, runner.getX(),"redLaserRay");
	this.setX(runner.getX());
	this.xPosition = (int)runner.getX();
	this.setY((int)runner.getY() + (int)runner.getHeight() / 2);
    }
    /** public boolean canShoot()
     * determines if you can shoot based on 
     * the last fire that was made and the fireInterval
     */
    public boolean canShoot(){
	if((int)System.currentTimeMillis() - lastFire > fireInterval)
	    return true;
	return false;
    }
    /** updateCurrentPosition
     * Moves the bullet to left until it is off screen.
     */
    public int getScore(){
        return 0;
    }
    public void updateCurrentPosition()
    {
	if(!offTheScreen())
	    xPosition = xPosition - (int)speed;
	this.setX(xPosition);
	t++;
    }
    /** public boolean offTheScreen() 
     * checks if the bullet is off the screen 
     */
    public boolean offTheScreen()
    {
	if((int)this.getX() < 0 || xPosition < 0)
	    return true;
	return false;
    }
}

