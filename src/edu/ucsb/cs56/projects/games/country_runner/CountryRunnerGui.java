package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;

/** CountryRunnerGui
 * @author Mathew Glodack, Christina Morris
 * @author Tom Craig, Sidney Rhoads
 * @author William Huang, Ray Ouyang
 * @version cs56, W16, proj2
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
        mainWindow.setLocationRelativeTo(null);
        mainWindow.add(cp);
        mainWindow.setVisible(true);
    }
    /** main creates a new CountryRunnerGUI
     *  @param args
     */
    public static void main(String [] args)
    {
        new CountryRunnerGui();
    }
    /** setCurrentPanelTo sets the current panel to
     *  what you want it to be
     *  @param panel
     */
    public static void setCurrentPanelTo(JPanel panel){
        mainWindow.setContentPane(panel);
        mainWindow.revalidate();
        mainWindow.repaint();
        panel.requestFocusInWindow();
    }
}
