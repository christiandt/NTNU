package oving8;

import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;

public class GSpriteProgram extends GraphicsProgram {
	
	GSpritePanel gSpritePanel;
	
	@Override
	protected GCanvas createGCanvas(){
		gSpritePanel = new GSpritePanel();
		return gSpritePanel;
	}
	
	public void run() {
		int screensizex = 1680;
		int screensizey = 1050;
		for (int i = 0; i < 20; i++) {
			GCircle circle = new GCircle(Math.random()*screensizey);
			circle.setLocation(Math.random()*screensizex, Math.random()*(screensizey));
			add(circle);
		}
		GSprite mover = new GBouncingObject("sokoban/icons/mover16x16.png");
		GSprite wall = new GBouncingObject("sokoban/icons/wall16x16.png");
		GSprite movable = new GBouncingObject("sokoban/icons/movable16x16.png");
		mover.setLocation(Math.random()*100, Math.random()*100);
		wall.setLocation(Math.random()*100, Math.random()*100);
		movable.setLocation(Math.random()*100, Math.random()*100);
		mover.setSpeed(Math.random()*100, Math.random()*100);
		wall.setSpeed(Math.random()*100, Math.random()*100);
		movable.setSpeed(Math.random()*100, Math.random()*100);
		add(mover);
		add(wall);
		add(movable);
		gSpritePanel.startSprites(100);
		
	}
}
