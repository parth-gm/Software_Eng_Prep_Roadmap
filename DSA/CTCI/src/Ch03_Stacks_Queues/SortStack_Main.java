package Ch03_Stacks_Queues;

import java.util.Stack;


public class SortStack_Main {

	public static void main(String[] args) {
		//Push Takes O(N^2)
		SortStack ss=new SortStack();//
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			ss.push(r);
		}
		
		
		
		while(!ss.s1.isEmpty()) {
			System.out.println(ss.s1.pop());
		}
	}

}
