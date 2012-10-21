package oving3;

import java.util.ArrayList;

/*
 * @startuml
 * class Person {
 * 	String name
 * 	Person mother
 * 	Person father
 * }
 * Person --> "*" Person : children
 * @enduml
 */
public class Person {
	String name;
	Person mother;
	Person father;
	ArrayList<Person> children = new ArrayList<Person>();
	
	public Person(){
	}
	
	public Person(String navn){
		this.name = navn;
	}
	
	public boolean isMotherOf(Person var){
		if(this == var.mother && this.children.contains(var)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isFatherOf(Person var){
		if(this == var.father && this.children.contains(var)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSiblingOf(Person var){
		if(this == var){
			return false;
		}
		else if (this.mother == var.mother && this.father == var.father && mother.isMotherOf(var) && father.isFatherOf(var) && father.isFatherOf(this) && mother.isMotherOf(this)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public String toString() {
		String s = "";
		s+= this.name + " [";
		for (int i = 0; i < children.size(); i++){
			s+=children.get(i);
			if(i!=children.size()-1){
				s+=", ";
			}
		}
		s+="]";
		return s;
	}
	
	
}