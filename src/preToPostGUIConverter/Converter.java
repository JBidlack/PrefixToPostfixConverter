package preToPostGUIConverter;

import java.util.*;

public class Converter {

	private static Stack<String> ReversalStack = new Stack<String>();
	private static Stack<String> OperandStack = new Stack<String>();
		
	static class Evaluate{
		String token;
		
		public Evaluate() {
			
		}
		public String PreToPostConv(String UserInput) {
			
			StringTokenizer tokenizer = new StringTokenizer(UserInput, " +-*/", true);
			
			while (tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();
				if(!token.equals(" ")) {
					ReversalStack.push(token);
				}
			} // end while statement
			while (!ReversalStack.isEmpty()) {
				String top = ReversalStack.pop();
				if (!isOperator(top.charAt(0))) {
					OperandStack.push(top);
				}
				else if(isOperator(top.charAt(0))) {
					String a = OperandStack.pop();
					String b = OperandStack.pop();
					String stackAdd = " " + a + " " + b + " " + top;
					OperandStack.push(stackAdd);
				}
			
			} // end while statement
			String result = OperandStack.pop();
			return result;
			
			} // end method
		
		public String PostToPreConv (String UserInput){
			
			StringTokenizer tokenizer = new StringTokenizer(UserInput, " +-*/", true);
			
			while (tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();
				if(!token.equals(" ")) {
					
					if (!isOperator(token.charAt(0))) {
						OperandStack.push(token);
					}
					else if (isOperator(token.charAt(0))) {
						String top = token;
						String a = OperandStack.pop();
						String b = OperandStack.pop();
						String stackAdd = " " + top + " " + b + " " + a + " ";
						OperandStack.push(stackAdd);
					}
				}	
			}
			String result = OperandStack.pop();
			return result; 	
		} // end method
	
		
		public boolean isOperator(char input) {
				
			switch(input) {
				case '+':
				case '-':
				case '*':
				case '/':
					return true;
			}
			return false;
		}
	
	}
}
