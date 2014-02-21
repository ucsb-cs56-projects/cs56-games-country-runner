package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Sprite
{
    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 64;
  	private static ArrayList<BufferedImage> ;

    public static BufferedImage loadSpriteSheet(String file)
    {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;

    }

    public static BufferedImage getSprite(int xGrid, int yGrid)
    {
        if (spriteSheet == null) {
            spriteSheet = loadSpriteSheet("pig");
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public static ArrayList<BufferedImage> getrunningImages()
    {
	    return runningImages;
    }

}