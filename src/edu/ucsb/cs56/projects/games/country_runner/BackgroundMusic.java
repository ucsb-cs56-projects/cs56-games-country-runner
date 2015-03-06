package edu.ucsb.cs56.projects.games.country_runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 * Class plays background music when the use is playing the game and stops
 * when he or she loses
 */
public class BackgroundMusic implements Runnable{
    // Song is static so other classes can stop the music
    public static AudioStream song;

    // Is called when the thread is first ran.
    void playMusic(){
        String filename = "res/Jipang.wav";
        InputStream in = null;

        //attempt to read in the file name
        try{
            in = new FileInputStream(filename);
        } catch (FileNotFoundException ex){
            System.out.println("Song File not found");
        }

        //attempt to play song
        try{
            song = new AudioStream(in);
            AudioPlayer.player.start(song);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        playMusic();
    }
}
