package Ch02_LinkedLists;

public class Intersection {

	
	static Node LinearTime(Node head1,Node head2) {
		
		if(head1==null || head2==null) return null;
		
		int length1=head1.lenFromNode();
		int length2=head2.lenFromNode();
		//System.out.println(length1+" "+length2);
		
//		boolean isIntersectionPoint=checkIntersection();
		
		Node longerListHead=null, shorterListHead=null;
		
		if(length1>length2) { shorterListHead=head2; longerListHead=head1;}
		else  {shorterListHead=head1; longerListHead=head2;}
		
		int countToList2=Math.abs(length1-length2);
		
		while(countToList2-->0) {
			longerListHead=longerListHead.next;
		}
		
		while(longerListHead!=shorterListHead)
		{
			longerListHead=longerListHead.next;
			shorterListHead=shorterListHead.next;
		}
		
		return longerListHead;
	}
	
	
	static Node createLinkedeListFromArray(int[] vals) {
		
		Node head=new Node(vals[0]);
		Node curhead=head;
		for(int i=1;i<vals.length;i++) {
			
			curhead.next=new Node(vals[i]);
			curhead=curhead.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		Node head1=createLinkedeListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		Node head2=createLinkedeListFromArray(vals2);
		
		System.out.println(" List1 "+ head1.printForward());
		System.out.println(" List2 "+head2.printForward());
		
		//head2.next.next = head1.next.next.next.next;
		head2=head1;
		System.out.println(" Intersected List2 "+head2.printForward());
	
		Node intersectedNode=LinearTime(head1,head2);
		if(intersectedNode!=null) {
			System.out.println("Intersected Node Data: "+intersectedNode.data);
			System.out.println(intersectedNode.printForward());
		}
		else
			System.out.println("No intersection point found");
		
	}	

}
