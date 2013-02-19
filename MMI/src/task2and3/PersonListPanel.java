package task2and3;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class PersonListPanel extends JPanel {
	private JList list;
	private PersonPanel panel;
	private DefaultListModel model;
	
	public PersonListPanel(){
		list = new JList();
		
		panel = new PersonPanel();
		list.setName("PersonList");
		panel.setName("PersonPanel");
	}
	
	
	public void setModel(DefaultListModel model){
		this.model = model;
		list.setModel(this.model);
	}
	
	public DefaultListModel getModel(){
		return this.model;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Person frank = new Person("Frank Arnesen");
		Person arne = new Person("Arne Bjarnesen");
		Person beate = new Person("Beate Stakesen");
		
		PersonListPanel personList = new PersonListPanel();
		DefaultListModel listModel = new DefaultListModel();
		listModel.add(0, frank);
		listModel.add(1, arne);
		listModel.add(2, beate);
		
		personList.setModel(listModel);
		frame.getContentPane().add(personList);
		
		frame.setVisible(true);
		
		
	}
	
}
