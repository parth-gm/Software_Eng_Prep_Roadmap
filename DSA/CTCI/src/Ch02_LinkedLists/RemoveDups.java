package Ch02_LinkedLists;

import java.util.HashSet;

public class RemoveDups {

	
	static void removeDups(Node head) {
		Node prev=head,cur=head;
		HashSet<Integer> hashList=new HashSet<Integer>();
		while(cur!=null) {
			if(hashList.contains(cur.data)){
				prev.next=cur.next;
			}else {
				hashList.add(cur.data);
				prev=cur;
			}
			cur=cur.next;
		}
	}
	
	
	static void removeDupsv2(Node head){
		Node current=head,runner=head;
		
		while(current!=null) {
			runner=current;
			while(runner.next!=null) {
				if(runner.next.data==current.data) {
					runner.next=runner.next.next;
				}else {
					runner=runner.next;
				}
			}
			
			current=current.next;
		}
		
	}
	

	static void removeDupsv3(Node head) {
		
		Node previous=head;
		Node current=previous.next;
		
		while(current!=null) {
			Node runner=head;
			while(runner!=current) {
				if(runner.data==current.data) {
					Node tmp=current.next;
					previous.next=tmp;
					current=tmp;
					break;
				}
				runner=runner.next;
			}
			
			if(current==runner) {
				previous=current;
				current=current.next;
				
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head=new Node(99);
		Node itr=head;
		for(int i=1;i<12;i++) {
			Node nextn=new Node(i%4);
			itr.next=nextn;
			itr=nextn;
		}
		System.out.println(head.printForward());
		
		removeDupsv3(head);
		
		System.out.println(head.printForward());

		/*
		 * Print Iteratively LinkedList
		itr=head;
		while(itr.next!=null) {
			System.out.println(itr.data);
			itr=itr.next;
		}
		*/
	}

}
