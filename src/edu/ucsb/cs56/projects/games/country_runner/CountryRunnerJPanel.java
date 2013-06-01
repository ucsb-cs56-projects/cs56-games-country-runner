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
    Runner boy = new Runner(300.0);
    Circle c1 = new Circle(20, 20);
    Circle c2 = new Circle(40, 40);
    Label l1;
    //  Runnable r = new CountryRunnerJPanel();
    Thread t;
    //Thread t2 = new Thread(this);
    public Graphics2D g2;

    public static final boolean debug = true;

    /** Constructor adds the keyListener
     */


    public CountryRunnerJPanel(){
	t = new Thread(this);
	setFocusable(true);
	requestFocusInWindow();

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
		makeThread();
	    }
	    else if (key == KeyEvent.KEY_RELEASED){
		System.out.println("key released");
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
	g2.setColor(Color.white);
	g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	g2.setColor(Color.black);
	g2.draw(boy);
	g2.draw(c1);
    }
    /**This moves the circle
     *
     */
  
      public void moveObstacle(){
	for ( int i=0; i<this.getWidth(); i+=1)
	    {
		if(crash(c1, boy))
		    System.out.println("CRASH!!!!!");
		c1.move(10);
	        this.repaint();
		try{
		    Thread.sleep(100);
		}catch(Exception e){
		}
	    }
	    }

    public void run(){
	jumpRun(-1);
	jumpRun(1);
	/*

	for(int i = 0; i<100; i++){
	    boy.jump(-1);
	    this.repaint();
	    //	((CountryRunnerJPanel)e.getSource()).repaint();
	    try{
		t.sleep(10);
	    }catch (InterruptedException ex){
	    }
	}
	
	if(!boy.onGround() && boy.getY()==200){
	    for(int i = 0; i<100; i++){
		boy.jump(1);
		this.repaint();
		try{
		    t.sleep(10);
		}catch (InterruptedException ex){
		}
		}}*/
    }
    
    public synchronized void jumpRun(int j){
	for(int i = 0; i<100; i++){
	    boy.jump(j);
	    this.repaint();
	    try{
		t.sleep(10);
	    }catch (InterruptedException ex){
	    }
	}
    }

    public void makeThread(){
	t = new Thread(this);
	t.start();
    }
    public boolean crash(Circle c, Runner r){
	return c.getX()==r.getX())
}

    
}
