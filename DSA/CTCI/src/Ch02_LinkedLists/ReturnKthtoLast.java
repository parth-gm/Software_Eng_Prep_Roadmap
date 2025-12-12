package Ch02_LinkedLists;

public class ReturnKthtoLast {

	
	static int findKthToLast(Node head,int k) {
		int len=head.lenFromNode();
		int nodeFormStart=len-k+1;
		if(k>len)return -1;
		return head.findKthNode(nodeFormStart);
	}
	static void printAllUsingLast(Node head) {
		int len=head.lenFromNode();
		Node current=head;
		for(int last=len;last>0;last--) {
			System.out.println(last+"th Elementfrom Last "+current.data);
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);
		Node itr=head;
		for(int i=1;i<8;i++) {
			Node nextn=new Node(i);
			itr.next=nextn;
			itr=nextn;
		}
		System.out.println(head.printForward());
		System.out.println(findKthToLast(head,0));
		printAllUsingLast(head);
		
	}

}
