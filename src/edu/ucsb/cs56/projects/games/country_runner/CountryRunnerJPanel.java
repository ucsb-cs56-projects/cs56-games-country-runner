package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

import java.awt.image.BufferedImage;


/**
   This class makes the JPanel for the Country Runner game
   @author Mathew Glodack, Christina Morris
   @author Sidney Rhoads, Tom Craig
   @version cs56  W14 proj1
*/


public class CountryRunnerJPanel extends JPanel implements Runnable
{
	//---------------------------------------------------------------------
	//The runner and the sheep, there is only one sheep right now, may want
	//to add more in the future.
	//There is a running and a jumping thread here, this may be taken out
	//in favor of timing calculations
	//"runnerTrue" is for decicing on animation later on, this logic should
	//be moved to the runner class
	//---------------------------------------------------------------------
    Runner runner = new Runner();
    Sheep sheep = new Sheep();
    Thread jumpThread;
    Thread objectThread;
    boolean runnerTrue = true;
    boolean upArrowPressed = false;

    boolean crash;
    public Graphics2D g2;
    public static int sheepX = 630;

    /** Constructor
     * Adds the keylistener and creates the obstacle thread
     * to be run for the duration of the program
     */
    public CountryRunnerJPanel()
    {
    	//Give CountryRunnerJPanel the focus of the application;
    	//it will be the field that receives the keyboard input.
		setFocusable(true);
		requestFocusInWindow();

		ObstacleThread obstacleThread = new ObstacleThread();

		//---------------------------------------------------------------------
		//keyPressed - when the key goes down
		//keyReleased - when the key comes up
		//keyTyped - when the unicode character represented
		//by this key is sent by the keyboard to system input.
		//NOTE: right now we are only handling the keyPressed actions and don't
		//care about anything else.  This may change in the future
		//---------------------------------------------------------------------
		addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
			    pressed(e, "keyPressed");
			}
			@Override
			public void keyReleased(KeyEvent e)
			{
			    //Not currently using
			}
			@Override
			public void keyTyped(KeyEvent e)
			{
			    //Not currently using
			}

	    });
    }

	/** pressed
	 * Handles all key pressed events, if the up arrow was pressed,
	 * we make him jump
     */
	private void pressed(KeyEvent e, String text)
	{
	    int key = e.getKeyCode();

	    //VK_UP = Up arrow
	    if (key == KeyEvent.VK_UP)
		{
		    upArrowPressed = true;

		    //Makes a new thread so runner can jump
		    //This is because after the jump finishes,
		    //the jumping thread dies and it must be
		    //made again for each jump
		    if (runner.isOnGround())
		    {
				makeThread();
			}
		}
	}

	/**makeThrad
	 * Makes a new thread for the
	 * jumper and the moving object
     */
    public void makeThread()
    {
		jumpThread = new Thread(this);
		jumpThread.start();
    }

    /**run
     * The method MUST be defined for something implementing runnable,
     * this runs continuously, and can be thought of as the "main"
     * for all of the animation tasks
	 *
     * Here, we make the runner jump if the up arrow has been pressed
     * if not, we call "this.repaint()" which updates the images
     */
    public void run()
    {
		if (upArrowPressed)
		{
		    jump();
			if (runner.isOnGround())
			{
				runOnGround();
			}
		}
		while ( runner.isOnGround() ){
		    if(runnerTrue && !upArrowPressed){
			runnerTrue = false;
			this.repaint();
			try{
			    Thread.sleep(500); //changed this to main thread
			}catch (InterruptedException ex){
			}
		    }
		    else if (!runnerTrue && !upArrowPressed){
			runnerTrue = true;
			this.repaint();
			try{
			    Thread.sleep(500); //changed to main thread
			}catch (InterruptedException ex){
			}
		    }
		}
    }


	/** jump
     * negative moves up, positive moves down.
     * Uses the jumpThread
     * Currently implements gravity, such that the jump
     * slows until reaching the top, then speeds up again
     * until reaching the ground.
     */
    public synchronized void jump()
    {

    	//Piggy velocity
		double v = 1.8;
		//Acceleration
		double a = .01;
		while (runner.getY() > 10)
		{
			//Descrease the velocity every round
			v = v-a;
			runner.setY((runner.getY() - v));

			try
		    {
				jumpThread.sleep(5);
		    } catch (InterruptedException ex){}

			//Once we return to the ground, stop moving
		    if (runner.isOnGround())
		    {
			    break;
		    }


		}
    }

    /** paintComponent
     * Required for any graphics on a JPanel.
     * Does all of our drawing.
    */
    public void paintComponent(Graphics g)
    {
    	//Background stuff
		g2 = (Graphics2D) g;
		Image image = new ImageIcon("res/background.jpg").getImage();
		Image heaven = new ImageIcon("res/heaven.jpg").getImage();
		g.drawImage(image, 0, 0, this);

		//Runner stuff
		runner.updateCurrentImage();
		g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
		sheep.updateCurrentImage();
		g2.drawImage(sheep.getCurrentImage(), (int)sheep.getX(), (int)sheep.getY(), null);

		if ( crash )
		{
		    g.drawImage(heaven, 0, 0, this);
		}
    }


/*Tom, Sidney - we have not looked at the code below... We are refactoring the runner first*/
    /**This moves the Obstacles
     * Uses the objectThread thread
     */
    public class ObstacleThread implements Runnable
    {
		Thread objectThread;

		public ObstacleThread () {
	    objectThread = new Thread(this);
	    objectThread.start();
	}

		/**A run method for the Obstacles Thread
		 */
		public void run(){
	    while( true )
		{
		    if(crash(sheep, runner)) {
			crash = true;
			System.out.println("CRASH!!!!!");
		    }
		    if(sheep.getX()==sheepX)


		    paintObstacles();
		    try{
			jumpThread.sleep(100);
		    }catch(Exception e){
		    }
		}
	}

		}
    /**Repaints the Obstacles
     */
    public void paintObstacles(){
	this.repaint();
    }

    /**Determines if the runner hits the sheep object
     *@param c sheep object
     *@param r runner object
     *@return boolean true if there is a crash, false if not
     */
    public boolean crash(Sheep c, Runner r){
	if ( c.getY() == r.getY() )
	    return c.getX()==r.getX();
	return false;
    }

    /**Switches the runners position on while on the ground
     * Uses the main Thread
     */
    public void runOnGround()
    {
		while (runner.isOnGround())
		{
		    if(runnerTrue)
		    {
				runnerTrue = false;
				this.repaint();
				try
				{
				    Thread.sleep(250);
				}
				catch(Exception e){}
			}

		    if (!runnerTrue)
		    {
				runnerTrue = true;
				this.repaint();
				try
				{
				    Thread.sleep(250);
				}
				catch(Exception e){}
			}
		}//while loop
    }//runOnGround
}//JPanel
