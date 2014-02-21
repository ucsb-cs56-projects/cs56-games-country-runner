package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class SpriteSequence
{
    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 64;
  	private static ArrayList<BufferedImage> sequence;

  	public SpriteSequence(String sheetName, int row, int numOfImages)
  	{
	  	try {
            spriteSheet = ImageIO.read(new File("res/" + sheetName + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0; i < numOfImages; i++)
        {
	       sequence.add(getSprite(row, i));
        }
  	}


    public static BufferedImage getSprite(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public static ArrayList<BufferedImage> getSequence()
    {
	    return sequence;
    }

}