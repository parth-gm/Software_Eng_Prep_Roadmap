package Ch03_Stacks_Queues;

import java.util.Stack;

public class StackMin extends Stack<MinNode> {

	public void push(int val) {
		int newmin=Math.min(val, min());
		super.push(new MinNode(val, newmin));
		
	}
	
	public int min() {
		if(this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return this.peek().minvalue;
			
	}
	
	
}
