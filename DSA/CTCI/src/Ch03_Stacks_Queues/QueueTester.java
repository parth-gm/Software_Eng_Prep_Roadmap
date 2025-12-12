package Ch03_Stacks_Queues;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class QueueTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int[] array = AssortedMethods.randomArray(100, -100, 100);
				MyQueue<Integer> q1 = new MyQueue<Integer>();		
				Queue<Integer> q2 = new LinkedList<Integer>();
				
				for (int a : array) {
					if (a < 0) {
						int last1, last2;
						try {
							last1 = q1.remove();
						} catch (NoSuchElementException ex) {
							last1 = Integer.MIN_VALUE;
						}
						try {
							last2 = q2.remove();
						} catch (NoSuchElementException ex) {
							last2 = Integer.MIN_VALUE;
						}
						if (last1 != last2) {
							System.out.println("ERROR: mismatching tops");
						} else {
							System.out.println("SUCCESS: matching tops: " + last1);
						}
					} else {
						q1.add(a);
						q2.add(a);
					}
				}
				
				while (!q1.isEmpty() || !q2.isEmpty()) {
					int first1,first2;
					try {
						first1=q1.remove();
					} catch (NoSuchElementException ex) {
						
						first1 = Integer.MIN_VALUE;
					}
					try {
						first2=q2.remove();
					} catch (NoSuchElementException ex) {
						first2 = Integer.MIN_VALUE;
					}
					if (first1 != first2) {
						System.out.println("ERROR: mismatching tops");
					} else {
						System.out.println("SUCCESS: matching tops: " + first1);
					}
				}
	}

}
