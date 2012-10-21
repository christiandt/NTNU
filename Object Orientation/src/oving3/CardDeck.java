package oving3;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/*
 * @startuml
 * class Card {
 * 	String suit
 * 	int face
 * }
 * class CardDeck {
 * 	+Card getCard(int i)
 * }
 * CardDeck --> "*" Card : cards
 * @enduml
 */

public class CardDeck extends GraphicsProgram {
	
	ArrayList<Card> cards = new ArrayList<Card>();
	String suit[] = {"S", "H", "D", "C"};
	
	public void init(){
		for (int i = 0; i < suit.length; i++) {
			for (int j = 1; j <= 13; j++) {
				Card kort = new Card();
				kort.suit = suit[i];
				kort.face = j;
				cards.add(kort);
			}
		}
	}
	
	
	public Card getCard(int var){
		return cards.get(var);
	}

	GImage createGImage(String suit, int value) {
		String name="";
		switch(suit.charAt(0)){
		case 'H':
			name+="hearts";
			break;
		case 'D':
			name+="diamonds";
			break;
		case 'C':
			name+="clubs";
			break;
		case 'S':
			name+="spades";
			break;
		}
		name+="-";
		switch(value) {
		case 1:
			name+="a";
			break;
		case 11:
			name+="j";
			break;
		case 12:
			name+="q";
			break;
		case 13:
			name+="k";
			break;
		default:
			name+="" + value;
		}
		
		name+="-150.png";
		return new GImage("oving3/img/" + name);
	}
}
