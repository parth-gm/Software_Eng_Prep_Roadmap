package linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergSortLinkedList {

	static void printList(Node start) {
		while(start!=null) {
			System.out.print(start.value+" ");
			start = start.next;
		}
	}
	
	public static void main(String[] args) {
		int k = 4;
		Node[] lists = new Node[k];
		lists[0] = new Node(1);
		lists[0].next = new Node(2);
		lists[0].next.next = new Node(9);
		lists[0].next.next.next = new Node(10);
		
		
		lists[1] = new Node(3);
		lists[1].next = new Node(7);
		
		lists[2] = new Node(5);
		lists[2].next = new Node(6);
		
		lists[3] = new Node(0);
		lists[3].next = new Node(8);
		
//		simpleApproach(lists, k);
		mergeSortedList(lists, k);

	}

	//Traverse Every linked list in O(nk) and form new linkedlist space = O(n)
	static void simpleApproach(Node[] lists, int k) {
	
		
		
		Node[] currentPointers = new Node[k];
		
		for(int i=0;i<k;i++) {
			currentPointers[i] = lists[i];
		}
		
		int firstValue = getNextMinimum(currentPointers, k);
		Node sortedListHead = new Node(-1);
		Node currentListHead = sortedListHead;
		while(firstValue!=Integer.MAX_VALUE) {
			currentListHead.next = new Node(firstValue);
			firstValue = getNextMinimum(currentPointers, k);
			currentListHead = currentListHead.next;
			
		}
		printList(sortedListHead.next);
		
	}

	private static int getNextMinimum(Node[] currentPointers, int k) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0;i<k;i++) {
			if(currentPointers[i]!=null) {
				if(currentPointers[i].value<min) {
					index = i;
					min = currentPointers[i].value;
				}	
			}
		}
		if(index!=-1)
			currentPointers[index] = currentPointers[index].next; 
		return min;
	}
	
	//O(nlogk) Solution using priority queue
	static void mergeSortedList(Node[] lists, int k) {
		
		Node sortedList = new Node(-1);
		Node currentpointer = sortedList;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.value - n2.value;
			}

		});
		
		for(int i=0;i<k;i++) {
			pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()) {
				
			Node removedNode = pq.remove();	
			int nodeValue = removedNode.value;
			currentpointer.next = new Node(nodeValue);
			
			if(removedNode.next!=null) {
				pq.add(removedNode.next);
			}
			currentpointer = currentpointer.next;
			
		}
		
		printList(sortedList.next);
		
	}
	
	
	static void mergeSortedList(ArrayList<Node> a) {
		
		Node sortedList = new Node(-1);
		Node currentpointer = sortedList;
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)-> n1.value-n2.value);
		
		for(int i=0;i<a.size();i++) {
			pq.add(a.get(i));
		}
		
		while(!pq.isEmpty()) {
				
			Node removedNode = pq.remove();	
			int nodeValue = removedNode.value;
			currentpointer.next = new Node(nodeValue);
			
			if(removedNode.next!=null) {
				pq.add(removedNode.next);
			}
			currentpointer = currentpointer.next;
			
		}
		
		printList(sortedList.next);
		
	}
	
}
