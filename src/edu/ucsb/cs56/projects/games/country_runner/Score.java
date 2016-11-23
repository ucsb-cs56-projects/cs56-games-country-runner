package edu.ucsb.cs56.projects.games.country_runner;

public class Score implements Comparable<Score> {

    public int score;
    public String name;
    public String difficulty;
    /** Score constructor that changes the difficulty for the 
     *  main screen when u switch it
     *  @param score of user
     *  @param name of user
     *  @param difficulty of user
     */
    public Score(int score, String name, int difficulty) {
	this.score = score;
	this.name = name;
	switch (difficulty) {
	case 1: {
	    this.difficulty = "Easy";
	    break;
	}
	case 2: {
	    this.difficulty = "Normal";
	    break;
	}
	case 3: {
	    this.difficulty = "Hard";
	    break;
	}
	}
    }
    /** Score constructor that takes the score, name, and difficulty
     *  in a line instead of 3 paramters 
     *  @param line description
     */
    public Score(String line) {
	String[] temp = line.split(" ");
	int score = (int)Integer.parseInt(temp[1]);
	String name = temp[0];
	String difficulty = temp[3];
	this.score = score;
	this.name = name;
	this.difficulty = difficulty;
    }

    @Override
    public String toString() {
	String result = name + " " + score + " Difficulty: " +  difficulty;
	return result;
    }

    @Override
    public int compareTo(Score o) {
	int cmp = this.score > o.score? +1 : this.score < o.score? -1 : 0;
	return cmp;
    }
}
