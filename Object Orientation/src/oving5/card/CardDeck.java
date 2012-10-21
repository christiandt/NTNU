package oving5.card;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	String[] suit = {"S", "H", "D", "C"};
	
	
	public CardDeck(){
		for (int i = 0; i < suit.length; i++){
			for (int j = 1; j <= 13; j++) {
				Card kort = new Card(suit[i], j);
				cards.add(kort);
			}
		}
	}
	
	public int getCardCount(){
		return cards.size();
	}
	
	public Card getCard(int index){
		if(0<=index && index <= getCardCount()){
			return cards.get(index);
		}
		else{
			return null;
		}
	}
	
	public ArrayList<Card> deal(int var){
		ArrayList<Card> kortstokk = new ArrayList<Card>();
		if(cards.size()>=var){
			for (int i = 0; i < var; i++) {
				kortstokk.add(cards.get(cards.size()-1));
				cards.remove(cards.size()-1);
			}
			return kortstokk;
		}
		else if (cards.size()<var){
			return null;
		}
		else{ 
			return null;
		}
//		Collections.reverse(kortstokk);
		
	}
	

}
