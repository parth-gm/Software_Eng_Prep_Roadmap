package linkedlist;

public class DoublyLinkedList{
	
	DoublyLinkedListNode first=null;
	DoublyLinkedListNode end=null;
	int size = 0;
	
	public void remove(DoublyLinkedListNode node) {
		if(node.prev==null && node.next==null) {
			first = null;
			end = null;
		}
		else if(node.prev==null) {
			first = node.next;
			node.next = null;
			first.prev = null;
			
			
		}else if(node.next==null) {
			end = node.prev;
			end.next = null;
			node.prev = null;
			
		}else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
	}
	
	public void addFirst(DoublyLinkedListNode node) {
		
		if(first==null) {
			first = node;
			end = node;
		}else 
		{
			first.prev = node;
			node.next = first;
			node.prev = null;
			first = node;
		}
		size++;
	}
	
	public void addLast(DoublyLinkedListNode node) {
		if(end==null) {
			end = node;
			first= node;
		}else 
		{
			end.next = node;
			node.prev = end;
			node.next = null;
			end = node;
		}
		size++;
	}
	
	public DoublyLinkedListNode removeFirst() throws Exception {
		if(first!=null)
		{
			DoublyLinkedListNode temp = first;
			
			first = first.next;
			if(first!=null) {
				first.prev = null;
			}else {
				end = null;
			}
			
			size--;
			return temp;
		}
        return null;
		
	}
	
	public DoublyLinkedListNode removeLast() {
		
		if(end!=null)
		{
			DoublyLinkedListNode temp = end;
			end = end.prev;
			if(end!=null)
				end.next = null;
			else
				first = null;
			size--;
			return temp;
		}
        return null;
	}
	
	
}