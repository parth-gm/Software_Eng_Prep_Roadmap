package Ch02_LinkedLists;

import java.util.Stack;

//Using fast and slow pointer and stack
public class PalindromV2 {
	
	
	static boolean isPalindromv2(Node head,int length) {
		
		Node fast=head,slow=head;
		
		if(head==null || head.next==null) return true;
		
		Stack<Integer> stack=new Stack<Integer>();
		
		while(fast!=null && fast.next!=null) {
			stack.push(slow.data);
			
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null) slow=slow.next;
		
//		int count=length/2;
		
		while(slow!=null) {
			if(stack.pop()!=slow.data) return false;
			slow=slow.next;
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length=4;
		Node lists[]=new Node[length];
		
		for(int i=0;i<length;i++) {
			lists[i]=new Node(i<(length/2)?i:length-i-1);
			//System.out.println(lists[i].data);
		}
		
		for(int j=0;j<length-1;j++) {
			lists[j].setNext(lists[j+1]);
		}
		//lists[2].data=4;
		
		System.out.println(lists[0].printForward());
		
		System.out.println(isPalindromv2(lists[0],length));
	}

}
