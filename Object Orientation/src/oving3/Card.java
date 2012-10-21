package oving3;

/*
 * @startuml
 * class Card {
 * 	String suit
 * 	int face
 * }
 * @enduml
 */
public class Card {
	
	String suit;
	int face;
	
	public String toString(){
		String var = this.suit;
		var += this.face;
		return var;
	}
	
}