
package edu.ucsb.cs56.projects.games.country_runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
 * Class plays background music when the use is playing the game and stops
 * when he or she loses
 */

public class BackgroundMusic implements Runnable{
    private int currentSongIndex;
    private Clip clip;
    public void playMusic(String fileName){
        try{
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void stop(){
        if(clip==null) return;
        clip.stop();
    }
    @Override
    public void run() {
        playMusic("res/Jipang.wav");
    }
}
