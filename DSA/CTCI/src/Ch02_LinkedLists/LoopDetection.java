package Ch02_LinkedLists;


public class LoopDetection {

	
	static boolean checkIsLoop(Node head) {
		
		if(head==null) return false;
		
		if(head.next==head) return true;
		
		Node fast=head,slow=head;
		
		while( slow!=null && fast!=null && fast.next!=null){
			
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int list_length = 100;
		int k = 10;
		
		// Create linked list 99-->98-->97-->96-->...-->0-->90(at K distance from end)
		Node[] nodes = new Node[list_length];
		
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new Node(i,  i > 0 ? nodes[i - 1] : null);
		}
		
		System.out.println(nodes[99].printForward());

		nodes[0].next = nodes[list_length - k];
		System.out.println("Loop come back to "+ nodes[list_length - k].data);
		
		System.out.println(checkIsLoop(nodes[list_length-1]));
		
	}

}
