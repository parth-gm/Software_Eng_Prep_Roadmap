	package codechef;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	static int  precedence(char c) {
		switch(c) {
		case '^': return 5;
		case '/': return 4;
		case '*': return 3;
		case '-': return 2;
		case '+': return 1;
		default:  return -1;
			
		}
	}
	
	static String convert(String exp) {
		Stack<Character> stack=new Stack<Character>();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<exp.length();i++) {
			
			if(exp.charAt(i)>= 97 && exp.charAt(i)<=122) {
				sb.append(exp.charAt(i));
			}else {
				if(exp.charAt(i)=='(') stack.push('(');
				else {
					if(exp.charAt(i)==')') {
						while(stack.peek()!='(') sb.append(stack.pop());
						stack.pop();
					}else {
						if( precedence(stack.peek())>=precedence(exp.charAt(i))) {
							sb.append(stack.pop());
							stack.push(exp.charAt(i));
						}else {
							stack.push(exp.charAt(i));
						}
					}
				}
				
				
			}
			
			
			
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			String exp=sc.next();
			System.out.println(convert(exp));
		}
		
		
	}

}
