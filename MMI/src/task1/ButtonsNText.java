package task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel {
	
	private ButtonGroup group;
	private JTextField TextLine;
	private JToggleButton UpperCaseButton;
	private JToggleButton LowerCaseButton;
	private JCheckBox ContinuousButton;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Task 1");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}
	
	public ButtonsNText(){
		group = new ButtonGroup();
		TextLine = new JTextField();
		UpperCaseButton = new JToggleButton("Upper case");
		LowerCaseButton = new JToggleButton("Lower case");
		ContinuousButton = new JCheckBox();
		
		UpperCaseButton.addActionListener(new UpperCase());
		LowerCaseButton.addActionListener(new LowerCase());
		TextLine.addKeyListener(new Type());
		
		TextLine.setColumns(20);
		group.add(LowerCaseButton);
		group.add(UpperCaseButton);
		ContinuousButton.setText("Continuous?");
		
		TextLine.setName("TextLine");
		UpperCaseButton.setName("UpperCaseButton");
		LowerCaseButton.setName("LowerCaseButton");
		ContinuousButton.setName("ContinuousButton");
		
		add(TextLine);
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(ContinuousButton);
	}
	
	class UpperCase implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int caret = TextLine.getCaretPosition();
			TextLine.setText(TextLine.getText().toUpperCase());
			TextLine.grabFocus();
			TextLine.setCaretPosition(caret);
		}
	}
	
	class LowerCase implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int caret = TextLine.getCaretPosition();
			TextLine.setText(TextLine.getText().toLowerCase());
			TextLine.grabFocus();
			TextLine.setCaretPosition(caret);
		}
	}
	
	class Type implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int caret = TextLine.getCaretPosition();
			if(e.getKeyCode()==10){
				if(UpperCaseButton.isSelected()){
					TextLine.setText(TextLine.getText().toUpperCase());
				}
				else if(LowerCaseButton.isSelected()){
					TextLine.setText(TextLine.getText().toLowerCase());
				}
				TextLine.grabFocus();
				TextLine.setCaretPosition(caret);
			}
			
			if(ContinuousButton.isSelected()){
				if(UpperCaseButton.isSelected()){
					TextLine.setText(TextLine.getText().toUpperCase());
				}
				else if(LowerCaseButton.isSelected()){
					TextLine.setText(TextLine.getText().toLowerCase());
				}
				TextLine.grabFocus();
				TextLine.setCaretPosition(caret);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

	}
	
}
