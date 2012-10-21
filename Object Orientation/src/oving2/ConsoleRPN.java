package oving2;

import java.util.ArrayList;
import acm.program.ConsoleProgram;

/*
 * @startuml
 * class ConsoleProgram {
 * }
 * class ConsoleRPN {
 * 	Stack<Double> operandStack
 * 	+void init()
 * 	+void run()
 * }
 * ConsoleProgram <|-- ConsoleRPN
 * @enduml
 */

public class ConsoleRPN extends ConsoleProgram {
	ArrayList<Double> operandStack = new ArrayList<Double>();
	
	public void init(){
		
	}
	
	public void run(){
		kjoring();
	}
	
	public void kjoring(){
		print();
		String var = readLine();
		if(var.equals("+")){
			add();
		}
		else if(var.equals(".")){
			pop();
		}
		else if(var.equals(",")){
			dup();
		}
		else if(var.equals("-")){
			sub();
		}
		else if(var.equals("*")){
			multiply();
		}
		else if(var.equals("/")){
			div();
		}
		else{
			double tallverdi = Double.parseDouble(var);
			push(tallverdi);
		}
		kjoring();
	}
	
	public void add(){
		double tall1 = pop();
		double tall2 = pop();
		double svar = (tall1+tall2);
		operandStack.add(svar);
	}
	
	public void dup(){
		double tall1 = peek();
		operandStack.add(tall1);
	}
	
	public void sub(){
		double tall1 = pop();
		double tall2 = pop();
		double svar = (tall1-tall2);
		operandStack.add(svar);
	}
	
	public void multiply(){
		double tall1 = pop();
		double tall2 = pop();
		double svar = (tall1*tall2);
		operandStack.add(svar);
	}
	
	public void div(){
		double tall1 = pop();
		double tall2 = pop();
		double svar = (tall1/tall2);
		operandStack.add(svar);
	}
	
	public void push(double tall){
		operandStack.add(tall);
	}
	
	public double pop(){
		double toppverdi = operandStack.get(operandStack.size()-1);
		operandStack.remove(operandStack.size()-1);
		return toppverdi;
	}
	
	public double peek(){
		Double lastvalue = operandStack.get(operandStack.size()-1);
		return lastvalue;
	}
	
	public void print(){
		for (int i = 0; i < operandStack.size(); i++) {
			double var = operandStack.get(i);
			println(var);
		}
	}
	
}