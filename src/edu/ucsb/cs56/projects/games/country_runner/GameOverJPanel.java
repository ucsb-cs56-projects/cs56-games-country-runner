package edu.ucsb.cs56.projects.games.country_runner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GameOverJPanel extends JPanel {
    public Graphics2D g2;
    Image backgroundImage;
    JButton playAgainButton;
    JButton backToMenuButton;
    JButton scoreLabel;
    //JLabel scoreLabel;
    
    private int score;

    public GameOverJPanel(int score) {
	this.score = score;
	
        backgroundImage = new ImageIcon("res/gameover.png").getImage();
        this.repaint();
	
	/*scoreLabel = new JLabel("Your score: " + Integer.toString(score));
        scoreLabel.setFont(new Font("Arial",Font.BOLD,24));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(450,1,200,100);*/

	String str = "Score: " + score;
	scoreLabel = new JButton(str);
        playAgainButton = new JButton("Play Again?");
        backToMenuButton = new JButton("Go back to Main Menu");

	this.add(scoreLabel);
        this.add(playAgainButton);
        this.add(backToMenuButton);

        /** Event Listeners **/
        playAgainButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CountryRunnerGui.setCurrentPanelTo(new CountryRunnerJPanel());
            }
        }); 
        backToMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CountryRunnerGui.setCurrentPanelTo(new CountryRunnerTitleScreen());
            }
        });
    }

    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
