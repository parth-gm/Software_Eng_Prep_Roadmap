package Ch02_LinkedLists;

public class Node {
	Node next=null;
	int data;
	
	public Node(int data) {
		this.data=data;
	}
	
	public Node(int data,Node n) {
		this.data=data;
		this.next=n;
	}
	
	public void setNext(Node n) {
		this.next=n;
	}
	
	void appendToTail(int d) {
		Node end =new Node(d);
		Node n=this;
		while(n.next!=null)n=n.next;
		n.next=end;
	}
	public String printForward() {
	
		if(this.next!=null)
			return this.data+"-->"+this.next.printForward();
		else
			return ((Integer)this.data).toString();
		
	}
	
	public int lenFromNode() {
		int count=0;
		Node cur=this;
		while(cur!=null) {
			cur=cur.next;
			count++;
		}
		return count;
	}
	
	public int findKthNode(int k) {
		Node cur=this;
		int count=0;
		if(k>this.lenFromNode() && k<=0) return -1;
		while(cur!=null) {
			if(count==(k-1))
				return cur.data;
			count++;
			cur=cur.next;
			
		}
		return -1;
	}
	
}
