package edu.ucsb.cs56.projects.games.country_runner;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

//imports for the sprites
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**Sprite an abstract class form which all particular sprites inherit.
 * @author Sidney Rhoads, Tom Craig
 * @version CS56, W14
 *
 */

public class Sprite extends GeneralPathWrapper implements Shape
{