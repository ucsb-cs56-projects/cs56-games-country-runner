package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

 
public class Background {
    private BufferedImage image;
 
    private int x;
    private int y;
 
    public Background(String imageName) {
        this(0,0,imageName);
    }
 
    public Background(int x, int y, String imageName) {
        this.x = x;
        this.y = y;
 
        // Try to open the image file background.png
        try {
            image = ImageIO.read(new File(imageName));
        }
        catch (Exception e) { System.out.println(e); }
 
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     */
    public void draw(Graphics window) {
 
        // Draw the image onto the Graphics reference
        window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
 
        // Move the x position right for next time
        this.x += 2;
 
        // Check to see if the image has gone off stage right
        if (this.x >= image.getWidth()) {
 
            // If it has, line it back up so that its right edge is
            // lined up to the left side of the other background image
            this.x = this.x - image.getWidth() * 2;
        }
 
    }
 
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getImageWidth() {
        return image.getWidth();
    }
 
    public static String[] loadBackgrounds() {
	//Load background images
	String[] backgrounds = new String[3];
	for (int i=1; i<=backgrounds.length; i++) {
	    String imagePath = "res/background";
	    imagePath += i;
	    imagePath += ".jpg";		    
	    backgrounds[i-1] = imagePath;
	}
	return backgrounds;
    }
 
}
