package task2and3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener {
	private GridBagConstraints c;
	private JList list;
	protected PersonPanel panel;
	private DefaultListModel model;
	private JButton newBtn;
	private JButton deleteBtn;
	private int listSize;
	
	public PersonListPanel(){
		model = new DefaultListModel();
		
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		list = new JList();
		list.setName("PersonList");
		list.setFixedCellWidth(150);
		list.addListSelectionListener(this);
		list.setCellRenderer(new PersonRender());
		
		setModel(model);
		
		panel = new PersonPanel();
		panel.setName("PersonPanel");
		
		newBtn = new JButton("New");
		newBtn.setName("NewPersonButton");
		newBtn.addActionListener(new listener());
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setName("DeletePersonButton");
		deleteBtn.addActionListener(new listener());

		c.anchor = GridBagConstraints.SOUTH;
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(newBtn, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(deleteBtn, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(list, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 3;
		this.add(panel, c);
	}

	public void setModel(DefaultListModel model){
		this.model = model;
		this.list.setModel(this.model);
	}
	
	public DefaultListModel getModel(){
		return this.model;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
//		System.out.println(list.getModel().getSize());
//		System.out.println(list.getSelectedValue());
		
		int newsize = list.getModel().getSize();
		if(newsize == listSize){
			panel.setModel((Person) list.getSelectedValue());			
		}
		else if(newsize>0){
				panel.setModel((Person) list.getModel().getElementAt(0));
				list.setSelectedIndex(0);
		}
		listSize = list.getModel().getSize();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Task 4");
		
		Person frank = new Person("Frank Arnesen");
		frank.setDateOfBirth("10.10.1960");
		frank.setEmail("test@test.no");
		frank.setGender(Gender.male);
		frank.setHeight(180);
		
		Person arne = new Person("Arne Bjarnesen");
		arne.setDateOfBirth("10.10.1985");
		arne.setEmail("her@der.no");
		arne.setGender(Gender.male);
		arne.setHeight(175);
		
		Person beate = new Person("Beate Stakesen");
		beate.setDateOfBirth("02.03.1990");
		beate.setEmail("opp@ned.no");
		beate.setGender(Gender.female);
		beate.setHeight(160);
		
		PersonListPanel personList = new PersonListPanel();
		DefaultListModel listModel = new DefaultListModel();
		personList.setModel(listModel);
		
		listModel.addElement(frank);
		listModel.addElement(arne);
		listModel.addElement(beate);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(personList);
		frame.pack();
		
		frame.setVisible(true);

	}

	class listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();

			if(e.getSource()==newBtn){
				Person person = new Person("New Person");
				DefaultListModel listModel = (DefaultListModel) list.getModel();
				panel.setModel(person);
				listModel.addElement(person);
				list.setSelectedIndex(2);
				listSize = list.getModel().getSize();
			}
			else if(e.getSource()==deleteBtn){
				Person person = (Person) list.getSelectedValue();
				DefaultListModel listModel = (DefaultListModel) list.getModel();
				listModel.removeElement(person);
			}
			
		}
		
	}
	
}
