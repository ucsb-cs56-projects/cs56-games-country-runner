package edu.ucsb.cs56.projects.games.country_runner;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** Test class for Sprite
*@author Sidney Rhoads, Tom Craig
*@version 2014/02/27 
*@see Sprite
*/

public class SpriteTest
{
	/** Test for Sprite.getX()
	@see Sprite.getX()
	*/
	@Test
		public void test_getX() {
		Runner piggy = new Runner();
		assertEquals(500, piggy.getX(), 0.00);
	}
	
	/** Test for Sprite.getY()
	@see Sprite.getY()
	*/
	@Test 
		public void test_getY() {
		Runner piggy = new Runner();
		piggy.setY(0);
		assertEquals(0, piggy.getY(), 0.00);
	}
	
	/** Test for Sprite.setX()
	@see Sprite.setX()
	*/
	@Test 
		public void test_setX() {
		Runner piggy = new Runner();
		piggy.setX(350);
		assertEquals(350, piggy.getX(), 0.00);
	}
	/** Test for Sprite.setY()
	@see Sprite.setY()
	*/
	@Test 
		public void test_setY() {
		Runner piggy = new Runner();
		piggy.setY(350);
		assertEquals(350, piggy.getY(), 0.00);
	}
}
	
	
	
