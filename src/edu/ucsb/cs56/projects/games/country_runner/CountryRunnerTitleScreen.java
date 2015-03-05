package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CountryRunnerTitleScreen extends JPanel{
    // Java GUI Components
    JButton playGameButton;
    JButton helpButton;
    JButton highscoreButton;
    JLabel titleLabel;
    GridBagConstraints gbc;
    JPanel topPanel;
    JPanel botPanel;
    JFrame instuctionsFrame;

    public CountryRunnerTitleScreen(){
        playGameButton = new JButton("Play Game");
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
    }
}
