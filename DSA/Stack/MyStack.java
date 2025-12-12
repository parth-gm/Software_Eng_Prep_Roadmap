package tutorial;

import java.util.EmptyStackException;

public class MyStack<T> {
	private class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data){
			this.data=data;
		}
	}
	
	private StackNode<T> top;
	private int size;
	public T pop() {
		if(top==null) throw new EmptyStackException();
		T item=top.data;
		top=top.next;
		size--;
		return item;
		
	}
	public int getSize() {
		return size;
	}
	public void push(T item) {
		StackNode<T> t=new StackNode<T>(item);
		t.next=top;
		top=t;
		size++;
	}
	
	public T peek() {
		if(top==null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		if(top==null) return true;
		return false;
	}

}
