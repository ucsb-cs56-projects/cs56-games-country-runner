package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;


public class CountryRunnerGui extends JFrame {
    CountryRunnerJPanel cp;

    public CountryRunnerGui(){
	//	RunGame rg = new RunGame();
	//	rg.start();
	cp = new CountryRunnerJPanel();
	cp.setFocusable(true);
	cp.addKeyListener(cp);
	this.setSize(600,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(cp);
	this.setVisible(true);
    }
    /**   public void keyPressed(KeyEvent e) {
	cp.keyPaint();
    }
    public void keyReleased(KeyEvent e){
    }
    public void keyTyped(KeyEvent e){
    }
   */
    public static void main(String [] args){

	new CountryRunnerGui();
	
    }
}
