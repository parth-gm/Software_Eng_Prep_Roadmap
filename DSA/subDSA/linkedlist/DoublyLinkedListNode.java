package linkedlist;
public class DoublyLinkedListNode {
	
	int key;
	int value;
	DoublyLinkedListNode prev, next;
	
	public DoublyLinkedListNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
	
	public DoublyLinkedListNode(int key, int value, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
		this.key = key;
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
}