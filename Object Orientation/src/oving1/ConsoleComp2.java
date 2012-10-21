package oving1;

import acm.program.ConsoleProgram;

/*
 * @startuml
 * class ConsoleProgram {
 * }
 * class ConsoleComp2 {
 * 	double d1, d2
 * 	+void run()
 * }
 * ConsoleProgram <|-- ConsoleComp2
 * @enduml
 */

public class ConsoleComp2 extends ConsoleProgram {
	
	double tall1;
	double tall2;
	
	public void init() {
		
	}
	
	public void run() {
		println("First operand:");
		tall1 = readDouble();
		println("Second operand:");
		tall2 = readDouble();
		println("Operator: ");
		String operand = readLine();
		double svar = performOperation(operand);
		println("The result of " + tall1 + operand + tall2 + " is " + svar);
		run();
	}
	
	public double performOperation(String operand) {
		double svar = 0;
		
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
		return svar;
	}
	
} 
