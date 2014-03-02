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
		Sprite piggy = new Sprite(300, 400, null);
		assertEquals(300, piggy.getX());
	}
	
	/** Test for Sprite.getY()
	@see Sprite.getY()
	*/
	@Test 
		public void test_getY() {
		Sprite piggy = new Sprite(300, 400, null);
		assertEquals(300, piggy.getY());
	}
	
	/** Test for Sprite.setX()
	@see Sprite.setX()
	*/
	@Test 
		public void test_setX() {
		Sprite piggy = new Sprite(300, 400, null);
		piggy.setX(350);
		assertEquals(350, piggy.getX());
	}
	/** Test for Sprite.setY()
	@see Sprite.setY()
	*/
	@Test 
		public void test_setY() {
		Sprite piggy = new Sprite(300, 400, null);
		piggy.setY(350);
		assertEquals(350, piggy.getY());
	}
}
	
	
	