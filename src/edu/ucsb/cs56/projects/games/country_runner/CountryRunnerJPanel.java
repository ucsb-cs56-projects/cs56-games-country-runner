package edu.ucsb.cs56.projects.games.country_runner;

import sun.audio.AudioPlayer;
import edu.ucsb.cs56.projects.games.country_runner.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/** CountryRunnerJPanel
 * @author Mathew Glodack, Christina Morris
 * @author Sidney Rhoads, Tom Craig
 * @author William Huang, Ray Ouyang
 * @version cs56, F16, proj2
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
    boolean fired;
    boolean easy;
    boolean medium;
    boolean impossible;
    boolean drawingLevel = false;
    boolean scoreWasTen = false;
    boolean scoreWasTwenty = false;
    boolean scoreWasForty = false;
    //GROUND is for positioning
    //ths sprites.  Note that this
    //is also defined in the Sprite class
    final double GROUND = 375.0;
    public Graphics2D g2;
    //Main thread of execution.
    Thread mainThread;
    Thread musicThread;
    
    //Background
    private Background backOne;
    private Background backTwo;
    private BufferedImage back;
    
    //The runner and the sheep, there
    //is only one sheep right now, may want
    //to add more in the future.
    Runner runner = new Runner(CountryRunnerTitleScreen.avatar);
    
    //initObstalcles(sheep, snail, racoon, panda)
    ArrayList<Sprite> gameObstacles = initObstacles(2, 1, 1, 1);
    
    //Score Overlay
    JLabel scoreLabel;
    int score;
    int drawingPosition;
    int levelsDefeated;
    
    
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
	
	
	//background
	//Load background images
	String[] backgrounds = Background.loadBackgrounds();
	
	//String imageName = "background.png";
	backOne = new Background(backgrounds[CountryRunnerTitleScreen.changeBackground-1]);
        backTwo = new Background(backOne.getImageWidth(), 0, backgrounds[CountryRunnerTitleScreen.changeBackground-1]);
	
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
	//VK_SPACE = space bar
	if(key == KeyEvent.VK_SPACE && !drawingLevel)
	    {
		fired = true;
	    }
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
    
    
    /** private void released(KeyEvent e, String text)
     *  checks if the left or right key is released
     *  in order to stop the character 
     */ 
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
		//if the spacebar is pressed,
		//tell the runner to fire()
		if(fired)
		    {
			runner.fire();
			fired = false;
		    }
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
	        //TODO: re formulate how the score is called
		score = levelsDefeated*5;
		for(Sprite thisObstacle : gameObstacles)
		{
			score = score + thisObstacle.getScore();
		}
		if (this.runnerHasCollided(gameObstacles, runner))
		    {
			runner.death();
		    }
		if(score == 5 && scoreWasTen == false){
		    int amountToAdd = 2;
		    gameObstacles = makeNewSpriteArray(2, 1, 1, 1 , amountToAdd);
		    easy = true;
		    drawingLevel = true;
		    scoreWasTen = true;
		    levelsDefeated = 1;
		}
		else if(score == 10 && scoreWasTwenty == false){
		    int amountToAdd = 3;
		    gameObstacles = makeNewSpriteArray(2, 1, 1, 1 , amountToAdd);
		    easy = false;
		    medium = true;
		    drawingLevel = true;
		    scoreWasTwenty = true;
		    levelsDefeated = 2;
		}
		else if(score == 20 && scoreWasForty == false){
		    int amountToAdd = 4;
		    gameObstacles = makeNewSpriteArray(2, 1, 1, 1 , amountToAdd);
		    medium = false;
		    impossible = true;
		    drawingLevel = true;
		    scoreWasForty = true;
    		    levelsDefeated = 4;
		}
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
	
	Image heaven = new ImageIcon("res/heaven.jpg").getImage();
	
	scrollingBackground(g);
	//if the runner is dying, do the death animation
	if(runner.isDying())
	    {
		runner.updateDeath();
		g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
		for(Sprite thisObstacle : gameObstacles){
		    g2.drawImage(thisObstacle.getCurrentImage(), (int)thisObstacle.getX(), (int)thisObstacle.getY(), null);
		}
		if(runner.getY() > GROUND){
		    runner.setDying(false);
		    this.gameIsRunning = false;
		    AudioPlayer.player.stop(BackgroundMusic.song);
		    CountryRunnerGui.setCurrentPanelTo(new GameOverJPanel(this.score));
		}
	    }
	else{
	    if(drawingLevel && easy){
		drawingPosition += 20;
		g2.drawString("LEVEL 2!", drawingPosition, 200);
		drawWithoutUpdating(g2);
		if(drawingPosition == 600)
		    {
			easy = false;
			drawingPosition = 0;
			drawingLevel = false;
		    }
	    }
	    else if(drawingLevel && medium){
		drawingPosition += 20;
		g2.drawString("LEVEL 3!", drawingPosition, 200);
		drawWithoutUpdating(g2);
		if(drawingPosition == 600)
		    {
			drawingPosition = 0;
			drawingLevel = false;
			easy = false;
		    }
	    }
	    else if(drawingLevel && impossible){
		drawingPosition += 20;
		g2.drawString("GOOD LUCK!", drawingPosition, 200);
		drawWithoutUpdating(g2);
		if(drawingPosition == 600)
		    {
			drawingPosition = 0;
			drawingLevel = false;
			easy = false;
		    }
	    }
	    else
	        drawRegularly(g2);
	}
    }
    public void drawWithoutUpdating(Graphics2D g2){
	runner.updateCurrentImage();
	g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
	
	//Update the sprites' images and draws them on the panel
	//Note that at the beginning of execution of the JPanel,
	//the sprites are put on the ground, and after that they
	//handle their own repositionings internally.  We do not
	//explicitly position them in the JPanel
	ArrayList<Bullet> bullets = runner.getBullets();
	for(int i = 0; i < gameObstacles.size(); i++){
	    Sprite thisObstacle = gameObstacles.get(i);
	    thisObstacle.updateCurrentImage();
	    g2.drawImage(thisObstacle.getCurrentImage(), (int)thisObstacle.getX(), (int)thisObstacle.getY(), null);   
	}
	scoreLabel.setText("Score: " + Integer.toString(this.score));
    }
    public void drawRegularly(Graphics2D g2){
	runner.updateCurrentImage();
	runner.updateCurrentPosition();
	g2.drawImage(runner.getCurrentImage(), (int)runner.getX(), (int)runner.getY(), null);
	
	//Update the sprites' images and draws them on the panel
	//Note that at the beginning of execution of the JPanel,
	//the sprites are put on the ground, and after that they
	//handle their own repositionings internally.  We do not
	//explicitly position them in the JPanel
	ArrayList<Bullet> bullets = runner.getBullets();
	for(int i = 0; i < bullets.size(); i++){
	    runner.updateBulletPosition();
	}
	for(int i = 0; i < gameObstacles.size(); i++){
	    Sprite thisObstacle = gameObstacles.get(i);
	    thisObstacle.updateCurrentImage();
	    thisObstacle.updateCurrentPosition();
	    g2.drawImage(thisObstacle.getCurrentImage(), (int)thisObstacle.getX(), (int)thisObstacle.getY(), null);
	    for(int j = 0; j < bullets.size(); j++)
		if(thisObstacle.collides(bullets.get(j))){
		    thisObstacle.incrementScore();
		    thisObstacle.setX(-100);
		    bullets.remove(j);
		    //Sprite makeObstacle = Sprite.randomlyCreateSprite();
		}	    
	}
	for(int i = 0; i < bullets.size(); i++){
	    g2.drawImage(runner.getCurrentImage(), (int)bullets.get(i).getX(), (int)bullets.get(i).getY() - (int)runner.getHeight() / 2, null);
	}
	scoreLabel.setText("Score: " + Integer.toString(this.score));
    }
    public boolean runnerHasCollided(ArrayList<Sprite> gameObstacles, Runner r )
    {
	for(Sprite thisObstacle : gameObstacles)
	    {
		if ((r.getY() + r.getHeight()) >= thisObstacle.getY())
		    {
			if ((thisObstacle.getX()+50>r.getX()) && ((thisObstacle.getX()-50) <r.getX()))
				{
				    return true;
				}
		    }
		}
		return false;
    }
    private ArrayList<Sprite> initObstacles(int sheepNum, int snailNum, int raccoonNum, int pandaNum){
    	Sheep makeSheep;
    	Snail makeSnail;
    	Raccoon makeRaccoon;
    	Panda makePanda;
    	Sprite temp;
    	ArrayList<Sprite> makeObstacle = new ArrayList<Sprite>();
    	for(int i = 0; i < sheepNum; i++){
    		makeSheep = new Sheep(CountryRunnerTitleScreen.difficulty);
    		temp = (Sprite) makeSheep;
    		makeObstacle.add( temp );
    	}
    	for(int i = 0; i < snailNum; i++){
    		makeSnail = new Snail(CountryRunnerTitleScreen.difficulty);
    		temp = (Sprite) makeSnail;
    		makeObstacle.add( temp );
    	}
    	for(int i = 0; i < raccoonNum; i++){
    		makeRaccoon = new Raccoon(CountryRunnerTitleScreen.difficulty);
    		temp = (Sprite) makeRaccoon;
    		makeObstacle.add( temp );
    	}
    	for(int i = 0; i < pandaNum; i++){
    		makePanda = new Panda(CountryRunnerTitleScreen.difficulty);
    		temp = (Sprite) makePanda;
    		makeObstacle.add( temp );
    	}
    	return makeObstacle;
    }
    private ArrayList<Sprite> makeNewSpriteArray(int sheepNum, int snailNum, int raccoonNum, int pandaNum , int amountToAdd)
    {
	ArrayList<Sprite> makeObstacle = new ArrayList<Sprite>();
    	for(int i = 0; i < sheepNum; i++){
	    Sprite makeSheep = new Sheep(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add( makeSheep );
    	}
	for(int i = 0; i < amountToAdd; i++){
	    Sprite makeSheep = new Sheep(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add(makeSheep);
	}
    	for(int i = 0; i < snailNum; i++){
	    Sprite makeSnail = new Snail(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add( makeSnail );
    	}
	for(int i = 0; i < amountToAdd/2; i ++){
	    Sprite makeSnail = new Snail(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add(makeSnail);
	}
    	for(int i = 0; i < raccoonNum; i++){
	    Sprite makeRaccoon = new Raccoon(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add( makeRaccoon );
    	}
	for(int i = 0; i < amountToAdd / 6; i++){
	    Sprite makeRaccoon = new Raccoon(CountryRunnerTitleScreen.difficulty);
	    makeObstacle.add(makeRaccoon);
	}
    	for(int i = 0; i < pandaNum; i++){
    		Sprite makePanda = new Panda(CountryRunnerTitleScreen.difficulty);
    		makeObstacle.add( makePanda );
    	}
	for(int i = 0; i < amountToAdd / 2; i++)
	    {
	        Sprite makePanda = new Panda(CountryRunnerTitleScreen.difficulty);
		makeObstacle.add(makePanda);
	    }
    	return makeObstacle;
    }
    /** public void scrollingBackground(graphics g)
     *  creates a scrolling background with the use 
     *  of buffering the images and backgrounds 
     */
    public void scrollingBackground(Graphics g)
    {
	if (back == null)
	    back = (BufferedImage)(createImage(getWidth(), getHeight()));
	
	// Create a buffer to draw to
	Graphics buffer = back.createGraphics();
	
	// Put the two copies of the background image onto the buffer
	backOne.draw(buffer);
	backTwo.draw(buffer);
	
	// Draw the image onto the window
	g.drawImage(back, 0, 0, this);	
    }
    
}//JPanel
