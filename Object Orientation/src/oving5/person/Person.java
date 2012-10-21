package oving5.person;

import java.util.ArrayList;

public class Person {
	
	String name;
	char gender;
	Person mother;
	Person father;
	ArrayList<Person> children = new ArrayList<Person>();
	
	
	public Person(char var){
		if(var == 'm' || var == 'f'){
			this.gender = var;
		}
		this.children.clear();
	}
	
	public boolean isMale(){
		if(this.gender == 'm'){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isFemale(){
		if(this.gender == 'f'){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	private boolean nameCheck(char c){
		c = Character.toLowerCase(c);
		boolean var=false;
		switch(c){
		case 'a':
			var= true;
			break;
		case 'b':
			var= true;
			break;
		case 'c':
			var= true;
			break;
		case 'd':
			var= true;
			break;
		case 'e':
			var= true;
			break;
		case 'f':
			var= true;
			break;
		case 'g':
			var= true;
			break;
		case 'h':
			var= true;
			break;
		case 'i':
			var= true;
			break;
		case 'j':
			var= true;
			break;
		case 'k':
			var= true;
			break;
		case 'l':
			var= true;
			break;
		case 'm':
			var= true;
			break;
		case 'n':
			var= true;
			break;
		case 'o':
			var= true;
			break;
		case 'p':
			var= true;
			break;
		case 'q':
			var= true;
			break;
		case 'r':
			var= true;
			break;
		case 's':
			var= true;
			break;
		case 't':
			var= true;
			break;
		case 'u':
			var= true;
			break;
		case 'v':
			var= true;
			break;
		case 'w':
			var= true;
			break;
		case 'x':
			var= true;
			break;
		case 'y':
			var= true;
			break;
		case 'z':
			var= true;
			break;
		case '¾':
			var= true;
			break;
		case '¿':
			var= true;
			break;
		case 'Œ':
			var= true;
			break;
		case ' ':
			var= true;
			break;
		default:
			var= false;
			break;
		}
		return var;
	}
	
	public void setName(String name){
		boolean var = true;
		if (name == null) {
			this.name = null;			
		}
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (nameCheck(c)) {
				var = true;
			}
			else{
				var = false;
				break;
			}
		}
		if(var == true){
			this.name = name;
		}
		else{
			this.name = null;
		}
	}
	
	public int getChildCount(){
		return this.children.size();
	}
	
	public Person getMother(){
		return this.mother;
	}
	
	public void setMother(Person mor){
		if(mor == null){
			if(this.mother != null){
				this.mother.children.remove(this);			
			}
			this.mother = mor;
		}
		else if(mor.isFemale()){
			if(this.mother != null){
				this.mother.children.remove(this);
			}
			this.mother = mor;
			this.mother.children.add(this);
		}
	}
	
	public Person getFather(){
		return this.father;
	}
	
	public void setFather(Person far){
		if(far == null){
			if(this.father != null){
				this.father.children.remove(this);			
			}
			this.father = far;
		}
		else if(far.isMale()){
			if(this.father != null){
				this.father.children.remove(this);
			}
			this.father = far;
			this.father.children.add(this);
		}
	}
	
	public void addChild(Person barn){
		if(!this.children.contains(barn)){
			if(this.isMale()){
				barn.setFather(this);
			}
			else if(this.isFemale()){
				barn.setMother(this);
			}
		}
	}
	
	public void removeChild(Person barn){
		if(this.isMale()){
			barn.setFather(null);
		}
		else if(this.isFemale()){
			barn.setMother(null);
		}
	}
	
	public Person getChild(int index){
		if(index >= 0 && index < this.getChildCount()){
			return this.children.get(index);
		}
		else{
			return null;
		}
	}
	
	public int indexOfChild(Person barn){
		if(this.children.contains(barn)){
			return this.children.indexOf(barn);
		}
		else{
			return -1;
		}
	}
	
	public boolean containsChild(Person barn){
		if(this.children.contains(barn)){
			return true;
		}
		else{
			return false;
		}
	}
	
//	public boolean isAncestorOf(Person person){
//		if(checkMotherFather(person.mother, person.father)){
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean checkMotherFather(Person mother, Person father){
//		if(mother != null || father != null){
//			if(this == mother || this == father){
//				return true;
//			}
//			else if(this.children.contains(mother) || this.children.contains(father)){
//				return true;
//			}
//			else{
//				checkMotherFather(mother.mother, father.father);
//			}
//		}
//		return false;
//	}
	
	public boolean isAncestorOf(Person p){
		boolean ancestor = false;
		
		if(this.containsChild(p)){
			ancestor = true;
		}
		
		for(int i = 0; i<this.getChildCount(); i++){
			if(this.getChild(i).isAncestorOf(p)){
				ancestor = true;
			}
		}
		return ancestor;
	}
	
}
