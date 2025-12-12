package gfg;

import java.util.Arrays;
import java.util.HashMap;

public class OptimizeLRUCache {

	
	Node head;
	Node tail;
	int capacity;
	HashMap<Integer,Node> hm;
	int curSize=0;
	public OptimizeLRUCache(int capacity) {
		this.capacity=capacity;
		hm=new HashMap<Integer, OptimizeLRUCache.Node>();
//		head=new Node();
//		tail=new Node();
	}
	
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node(int key,int value) {
			this.key=key;
			this.value=value;
			this.next=null;
			this.prev=null;
		}
	}
	public int get(int key) {
		
		if(hm.containsKey(key)) {
			Node nodeAdd=hm.get(key);
			
			if(nodeAdd!=tail) {
				if(nodeAdd.prev!=null)
					nodeAdd.prev.next=nodeAdd.next;
				else{
					if(head.next!=null) {
						head=head.next;
					
					}
				}
				
				if(nodeAdd.next!=null)
					nodeAdd.next.prev=nodeAdd.prev;
				
				nodeAdd.next=null;
				tail.next=nodeAdd;
				nodeAdd.prev=tail;
				tail=nodeAdd;
			}			
			return nodeAdd.value;
		}else {
			return -1;
		}
		
	}
	
	public void put(int key, int value) {
		if(!hm.containsKey(key)) {
			Node newNode=new Node(key,value);
			hm.put(key, newNode);
			if(curSize==0) {
				head=newNode;
				tail=newNode;
				curSize++;
			}else{
				
				if(curSize==capacity) {
					hm.remove(head.key);
					if(head.next!=null) {
						head=head.next;
						head.prev.next=null;
						head.prev=null;
					}else {
						//only for capacity =1
						head=newNode;
						tail=newNode;
						return;
					}	
					
				}else {
					curSize++;
				}
				
				newNode.prev=tail;
				tail.next=newNode;
				tail=newNode;
			}
			
		}else {
			Node keyNode=hm.get(key);
			keyNode.value=value;
			this.get(key);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimizeLRUCache lruc=new OptimizeLRUCache(1);
		lruc.put(2, 1);
//		lruc.put(2, 2);
//		lruc.put(3, 3);
//		lruc.put(4, 4);
		System.out.println(""+lruc.get(2));
		OptimizeLRUCache.Node hd=lruc.head;
		while(hd!=null) {
			System.out.print(hd.key+"->");
			hd=hd.next;
		}
		
		lruc.put(3, 2)
		;
		System.out.println(lruc.get(2));
	
		
		System.out.println(lruc.get(3));
		
//		
//		System.out.println(lruc.get(1));
//		
//		
//		lruc.put(5, 5);
//		System.out.println();
//		System.out.println(""+lruc.get(1)+lruc.get(2));
//		System.out.println(lruc.get(5));
	}

}
