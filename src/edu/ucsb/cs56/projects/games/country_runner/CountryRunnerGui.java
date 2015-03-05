package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;

/** CountryRunnerGui
 * @author Mathew Glodack, Christina Morris
 * @author Tom Craig, Sidney Rhoads
 * @version cs56, W14, proj2
 *
 * Creates a JFrame for CounterRunnerJPanel.
 * This represents the actual on screen window,
 * and holds the JPanel, which handle game logic
 * Think of this like a "main" for the game operations,
 * fixing windowing issues will happen in this class.
 */
public class CountryRunnerGui
{
    //GUI Constants
    public static JFrame mainWindow;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    CountryRunnerTitleScreen cp;

    /** Constructor **/
    public CountryRunnerGui()
    {
        mainWindow = new JFrame();
		cp = new CountryRunnerTitleScreen();

		mainWindow.setSize(WIDTH, HEIGHT);
        mainWindow.setResizable(false);
        mainWindow.setTitle("Country Runner");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.add(cp);
		mainWindow.setVisible(true);
    }

    public static void main(String [] args)
    {
        new CountryRunnerGui();
    }

    public static void setCurrentPanelTo(JPanel panel){
        mainWindow.setContentPane(panel);
        mainWindow.revalidate();
        mainWindow.repaint();
        panel.requestFocusInWindow();
    }
}
