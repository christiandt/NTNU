import java.io.*;
import java.util.*;

public class Sprengstoff {

    private static int spor(Kubbe kubbe) {
	int max = kubbe.vekt;
	Kubbe next = kubbe.neste;
	while(next != null){
		if(next.vekt>max){
			max = next.vekt;
		}
		next = next.neste;
	}
	return max;
    }

    public static void main(String args[]) {
        BufferedReader in;
        if (args.length > 0) {
            try {
              in = new BufferedReader(new FileReader(args[0]));
            }
            catch (FileNotFoundException e) {
                System.out.println("Kunne ikke Œpne filen " + args[0]);
                return;
            }
        }
        else {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        try {
            Kubbe forste = null, siste = null, forrige_siste = null;
            String linje = in.readLine();
            while (linje != null) {
            	forrige_siste = siste;
                int i = Integer.parseInt(linje);
                siste = new Kubbe(i);
                	if(forste == null){
                		forste = siste;
                	}
                	else{
                		forrige_siste.neste = siste;
                	}
                linje = in.readLine();
            }
            System.out.println(spor(forste));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Kubbe {
	int vekt;
	Kubbe neste;
	
	public Kubbe(int vekt) { 
		this.vekt = vekt;
	}
}
