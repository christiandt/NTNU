package sokoban3;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import acm.program.GraphicsProgram;

public class ClipboardAndModifiers extends GraphicsProgram implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Clipboard clipboard;
	
	public void init() {
		addKeyListeners();
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

	}

	public void run() {

	}

	public void keyPressed(KeyEvent event) {
		if (event.isShiftDown())
			println("Shift is down!");
		else
			println("Shift is not down");
		
		if (event.getKeyCode() == event.VK_P) {
			println("Printing the clipboard");
			String data;
			try {
				data = (String) clipboard.getData(DataFlavor.stringFlavor);
				println(data);
			} catch (UnsupportedFlavorException e) {
				println("Feil type!");
				e.printStackTrace();
			} catch (IOException e) {
				println("I/O-feil");
			}
		}

		else if (event.getKeyCode() == event.VK_C) {
			println("Copying the text \"Sokoban\" onto the keyboard");
			String data = "Sokoban";
			Transferable transferableData = new StringSelection(data);
			clipboard.setContents(transferableData,null);

		}
	}

}