package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

public class CountryRunnerJPanel extends JPanel{
    Runner boy = new Runner(300);
    Circle c1 = new Circle(20, 20);
    Circle c2 = new Circle(40, 40);
    Label l1;
    public Graphics2D g2;
    public static final boolean debug = true;

    public CountryRunnerJPanel(){
	setFocusable(true);
	requestFocusInWindow();

	addKeyListener(new KeyAdapter() {
		         @Override
         public void keyTyped(KeyEvent e) {
            myKeyEvt(e, "keyTyped");
         }

         @Override
         public void keyReleased(KeyEvent e) {
            myKeyEvt(e, "keyReleased");
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
                //Call some function
		boy.jump(-5);
		((CountryRunnerJPanel)e.getSource()).repaint();
		
            }
            else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
            {
                System.out.println(text + " RIGHT");
                //Call some function
            }
         }


      });
   }

    
    public void paintComponent(Graphics g){
	g2 = (Graphics2D) g;
	g2.setColor(Color.white);
	g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	g2.setColor(Color.black);
	g2.draw(boy);
	g2.draw(c1);
    }
    public void addNotify() {
	super.addNotify();
        requestFocus();
    }
    
    /**
    
    public void keyPressed(KeyEvent e) {
	//	if(e.getKeyCode() ==37){ 
	    // g2.draw(c2);
	    // this.repaint();
	    //	    c1.move(50);
	    //	    g2.draw(c2);
	    //	    keyPaint(g2);
	//	}
    }
	
	public void keyReleased(KeyEvent e){
	}

	public void keyTyped(KeyEvent e){
	    if(e.getKeyCode() == 37){
		boy.jump(200);
		repaint();
	    }}
    
    class RunGame extends Thread{
	public void run(){//begin run method
	    try{
		while(true){
		    doAction(40);
		}//end while loop
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){}
		else{//Unexpected exception occurred.
		    System.out.println(ex);
		    System.exit(1);//terminate program
		}//end else
	    }//end catch
	}//end RunGame
    }
    */
    public void keyPaint(Graphics g) { 
	g2 = (Graphics2D) g;
	c1.move(50);
	
	g2.draw(c2);
	g2.draw(c1); 
	this.repaint();
	if(debug){ System.out.println("In keyPaint()" + "c1 should be:50 "+c1.getX());}
}
    /*
    public void doAction(int delay) throws InterruptedException{
	
	    
	    this.repaint();
	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    Thread.currentThread().sleep(delay);
	    }*/
}
