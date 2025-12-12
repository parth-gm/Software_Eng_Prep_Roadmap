package graph2;

import java.util.PriorityQueue;
import java.util.Queue;

import graph2.PrimAlgorithm.Pair;

public class TestPriorityQueue {
	
	static class Pair{
		int index, value;
		Pair(int index, int value){
			this.index = index;
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == this) {
				return true;
			}
			System.out.println(obj==this);
			if(obj == null || obj.getClass()!=this.getClass()) {
				return false;
			}
			
			Pair p = (Pair) obj;
			return index == p.index;
			
			
			
		}
		
		@Override
		public int hashCode() {
			return index;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return index+","+value;
		}
		
	}
	
	public static void main(String[] args) {
		
		Queue<Pair> pq = new PriorityQueueDistinct<Pair>(
				(a,b)->a.value - b.value);
		pq.add(new Pair(1,1));
		pq.add(new Pair(2,2));
		System.out.println(pq);
		pq.add(new Pair(1,2));
		pq.remove(1);
		System.out.println(pq);
		
	}
}
