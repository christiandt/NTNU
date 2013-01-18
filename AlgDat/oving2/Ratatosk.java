import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Stack;


public class Ratatosk{

	/**
	 * Denne metoden skal gjøre et bredde-først-søk i treet.
	 * Den skal returnere dybden til ratatosk-noden.
	 *
	 * @param rot - rotnoden i treet
	 * @return dybden til ratatosknoden
	 */
	public static int bfs(Node rot){
		// SKRIV DIN KODE HER
		return -1;
	}
	
	/**
	 * Denne metoden skal gjøre et dybde-først-søk i treet vha. en stack.
	 * Den skal returnere dybden til ratatosk-noden.
	 *
	 * @param rot - rotnoden i treet
	 * @return dybden til ratatosknoden
	 */
	public static int dfs(Node rot){
		// SKRIV DIN KODE HER
		return -1;
	}


	/**
	 * Main-metoden som leser inn inputdataene fra stdin og kaller den metoden 
	 * man må. Dersom input sier velg 
	 *
	 **/
	public static void main(String args[]){
		try{
			BufferedReader in;
        		if (args.length > 0) {
				try {
					in = new BufferedReader(new FileReader(args[0]));
				}
				catch (FileNotFoundException e) {
					System.out.println("Kunne ikke åpne filen " + args[0]);
					return;
				}
			}
        		else {
				in = new BufferedReader(new InputStreamReader(System.in));
			}
			String funksjon = in.readLine().trim();
			int antallNoder=Integer.parseInt(in.readLine());
			ArrayList noder = new ArrayList();
			for(int i=0;i<antallNoder;i++){
				noder.add(new Node());
			}
			Node rotNode=(Node)noder.get(Integer.parseInt(in.readLine()));
			//setter ratatosknode:
			((Node)noder.get(Integer.parseInt(in.readLine()))).ratatosk=true;
			String linje=in.readLine();
			while(linje!=null){
				StringTokenizer st = new StringTokenizer(linje);
				Node currentNode = (Node)noder.get(Integer.parseInt(st.nextToken()));
				while(st.hasMoreTokens()){
					currentNode.barn.add(noder.get(Integer.parseInt(st.nextToken())));
				}
				linje=in.readLine();
			}
			if(funksjon.equals("dfs")){
				System.out.println(""+dfs(rotNode));
			}
			else if(funksjon.equals("bfs")){
				System.out.println(""+bfs(rotNode));
			}
			else if(funksjon.equals("velg")){
				// SKRIV DIN KODE HER
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}

class Node{
	boolean ratatosk;
	ArrayList barn;
	// Denne kan du velge om du vil ha med eller ikke. Det er meningen at den skal representere
	// dybden denne noden har i treet, og at det skal regnes ut underveis i din algoritme.
	// (Du kan selvfølgelig droppe å bruke hele rammeverket)
	int dybde;
	public Node(){
		ratatosk=false;
		barn=new ArrayList();
		dybde=-1;
	}
}
