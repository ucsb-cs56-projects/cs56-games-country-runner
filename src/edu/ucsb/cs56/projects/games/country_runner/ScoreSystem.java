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

public class ScoreSystem extends ArrayList<Integer> {

    public ScoreSystem() { }

    public void loadScores() throws java.io.IOException {

        File file = new File("HighScores");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Boolean dot = false;
            while ((line = br.readLine()) != null) {
                int score = Integer.parseInt(line);
                this.add(score);
            }
        }
    }

    public void addScore(int score) { this.add(score); }

    public void saveScores() throws java.io.IOException {
	
        int size = this.size();
	
        //sort currente arraylist in decreasing order
        Collections.sort(this);
        Collections.reverse(this);

        try {
            //check if the file exists, if not, create one
            File file = new File("HighScores");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //write scores to the file line by line
            for (int i=0; i<size; i++) {
                int score = this.get(i);
                if (score != 0) {
                    String content = score + System.lineSeparator();
                    bw.write(content);
                }
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String toStringFromMemory() {
	
        //sort currente arraylist in decreasing order
        Collections.sort(this);
        Collections.reverse(this);

        String result = "";

        for (int i=0; i<this.size(); i++)
            result = result + (i+1) + ". " + this.get(i) + "\n";

        //if memory is empty, print out "Empty"
        if (this.size() == 0)
            result = "Empty";

        return result;
    }

    public String toStringFromFile() throws java.io.IOException {
        try{
            this.loadScores();
        }catch(Exception e){
            System.out.println("Failed to load scores");
        }
        String result = this.toStringFromMemory();

        return result;
    }
}