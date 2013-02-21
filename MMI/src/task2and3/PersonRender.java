package task2and3;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;


public class PersonRender extends JLabel implements ListCellRenderer {
	private ImageIcon icon;
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		icon = new ImageIcon("male.png");
		Person person = (Person) value;
		this.setIcon(icon);
		this.setText(person.getName());
		this.setOpaque(true);
		
		
		if (isSelected){
			this.setForeground(UIManager.getColor("List.selectionForeground"));
			this.setBackground(UIManager.getColor("List.selectionBackground"));
		}
		else{
			this.setForeground(UIManager.getColor("List.foreground"));
			this.setBackground(UIManager.getColor("List.background"));
		}
				
		return this;
	}

}
