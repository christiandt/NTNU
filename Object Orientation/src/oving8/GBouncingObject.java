package oving8;

import java.awt.Rectangle;

import acm.graphics.GCanvas;
import acm.graphics.GContainer;
import acm.graphics.GDimension;
import acm.graphics.GObject;
import acm.graphics.GRectangle;

public class GBouncingObject extends GSprite {

	public GBouncingObject(String name) {
		super(name);
	}

	private GRectangle getParentBounds() {
		GContainer parent = getParent();
		if (parent instanceof GCanvas) {
			Rectangle bounds = ((GCanvas) parent).getBounds();
			return new GRectangle(bounds.x, bounds.y, bounds.width, bounds.height);
		} else if (parent instanceof GObject) {
			return ((GObject) parent).getBounds();
		}
		return null;
	}
	
	@Override
	public void move() {
		super.move();
		GRectangle parentBounds = getParentBounds(), bounds = getBounds();
		GDimension speed = getSpeed();
		double dx = 0, dy = 0, sx = 1, sy = 1;
		if (bounds.getX() < 0) {
			dx = -bounds.getX();
			sx = -1;
		} else if (bounds.getX() > parentBounds.getWidth() - this.getWidth()) {
			dx = parentBounds.getWidth() - (bounds.getX() + bounds.getWidth());
			sx = -1;
		}
		if (bounds.getY() < 0) {
			dy = -bounds.getY();
			sy = -1;
		} else if (bounds.getY() > parentBounds.getHeight() - this.getHeight()) {
			dy = parentBounds.getHeight() - (bounds.getY() + bounds.getHeight());
			sy = -1;
		}
		if (dx != 0 || dy != 0) {
			move(dx, dy);
		}
		if (sx != 1 || sy != 1) {
			setSpeed(speed.getWidth() * sx, speed.getHeight() * sy);
		}
	}
}
