package task2and3;

import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {
	
	JTextField GenderPropertyComponent;
	JTextField HeightPropertyComponent;
	
	public PassivePersonPanel(){
		super();
		remove(super.GenderPropertyComponent);
		remove(super.HeightPropertyComponent);
		
		c.gridx = 1;
		c.gridy = 3;
		GenderPropertyComponent = new JTextField(15);
		add(GenderPropertyComponent, c);
		
		c.gridx = 1;
		c.gridy = 4;
		HeightPropertyComponent = new JTextField(15);
		add(HeightPropertyComponent, c);
		
		NamePropertyComponent.setEditable(false);
		EmailPropertyComponent.setEditable(false);
		DateOfBirthPropertyComponent.setEditable(false);
		GenderPropertyComponent.setEditable(false);
		HeightPropertyComponent.setEditable(false);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String event = evt.getPropertyName();
		if(event.equals("name")){
			NamePropertyComponent.setText(this.model.getName());
		}
		else if(event.equals("gender")){
			if(this.model.getGender()!=null){
				GenderPropertyComponent.setText(this.model.getGender().toString());			
			}
		}
		else if(event.equals("dateOfBirth")){
			DateOfBirthPropertyComponent.setText(this.model.getDateOfBirth());
		}
		else if(event.equals("email")){
			EmailPropertyComponent.setText(this.model.getEmail());
		}
		else if(event.equals("height")){
			this.HeightPropertyComponent.setText(Integer.toString(this.model.getHeight()));
		}
	}
	
}
