package task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel {
	
	private JTextField textLine;
	private JToggleButton UpperCaseButton;
	private JToggleButton LowerCaseButton;
	private JCheckBox check;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Task 1");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}
	
	public ButtonsNText(){
		ButtonGroup group = new ButtonGroup();
		textLine = new JTextField();
		UpperCaseButton = new JToggleButton("Upper case");
		LowerCaseButton = new JToggleButton("Lower case");
		check = new JCheckBox();
		
		UpperCaseButton.addActionListener(new UpperCase());
		LowerCaseButton.addActionListener(new LowerCase());
		textLine.addKeyListener(new Type());
		
		textLine.setColumns(20);
		group.add(LowerCaseButton);
		group.add(UpperCaseButton);
		check.setText("Continuous?");
		
		add(textLine);
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(check);
	}
	
	class UpperCase implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			textLine.setText(textLine.getText().toUpperCase());
		}
	}
	
	class LowerCase implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			textLine.setText(textLine.getText().toLowerCase());
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
			if(check.isSelected()){
				if(UpperCaseButton.isSelected()){
					textLine.setText(textLine.getText().toUpperCase());
				}
				else if(LowerCaseButton.isSelected()){
					textLine.setText(textLine.getText().toLowerCase());
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

	}
	
}
