package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

/**Creates a JFrame for Country Runner Game
 *@author Mathew Glodack, Christina Morris
 *@version CS56, S13, proj3
 */

public class CountryRunnerGui extends JFrame {
    CountryRunnerJPanel cp;
       
    /**Constructor for the CountryRunnerGui JFrame
     */
    public CountryRunnerGui(){
	cp = new CountryRunnerJPanel();
	this.setSize(600,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(cp);
	this.setVisible(true);
	cp.runOnGround();
    }

    public static void main(String [] args){

	new CountryRunnerGui();
	
    }
}
