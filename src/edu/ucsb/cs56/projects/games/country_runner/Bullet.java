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
public class Bullet extends Sprite
{
    //initialXPosition goes into the super constructor
    private static double initialXPosition;
    private static int xPosition;
    private double t;
    //the speed of bullet 
    private static final double speed = 15.0;
    //the amount of time that each bullet can be fired in milliseconds
    private static final int fireInterval = 1000;
    //holds the time of when a bullet was last fired
    private static int lastFire = 0; 
    //Image of the bullet
    private BufferedImage image;
    
    
    /** Default Constructor makes a Bullet.
     * sets up the spriteSheet and fills the
     * sequences with images from it
     */
    public Bullet(Runner runner)
    {
	//reference a runner so one can get the position from where the bullet is to be shot
	super(290,74, runner.getX(),runner.getY());
	try {
	    image = ImageIO.read(new File("redLaserRay.png"));
	} catch (IOException e) {
	}
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
    /** public BufferedImage returnImage()
     * returns the current image of the bullet
     */
    public BufferedImage returnImage()
    {
	return image;
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
	    if(canShoot())
		xPosition = (int)(speed * t);
	this.setX(xPosition);
	t++;
    }
    /** public boolean offTheScreen() 
     * checks if the bullet is off the screen 
     */
    public boolean offTheScreen()
    {
	if(xPosition - 600 == 0)
	    return true;
	return false;
    }
}

