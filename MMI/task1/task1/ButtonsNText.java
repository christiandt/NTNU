package task1;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Task 1");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}
	
	public ButtonsNText(){
		ButtonGroup group = new ButtonGroup();
		JTextField TextLine = new JTextField();
		JToggleButton UpperCaseButton = new JToggleButton("Upper case");
		JToggleButton LowerCaseButton = new JToggleButton("Lower case");
		
		TextLine.setColumns(20);
		group.add(LowerCaseButton);
		group.add(UpperCaseButton);
		
		add(TextLine);
		add(UpperCaseButton);
		add(LowerCaseButton);
	}
	
}
