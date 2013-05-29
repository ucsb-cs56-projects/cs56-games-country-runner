package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

public class CountryRunnerJPanel extends JPanel {
    Runner boy = new Runner(300);
    public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D) g;

	g2.setColor(Color.black);
	g2.draw(boy);
	addKeyListener(new KeyInput());
    }
    public class KeyInput implements KeyListener{
	

	public void keyPressed(KeyEvent e) {
	    if ( e.getKeyCode() == 37 )
		{
		    boy.jump(200);
		}
	    doAction();
	}
	
	public void keyReleased(KeyEvent e){
	    // boy.ground();
	}

	public void keyTyped(KeyEvent e){
	}
    }
    
    public void doAction(){
	this.repaint();
    }
}
