package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RunnerImageManager extends ImageManager
{
	private int currentSequenceIndex = 0;
	private ArrayList<BufferedImage> running;
	private ArrayList<BufferedImage> jumping;

	RunnerImageManager(String sheetName)
	{
		super(sheetName);

		running = new ArrayList<BufferedImage>();
		loadSequence(running, 0, 2);
		//Not yet implemented
		/*
		jumping = new ArrayList<BufferedImage>();
		loadSequence(jumping);
		*/
	}

	//Where x is the row number, and y is the number
	//of images in the sequence for that row
	public void loadSequence(ArrayList<BufferedImage> sequence, int row, int numImages)
	{
		for (int i = 0; i < numImages; i++)
		{
			sequence.add(getSubImage(i, row));
		}
	}

	public BufferedImage getSequenceImage(ArrayList<BufferedImage> sequence, int index)
	{
		return sequence.get(index);
	}

	public BufferedImage getNextRunningImage()
	{
		currentSequenceIndex++;
		if (currentSequenceIndex == running.size())
		{
			currentSequenceIndex = 0;
		}

		return running.get(currentSequenceIndex);
	}
}