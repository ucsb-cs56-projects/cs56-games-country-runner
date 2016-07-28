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
    JButton saveScoreLabel;
    
    private int score;
    public static String name;

    public GameOverJPanel(int score) {
	this.score = score;
	
        backgroundImage = new ImageIcon("res/Gameover.jpg").getImage();
        this.repaint();

	String str = "Score: " + score;
	scoreLabel = new JButton(str);
        playAgainButton = new JButton("Play Again?");
        backToMenuButton = new JButton("Go back to Main Menu");
	saveScoreLabel = new JButton("Save Score");

	this.add(scoreLabel);
	this.add(saveScoreLabel);
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
	saveScoreLabel.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseReleased(MouseEvent e){
		    String str = (String)JOptionPane.showInputDialog(null, "Input Name", "Username", JOptionPane.INFORMATION_MESSAGE, null, null,"Name");
		    name = str;

		    //save score to score system
		    ScoreSystem ss = new ScoreSystem();
		    try{
			ss.loadScores();
		    }catch(Exception q){}
		    Score s = new Score (score, name, CountryRunnerTitleScreen.difficulty);
		    ss.addScore(s);
		    try{
			ss.saveScores();
		    }catch(Exception q){}
		    

		}
	    });
    }

    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
