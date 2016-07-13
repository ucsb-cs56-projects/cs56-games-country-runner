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

    public ScoreSystem() throws java.io.IOException {

	String  thisLine = null;
	//load file and check if the file exist, if not create one
	File file = new File("res/HighScores");
	if (!file.exists()) {
	    file.createNewFile();
	}

	//load file into bufferedreader
	FileReader fr = new FileReader(file.getAbsoluteFile());
	BufferedReader br = new BufferedReader(fr);    

	//if file is empty, start arraylist with size of 1 and with just 0
	if (br.readLine() == null) {
	    this.add(0,0);
	}
	else {
	    try{
		//load scores into arraylist
		while ((thisLine = br.readLine()) != null) {
		    int score = Integer.parseInt(thisLine);
		    this.add(score);
		}       
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    
	}
    }

    //public int numOfScores() { return.this.size(); }

    public void addScore(int score) { this.add(score); }

    public void saveScores() throws java.io.IOException {

	int size = this.size();

	//sort currente arraylist in decreasing order
	Collections.sort(this);
	Collections.reverse(this);

	try {
	    //check if the file exists, if not, create one
	    File file = new File("res/HighScores");
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

    public String toStringFromFile() throws java.io.IOException {

	String thisLine = null;
	String result = null;
	int num = 1;
	
	//load file and check if the file exist, if not create one
	File file = new File("res/HighScores");
	if (!file.exists()) {
	    file.createNewFile();
	}

	//load file into bufferedreader
	FileReader fr = new FileReader(file.getAbsoluteFile());
	BufferedReader br = new BufferedReader(fr);    

	//if file is empty, print out "Empty"
	if (br.readLine() == null) {
	    result = "Empty";
	}
	else {
	    try{
		//load scores string with count
		while ((thisLine = br.readLine()) != null) {
		    result = result + num + ". " + thisLine;
		    num++;
		}       
	    }catch(Exception e){
		e.printStackTrace();
	    }
	}
	return result;
    }
       
}
    
