package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;


public class CountryRunnerGui extends JFrame {
    CountryRunnerJPanel cp;
    boolean b = true;

    public CountryRunnerGui(){
	cp = new CountryRunnerJPanel();
	this.setSize(600,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(cp);
	this.setVisible(true);
	//cp.run();
	//		cp.moveObstacle();
	cp.runOnGround();
	//	cp.fall();
    }

    public static void main(String [] args){

	new CountryRunnerGui();
	
    }
}
