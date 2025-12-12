package Stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
	
	LinkedList<T> list = new LinkedList<>();
	
	public Stack() {
		
	}
	
	public Stack(T ele) {
		push(ele);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void push(T ele) {
		list.addLast(ele);
	}
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return list.removeLast();
	}
	
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		return list.peekLast();
	}
	
	public Iterator<T> iterator() {
		
		return list.iterator();
		
	}

}
