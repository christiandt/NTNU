package oving1;

import acm.program.ConsoleProgram;

/*
 * @startuml
 * class ConsoleProgram {
 * }
 * class ConsoleComp1 {
 * 	+void run()
 * 	+double performOperation(...)
 * }
 * ConsoleProgram <|-- ConsoleComp1
 * @enduml
 */

public class ConsoleComp1 extends ConsoleProgram {

	
	public void init() {
		
	}
	
	public void run() {
		println("First operand:");
		double tall1 = readDouble();
		println("Second operand:");
		double tall2 = readDouble();
		println("Operator: ");
		String operand = readLine();
		double svar = performOperation(tall1, tall2, operand);
		println("The result of " + tall1 + operand + tall2 + " is " + svar);
		run();
	}
	
	public double performOperation(double tall1, double tall2, String operand) {
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
