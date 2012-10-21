package oving9;

import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

public class HighscoreView extends ConsoleProgram{
	
	HighscoreList scorelist;
	SokobanResult result;
	

	public void run(){
		scorelist = new HighscoreList(5);
		while(true){
			koskos();
		}
	}
	
	private void koskos(){
		println("Navn:");
		String navn = readLine();
		println("Score");
		int score = readInt();
		result = new SokobanResult(navn, score);
		scorelist.addResult(result);
		for (int i = 0; i < scorelist.getList().size(); i++) {
			println(scorelist.getList().get(i));
		}
	}
	
	
}
