package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

/**
   This class makes the JPanel for the Country Runner game
   @author Mathew Glodack, Christina Morris
   @version cs56 S13 proj3
*/


public class CountryRunnerJPanel extends JPanel implements Runnable{
    Runner boy = new Runner(); //Displays an image of a runner
    Runner2 girl = new Runner2(); //Displays an image
    Sheep sheep = new Sheep(20,20);
    Thread jt; //jump thread for the runner
    Thread ot; //object thread for objects
    boolean boyTrue = true;
    boolean kp = false;
    boolean crash;
    public Graphics2D g2;
    public static int sheepX = 630;

    public static final boolean debug = true;

    `    /** Constructor adds the keyListener
	  */
	public CountryRunnerJPanel(){
	jt = new Thread(this);
	setFocusable(true);
	requestFocusInWindow();
	ObstacleThread obtd = new ObstacleThread();

	addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
		    myKeyEvt(e, "keyTyped");
		}

		@Override
		public void keyReleased(KeyEvent e) {
		    //  myKeyEvt(e, "keyReleased");
		}

		@Override
		public void keyPressed(KeyEvent e) {
		    myKeyEvt(e, "keyPressed");
		}

		private void myKeyEvt(KeyEvent e, String text) {
		    int key = e.getKeyCode();
		    System.out.println("TEST");

		    if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
			{
			    System.out.println(text + " LEFT");
			    //Makes a new thread so runner can jump
			    kp = true;
			    makeThread();
			}
		    else if (key == KeyEvent.KEY_RELEASED){
			System.out.println("key released");
			kp = false;
			if(boy.onGround())
			    runOnGround();
		    }
		    else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
			{
			    System.out.println(text + " RIGHT");
			}
		}
	    });
    }

    /**The Paint Component method is required for any graphics on a
       JPanel. It draws the Runner and obstacles.       
    */
    
    public void paintComponent(Graphics g){
	g2 = (Graphics2D) g;
	Image image = new ImageIcon("background.jpg").getImage();
	g.drawImage(image, 0, 0, this);
	g2.setStroke(new BasicStroke(3));
	g2.setColor(Color.black);
	if(boy.onGround() && boyTrue)
	    g2.draw(girl);
	else if(girl.onGround() && !boyTrue)
	    g2.draw(boy);
	else
	    g2.draw(boy);
	g2.setStroke(new BasicStroke(3));
	g2.setColor(Color.white);
	g2.draw(sheep);
	if ( crash ) {
	    g2.setColor(Color.black);
	    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
    }
    
    /**This moves the Obstacles
     * Uses the ot thread
     */
    public class ObstacleThread implements Runnable {
	Thread ot;
	
	public ObstacleThread () {
	    ot = new Thread(this);
	    ot.start();
	}
	
	/**A run method for the Obstacles Thread 
	 */
	public void run(){
	    while( true )
		{
		    if(crash(sheep, boy)) {
			crash = true;
			System.out.println("CRASH!!!!!");
		    }
		    if(sheep.getX()==sheepX)
			sheep.move(-sheepX);
		    sheep.move(10);
		    paintObstacles();
		    try{
			jt.sleep(100);
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

    /**The run method is required by the Runnable interface
     *
     */

    public void run(){
	if ( kp ){
	    jumpRun(-1);
	    jumpRun(1);
	    if ( boy.onGround() ) {
		runOnGround();
	    }
	}
	while ( boy.onGround() ){
	    if(boyTrue && !kp){
		boyTrue = false;
		this.repaint();
		try{
		    Thread.sleep(500); //changed this to main thread
		}catch (InterruptedException ex){
		}
	    }
	    else if (!boyTrue && !kp){
		boyTrue = true;
		this.repaint();
		try{
		    Thread.sleep(500); //changed to main thread
		}catch (InterruptedException ex){
		}	
	    }
	}
    }
    
    /**
     *@param j the amount the runner jumps by each time jump is called, negative moves up, positive moves down
     * Uses the a seperate thread jt
     */
    
    public synchronized void jumpRun(int j){
	for(int i = 0; i<100; i++){
	    boy.jump(j);
	    this.repaint();
	    try{
		jt.sleep(10);
	    }catch (InterruptedException ex){
	    }
	}
    }

    /**This method makes a new thread or the jumper and the moving
     * object
     */
    public void makeThread(){
	jt = new Thread(this);
	jt.start();
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
    public void runOnGround(){
	while ( boy.onGround() ) {
	    if( boyTrue){
		boyTrue = false;
		this.repaint();
		try{
		    Thread.sleep(250);
		}catch(Exception e){
		}
	    }
	    if ( !boyTrue){
		boyTrue = true;
		this.repaint();
		try{
		    
		    Thread.sleep(250);
		}catch(Exception e){
		}
	    }
	
	}
    }//runOnGround
}//JPanel

