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
	//Booleans for the game logic
	//Main thread of execution.
	boolean gameIsRunning;
	boolean upArrowPressed;
    boolean runnerHasCollided;
    public Graphics2D g2;
    Thread mainThread;

	//The runner and the sheep, there is only one sheep right now, may want
	//to add more in the future.
    Runner runner = new Runner();
    Sheep sheep = new Sheep();


    /** Constructor
     * Sets up the boolean state variables for the JPanel
     * Sets up the main thread of execution
     * Adds the keylistener and creates the obstacle thread
     */
    public CountryRunnerJPanel()
    {
        setFocusable(true);
		requestFocusInWindow();

		//These booleans determine the "state" of the JPanel/game
    	this.gameIsRunning = true;
    	this.upArrowPressed = false;
    	this.runnerHasCollided = false;

		//The thrad gets started once and its run method is the main game loop
		this.mainThread = new Thread(this);
		mainThread.start();

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

	/**
	 * run
	 * This is run method for the main thread
	 * It will run once, but we have a while loop inside
	 * for the main execution of the the game logic
	*/
	public void run()
    {
    	//While gameIsRunning is true, the game
    	//does all of its updating
		while(this.gameIsRunning)
		{
			//If the up arrow has been pressed,
			//we tell the runner to jump. This happens once.
			if (upArrowPressed)
			{
			    runner.startJump();
			    upArrowPressed = false;
			}

			//Every iteration of the main loop, we want
			//to call this to redraw all of the images
			this.repaint();

			//Sleep the main thread so its doesn't update everything super quickly
			try
			{
				mainThread.sleep(75);
		    }
		    catch(Exception e){}

		}
    }

    /** pressed
	 * Handles all key pressed events, if the up
	 * arrow was pressed, we set the upArrowPressed
	 * boolean to true, so the run method picks
     */
	private void pressed(KeyEvent e, String text)
	{
	    int key = e.getKeyCode();

	    //VK_UP = Up arrow
	    if (key == KeyEvent.VK_UP)
		{
		    upArrowPressed = true;
		}
	}

	/** paintComponent
	 * Required for any graphics on a JPanel.
     * Does all of our drawing.
     */
    public void paintComponent(Graphics g)
    {
    	//Draw the background
		g2 = (Graphics2D) g;
		Image image = new ImageIcon("res/background.jpg").getImage();
		Image heaven = new ImageIcon("res/heaven.jpg").getImage();
		g.drawImage(image, 0, 0, this);

		//Update the sprites' positions
		runner.updateCurrentPosition();
		sheep.updateCurrentPosition();

		//Collision check, did the runner hit anything?
		if (runnerHasCollided)
		{
		    g.drawImage(heaven, 0, 0, this);
		}

		//Update the sprites' images ad draw them on the panel
		runner.updateCurrentImage();
		sheep.updateCurrentImage();

		g2.drawImage(sheep.getCurrentImage(), (int)sheep.getX(), (int)sheep.getY(), null);
		g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
    }

	/** runnerHasCollided
	 * Determines if the runner hits the sheep object
     * @param c sheep object
     * @param r runner object
     * @return boolean true if there is a runnerHasCollided, false if not
     */
    public boolean runnerHasCollided(Sheep c, Runner r)
    {
		if (c.getY() == r.getY())
		{
			return c.getX()==r.getX();
		}
		return false;
    }
}//JPanel
