package edu.ucsb.cs56.projects.games.country_runner;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreSystem extends ArrayList<Score> {
    /** Default constructor */
    public ScoreSystem() {}
    /** loadScores
     *  loads the score into a file that is in
     *  the data folder unless there is none.
     *  If there is none, it will create a new file
     *  and put the score into the new file
     */
    public void loadScores() throws java.io.IOException {
        
        File file = new File("data/HighScores");
        if (!file.exists()) {
            file.createNewFile();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Boolean dot = false;
            while ((line = br.readLine()) != null) {
                Score s = new Score(line);
                //int score = Integer.parseInt(line);
                this.add(s);
            }
        }
    }
    /** addScore adds a new score
     *  @param score
     */
    public void addScore(Score score) { this.add(score); }
    /** saveScores saves the score into the file
     *  and sorts the score in order to display the
     *  highest score
     */
    
    public void clearScores() throws java.io.IOException {
        
        int size = this.size();
        try {
            //check if the file exists, if not, create one
            File file = new File("data/HighScores");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            //delete scores to the file line by line
            for (int i=0; i<10 && i<size; i++) {
                Score score = this.get(i);
                if (score.score != 0) {
                    String content = "";
                    bw.write(content);
                }
            }
            
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveScores() throws java.io.IOException {
        
        int size = this.size();
        
        //sort current arraylist in decreasing order
        Collections.sort(this);
        Collections.reverse(this);
        
        try {
            //check if the file exists, if not, create one
            File file = new File("data/HighScores");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            //write scores to the file line by line
            for (int i=0; i<10 && i<size; i++) {
                Score score = this.get(i);
                if (score.score != 0) {
                    String content = score.toString() + System.lineSeparator();
                    bw.write(content);
                }
            }
            
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** toStringFromMemory
     *  converts the ScoreSystem into a
     *  String while at the same sorting it
     */
    public String toStringFromMemory() {
        
        //sort currente arraylist in decreasing order
        Collections.sort(this);
        Collections.reverse(this);
        
        String result = "";
        
        for (int i=0; i<this.size(); i++)
            result = result + (i+1) + ". " + this.get(i).toString() + "\n";
        
        //if memory is empty, print out "Empty"
        if (this.size() == 0)
            result = "Empty";
        
        return result;
    }
    /** toStringFromFile loads the scores and then
     *  uses toStringFromMemory and returns that result
     */
    public String toStringFromFile() throws java.io.IOException {
        try{
            this.loadScores();
        }
        catch(Exception e){
            System.out.println("Failed to load scores");
        }
        String result = this.toStringFromMemory();
        
        return result;
    }
}
