package task3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel{
	private Person model = null;
	
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel birthdayLabel;
	private JLabel genderLabel;
	private JLabel heightLabel;
	private JTextField NamePropertyComponent;
	private JTextField EmailPropertyComponent;
	private JTextField DateOfBirthPropertyComponent;
	private JComboBox GenderPropertyComponent;
	private JSlider HeightPropertyComponent;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Task2");
		PersonPanel panel = new PersonPanel();
		panel.model = new Person("Frank");
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public PersonPanel(){
		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		birthdayLabel = new JLabel("Birthday:");
		genderLabel = new JLabel("Gender:");
		heightLabel = new JLabel("Height:");
		
		NamePropertyComponent = new JTextField();
		EmailPropertyComponent = new JTextField();
		DateOfBirthPropertyComponent = new JTextField();
		GenderPropertyComponent = new JComboBox(Gender.values());
		HeightPropertyComponent = new JSlider();
		
		NamePropertyComponent.setName("NamePropertyComponent");
		EmailPropertyComponent.setName("EmailPropertyComponent");
		DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
		GenderPropertyComponent.setName("GenderPropertyComponent");
		HeightPropertyComponent.setName("HeightPropertyComponent");
		
		NamePropertyComponent.addActionListener(new nameChange());
		EmailPropertyComponent.addActionListener(new emailChange());
		DateOfBirthPropertyComponent.addActionListener(new dateChange());
		GenderPropertyComponent.addActionListener(new genderChange());
		HeightPropertyComponent.addChangeListener(new heightChange());
		
		
		
		HeightPropertyComponent.setMinimum(120);
		HeightPropertyComponent.setMaximum(220);
		HeightPropertyComponent.setMinorTickSpacing(10);
		HeightPropertyComponent.setMajorTickSpacing(20);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		
		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(emailLabel, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(birthdayLabel, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(genderLabel, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(heightLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(NamePropertyComponent, c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(EmailPropertyComponent, c);
		
		c.gridx = 1;
		c.gridy = 2;
		add(DateOfBirthPropertyComponent, c);
		
		c.gridx = 1;
		c.gridy = 3;
		add(GenderPropertyComponent, c);
		
		c.gridx = 1;
		c.gridy = 4;
		add(HeightPropertyComponent, c);
		
		
	}
	
	
	class nameChange implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (model!=null){
				model.setName(NamePropertyComponent.getText());
			}
			// TODO Auto-generated method stub
			
		}
	}
	
	class emailChange implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (model!=null){
				model.setEmail(EmailPropertyComponent.getText());
			}
		}
	}
	
	class genderChange implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (model!=null){
				model.setGender((Gender)GenderPropertyComponent.getSelectedItem());
			}			
		}
	}
	
	class dateChange implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (model!=null){
				model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
			}
		}
	}
	
	class heightChange implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			if (model!=null){
				model.setHeight(HeightPropertyComponent.getValue());
				
			}
		}
	}
	


	public void setModel(Person person) {
		this.model = person;
		NamePropertyComponent.setText(this.model.getName());
		EmailPropertyComponent.setText(this.model.getEmail());
		DateOfBirthPropertyComponent.setText(this.model.getDateOfBirth());
		GenderPropertyComponent.setSelectedItem(this.model.getGender());
		HeightPropertyComponent.setValue(this.model.getHeight());
	}
	
	public Person getModel(){
		return model;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "name"){
			NamePropertyComponent.setText(model.getName());
		}
		else if(evt.getPropertyName() == "name"){
			
		}
		else if(evt.getPropertyName() == "gender"){
			
		}
		else if(evt.getPropertyName() == "dateOfBirth"){
			
		}
		else if(evt.getPropertyName() == "email"){
			
		}
		else if(evt.getPropertyName() == "height"){
			
		}
	}
	
	
	
}
