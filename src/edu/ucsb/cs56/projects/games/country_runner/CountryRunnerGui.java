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

	CountryRunnerJPanel cp = new CountryRunnerJPanel();
	frame.add(cp);
	frame.setVisible(true);
    }
	

}
