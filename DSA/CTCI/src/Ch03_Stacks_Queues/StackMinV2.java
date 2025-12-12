package Ch03_Stacks_Queues;

import java.util.Stack;

public class StackMinV2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackMinV2() {
		s2=new Stack<Integer>();
	}
	
	public void push(int item) {
		if(item<min()) {
			s2.push(item);
		}
		super.push(item);
	}
	
	public Integer pop() {
		int value=super.pop();
		if(value==min()) s2.pop();
		
		return value;
	}
	
	public int min() {
		if(s2.isEmpty()) return Integer.MAX_VALUE;
		else {
			return s2.peek();
		}
	}
	
	
}
