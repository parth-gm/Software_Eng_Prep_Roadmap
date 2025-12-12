package Ch02_LinkedLists;

public class Partition {

	
	static Node makePartition(Node head,int x){
		
		Node smallerListStart = null,largerListStart=null,smallerListEnd=null,largerListCurrent=null;
		Node originalCurrent=head;
		
		if(originalCurrent==null) return null;
		
		while(originalCurrent!=null) {
			if(originalCurrent.data<x) {
				if(smallerListStart==null) {
					smallerListStart=originalCurrent;
					smallerListEnd=originalCurrent;
				}else {
					smallerListEnd.next=originalCurrent;
					smallerListEnd=originalCurrent;
				}
			}else {
				if(largerListStart==null) {
					largerListStart=originalCurrent;
					largerListCurrent=originalCurrent;
				}else {
					largerListCurrent.next=originalCurrent;
					largerListCurrent=originalCurrent;
				}
			}
			originalCurrent=originalCurrent.next;
		}
		smallerListEnd.next=largerListStart;
		
		return smallerListStart;
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val={33,9,2,3,10,10389,838,874578,5};
		Node head=new Node(val[0]);
		Node prev=head;
		for(int i=1;i<val.length;i++) {
			Node cur=new Node(val[i]);
			prev.setNext(cur);
			prev=cur;
		}
		
		System.out.println(head.printForward());
		
		Node newhead=makePartition(head, 3);
		
		System.out.println(newhead.printForward());
		
		

	}

}
