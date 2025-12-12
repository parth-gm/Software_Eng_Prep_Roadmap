package DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

	private int size=0;
	private Node<T> head=null, tail=null;
	
	private class Node<T>{
		T data;
		Node<T> prev, next;
		public Node(T data, Node<T> prev, Node<T> next)
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
			
		}
		
		public String toString() {
			return this.data.toString();
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node<T> trav = head;
		while(trav!=null) {
			sb.append(trav.data);
			if(trav.next!=null)
				sb.append(", ");
		}
		return sb.append("]").toString();
	}
	
	public void clear() {
		Node<T> trav = head;
		while(trav!=null) {
			Node<T> next = trav.next;
			trav.next = trav.prev = null;
			trav.data =null;
			trav = next;
		}
		head = tail =null;
		size =0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void add(T ele) {
		addLast(ele);
	}
	
	public void addFirst(T ele) {
		if(isEmpty())
		{
			head = tail = new Node<T>(ele, null, null); 
		}else {
			this.head.prev = new Node<T>(ele, null, head);
			this.head = head.prev;
		}
		size++;
	}
	
	public void addLast(T ele) {
		if(isEmpty())
		{
			head = tail = new Node<T>(ele, null, null); 
		}else {
			this.tail.next = new Node<T>(ele, tail, null);
			this.tail = tail.next;
		}
		size++;
	}
	
	public T peekFirst() {
		if(isEmpty()) throw new  RuntimeException("Empty List");
		return head.data;
	}
	
	public T peekLast() {
		if(isEmpty()) throw new  RuntimeException("Empty List");
		return tail.data;
	}
	
	public T removeFirst() {
		if(isEmpty()) throw new  RuntimeException("Empty List");
		T ele = head.data;
		Node<T> first = head;
		head = head.next;
		--size;
		
		if(isEmpty()) tail = null;
		else head.prev = null;
		first.prev = first.next = null;
		
		return ele;
	}
	
	private T remove(Node<T> node) {
		
		if(node.prev==null) return removeFirst();
		if(node.next==null) return removeLast();
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		T data = node.data;
		node.data = null;
		node = node.prev = node.next = null;
		
		--size;
		
		return data;
		
	}
	
	public T removeAt(int index) {
		if(index<0 || index>=size())
			throw new IllegalArgumentException();
		Node<T> trav = head;
		for(int i=0;i<index;i++) {
			trav =trav.next;
		}
		
		return remove(trav);
		
		
	}
	
	public void addAt(int index, T data) throws Exception {
		if(index < 0) {
			throw new Exception("Illegal Index");
			
		}
		if(index == 0) {
			addFirst(data);
			return;
		}
		if(index==size) {
			addLast(data);
			return;
		}
		Node<T> temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		
		Node<T> newNode = new Node<T>(data, temp, temp.next);
		temp.next.prev = newNode;
		temp.next = newNode;
		size++;
		
	}
	
	public boolean remove(Object obj) {
		Node<T> trav =head;
		if(obj == null) {
			for(trav =head; trav!=null;trav = trav.next)
			{
				if(trav.data==null) {
					remove(trav);
					return true;
				}
			}
		}else {
			for(trav =head; trav!=null;trav = trav.next)
			{
				if(obj.equals(trav.data)) {
					remove(trav);
					return true;
				}
			}
		}
		return false;
	}
	
	public int indexOf(Object obj) {
		int index=0;
		Node<T> trav =head;
		if(obj == null) {
			for(trav =head; trav!=null;trav = trav.next,index++)
			{
				if(trav.data==null) {
					return index;
				}
			}
		}else {
			for(trav =head; trav!=null;trav = trav.next,index++)
			{
				if(obj.equals(trav.data)) {
					
					return index;
				}
			}
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj)!= -1;
	}
	
	private T removeLast() {
		// TODO Auto-generated method stub
		if(isEmpty())throw new RuntimeException("Empty List");

		T data = tail.data;

		tail = tail.prev;
		
		--size;
		 if(isEmpty()) head = tail = null;
		 else tail.next = null; 
		 return data;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> it = new Iterator<T>() {
			private Node<T> trav =  head;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return trav!=null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T data = trav.data;
				trav =trav.next;
				return data;
			}
			
		};
		return it;

	}

	
}
