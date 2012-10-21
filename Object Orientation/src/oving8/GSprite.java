package oving8;

import acm.graphics.GDimension;
import acm.graphics.GImage;

public class GSprite extends GImage implements GMoving {

	GDimension speed;
	
	public GSprite(String name) {
		super(name);
		this.speed = new GDimension();
	}

	@Override
	public GDimension getSpeed() {
		return new GDimension(this.speed);
	}

	@Override
	public void setSpeed(double xSpeed, double ySpeed) {
		this.speed.setSize(xSpeed, ySpeed);
	}
	

	@Override
	public void accelerate(double xAcc, double yAcc) {
		double xSpeed = this.speed.getWidth();
		double ySpeed = this.speed.getHeight();
		setSpeed(xSpeed+xAcc, ySpeed+yAcc);
	}

	@Override
	public void move() {
		double xLocation = this.getX();
		double yLocation = this.getY();
		double xSpeed = this.speed.getWidth();
		double ySpeed = this.speed.getHeight();
		this.setLocation(xLocation+xSpeed, yLocation+ySpeed);
	}

}
