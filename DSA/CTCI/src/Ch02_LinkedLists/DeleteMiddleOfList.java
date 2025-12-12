package Ch02_LinkedLists;

public class DeleteMiddleOfList {

	
	static int randomIntInRange(int min,int max) {
		return (int)(Math.random()*(max-min+1))+min;
	}
	
	static Node randomLinkList(int N,int max,int min) {
		Node head=new Node(randomIntInRange(min, max));
		Node prev=head;
		for(int i=1;i<N;i++) {
			Node next=new Node(randomIntInRange(min, max));
			prev.setNext(next);
			prev=next;
		}
		return head;
	}
	
	static boolean deleteMiddleNode(Node n) {
		if(n==null || n.next==null) return false;
		
		n.data=n.next.data;
		n.next=n.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=randomLinkList(5, 7, 1);
		System.out.println(root.printForward());
		deleteMiddleNode(root.next.next);
		System.out.println(root.printForward());

	}

}
