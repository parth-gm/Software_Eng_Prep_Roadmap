package Ch02_LinkedLists;

public class Palindrom {

	static boolean isPalindrom(Node head,int length) {
		Node reversedhead=reverseAndClone(head,length);
		return isEqual(head,reversedhead);
	}
	
	static Node reverseAndClone(Node head,int length) {
		
		if(head==null) return null;
		if(head.next==null) return head;
		
		Node curhead=head,prev=null;
		
		while(curhead!=null) {
			Node next=curhead.next;
			curhead.next=prev;
			prev=curhead;
			curhead=next;
			
		}
		
		return prev;
		
	}
	
	static boolean isEqual(Node head,Node rhead) {
		
		while(head!=null && rhead!=null)
		{
			if(head.data!=rhead.data)
				return false;
			head=head.next;
			rhead=rhead.next;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length=10;
		Node lists[]=new Node[length];
		
		for(int i=0;i<length;i++) {
			lists[i]=new Node(i<(length/2)?i:length-i-1);
			//System.out.println(lists[i].data);
		}
		
		for(int j=0;j<length-1;j++) {
			lists[j].setNext(lists[j+1]);
		}
		
		System.out.println(lists[0].printForward());
		
		System.out.println(isPalindrom(lists[0],length));
	}

}
