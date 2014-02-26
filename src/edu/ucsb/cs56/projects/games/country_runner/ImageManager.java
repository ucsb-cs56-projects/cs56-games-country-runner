package edu.ucsb.cs56.projects.games.country_runner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/** Class ImageManager loads and manages a sprite sheet
*	This is meant to be subclassed for each sprite, be-
*	cause we aren't sure ahead of tiem how many images
*	each sprite will have
*/
public class ImageManager
{
    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 64;
	//Subclasses will have instance varaiebls of this form:
 	//private static ArrayList<BufferedImage> sequence;

	/**Contructor
	 * Loads an entire sprite sheet
	 */
  	public ImageManager(String sheetName)
  	{
	  	try {
            spriteSheet = ImageIO.read(new File("res/" + sheetName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
         }
  	}

  	/**Returns a single sprite, pulled
  	 * from the sprite sheet
  	 */
    public BufferedImage getSubImage(int xGrid, int yGrid)
    {
        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}