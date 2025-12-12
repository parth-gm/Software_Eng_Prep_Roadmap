package Ch02_LinkedLists;

public class SumList {

	static Node addReverseTwoList(Node n1,Node m1,SeparateSum ss) {
		
		if(n1.next==null && m1.next==null) {
			Node cur=new Node((n1.data+m1.data)%10);
			ss.sumnode=cur;
			ss.carry=(n1.data+m1.data)/10;
			return ss.sumnode;
		}
		Node cur=addReverseTwoList(n1.next, m1.next,ss);
		int sum=(n1.data+m1.data+ss.carry);
		//System.out.println("Sum"+sum);
		ss.sumnode=new Node(sum%10,ss.sumnode);
		
		ss.carry=sum/10;
		//System.out.println("Carry"+ss.carry);
		return ss.sumnode;
	}
	
	static Node addTwoList(Node n1,Node m1) {
		
		Node sumhead,sumcur=null,prev;
		int carry=0;
		if(n1==null && m1==null) return null;
		int sum=(n1.data+m1.data);
		sumhead=new Node(sum%10);
		prev=sumhead;
		
		carry=sum/10;
		n1=n1.next;
		m1=m1.next;
		//Assuming length are equal for both list
		while(n1!=null && m1!=null) {
			
			sum=n1.data+m1.data+carry;
			carry=sum/10;
			
			sumcur=new Node(sum%10);
			prev.next=sumcur;
			prev=sumcur;
			
			n1=n1.next;
			m1=m1.next;
		}
		System.out.println("Carry"+carry);
		if(carry!=0)
			sumcur.next= new Node(carry);
		
		
		return sumhead;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n4=new Node(9);
		Node n3=new Node(9,n4);
		Node n2=new Node(9,n3);
		Node n1=new Node(9,n2);
		
		System.out.println(n1.printForward());
		
		Node m4=new Node(1);
		Node m3=new Node(0,m4);
		Node m2=new Node(0,m3);
		Node m1=new Node(0,m2);
		
		System.out.println(m1.printForward());
		
		Node sumList=addTwoList(n1,m1);
		
		System.out.println(sumList.printForward());
		
		System.out.println("Add In Reverse");
		Node head=null;
		SeparateSum ss=new SeparateSum();;
		Node sumReverseList=addReverseTwoList(n1,m1,ss);
		if(ss.carry!=0) head=new Node(ss.carry,sumReverseList); 
		System.out.println(head.printForward());

	}

}
