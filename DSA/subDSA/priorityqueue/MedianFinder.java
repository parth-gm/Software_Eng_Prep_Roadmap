package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

//	ArrayList<Integer> streamOfData;	
	PriorityQueue<Integer> minHeap ;
	PriorityQueue<Integer> maxHeap ;
	
	public MedianFinder(){
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	}
	
	public void addNum(int num) {
		minHeap.add(num);
		if(minHeap.size()!=maxHeap.size())
			maxHeap.add(minHeap.poll());
		
	}
	
	
	public double findMedian() {
		
		int totalSize = minHeap.size() + maxHeap.size();
		if((totalSize&1)==1)
			return minHeap.poll();
		else
			return (double)(minHeap.poll() + maxHeap.poll())/2;
	}
	
	public static void main(String[] args) {
		
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		double param_2 = obj.findMedian();
		System.out.print(param_2);
		 
	}

}
