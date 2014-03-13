package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

/** CountryRunnerGui
 * @author Mathew Glodack, Christina Morris
 * @author Tom Craig, Sidney Rhoads
 * @version cs56, W14, proj2
 *
 * Creates a JFrame for CountrRunnerJPannel.
 * This represents the actual on screen window,
 * and holds the JPanel, which handle game logic
 * Think of this like a "main" for the game operations,
 * fixing windowing issues will happen in this class.
 */
public class CountryRunnerGui extends JFrame
{
    CountryRunnerJPanel cp;

    /** Constructor
     */
    public CountryRunnerGui()
    {
		cp = new CountryRunnerJPanel();
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(cp);
		this.setVisible(true);
    }

    public static void main(String [] args)
    {
		new CountryRunnerGui();
    }
}
