package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**We extend the basic ImageManager class to
 * work with the runner.
 * This way we can handle the runner's specifics
 * like runnig and jumping etc.
 */
public class RunnerImageManager extends ImageManager
{
	//Keeps track of what image the runner is
	//displaying from a speicif animation sequence
	//Essentially an iterator
	public int currentSequenceIndex = 0;

	//The runner will keep an array list for each
	//sequence his sprite needs to cycle through
	private ArrayList<BufferedImage> running;
	private ArrayList<BufferedImage> jumping;

	/**
	 * Constructor
	 * Takes in a sprite sheet and loads the approprites
	 * arrayist with images from the sheet
	 */
	RunnerImageManager(String sheetName)
	{
		super(sheetName);

		running = new ArrayList<BufferedImage>();
		loadSequence(running, 0, 4);
		//Not yet implemented...
		//jumping = new ArrayList<BufferedImage>();
		//loadSequence(jumping);

	}

	/**
	 * loadSequence loads a specific arrayList with appropriates
	 * images from the sprite sheet.
	 * It is only ever called in the constructor.
	 * Here, row is what row we take images from in the sprite sheet
	 * numImages is thenumber of images in that sequence
	 *
	 * These parametes allow for precision when loading sprite sequences.
	 * If the running animation takes more images to complete than the
	 * jumping sequence, for example, that can be sepcified with the parameters
	 */
	public void loadSequence(ArrayList<BufferedImage> sequence, int row, int numImages)
	{
		for (int i = 0; i < numImages; i++)
		{
			//This method comes from the daddy class
			sequence.add(getSubImage(i, row));
		}
	}

	/**
	 * getSequenceImages returns a specific images from a sequence.
	 * For example you can access the third image in the runner's running sequence in this fashion
	 * This could be abstracted and put into the ImageManager calss, not sure...
	 */
	public BufferedImage getSequenceImage(ArrayList<BufferedImage> sequence, int index)
	{
		return sequence.get(index);
	}

	/**
	 * Returns the next image in the running sequence
	 * If we are at the end of the sequence,
	 * it returns the first image, and resets the
	 * currentSequenceIndex iterator
	 */
	public BufferedImage getNextRunningImage()
	{
		currentSequenceIndex++;
		if (currentSequenceIndex == running.size())
		{
			currentSequenceIndex = 0;
		}

		return running.get(currentSequenceIndex);
	}

	/**
	 * Returns the next image in the jumping sequence
	 * If we are at the end of the sequence,
	 * it returns the first image, and resets the
	 * currentSequenceIndex iterator
	 * NOTE THAT THIS CALLS THE RUNNING SEQUENCE
	 * NOT A BUG!!! JUST HAVENT FINISHED THE SPRITE SHEET YET!!!
	 */
	public BufferedImage getNextJumpingImage()
	{
		currentSequenceIndex++;
		if (currentSequenceIndex == running.size())
		{
			currentSequenceIndex = 0;
		}

		return running.get(currentSequenceIndex);
	}
}