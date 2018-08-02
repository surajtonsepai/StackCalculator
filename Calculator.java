package edu.metrostate.ics240.STP059.p3.calc;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator implements StackCalculator {
	private Stack<Double> stack = new Stack<Double>();
	
	@Override
	public void enter(String entry) {
		if (entry.matches("[*-/]") && stack.size() > 1){
			double operand2 = stack.pop();
			double operand1 = stack.pop();
			double result = 0;
			switch (entry) {
				case "+":	
					result = operand1 + operand2;
					break;
				case "-":	
					result = operand1 - operand2;
					break;
				case "*":	
					result = operand1 * operand2;
					break;
				case "/":	
					result = operand1 / operand2;
					break;
				default:
					break;
			}
			stack.push(result);		
		}
		else if (isDouble(entry)){
			stack.push(Double.parseDouble(entry));
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public double peek() {
		if (stack.size() > 0){
			double output = stack.peek();
			return output;
		}
		else {
			throw new EmptyStackException();
		}
	}
	
	@Override
	public double pop() {
		if (stack.size() > 0){
			double output = stack.pop();
			return output;
		}
		else {
			throw new EmptyStackException();
		}
	}
	
	@Override
	public void clear() {
		stack.clear();

	}
	
	@Override
	public boolean isEmpty() {
		return stack.empty();
	}
	
	@Override
	public int size() {
		return stack.size();
	}
	
	public boolean isDouble( String str ){
		try{
			Double.parseDouble(str);
			return true;
		}
		catch( Exception e ){
			return false;
		}
	}
}
