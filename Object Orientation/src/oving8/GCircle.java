package oving8;

import java.awt.Graphics;
import acm.graphics.GObject;
import acm.graphics.GRectangle;
import acm.graphics.GScalable;

public class GCircle extends GObject implements GScalable {
	
	private double radius;
	

	GCircle(double radius){
		this.radius = radius;
	}
	
	double getRadius(){
		return this.radius;
		
	}
	
	void setRadius(double radius){
		this.radius = radius;
	}

	@Override
	public void scale(double sx, double sy) {
		if(sy>sx){
			this.radius = sx;			
		}
		else{
			this.radius = sy;
		}
		
	}

	@Override
	public void scale(double sf) {
		this.radius = radius*sf;
		
	}

	@Override
	public void paint(Graphics g) {
		int x = (int)Math.round(this.getX());
		int y = (int)Math.round(this.getY());
		int diameter = (int)this.radius*2;
		g.drawOval(x, y, diameter, diameter);
		
	}

	@Override
	public GRectangle getBounds() {
		int x = (int)Math.round(this.getX());
		int y = (int)Math.round(this.getY());
		double diameter = this.radius*2;
		GRectangle rekt = new GRectangle();
		rekt.setBounds(x, y, diameter, diameter);
		return rekt;
	}

	
}
