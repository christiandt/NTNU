package sokoban1;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

/*
 * @startuml
 * class ConsoleSokoban {
 * }
 * class ConsoleProgram {
 * }
 * ConsoleProgram <|-- ConsoleSokoban
 * @enduml
 */

public class ConsoleSokoban extends ConsoleProgram {
	
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
	
	String sokoban1 = "###|#.#|#$#|#@#|###";
	String sokoban2 = "    ####|#####  #|#   $  #|# *.#  #|## ## ##|#      #|# @#   #|#  #####|####    ";
	String sokoban3 = " ##### | #   ## |##.#$ ##|# $    #|#. .#$ #|### @ ##|  # # # |  #   # |  ##### ";
	
	String valgtbrett = sokoban2;
	
	ArrayList<Character> moveHistory = new ArrayList<Character>(); 
	
	
	public void init(){
		makeLevel(valgtbrett);
	}
	
	public void run(){
		printLevel();
		won();
	//	printtargets();
		kontroll();
			print(playerX + ",");
			print(playerY + "\n");
		println(moveHistory.toString());
		run();
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
			print("Gratulerer, du har fullf�rt brettet p� " + moveHistory.size() + " flytt.");
		}
		println("bokser: " + numOfBoxes);
		println("vinner: " + vinnerBokser);
	}
	
	void kontroll(){
		String var = readLine();
		if(var.length()>0){
			char c = var.charAt(0);			
			switch(c){
				case 'w':
					doMove(0,-1);
					moveHistory.add(c);
					break;
				case 's':
					doMove(0,1);
					moveHistory.add(c);
					break;
				case 'a':
					doMove(-1,0);
					moveHistory.add(c);
					break;
				case 'd':
					doMove(1,0);
					moveHistory.add(c);
					break;
				case 'z':
					if(moveHistory.size()>0){
						translator(moveHistory.get(moveHistory.size()-1));
						moveHistory.remove(moveHistory.size()-1);
					}
					break;
				default:
					println("Ugyldig retning, bruk wasd.");
					break;
			}
		}
		else{
			print("Du m� skrive inn en retning, bruk wasd.\n");
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
			default:
				break;
		}
	}
	
	void makeLevel(String brett){
		numOfBoxes = 0;
		String level[] = valgtbrett.split("\\|");
		gridWidth = level[0].length();
		grid = new char[level.length][level[0].length()];
		for (int y = 0; y < level.length; y++) {
			for (int x = 0; x < level[0].length(); x++) {
				grid[y][x] = level[y].charAt(x);
			}
		}
		gridDepth = level.length;
		targets = new boolean[level.length][level[0].length()];
		for (int y = 0; y < level.length; y++) {
			for (int x = 0; x < level[0].length(); x++) {
				switch(grid[y][x]){
					case PLAYER_ON_TARGET:
						targets[y][x] = true;
						break;
					case BOX_ON_TARGET:
						targets[y][x] = true;
						numOfBoxes++;
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
	
	void printLevel(){
		for (int i = 0; i < gridDepth; i++) {
			for (int j = 0; j < gridWidth; j++) {
				char c = grid[i][j];
				if (c == PLAYER && targets[i][j]) {
					c = PLAYER_ON_TARGET;
				} else if (c == BOX && targets[i][j]) {
					c = BOX_ON_TARGET;
				} else if (c == EMPTY_FIELD && targets[i][j]) {
					c = TARGET;
				}
				print(c);
			}
			println();
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
	
	void doMove(int dx, int dy){
		if((dx==1 || dx==0 || dx==-1) && (dy==1 || dy==0 || dy==-1)){
//			if(getCell(playerX+dx,playerY+dy)==EMPTY_FIELD){
//				setCell(playerX, playerY,EMPTY_FIELD);
//				setCell(playerX+dx, playerY+dy,PLAYER);
//				playerX+=dx;
//				playerY+=dy;
//			}
//			if(legalPush(dx, dy)){
//				setCell(playerX, playerY,EMPTY_FIELD);
//				setCell(playerX+dx, playerY+dy,PLAYER);
//				setCell(playerX+2*dx, playerY+2*dy,BOX);
//				playerX+=dx;
//				playerY+=dy;
//			}
//			if(getCell(playerX+dx,playerY+dy)==TARGET){
//				
//			}
			
			if(getCell(playerX+dx,playerY+dy)==EMPTY_FIELD || getCell(playerX+dx,playerY+dy)==TARGET){
				moveplayer(playerX, playerY, playerX+dx, playerY+dy);
				
			}
			else if(getCell(playerX+dx,playerY+dy)==BOX || getCell(playerX+dx,playerY+dy)==BOX_ON_TARGET){
				if(getCell(playerX+dx+dx,playerY+dy+dy)==EMPTY_FIELD || getCell(playerX+dx+dx,playerY+dy+dy)==TARGET){
					movebox(playerX+dx, playerY+dy, playerX+dx+dx, playerY+dy+dy);
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
	
}
