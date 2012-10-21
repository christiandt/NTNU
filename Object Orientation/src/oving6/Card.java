package oving6;

import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Comparable<Card>{

	private String suit;
	private int face;
	String[] suiti = {"C", "D", "H", "S"};
	ArrayList<String> lal;


	@Override
	public int compareTo(Card kort) {
		lal = new ArrayList<String>(Arrays.asList(suiti));
		int kort1Verdi = this.face;
		int kort2Verdi = kort.face;
		
		if(kort1Verdi == 1){
			kort1Verdi = 14;
		}
		if(kort2Verdi == 1){
			kort2Verdi = 14;
		}
		
		
		
		if(kort1Verdi>kort2Verdi){
			return 1;
		}
		else if(kort1Verdi==kort2Verdi){
			if(lal.indexOf(this.suit)<lal.indexOf(kort.suit)){
				return -1;
			}
			else if(lal.indexOf(this.suit)==lal.indexOf(kort.suit)){
				return 0;
			}
			else if(lal.indexOf(this.suit)>lal.indexOf(kort.suit)){
				return 1;
			}
		}
		else if(kort1Verdi<kort2Verdi){
			return -1;
		}
		return 0;
	}

	
	public Card(String suit, int face){
		if((suit == "S" || suit == "H" || suit == "D" || suit == "C") && (0<face && face<=13)){
			this.suit = suit;
			this.face = face;
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
		var += this.face;
		return var;
	}
	
	
	
	
}
