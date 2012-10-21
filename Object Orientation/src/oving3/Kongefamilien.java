package oving3;

import acm.program.ConsoleProgram;


/*
 * @startuml
 * object Kongefamilien
 * 
 * object Harald
 * object Sonja
 * object Martha
 * object Ari
 * object Haakon
 * object "Mette-Marit" as MetteMarit
 * object "Ingrid Alexandra" as Ingrid
 * object "Sverre Magnus" as Sverre
 * object "Maud Angelica" as Maud
 * object "Leah Isadora" as Leah
 * object "Emma Tallulah" as Emma
 * 
 * Harald --> "children" Haakon
 * Harald --> "children" Martha
 * Sonja --> "children" Haakon
 * Sonja --> "children" Martha
 * 
 * Haakon --> "children" Ingrid
 * Haakon --> "children" Sverre
 * MetteMarit --> "children" Ingrid
 * MetteMarit --> "children" Sverre
 * 
 * Martha --> "children" Maud
 * Martha --> "children" Leah
 * Martha --> "children" Emma
 * Ari --> "children" Maud
 * Ari --> "children" Leah
 * Ari --> "children" Emma
 * 
 * Kongefamilien --> "harald" Harald
 * Kongefamilien --> "sonja" Sonja
 * Kongefamilien --> "martha" Martha
 * Kongefamilien --> "ari" Ari
 * Kongefamilien --> "haakon" Haakon
 * Kongefamilien --> "metteMarit" MetteMarit
 * Kongefamilien --> "ingrid" Ingrid
 * Kongefamilien --> "sverre" Sverre
 * Kongefamilien --> "maud" Maud
 * Kongefamilien --> "leah" Leah
 * Kongefamilien --> "emma" Emma
 * 
 * @enduml
 */
public class Kongefamilien extends ConsoleProgram{
	
	public void init(){
		
	}
	
	public void run(){
		createRoyalFamily();
	}
	
	public void createRoyalFamily(){
		
		Person harald = new Person("Harald");
		Person sonja = new Person("Sonja");
		Person haakon = new Person("Haakon");
		Person mettemarit = new Person("Mette-Marit");
		Person ingrida = new Person("Ingrid Alexandria");
		Person sverrem = new Person("Sverre Magnus");
		Person martha = new Person("MŠrtha");
		Person ari = new Person("Ari");
		Person maud = new Person("Maud Angelica");
		Person leah = new Person("Leah Isadora");
		Person emma = new Person("Emma Talulah");
		
		harald.children.add(haakon);
		harald.children.add(martha);
		sonja.children.add(haakon);
		sonja.children.add(martha);
		haakon.children.add(ingrida);
		haakon.children.add(sverrem);
		mettemarit.children.add(ingrida);
		mettemarit.children.add(sverrem);
		martha.children.add(maud);
		martha.children.add(leah);
		martha.children.add(emma);
		ari.children.add(maud);
		ari.children.add(leah);
		ari.children.add(emma);
		
		haakon.father = haakon;
		martha.father = harald;
		ingrida.father = haakon;
		sverrem.father = haakon;
		maud.father = ari;
		leah.father = ari;
		emma.father = ari;
		
		haakon.mother = sonja;
		martha.mother = sonja;
		ingrida.mother = mettemarit;
		sverrem.mother = mettemarit;
		maud.mother = martha;
		leah.mother = martha;
		emma.mother = martha;
		
		println(harald);
		println(sonja);
		println(haakon);
		println(martha);
		println(ari);
		
		
	}
	
}