package oving1;

import acm.program.ConsoleProgram;

/*
 * @startuml
 * class ConsoleProgram {
 * }
 * class ConsoleComp3 {
 * 	double d1, d2, result
 * 	+void run()
 * }
 * ConsoleProgram <|-- ConsoleComp3
 * @enduml
 */

public class ConsoleComp3 extends ConsoleProgram {
	
	double tall1;
	double tall2;
	double svar;
	
	public void init() {
		
	}
	
	public void run() {
		if(svar<=1337){
			kjoring();
		}
		else{
			println("\nYou're just too leet!!!");
		}
	}
	
	public void performOperation(String operand) {
		
		if(operand.contains("+")){
			svar = tall1+tall2;
		}
		else if(operand.contains("-")){
			svar = tall1-tall2;
		}
		else if(operand.contains("*")){
			svar = tall1*tall2;
		}
		else if(operand.contains("/")){
			svar = tall1/tall2;
		}
	}
	
	public void kjoring() {
		println("First operand:");
		tall1 = readDouble();
		println("Second operand:");
		tall2 = readDouble();
		println("Operator: ");
		String operand = readLine();
		performOperation(operand);
		if(svar<=1337){
			println("The result of " + tall1 + operand + tall2 + " is " + svar);
		}
		run();
	}
	
} 
