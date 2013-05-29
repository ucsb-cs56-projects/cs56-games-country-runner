package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;


public class CountryRunnerGui{

    public static void main(String [] args){

	JFrame frame = new JFrame();

	frame.setSize(600,400);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	CountryPanel cp = new CountryPanel();
	frame.getContentPane().add(cp);
	frame.setVisible(true);
    }
	
	public static class CountryPanel extends JPanel{
	    public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Runner boy = new Runner();
		g2.setColor(Color.black);
		g2.draw(boy);
	    
	    }
	}
}
