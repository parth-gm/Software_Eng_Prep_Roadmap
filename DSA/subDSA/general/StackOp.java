package test;

import java.util.Stack;
import java.util.StringTokenizer;

public class StackOp {
	
	static final int minIntegerAllowed = 0;
	static final int maxIntegerAllowed = (int) (Math.pow(2, 20)-1);
	
	public static boolean isStackEmpty(Stack<Integer> stack, String op) {
		if(stack.isEmpty()) {
			System.err.println("Invalid Operation - Stack is empty while performing '"+op+"'");
			return true;
		
		}
		return false;
	}
	
	public static boolean isStackSizeInsufficient(Stack<Integer> stack, String op) {
		if(stack.size()<2) { 
			System.err.println("Invalid Operation - Stack size is insufficient while performing '"+op+"'");
			
			return true;
		}
		return false;
		
	}
	
	public static int validateOverflowAndGetSum(int n1, int n2) {
		
		int sum = n1+n2;
		if(sum>maxIntegerAllowed) {
			System.err.println("Overflow while adding "+n1+","+n2);
			return -1;
		}
		return sum;
	}
	
	public static int validateUnderflowAndGetSub(int n1, int n2) {
		int sub = n1-n2;
		if(sub < minIntegerAllowed)
		{
			 System.err.println("Underflow while subtracting "+n1+","+n2);
			 return -1;
		}
		return sub;
	}
	
	public static int validateIntegerAndGetInt(String s) {
		int ansInt = -1; 
		try { 
				ansInt = Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		    	System.out.println("Invalid Operation - Expected Unsigned Integer for push "+s);
		    	return -1;
		    }
		 return ansInt;
	}
	
	
	public static int solution(String S) {
        
		StringTokenizer st = new StringTokenizer(S, " ");
		Stack<Integer> stack = new Stack<>();
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			switch(token){
				
			case "POP":
				if(isStackEmpty(stack, token)) {
					return -1;
				}
				stack.pop();
				break;
			case "DUP":
				if(isStackEmpty(stack, token)) {
					return -1;
				}
				stack.push(stack.peek());
				break;
			case "+":
				if(isStackSizeInsufficient(stack, token)) {
					return -1;
				}
				int firsSum = stack.pop();
				int secondSum = stack.pop();
				int sum = validateOverflowAndGetSum(firsSum, secondSum);
				if(sum==-1)
					return -1;
				stack.push(sum);
				
				break;
			case "-":
				if(isStackSizeInsufficient(stack, token)) {
					return -1;
				}
				int firstSub = stack.pop();
				int secondSub = stack.pop();
				int sub = validateUnderflowAndGetSub(firstSub, secondSub);
				if(sub==-1)
					return -1;
				stack.push(sub);
				break;
			default:
				int eleToPush = validateIntegerAndGetInt(token);
				if(eleToPush==-1)
					return -1;
				stack.push(eleToPush);

			}
		}
		
		//Fetching top-most element as result
		if(isStackEmpty(stack, "TOP")) {
			return -1;
		}
		return stack.peek();
		
    }
	
	public static void main(String[] args) {
		System.out.println(solution("4 5 6 - 7 +"));
		System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
		System.out.println(solution("5 6 + -"));
		System.out.println(solution("3 DUP 5 - -"));
		System.out.println(solution("1048575 DUP +"));
		System.out.println(solution("-1 0 -"));
	}
	

}
