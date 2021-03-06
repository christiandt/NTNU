package sokoban3Chris;


import java.util.ArrayList;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import oving9.HighscoreList;
import oving9.SokobanResult;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/*
 * @startuml
 * class GraphicsSokoban {
 * }
 * class GraphicsProgram {
 * }
 * GraphicsProgram <|-- GraphicsSokoban
 * @enduml
 */

public class Sokoban extends GraphicsProgram{

		private static final long serialVersionUID = 1L;
	
		final static char PLAYER ='@';
		final static char PLAYER_ON_TARGET = '+';
		final static char EMPTY_FIELD = ' ';
		final static char TARGET = '.';
		final static char BOX = '$';
		final static char BOX_ON_TARGET = '*';
		final static char WALL = '#';
		
		boolean[][] targets;
		char[][] grid;
		
		int playerX;
		int playerY;
		int gridWidth;
		int gridDepth;
		int numOfBoxes=0;
		int vinnerBokser;
		
		boolean movedBox=false;
		boolean wallhit = false;
//		
//		String sokoban1 = "###|#.#|#$#|#@#|###";
//		String sokoban2 = "    ####|#####  #|#   $  #|# *.#  #|## ## ##|#      #|# @#   #|#  #####|####    ";
//		String sokoban3 = " ##### | #   ## |##.#$ ##|# $    #|#. .#$ #|### @ ##|  # # # |  #   # |  ##### ";

		ArrayList<Character> moveHistory;
		ArrayList<String> SokobanMap;
		
		int levelnumber = 1;
		String valgtbrett = Map.SokobanMap.get(levelnumber-1);
//		String valgtbrett = sokoban2;
		Sokoban sokoban;
		HighscoreList scorelist;
		SokobanResult result;
		
		
		
		public void init(){
			addKeyListeners();
			sokoban = new Sokoban();
			SokobanMap = new ArrayList<String>();
			moveHistory = new ArrayList<Character>();
			makeLevel(valgtbrett);
			scorelist = new HighscoreList(5);
		}
		
		public void run(){
			print();
//			kontroll();
//			printtargets();
//				print(playerX + ",");
//				print(playerY + "\n");
			println(moveHistory.toString());
			won();
//			run();
		}
		
		
		public void keyPressed(KeyEvent event){
//			String var = readLine();
			char c = event.getKeyChar();		
			switch(c){
				case 'w':
					doMove(0,-1);
					if(movedBox){
						c = Character.toUpperCase(c);						
					}
					if(!wallhit){
						moveHistory.add(c);						
					}
					else{
						wallhit = false;
					}
					run();
					break;
				case 's':
					doMove(0,1);
					if(movedBox){
						c = Character.toUpperCase(c);						
					}
					if(!wallhit){
						moveHistory.add(c);						
					}
					else{
						wallhit = false;
					}
					run();
					break;
				case 'a':
					doMove(-1,0);
					if(movedBox){
						c = Character.toUpperCase(c);						
					}
					if(!wallhit){
						moveHistory.add(c);						
					}
					else{
						wallhit = false;
					}
					run();
					break;
				case 'd':
					doMove(1,0);
					if(movedBox){
						c = Character.toUpperCase(c);						
					}
					if(!wallhit){
						moveHistory.add(c);						
					}
					else{
						wallhit = false;
					}
					run();
					break;
				case 'z':
					if(moveHistory.size()>0){
						translator(moveHistory.get(moveHistory.size()-1));
						moveHistory.remove(moveHistory.size()-1);
					}
					run();
					break;
				case KeyEvent.VK_ESCAPE:
						System.exit(0);	
						break;
				default:
					println("Ugyldig retning, bruk wasd.");
					break;
			}
		}
		
		void translator(char c){		
			switch(c){
				case 'w':
					doMove(0,1);
					break;
				case 's':
					doMove(0,-1);
					break;
				case 'a':
					doMove(1,0);
					break;
				case 'd':
					doMove(-1,0);
					break;
				case 'W':
					doMove(0,1);
					movebox(playerX-2*0, playerY -2*1, playerX-0, playerY-1);
					break;
				case 'S':
					doMove(0,-1);
					movebox(playerX-2*0, playerY -2*-1, playerX-0, playerY+1);
					break;
				case 'A':
					doMove(1,0);
					movebox(playerX-2*1, playerY -2*0, playerX-1, playerY-0);
					break;
				case 'D':
					doMove(-1,0);
					movebox(playerX-2*-1, playerY -2*0, playerX+1, playerY-0);
					break;
				default:
					break;
			}
		}
		
		void won(){
			vinnerBokser = 0;
			for (int y = 0; y < gridDepth; y++) {
				for (int x = 0; x < gridWidth; x++) {
					if(grid[y][x]==BOX_ON_TARGET){
							vinnerBokser++;
					}
				}
			}
			if(vinnerBokser == numOfBoxes){
				String spillerNavn = JOptionPane.showInputDialog("Navn");
				result = new SokobanResult(spillerNavn, moveHistory.size());
				scorelist.addResult(result);
				for (int i = 0; i < scorelist.getList().size(); i++) {
					println(scorelist.getList().get(i));
				}
				int test = JOptionPane.INFORMATION_MESSAGE;
				int svar = JOptionPane.showConfirmDialog(null, ("Du klarte brettet p� " + (moveHistory.size()) + " skritt. \nVil du g� til neste brett?"), "Gratulerer!", JOptionPane.YES_NO_OPTION);
				if(svar==0){
					scorelist = new HighscoreList(5);
					levelnumber++;
					valgtbrett = Map.SokobanMap.get(levelnumber-1);
					moveHistory.clear();
					makeLevel(valgtbrett);
					run();
				}
				else if(svar==1){
					int svar2 = JOptionPane.showConfirmDialog(null, ("Vil du spille brettet p� nytt?"), "ny runde?", JOptionPane.YES_NO_OPTION);
					if(svar2==0){
						valgtbrett = Map.SokobanMap.get(levelnumber-1);
						moveHistory.clear();
						makeLevel(valgtbrett);
						run();
					}
					else if(svar2==1){						
						System.exit(0);
					}
				}
			}
		}
		
		void makeLevel(String brett){
			numOfBoxes = 0;
			String level[] = valgtbrett.split("\\|");
			for (int i = 0; i < level.length; i++) {
				if(level[i].length()>gridWidth){
					gridWidth = level[i].length();					
				}
			}
			grid = new char[level.length][gridWidth];
			for (int y = 0; y < level.length; y++) {
				for (int x = 0; x < level[y].length(); x++) {
					grid[y][x] = level[y].charAt(x);
				}
			}
			gridDepth = level.length;
			targets = new boolean[level.length][gridWidth];
			for (int y = 0; y < level.length; y++) {
				for (int x = 0; x < gridWidth; x++) {
					switch(grid[y][x]){
						case PLAYER_ON_TARGET:
							targets[y][x] = true;
							break;
						case BOX_ON_TARGET:
							numOfBoxes++;
							targets[y][x] = true;
							break;
						case TARGET:
							targets[y][x] = true;
							break;
						case PLAYER:
							playerX = x;
							playerY = y;
							print(x + ",");
							print(y + "\n");
							break;
						case BOX:
							numOfBoxes++;
							break;
						default:
							targets[y][x] = false;
							break;
					}
				}
			}
		}
		
		void print(){
			for (int y = 0; y < gridDepth; y++) {
				for (int x = 0; x < gridWidth; x++) {
					char c = getCell(x,y);
					if (c == PLAYER_ON_TARGET) {						
						playerOnTarget(x*16, y*16);
					} else if ((c == BOX_ON_TARGET)) {
						boxOnTarget(x*16, y*16);
					} else if (c==TARGET) {
						target(x*16, y*16);
					} else if (c == PLAYER) {
						player(x*16, y*16);
					} else if (c == BOX) {
						box(x*16, y*16);
					} else if (c == EMPTY_FIELD) {
						empty(x*16, y*16);
					} else if (c == WALL) {
						wall(x*16, y*16);
					}
				}
			}
		}
		
		void printtargets(){
			for (int i = 0; i < gridDepth; i++) {
				for (int j = 0; j < gridWidth; j++) {
					if(targets[i][j]){
						print("t");
					}
					else{
						print("f");
					}
				}
				println();
			}
		}
		
		void setCell(int x, int y, char c){
			grid[y][x] = c;
		}
		
		char getCell(int x, int y){
			return grid[y][x];
		}
		
		boolean isTarget(int x, int y){
			if(targets[y][x]=true){
				return true;
			}
			else{
				return false;
			}
		}
		
		boolean getTarget(int x, int y){
			return targets[y][x];
		}
		
		void doMove(int dx, int dy){
			if((dx==1 || dx==0 || dx==-1) && (dy==1 || dy==0 || dy==-1)){
				if(getCell(playerX+dx, playerY+dy)== WALL || (getCell(playerX+dx, playerY+dy)== BOX && getCell(playerX+2*dx, playerY+2*dy)== WALL) || (getCell(playerX+dx, playerY+dy)== BOX_ON_TARGET && getCell(playerX+2*dx, playerY+2*dy)== WALL)){
					wallhit = true;
				}
				if(getCell(playerX+dx,playerY+dy)==EMPTY_FIELD || getCell(playerX+dx,playerY+dy)==TARGET){
					moveplayer(playerX, playerY, playerX+dx, playerY+dy);
					movedBox = false;
					
				}
				else if(getCell(playerX+dx,playerY+dy)==BOX || getCell(playerX+dx,playerY+dy)==BOX_ON_TARGET){
					if(getCell(playerX+dx+dx,playerY+dy+dy)==EMPTY_FIELD || getCell(playerX+dx+dx,playerY+dy+dy)==TARGET){
						movebox(playerX+dx, playerY+dy, playerX+dx+dx, playerY+dy+dy);
						movedBox = true;
						moveplayer(playerX, playerY, playerX+dx, playerY+dy);
					}
				}
			}
		}
		
		void movebox(int x0, int y0,int x1,int y1){
			if(getCell(x0, y0)==BOX){
				setCell(x0, y0, EMPTY_FIELD);
			}
			if(getCell(x0, y0)==BOX_ON_TARGET){
				setCell(x0, y0, TARGET);
			}
			if(getCell(x1, y1)==EMPTY_FIELD){
				setCell(x1, y1, BOX);
			}
			if(getCell(x1, y1)==TARGET){
				setCell(x1, y1, BOX_ON_TARGET);
			}
		}
		
		void moveplayer(int x0, int y0,int x1,int y1){
			if(getCell(x0, y0)==PLAYER){
				setCell(x0, y0, EMPTY_FIELD);
			}
			if(getCell(x0, y0)==PLAYER_ON_TARGET){
				setCell(x0, y0, TARGET);
			}
			if(getCell(x1, y1)==EMPTY_FIELD){
				setCell(x1, y1, PLAYER);
			}
			if(getCell(x1, y1)==TARGET){
				setCell(x1, y1, PLAYER_ON_TARGET);
			}
			playerX = x1;
			playerY = y1;
		}
		
		boolean legalPush(int dx, int dy){
			if((getCell(playerX+dx,playerY+dy) == BOX) && (getCell(playerX + 2*dx, playerY + 2*dy)==EMPTY_FIELD)){
				return true;
			}
			else{
				return false;
			}
		}

	
	void player(int x, int y){
		GImage player = new GImage("sokoban/icons/mover16x16.png", x, y);
		add(player);
	}
	
	void empty(int x, int y){
		GImage empty = new GImage("sokoban/icons/blank16x16.png", x, y);
		add(empty);
	}
	
	void playerOnTarget(int x, int y){
		GImage playerOnTarget = new GImage("sokoban/icons/mover_on_target16x16.png", x, y);
		add(playerOnTarget);
	}
	
	void boxOnTarget(int x, int y){
		GImage boxOnTarget = new GImage("sokoban/icons/movable_on_target16x16.png", x, y);
		add(boxOnTarget);
	}
	
	void box(int x, int y){
		GImage box = new GImage("sokoban/icons/movable16x16.png", x, y);
		add(box);
	}
	
	void target(int x, int y){
		GImage target = new GImage("sokoban/icons/target16x16.png", x, y);
		add(target);
	}
	
	void wall(int x, int y){
		GImage wall = new GImage("sokoban/icons/wall16x16.png", x, y);
		add(wall);
	}
	
	
	
}
