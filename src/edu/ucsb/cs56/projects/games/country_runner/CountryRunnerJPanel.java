package edu.ucsb.cs56.projects.games.country_runner;

import sun.audio.AudioPlayer;
import edu.ucsb.cs56.projects.games.country_runner.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/** CountryRunnerJPanel
 * @author Mathew Glodack, Christina Morris
 * @author Sidney Rhoads, Tom Craig
 * @version cs56, W14, proj2
 *
 * This class makes the JPanel for the
 * Country Runner game
*/
public class CountryRunnerJPanel extends JPanel implements Runnable
{
	//Booleans for the game logic
    boolean gameIsRunning;
    boolean upArrowPressed;
    boolean runnerHasCollided;
    boolean superJumpPressed;
    //GROUND is for positioning
    //ths sprites.  Note that this
    //is also defined in the Sprite class
    final double GROUND = 375.0;
    public Graphics2D g2;
	//Main thread of execution.
    Thread mainThread;
    Thread musicThread;

	//The runner and the sheep, there
	//is only one sheep right now, may want
	//to add more in the future.
    Runner runner = new Runner();
    Sheep sheep = new Sheep();
    Snail snail = new Snail();

    //Score Overlay
    JLabel scoreLabel;
    int score;


    /** Constructor
     * Sets up the boolean state variables for the JPanel
     * Sets up the main thread of execution
     * Adds the keylistener and creates the obstacle thread
     */
    public CountryRunnerJPanel()
    {
    	//These are just for making the
    	//JPanel and JFrame place nice, and
    	//accept keyboard input
        //sets panel layout to no layout manager
        setFocusable(true);
	requestFocusInWindow();
        setLayout(null);

		//These booleans determine the "state" of the JPanel/game
    	this.gameIsRunning = true;
    	this.upArrowPressed = false;
    	this.runnerHasCollided = false;
        this.score = 0;

		//The thrad gets started once and its run method is the main game loop
	this.mainThread = new Thread(this);
        this.musicThread = new Thread(new BackgroundMusic());
	mainThread.start();
        musicThread.start();

        //add score overlay
        scoreLabel = new JLabel("Score: " + Integer.toString(score));
        scoreLabel.setFont(new Font("Arial",Font.BOLD,24));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(450,1,200,100);
        add(scoreLabel);

		//This part if ro regestering keyboard keys
		//each overridden function is used to manage what
		//happens when keys are pressed and released
			//keyPressed - when the key goes down
			//keyReleased - when the key comes up
			//keyTyped - when the unicode character represented
				//by this key is sent by the keyboard to system input.
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //Here, we say that when a key is pressed,
                //the "pressed" function should be carried out
                pressed(e, "keyPressed");
                //NOTE: right now we are only handling the
                //keyPressed actions and don't care about
                //anything else.  This may change in the future
            }

            @Override
            public void keyReleased(KeyEvent e) {
                released(e,"keyReleased");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //Not currently using
            }
        });
    }

    /** pressed
	 * Handles all key pressed events, if the up
	 * arrow was pressed, we set the upArrowPressed
	 * boolean to true, so the run method picks it up
     */
	private void pressed(KeyEvent e, String text)
	{
	    int key = e.getKeyCode();

	    //VK_UP = Up arrow
	    if (key == KeyEvent.VK_UP)
		{
		    upArrowPressed = true;
		}
            if (key== KeyEvent.VK_X)
                {
                    superJumpPressed = true;
                }
            if (key== KeyEvent.VK_LEFT)
		{runner.move2();}
            if (key == KeyEvent.VK_RIGHT)
                {runner.move1();}
	}



        private void released(KeyEvent e,String text)
             { int key=e.getKeyCode();
	       if ((key==KeyEvent.VK_LEFT) || (key==KeyEvent.VK_RIGHT))
		    runner.stop();
         } 
	/**
	 * run
	 * This is run method for the main thread
	 * It will run once, but we have a while loop inside
	 * for the main execution of the the game logic.  It
	 * looks like a never-ending while loop, but we can
	 * control when the gameIsRUnning boolean is ON/OFF
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
                        if (superJumpPressed)
			{
			    runner.superJump();
                            superJumpPressed = false;
                        }

            //update scores
            score = sheep.getScore() + snail.getScore();

			//Every iteration of the main loop, we want
			//to call this to redraw all of the images
			this.repaint();

			//Sleep the main thread so its doesn't update everything super quickly
			try
			{
				mainThread.sleep(65);
		    }
		    catch(Exception e){}

		}
    }

   	/** paintComponent
	 * Required for any graphics on a JPanel.
     * Does all of our drawing.  It is called when
     * the program says "this.repaint()"
     */
    public void paintComponent(Graphics g)
    {
    	//Draw the background
		g2 = (Graphics2D) g;
		
		//Load background images
		Image[] backgrounds = new Image[3];
		for (int i=1; i<=backgrounds.length; i++) {
		    String imagePath = "res/background";
		    imagePath += i;
		    imagePath += ".jpg";		    
		    backgrounds[i-1] = new ImageIcon(imagePath).getImage();
		}
	
		Image heaven = new ImageIcon("res/heaven.jpg").getImage();

		g.drawImage(backgrounds[CountryRunnerTitleScreen.changeBackground-1], 0, 0, this);

		//Update the sprites' positions
		runner.updateCurrentPosition();
		sheep.updateCurrentPosition();
		snail.updateCurrentPosition();

		//Collision check, did the runner hit anything?
		//If so, the game is over
		if (this.runnerHasCollided(snail, sheep, runner)) // need to add snail to this later
		{
		    // can add death animation here

		    this.gameIsRunning = false;
		    AudioPlayer.player.stop(BackgroundMusic.song);

		    //save score to score system
		    ScoreSystem ss = new ScoreSystem();
		    try{
			ss.loadScores();
		    }catch(Exception e){}
		    ss.addScore(score);
		    try{
			ss.saveScores();
		    }catch(Exception e){}
		    
		    CountryRunnerGui.setCurrentPanelTo(new GameOverJPanel(score));
		}

		else
		{
			//Update the sprites' images and draws them on the panel
			//Note that at the beginning of execution of the JPanel,
			//the sprites are put on the ground, and after that they
			//handle their own repositionings internally.  We do not
			//explicitly position them in the JPanel
			runner.updateCurrentImage();
			sheep.updateCurrentImage();
			snail.updateCurrentImage();
			g2.drawImage(sheep.getCurrentImage(), (int)sheep.getX(), (int)sheep.getY(), null);
			g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
			g2.drawImage(snail.getCurrentImage(), (int)snail.getX(), (int)snail.getY(), null);

            scoreLabel.setText("Score: " + Integer.toString(score));
			

		}
    }

	/** runnerHasCollided
	 * Determines if the runner hits the sheep object
     * @param c sheep object
     * @param r runner object
     * @return boolean true if there is a runnerHasCollided, false if not
     */
    public boolean runnerHasCollided(Snail s, Sheep c, Runner r) // need to add snail to this function too
    {
        	if ((r.getY() + r.getHeight()) >= c.getY())
		{
		    if ((c.getX()+50>r.getX()) && ((c.getX()-50) <r.getX()))
			return true;
		}
         	if((r.getY() + r.getHeight()) >= s.getY())
		 {
		    if ((s.getX()+40>r.getX()) && ((s.getX()-20) <r.getX()))
			return true;
		 }

	       return false;
    }
}//JPanel
