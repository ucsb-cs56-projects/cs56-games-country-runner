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
    Label l1;
    Graphics2D g2;
    public void paintComponent(Graphics g){
	g2 = (Graphics2D) g;
	g2.setColor(Color.black);
	g2.draw(boy);
	g2.draw(c1);
	addKeyListener(this);
    }
  
	
    @Override
    public void keyPressed(KeyEvent e) {
	if ( e.getKeyCode() == 37 )
	    {
	
		boy.jump(200);
			g2.draw(boy);
			this.repaint();
			
    }
	keyPaint();
	//	doAction();
    }
	
	public void keyReleased(KeyEvent e){
	    // boy.ground();
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

    public void keyPaint() { this.repaint(); }

    public void doAction(int delay) throws InterruptedException{
	
	    c1.move(10);
	    this.repaint();
	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    Thread.currentThread().sleep(delay);
    }
}
