package Ch03_Stacks_Queues;

import java.util.Stack;

public class SortStack {

	Stack<Integer> s1,s2;
	
	public SortStack() {
		s1=new Stack<Integer>();
		s2=new Stack<Integer>();
	}
	
	public void push(int item) {
		
		if(s1.isEmpty())
			s1.push(item);
		else {
			if(s1.peek()>item) s1.push(item);
			else {
				while(!s1.isEmpty() && s1.peek()<item) s2.push(s1.pop());
				s1.push(item);
				while(!s2.isEmpty()) s1.push(s2.pop());
			}
		}
		
	}
	

	
	public Integer pop() {
		return s1.pop();
	}
	
	public void printStack() {
		System.out.println(s1);
	}
	
	
}
