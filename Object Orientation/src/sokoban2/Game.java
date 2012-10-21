package sokoban2;

import acm.program.GraphicsProgram;
import java.awt.event.KeyEvent;

public class Game extends GraphicsProgram {
        public void init() {
                addKeyListeners();
        }

        public void keyPressed(KeyEvent event) {
                println("You pressed: " + event.getKeyChar());
                if(event.getKeyChar() == KeyEvent.VK_ESCAPE){
                	println("There is no escape. :P");
                }
        }
}