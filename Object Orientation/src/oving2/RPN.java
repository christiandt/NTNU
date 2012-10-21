package oving2;

import java.util.ArrayList;

public class RPN {
	ArrayList<Double> operandStack = new ArrayList<Double>();
	
	int getOperandCount(){
		int var = operandStack.size();
		return var;
	}
	
	double peek(int n){
		double var = operandStack.get(operandStack.size()-(n+1));
		return var;
	}
	
	void push(double value){
		operandStack.add(value);
	}
	
	double pop(double defaultValue){
		double var = operandStack.get(operandStack.size()-1);
		operandStack.remove(operandStack.size()-1);
		if(operandStack.isEmpty()){
			return defaultValue;
		}
		else return var;
	}
	
	void performOperation(char operator){
		switch (operator) {
		case '+':
			add();
			break;
		case '-':
			sub();
			break;
		case '*':
			multiply();
			break;
		case '/':
			div();
			break;
		case ',':
			dup();
			break;
		case '.':
			pop();
			break;
		default:
			push(operator);
			break;
		}
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
	
	public double pop(){
		double toppverdi = operandStack.get(operandStack.size()-1);
		operandStack.remove(operandStack.size()-1);
		return toppverdi;
	}
	
	public double peek(){
		Double lastvalue = operandStack.get(operandStack.size()-1);
		return lastvalue;
	}
	
}
