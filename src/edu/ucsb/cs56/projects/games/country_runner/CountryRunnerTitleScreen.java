package edu.ucsb.cs56.projects.games.country_runner;
import edu.ucsb.cs56.projects.games.country_runner.ScoreSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CountryRunnerTitleScreen extends JPanel{
    // Java GUI Components
    JButton playGameButton;
    JButton helpButton;
    JButton highscoreButton;
    JButton chooseAvatar;
    JButton chooseBackground;
    JButton chooseDifficulty;
    JLabel titleLabel;
    GridBagConstraints gbc;
    JPanel topPanel;
    JPanel botPanel;
    JFrame instuctionsFrame;

    //default flag values
    public static int changeBackground = 1;
    public static String avatar = "Cowboy";
    public static int difficulty = 1;
    /** Constructor that sets up the main menu of the Game
     */
    public CountryRunnerTitleScreen(){

	this.repaint();
        playGameButton = new JButton("Play Game");
	chooseBackground = new JButton("Choose Background");
	chooseAvatar = new JButton("Choose Avatar");
	chooseDifficulty = new JButton("Choose Difficulty");
        helpButton = new JButton("Instructions");
        highscoreButton = new JButton("High Score");
        titleLabel = new JLabel("Country Runner");
        gbc = new GridBagConstraints();
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());

        // instructions
        final String instructions = "Avoid all obstacles that come into the screen.\n" + "Could be a stationary scarecrow, or a dashing sheep.\n" +
	    "Some ghosts may be overhead so time your jumps carefully.\n" +
	    "Press the Up arrow key to jump, and hold to super jump.\n" + "Press the Left/Right arrow keys to move forward or backward.\n" +
	    "Press the space bar to use your magical powers and shoot an image of yourself to kill the obstacles!";

        //set layout manager for this panel
        setLayout(new GridLayout(2,1));

        //set title font and size

        titleLabel.setFont(new Font("Cabin",Font.BOLD,38));
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add components to top panel
        topPanel.add(titleLabel, BorderLayout.CENTER);

        //add components to bot panel
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botPanel.add(playGameButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        botPanel.add(highscoreButton, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        botPanel.add(helpButton, gbc);
	gbc.gridx = 3;
	gbc.gridy = 4;
	botPanel.add(chooseDifficulty, gbc);
	gbc.gridx = 3;
	gbc.gridy = 5;
	botPanel.add(chooseAvatar, gbc);
	gbc.gridx = 3;
	gbc.gridy = 6;
	botPanel.add(chooseBackground, gbc);

	topPanel.setOpaque(false);
	botPanel.setOpaque(false);
        //add bot and top panel to this.panel
        add(topPanel);
        add(botPanel);

        //event managers
        playGameButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
		    CountryRunnerGui.setCurrentPanelTo(new CountryRunnerJPanel());
		}
	    });
        helpButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
		    JOptionPane.showMessageDialog(instuctionsFrame, instructions,"Instructions",JOptionPane.INFORMATION_MESSAGE);
		}
	    });
        highscoreButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
		    ScoreSystem ss = new ScoreSystem();
		    try{
			String scores = ss.toStringFromFile();
			JOptionPane.showMessageDialog(instuctionsFrame, scores,"High Scores",JOptionPane.INFORMATION_MESSAGE);
		    }catch(Exception ex){}
		}
	    });
	chooseDifficulty.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {

		    Object[] possibleValues = { "Easy", "Normal", "Hard"};
		    Object selectedValue = JOptionPane.showInputDialog(null,
								       "Choose one", "Input",
								       JOptionPane.INFORMATION_MESSAGE, null,
								       possibleValues, possibleValues[0]);

		    if (selectedValue == "Easy")
			difficulty = 1;
		    else if (selectedValue == "Normal")
			difficulty = 2;
		    else if (selectedValue == "Hard")
			difficulty = 3;
		}
	    });
	chooseAvatar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {

		    Object[] possibleValues = {"Cowboy", "Cowgirl", "Pumpkin Head"};
		    Object selectedValue = JOptionPane.showInputDialog(null,
								       "Choose one", "Input",
								       JOptionPane.INFORMATION_MESSAGE, null,
								       possibleValues, possibleValues[0]);
        if(selectedValue == "Cowboy"){
          avatar = "Cowboy";
        }
        else if(selectedValue == "Cowgirl"){
          avatar = "Cowgirl";
        }
        else if(selectedValue == "Pumpkin Head"){
          avatar = "Pumpkin Head";
        }
		}
	    });
	chooseBackground.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {

		    Object[] possibleValues = { "Sakura Forest Fall", "Desert", "Limbo"};
		    Object selectedValue = JOptionPane.showInputDialog(null,
								       "Choose one", "Input",
								       JOptionPane.INFORMATION_MESSAGE, null,
								       possibleValues, possibleValues[0]);

		    if (selectedValue == "Sakura Forest Fall")
			changeBackground = 1;
		    else if (selectedValue == "Desert")
			changeBackground = 2;
		    else if (selectedValue == "Limbo")
			changeBackground = 3;
		}
	    });
    }
    /** paintComponent paints the background for the main menu screen
     *  @param g
     */
    public void paintComponent(Graphics g){

	Image im = new ImageIcon("res/newbackground.jpg").getImage();

        g.drawImage(im, 0, 0, this);
    }
}
