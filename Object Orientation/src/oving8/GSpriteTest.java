package oving8;

import junit.framework.TestCase;
import acm.graphics.GDimension;

public  class GSpriteTest extends TestCase {

	private GSprite gSprite;

	protected void setUp() {
		this.gSprite = new GSprite("oving8/mover_on_target16x16.png");
	}

	protected void testLocation(double x, double y) {
		assertEquals(x, gSprite.getX());
		assertEquals(y, gSprite.getY());
	}
	
	public void testGetSetSpeed() {
		gSprite.setSpeed(10, 15);
		GDimension gDimension = gSprite.getSpeed();
		assertEquals(10.0, gDimension.getWidth());
		assertEquals(15.0, gDimension.getHeight());
		gDimension.setSize(15, 10);
		gDimension = gSprite.getSpeed();
		assertEquals(10.0, gDimension.getWidth());
		assertEquals(15.0, gDimension.getHeight());
	}
	
	public void testMove() {
		gSprite.setLocation(0, 10);
		gSprite.setSpeed(10, 15);
		gSprite.move();
		testLocation(10, 25);
		gSprite.accelerate(5, 10);
		gSprite.move();
		testLocation(25, 50);
	}
}
