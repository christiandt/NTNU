package oving8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import acm.graphics.GCanvas;
import acm.graphics.GObject;
import acm.util.SwingTimer;

public class GSpritePanel extends GCanvas implements ActionListener {

	private SwingTimer timer;
	GObject objekt;

	public void startSprites(int timerRate) {
		if (timer != null) {
			timer.stop();
		}
		timer = new SwingTimer(timerRate, this);
		timer.start();
	}

	public void stopSprites() {
		if (timer != null) {
			timer.stop();
		}
	}

	public void actionPerformed(ActionEvent e) {	
		for (int i = 0; i < getElementCount(); i++) {
			objekt = getElement(i);
			if (objekt instanceof GMoving) {
				((GMoving) objekt).move();
			}
		}
	}
}
