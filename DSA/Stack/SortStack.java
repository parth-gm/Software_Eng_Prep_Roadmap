package tutorial;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

	static Stack<Integer> sortStack(Stack<Integer> stack,int size){
		
		Stack<Integer> dummySt=new Stack<Integer>();
		
		for(int i=0;i<size;i++) {
			if(dummySt.isEmpty()) {
				dummySt.push(stack.pop());
			}else {
				int top=stack.pop();
				int count=0;
				while((!dummySt.isEmpty()) && dummySt.peek()<top) {
					stack.push(dummySt.pop());
					count++;
				}
				dummySt.push(top);
				
				while(count>0) {
					dummySt.push(stack.pop());
					count--;
				}
				
			}
		}
		return dummySt;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Stack<Integer> stack=new Stack<Integer>();
		
		System.out.println("Push Element into stack");
		
		System.out.println("No of Elements");
		int no=sc.nextInt();
		
		
		for(int i=0;i<no;i++) {
			stack.push(sc.nextInt());
		}
		System.out.println("Stack before Sort:");
		System.out.println(stack.toString());
		stack=sortStack(stack,no);
		
		
		System.out.println("Stack after sort");
		System.out.println(stack.toString());
		
	}

}
