package sokoban3Chris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	
	static ArrayList<String> SokobanMap;
	
	private Map(){
		SokobanMap = new ArrayList<String>();
		try {
			sokobanMaps();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sokobanMaps() throws IOException{
		FileReader file = new FileReader("sokoban2/SokobanMaps.txt");
		BufferedReader reader = new BufferedReader(file);
		while(true){
			String map = reader.readLine();
			if(map==null){
				break;
			}
			SokobanMap.add(map);
		}
		reader.close();
	}
	
	public static Map map = new Map();
	
	
}
