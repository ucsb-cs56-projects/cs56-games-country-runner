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
  	private static int numOfImages;
  	
  	public SpriteSequence(String sheetName, int row, int numOfImages)
  	{
  		this.setNumOfImages(numOfImages);
	  	try {
            spriteSheet = ImageIO.read(new File("res/" + sheetName + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
         }

		sequence = new ArrayList<BufferedImage>(numOfImages);
        for(int i=0; i < numOfImages; i++)
        {
	       sequence.add(getSprite(i, row));
        }


        
  	}
  	public int getNumOfImages()
  	{
	  	return this.numOfImages;
  	}
  	public void setNumOfImages(int numOfImages)
  	{
	  	this.numOfImages = numOfImages; 
  	}
  	
    public BufferedImage getSprite(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public ArrayList<BufferedImage> getSequence()
    {
	    return sequence;
    }

}