package tutorial;

class Node {
	int value;
	Node next;
	public Node(int value) {
		this.value=value;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
