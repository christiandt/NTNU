package oving5.card;

public class Card {
	
	private String suit;
	private int face;
	
	public Card(String suit, int face){
		if((suit == "S" || suit == "H" || suit == "D" || suit == "C") && (0<face && face<=13)){
			this.suit = suit;
			this.face = face;
		}
		else{
			this.suit = null;
			this.face = -1;
		}
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	public int getFace(){
		return this.face;
	}
	
	public String toString(){
		String var;
		var = this.suit;
		var += Integer.toString(face);
		return var;
	}
	
	
}
