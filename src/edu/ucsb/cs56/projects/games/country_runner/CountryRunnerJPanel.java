package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

public class CountryRunnerJPanel extends JPanel implements KeyListener{
    Runner boy = new Runner(300);
    Circle c1 = new Circle(20, 20);
    Circle c2 = new Circle(40, 40);
    Label l1;
    public Graphics2D g2;
    public static final boolean debug = true;
    
    public void paintComponent(Graphics g){
	g2 = (Graphics2D) g;
	g2.setColor(Color.black);
	g2.draw(boy);
	g2.draw(c1);
    }
    
    public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() ==37){ 
	    g2.draw(c2);
	    this.repaint();
	    this.keyPaint();
	}
    }
	
	public void keyReleased(KeyEvent e){
	}

	public void keyTyped(KeyEvent e){
	}
    
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

    public void keyPaint() { 
	c1.move(50);
	g2.draw(c1); 
	if(debug){ System.out.println("In keyPaint()");}
}

    public void doAction(int delay) throws InterruptedException{
	
	    
	    this.repaint();
	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    Thread.currentThread().sleep(delay);
    }
}
