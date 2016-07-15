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
    JButton chooseBackground;
    JLabel titleLabel;
    GridBagConstraints gbc;
    JPanel topPanel;
    JPanel botPanel;
    JFrame instuctionsFrame;

    public static int changeBackground = 1;

    public CountryRunnerTitleScreen(){
	
	this.repaint();
        playGameButton = new JButton("Play Game");
	chooseBackground = new JButton("Choose Background");
        helpButton = new JButton("Instructions");
        highscoreButton = new JButton("High Score");
        titleLabel = new JLabel("Country Runner");
        gbc = new GridBagConstraints();
        topPanel = new JPanel(new BorderLayout());
        botPanel = new JPanel(new GridBagLayout());

        // instructions
        final String instructions = "Avoid all obstacles that come into the screen. Could be a stationary scarecrow, or a dashing sheep.\n" +
                "Some crows could be overhead so time your jumps carefully." +
                "Press the UP arrow key to jump";

        //set layout manager for this panel
        setLayout(new GridLayout(2,1));

        //set title font and size

        titleLabel.setFont(new Font("Serif",Font.BOLD,38));
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
	chooseBackground.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseReleased(MouseEvent e) {

		Object[] possibleValues = { "Sakura Forest", "Desert", "Limbo"};
		Object selectedValue = JOptionPane.showInputDialog(null,
							  "Choose one", "Input",
							  JOptionPane.INFORMATION_MESSAGE, null,
							  possibleValues, possibleValues[0]);
		
		if (selectedValue == "Sakura Forest")
		    changeBackground = 1;
		else if (selectedValue == "Desert")
		     changeBackground = 2;
		else if (selectedValue == "Limbo")
		    changeBackground = 3;
		/*if(changeBackground == false){
		    changeBackground = true;
		}
		else{
		    changeBackground = false;
		    }*/
	    }
       });
    }
    public void paintComponent(Graphics g){
	
	Image im = new ImageIcon("res/newbackground.jpg").getImage();
	
        g.drawImage(im, 0, 0, this);
    }
}
