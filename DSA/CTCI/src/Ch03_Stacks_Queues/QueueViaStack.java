package Ch03_Stacks_Queues;

import java.util.Stack;

public class QueueViaStack<T> {

	Stack<T> s1,s2;
	
	
	public QueueViaStack() {
		// TODO Auto-generated constructor stub
		s1=new Stack<T>();
		s2=new Stack<T>();
	}
	
	public int size() {
		return s1.size()+s2.size();
	}
	
	public void add(T item) {
		s1.push(item);
	}
	
	public T remove() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
		}
		return s2.pop();
	}
	
	public T peek() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
		}
		return s2.peek();
	}
	
	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}
	
}
