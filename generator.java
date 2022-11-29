package generator;

import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.lang.Math;

public class generator {
	
	static String builder(String equation, int token) {
		
		switch(token) {
		case 1:
			equation += "+ ";
			break;
		case 2:
			equation += "- ";
			break;
		case 3:
			equation += "* ";
			break;
		case 4:
			equation += "/ ";
			break;
		case 5:
			equation += "^ ( ";
			break;
		case 6:
			equation += "sin ( ";
			break;
		case 7:
			equation += "cos ( ";
			break;
		case 8:
			equation += "tan ( ";
			break;
		case 9:
			equation += "cot ( ";
			break;
		case 10:
			equation += "ln ( ";
			break;
		case 11:
			equation += "log ( ";
			break;
		case 12:
			equation += "( ";
			break;
		case 13:
			equation += ") ";
			break;
		case 14:
			equation += "{ ";
			break;
		case 15:
			equation += "} ";
			break;
		}
		return equation;
	}
	
	static String setPrevious(int token) {
		
		String newToken = " ";
		
		switch(token) {
		case 1:
			newToken = "+";
			break;
		case 2:
			newToken = "-";
			break;
		case 3:
			newToken = "*";
			break;
		case 4:
			newToken = "/";
			break;
		case 5:
			newToken = "^";
			break;
		case 6:
			newToken = "sin";
			break;
		case 7:
			newToken = "cos";
			break;
		case 8:
			newToken = "tan";
			break;
		case 9:
			newToken = "cot";
			break;
		case 10:
			newToken = "ln";
			break;
		case 11:
			newToken = "log";
			break;
		case 12:
			newToken = "(";
			break;
		case 13:
			newToken = "end";
			break;
		case 14:
			newToken = "{";
			break;
		}
		
		return newToken;
	}
	
	static int[] possibles(String token) {
		int[] result = null;
		switch (token) {
		case "init":
			int[] init = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = init;
			break;
		case "num":
			int[] num = { 1, 2, 3, 4, 5, 13, 13, 15};
			result = num;
			break;
		case "+":
			int[] plus = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 14};
			result = plus;
			break;
		case "-":
			int[] minus = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 14};
			result = minus;
			break;
		case "*":
			int[] mult = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 14};
			result = mult;
			break;
		case "/":
			int[] div = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 14};
			result = div;
			break;
		case "^":
			int[] expo = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 10, 11, 12, 14};
			result = expo;
			break;
		case "(":
			int[] openPar = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = openPar;
			break;
		case "{":
			int[] openCurl = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = openCurl;
			break;
		case "end":
			int[] close = { 1, 2, 3, 4, 5, 13, 13, 15};
			result = close;
			break;
		case "sin":
			int[] sin = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = sin;
			break;
		case "cos":
			int[] cos = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = cos;
			break;
		case "tan":
			int[] tan = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = tan;
			break;
		case "cot":
			int[] cot = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = cot;
			break;
		case "ln":
			int[] ln = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = ln;
			break;
		case "log":
			int[] log = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 12, 14};
			result = log;
			break;
		}
		return result;
	}
	
	static int stackBuild (int x) {
		int y = 0;
		
		switch(x) {
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			y = 1;
			break;
		case 14:
			y = 2;
			break;
		}
		return y;
	}
	
	public static void main(String args[]) {
		
		int numMatched = 0;
		int numDifferent = 0;
		
		System.out.println("Ten Equations will be made and tested with both Math.Eval() and the Calculator Program.");
		for (int v = 0; v < 10; v++) {
			String equation = " ";
			String prevToken = "init";
			
			Stack<Integer> stack = new Stack<>();
			
			Random random = new Random();
			Random rando = new Random();
			Random rand = new Random();
			
			int[] arg = possibles(prevToken);
			int x = random.nextInt(arg.length);
			
			while (arg[x] != 15) {
			
				arg = possibles(prevToken);
				x = random.nextInt(arg.length);
			
				if (arg[x] == 0) {
				
					String num = " ";
				
					int a = rand.nextInt(2);
					if (a == 1) {
						num += "-";
					}
				
					int b = rand.nextInt(1, 3);
					for (int c = 0; c < b; c++) {
						num += String.valueOf(rando.nextInt(10));
					}
				
					a = rand.nextInt(2);
					Boolean hasDec = false;
					if (a == 1) {
						num += ".";
						hasDec = true;
					}
				
					b = rand.nextInt(1, 3);
				
					if (hasDec == true) {
						for (int c = 0; c < b; c++) {
							num += String.valueOf(rando.nextInt(10));
						}
					}
					equation += num + " ";
					prevToken = "num";
			
				} else if (arg[x] == 15) {
					while (stack.isEmpty() == false) {
					if (stack.peek() == 1) {
						equation = builder(equation, 13);
					} else if (stack.peek() == 2) {
						equation = builder(equation, 15);
					}
					stack.pop();
				}
				
				} else if (arg[x] == 13) {
					if (stack.isEmpty() == false) {
						if (stack.peek() == 1) {
							equation = builder(equation, 13);
							stack.pop();
						} else {
							equation = builder(equation, 15);
							stack.pop();
						}
					}
			
				} else {
					equation = builder(equation, arg[x]);
					prevToken = setPrevious(arg[x]);
					int y = stackBuild(arg[x]);
				
					if (y == 1) {
						stack.push(1);
					} else if (y == 2) {
						stack.push(2);
					}
				}
			}
		System.out.println("Final Equation:" + equation);
		String solCalc = Calculation.calculate(equation);
		}
		
		System.out.println("Equations whose solutions matched:");
	}
}

class Calculation {
	
	//Determines whether or not the current token is a number, operator, exponent, or trig equation
	static boolean getTokenType(String token) {
		
		boolean type = true;
		double num = 0.0;
		
		try {
			num = Double.valueOf(token);
		} catch (Exception e) {
			type = false;
		}
		
		return type;
		}
	
	//Function used to determine if a trig equation is negative or positive
	static String negativeCheck(String token) {
		
		char multiNTest = token.charAt(0);
		int nCounter = 0;
		int i = 0;
		
		//If token is longer than 1 char, checks for negative
		if (token.length() > 1) {
			
			//While loop that counts the number of '-' symbols
			while (multiNTest == '-') {
				nCounter++;
				i++;
				try {
					multiNTest = token.charAt(i);
				} catch (Exception e) {
					
				}
			}
			
		//Adjusts the token accordingly to match the later switch statement
			//For example, "---sin" becomes "-sin", and "----cos" becomes "cos"
		}
		if (multiNTest != '-') {
			token = token.substring(i);
		}
		if (nCounter%2 != 0) {
			token = "-" + token;
		}
		
		return token;
		
	}
	
	//Evaluation function for the postfix notation
	static String postFixEval(String equation) {
	
		//Creates stack for storing the numbers used in the calculation
		Stack<Double> stack = new Stack<>();
	
		//Tokenizes the postfix equation
		StringTokenizer eq = new StringTokenizer(equation, " ");
	
		//While loop that loops to deal with each part of the equation
		while (eq.hasMoreTokens()) {
			
			//Grabs the next token and checks the token's type
			String token = eq.nextToken();
			boolean type = getTokenType(token);
			
			//If the token is a number, pushes it to the stack
			if (type == true) {
				double num = 0.0;
				num = Double.valueOf(token);
				stack.push(num);
			
			//If the token is not a number, performs an operation 
			} else {
				
				//Creates two double variables for storing numbers
				double val1 = 0;
				double val2 = 0;
				
				//Checks the operator for a negative
				token = negativeCheck(token);
				
				//Switch case for handling each operator, exponent, negative, or trig equation
				switch(token) {
					
					//If the token is "+", push the addition of the second item and the first item from the top of the stack
					case "+":
						val2 = stack.pop();
						val1 = stack.pop();
						stack.push(val1 + val2);
						break;
						
					//If the token is "-+", return an error
					case "-+":
						return "error";
						
					//If the token is "-", push the subtraction of the second item from the first item of the stack
					case "-":
						val2 = stack.pop();
						val1 = stack.pop();
						stack.push(val1 - val2);
						break;
						
					//If the token is "--", return an error
					case "--":
						return "error";
						
					//If the token is "*", push the multiplication of the second item and the first item of the stack
					case "*":
						val2 = stack.pop();
						val1 = stack.pop();
						stack.push(val1 * val2);
						break;
						
					//If the token is "-*", return an error
					case "-*":
						return "error";
						
					//If the token is "/", push the division of the first item from the stack by the second item
					case "/":
						val2 = stack.pop();
						val1 = stack.pop();
						stack.push(val1 / val2);
						break;
						
					//If the token is "-/", return an error
					case "-/":
						return "error";
						
					//If the token is "^", push the first item to the power of the second item from the stack
					case "^":
						val2 = stack.pop();
						val1 = stack.pop();
						stack.push(Math.pow(val1, val2));
						break;
						
					//If the token is "-^", return an error
					case "-^":
						return "error";
						
					//If the token is "sin", push the sin of the first item from the stack
					case "sin":
						val1 = stack.pop();
						stack.push(Math.sin(val1));
						break;
						
					//If the token is "-sin", push the sin of the first item from the stack multiplied by -1
					case "-sin":
						val1 = stack.pop();
						stack.push(Math.sin(val1) * -1);
						break;
						
					//If the token is "cos", push the cos of the first item from the stack
					case "cos":
						val1 = stack.pop();
						stack.push(Math.cos(val1));
						break;
						
					//If the token is "-cos", push the cos of the first item from the stack multiplied by -1
					case "-cos":
						val1 = stack.pop();
						stack.push(Math.cos(val1) * -1);
						break;
						
					//If the token is "tan", push the tan of the first item from the stack
					case "tan":
						val1 = stack.pop();
						stack.push(Math.tan(val1));
						break;
						
					//If the token is "-tan", push the tan of the first item from the stack multiplied by -1
					case "-tan":
						val1 = stack.pop();
						stack.push(Math.tan(val1) * -1);
						break;
						
					//If the token is "cot", push the cot of the first item from the stack
						//If the first item from stack = 0, return "Infinity0" error
					case "cot":
						val1 = stack.pop();
						if (val1 == 0) {
							return "Infinity0";
						}
						stack.push(1/Math.tan(val1));
						break;
						
					//If the token is "-cot", push the cot of the first item from the stack multiplied by -1
						//If the first item from the stack = 0, return "-Infinity" error
					case "-cot":
						val1 = stack.pop();
						if (val1 == 0) {
							return "-Infinity";
						}
						stack.push(-1/Math.tan(val1));
						break;
						
					//If the token is "ln", push the natural log of the first item from the stack
						//If the first item from the stack =0, return "-Infinity" error
						//If the first item from the stack <0, return "NaN" error
					case "ln":
						val1 = stack.pop();
						if (val1 == 0) {
							return "-Infinity";
						} else if (val1 < 0) {
							return "NaN";
						}
						stack.push(Math.log(val1));
						break;
						
					//If the token is "-ln", push the natural log of the first item from stack multiplied by -1
						//If the first item from the stack =0, return "Infinity0" error
						//If the first item from the stack <0, return "NaN" error
					case "-ln":
						val1 = stack.pop();
						if (val1 == 0) {
							return "Infinity0";
						} else if (val1 < 0) {
							return "NaN";
						}
						stack.push(Math.log(val1) * -1);
						break;
						
					//If the token is "log", push the log10 of the first item from the stack
						//If the first item from the stack =0, return "-Infinity" error
						//If the first item from the stack <0, return "NaN" error
					case "log":
						val1 = stack.pop();
						if (val1 == 0) {
							return "-Infinity";
						} else if (val1 < 0) {
							return "NaN";
						}
						stack.push(Math.log10(val1));
						break;
						
					//If the token is "-log", push the log10 of the first item from the stack multiplied by -1
						//If the first item from the stack =0, return "Infinity0" error
						//If the first item from the stack <0, return "NaN" error
					case "-log":
						val1 = stack.pop();
						if (val1 == 0) {
							return "Infinity0";
						} else if (val1 < 0) {
							return "NaN";
						}
						stack.push(Math.log10(val1) * -1);
						break;
						
					//If the token is "N", push the top of the stack multiplied by -1
					case "N":
						val1 = stack.pop();
						stack.push(val1 * -1);
						break;
						
					//If no correct tokens are recognized, return an error
					default:
						return "error";
				}	
			}
		}
	
		//After all tokens are processed, take the top of the stack and turn it into a string
		Double result = stack.pop();
		
		//If the the stack is still not empty, throw an error
		if (!stack.isEmpty()) {
			return "error";
		}
		
		//Return the result
		return result.toString();
	}
	
	//Calculation function that calls the inToPostfix function and catches errors from it
	public static String calculate(String equation) {
		
		String postfix = Postfix.inToPostfix(equation);
		
		String solution;
		
		//Switch case for specific error catches
		switch(postfix) {
		case "error":
			return "error";
		case "par error":
			return "par error";
		case "E":
			return "E";
		default:
			solution = postFixEval(postfix);
			
		return solution;
		}
	}
}

class Postfix {
	
	/**
	 * Function for testing a symbol or function's priority in the que
	 */
	
	static int getPriority(String op) {
		
		//Initializes necessary variables
		char testForNegative = op.charAt(0);
		int i = 0;
		
		//If loop with a nested while loop used for detecting unary and binary negative symbols.
				//Temporarily erases all negative symbols to obtain priority
		if (op.length() > 1) {
			while (testForNegative == '-' && op.length() > 1) {
				try {
					op = op.substring(1);
					testForNegative = op.charAt(0);
				} catch (Exception e) {
				
				}
			}
		}
		
		/**
		 * Switch case for deciding priority. + and - have priority 1. * and / have priority 2. 
		 	* ^ has priority 3. Trig functions have priority 4. Parenthesis and curly brackets have priority 5.
		 * Numbers and invalid symbols have priority -1.
		 */
		switch(op) {
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "^":
			return 3;
		case "sin":
			return 4;
		case "cos":
			return 4;
		case "tan":
			return 4;
		case "cot":
			return 4;
		case "ln":
			return 4;
		case "log":
			return 4;
		case "(":
			return 5;
		case ")":
			return 5;
		case "{":
			return 5;
		case "}":
			return 5;
		}
		
		return -1;
	}
	
	/**
	 * Function for testing the correct amount of parenthesis and curly brackets. Does not check for correct order.
	 */
	
	static boolean testForParen(String equation) {
		
		//Initializes variables for counting parenthesis/curly bracket sets
		int openPar = 0;
		int openCur = 0;
		
		//Tokenizes the equation by " "
		StringTokenizer eq = new StringTokenizer(equation, " ");
		
		//While loop to count each open and closed parenthesis/curly bracket
		while(eq.hasMoreTokens()) {
			
			//Grabs the current token in eq
			String token = eq.nextToken();
			
			//Variables needed to check for negative symbols
			char multiNTest = token.charAt(0);
			int nCounter = 0;
			int i = 0;
			
			//While loop that checks for negative symbols
			while (multiNTest == '-' && token.length() > 1) {
				nCounter++;
				i++;
				try {
					multiNTest = token.charAt(i);
				} catch (Exception e) {
					
				}
			}
			
			//Once no more negatives remain, adjust the equation accordingly
			if (multiNTest != '-') {
				token = token.substring(i);
			}
			//If %2 returns 0, the number is positive. If not, the number is negative.
			if (nCounter%2 != 0) {
				token = "-" + token;
			}
			
			//Switch case for counting sets. (, -(, {, and -{ count up one. ) and } count down one.
			switch (token) {
			case "(":
				openPar++;
				break;
			case "-(":
				openPar++;
				break;
			case ")":
				openPar--;
				break;
			case "{":
				openCur++;
				break;
			case "-{":
				openCur++;
				break;
			case "}":
				openCur--;
				break;
			}
		}
		
		//If either openCur or openPar are not 0, that means that the number of 
			//open and closing parenthesis/curly brackets do not match.
		//If they = 0, return false.
		if (openCur != 0) {
			return false;
		}
		if (openPar != 0) {
			return false;
		}
		
		return true;
	}
	
	//Main function for converting an equation to postfix notation
	public static String inToPostfix(String equation) {
		
		//Calls testForParen using the equation.
		if (testForParen(equation) == false) {
			return "par error";
		}
		
		//Creates a stack for storing operators, parenthesis, curly brackets, exponents, and trig equations
		Stack <String> stack = new Stack<>();
		
		//Creates a string for storing the postfix notation
		String postFix = new String("");
		
		//Tokenizes the equation by " "
		StringTokenizer eq = new StringTokenizer(equation, " ");
		
		//While loop that does a bulk of the work
		while (eq.hasMoreTokens()) {
			
			//Creates a token string to store the current token.
			String token = eq.nextToken();
			
			//Calls getPriority for the current token and stores it in an int
			int priority = getPriority(token);
			
			//If else if statement for deciding what to do with specific priorities
				//If Priority == -1, tries to convert to a number and store it in String postFix
			if (priority == -1) {
				
				//Initializes variables for testing for negative unary/binary symbols
				double num = 0;
				char multiNTest = token.charAt(0);
				int nCounter = 0;
				int i = 0;
				
				//While loop that counts and subsequently erases the number of negative symols
				while (multiNTest == '-') {
					nCounter++;
					i++;
					try {
						multiNTest = token.charAt(i);
					} catch (Exception e) {
						
					}
				}
				
				//Changes token to adjust to a readable format
				if (multiNTest != '-') {
					token = token.substring(i);
				}
				//If the counter is even, the token is positive, if the counter is odd, the token is negative
				if (nCounter%2 != 0) {
					token = "-" + token;
				}
				
				//Tries to convert to a number. If an error is found, the equation is invalid
				try {
					num = Double.valueOf(token);
				} catch (Exception e) {
					System.out.println("Invalid Equation!");
					return "error";
				}
				
				//Adds the number to the postFix equation
				postFix = postFix.concat(token + " ");
				
			//If priority = 5, then it's a parenthesis or curly bracket
			} else if (priority == 5) {
				
				//Initializes variables to check for a negative
				char multiNTest = token.charAt(0);
				int nCounter = 0;
				int i = 0;
				
				//While loop that counts negative unary/binary symbols
				while (multiNTest == '-') {
					nCounter++;
					i++;
					try {
						multiNTest = token.charAt(i);
					} catch (Exception e) {
						
					}
				}
				
				//Changes token to adjust to a readable format
				if (multiNTest != '-') {
					token = token.substring(i);
				}
				//If the counter is even, the token is positive, if the counter is odd, the token is negative
				if (nCounter%2 != 0) {
					token = "-" + token;
				}
				
				//Switch case for each parenthesis or curly bracket symbol
				switch (token) {
				
				//If "(" is detected, pushes "(" to the stack
				case "(":
					stack.push(token);
					break;
					
				//If "-(" is detected, pushes "(" and then "N" to the stack
					//"N" represents negative parenthesis
				case "-(":
					stack.push(token.substring(1));
					stack.push("N");
					break;
					
				//If "{" is detected, pushes "{" to the stack
				case "{":
					stack.push(token);
					break;
					
				//If "-{" is detected, pushes "{" and then "N" to the stack
					//"N" represents negative curly brackets
				case "-{":
					stack.push(token.substring(1));
					stack.push("N");
					break;
				
				//If ")" is detected, pop all items in the stack to the equation
					//until a "(" is reached
				case ")":
					char testPar = 'a';
					
					//While loop for finding the "(" in the stack
					while (testPar != '(') {
						testPar = stack.peek().charAt(0);
						
						//If ")", "{", or "}" is found, throw an error
						if (testPar == ')' || testPar == '{' || testPar == '}') {
							return "par error";
						
						//Once "(" is found, pops it out of the stack but NOT into the equation
						} else if (testPar == '(') {
							stack.pop();
							
						//If the end of the stack is reached before finding "(", throw an error
						} else if (stack.isEmpty() == true) {
							return "par error";
							
						//Pops the top of the stack to the equation if it's not "(" or invalid
               			} else {
							postFix = postFix.concat(stack.pop() + " ");
						}
					}
					break;
					
				//If "-)" is detected, throw an error
				case "-)":
					return "error";
					
				//If "}" is detected, pop all items in the stack to the equation
					//until a "}" is reached
				case "}":
					char testChar = 'a';
					
					//While loop for finding "{"
					while (testChar != '{') {
						testChar = stack.peek().charAt(0);
						
						//If ")", "(", or "}" is reached before "{", throw an error
						if (testChar == ')' || testChar == '(' || testChar == '}') {
							return "par error";
							
						//Once "{" is found, pops it out of the stack but NOT into the equation
						} else if (testChar == '{') {
							stack.pop();
							
						//If the end of the stack is reached before "{", throws an error
						} else if (stack.isEmpty() == true) {
							return "par error";
							
						//Pops the top of the stack to the equation if it's not "{" or invalid
						} else {
							postFix = postFix.concat(stack.pop() + " ");
						}
					}
					break;
					
				//If "-}" is detected, throw an error
				case "-}":
					return "error";
				}
			
			//If priority is 1-4, determines how to add it to the stack
			} else {
				
				//Checks the priority of the top of the stack (if it's not empty)
				int prioCheck = -1;
				if (!stack.isEmpty()) {
					prioCheck = getPriority(stack.peek());
				}
				
				//Switch case for determining how to approach each priority value
				switch(priority) {
				
				//When priority is 1, check the top of the stack to see if the priority is
					//lower than 1 OR is a priority 5 (aka "(" or "{"), push to stack.
					//Otherwise, pops top of stack until the token can be pushed
				case 1:
					while (prioCheck >= 1 && prioCheck < 5 && !stack.isEmpty()) {
						postFix = postFix.concat(stack.pop() + " ");
						if (!stack.isEmpty()) {
							prioCheck = getPriority(stack.peek());
						}
					}
					stack.push(token);
					break;
					
				//When priority is 2, check the top of the stack to see if the priority is 1-4
					//lower than 2 OR is a priority 5 (aka "(" or "{"), push to stack.
					//Otherwise, pops top of stack until the token can be pushed
				case 2:
					while (prioCheck >= 2 && prioCheck < 5 && !stack.isEmpty()) {
						postFix = postFix.concat(stack.pop() + " ");
						if (!stack.isEmpty()) {
							prioCheck = getPriority(stack.peek());
						}
					}
					stack.push(token);
					break;
					
				//When priority is 3, check the top of the stack to see if the priority is 1-4
					//lower than 3 OR is a priority 5 (aka "(" or "{"), push to stack.
					//Otherwise, pops top of stack until the token can be pushed
				case 3:
					while (prioCheck >= 3 && prioCheck < 5 && !stack.isEmpty()) {
						postFix = postFix.concat(stack.pop() + " ");
						if (!stack.isEmpty()) {
							prioCheck = getPriority(stack.peek());
						}
					}
					stack.push(token);
					break;
				
				//When priority is 4, automatically push it to the top of the stack
				case 4:
					stack.push(token);
					break;
				}	
			}
		}
		
		//Once all tokens have been handled, pops the stack into the equation until the stack is empty
		while (!stack.isEmpty()) {
			postFix = postFix.concat(stack.pop() + " ");
		}
		
		//Returns completed equation
		return postFix;
	}
}