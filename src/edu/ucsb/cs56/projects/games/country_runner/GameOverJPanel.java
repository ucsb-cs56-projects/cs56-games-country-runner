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
    JButton clearScoreLabel;
    
    private int score;
    public static String name;
    /** Constructor that sets up the Game Over Screen, which
     *  occurs when the player runs into an obstacle
     *  @param score
     */
    public GameOverJPanel(int score) {
        this.score = score;
        
        backgroundImage = new ImageIcon("res/Gameover.jpg").getImage();
        this.repaint();
        
        String str = "Score: " + score;
        scoreLabel = new JButton(str);
        playAgainButton = new JButton("Play Again?");
        backToMenuButton = new JButton("Go back to Main Menu");
        clearScoreLabel = new JButton("Clear High Scores");
        /** Do not want to add the 'Save Score' button if a score of zero occurs **/
        if(score != 0){
            saveScoreLabel = new JButton("Save Score");
            this.add(saveScoreLabel);
        }
        this.add(clearScoreLabel);
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
        clearScoreLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ScoreSystem ss = new ScoreSystem();
                try{
                    ss.loadScores();
                }catch(Exception q){}
                try{
                    ss.clearScores();
                }catch(Exception q){}
            }
        });
        if(saveScoreLabel != null){
            saveScoreLabel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseReleased(MouseEvent e){
                    String str = (String)JOptionPane.showInputDialog(null, "Input Name", "Username", JOptionPane.INFORMATION_MESSAGE, null, null,"Name");
                    if (!str.isEmpty()) {
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
                }
            });
        }
        
    }
    /** paintComponent paints the Background Image
     */
    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
