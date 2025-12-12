package Core;

public class InsertLinkedList {

	static void insertAtNth(Node head, int n) {
		
		Node current = head;
		Node prev = null;
		if(n==0)
		{
			
		}
		while(n>0 && current.next!=null)
		{
			prev = current;
			current=current.next;
			n--;
		}
		if(n==0) {
			Node newN = new Node(999);
			newN.next = current;
			prev.next = newN;
		}else
		{
			System.out.println("List size exceded");
		}
	}
	
	public static void main(String[] args) {
		Node head= new Node(0);
		Node current = head;
		for(int i=1;i<9;i++) {
			Node temp = new Node(i);
			current.next = temp;
			current = temp;
		}
		insertAtNth(head, 3);
	}

}
