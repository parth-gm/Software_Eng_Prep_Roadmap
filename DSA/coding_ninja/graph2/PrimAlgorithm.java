package graph2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrimAlgorithm {

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
			
			if(obj == null || obj.getClass()!=this.getClass()) {
				return false;
			}
			
			Pair p = (Pair) obj;
			return index == p.index;
	
		}
		
		@Override
		public int hashCode() {
			int result = 1;
			result = 31*result + index +value;
			return result;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return index+","+value;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<EdgeNew>[] adjList = new ArrayList[V];
			for(int i=0;i<V;i++) {
				adjList[i] = new ArrayList<EdgeNew>();
			}
			
			for(int i=0;i<E;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int weight = sc.nextInt();
				adjList[u].add(new EdgeNew(v, weight));
				adjList[v].add(new EdgeNew(u, weight));
			}
					
			System.out.println(getMinimumSpanningTreeWeight(adjList, V));
		}
		

	}

	private static int getMinimumSpanningTreeWeight(ArrayList<EdgeNew>[] adjList, int v) {
		int[] parent = new int[v];
		int[] weight = new int[v];
//		int[] visited = new int[v];
		
		//Keep Track of visited vertexes
		HashSet<Integer> visitedSet = new HashSet<>();
		
		//Initialize parent and weight 
		for(int i=0;i<v;i++) {
			parent[i] = -1;
			weight[i] = Integer.MAX_VALUE;
			
		}
		
		//Starting from source vertex
		weight[0] = 0;  
		Queue<Pair> pq = new PriorityQueueDistinct<Pair>(
				(a,b)->a.value - b.value);
		pq.add(new Pair(0,0));
		while(visitedSet.size()<v) {
			
			//Get Vertex With min weight which is not visited
//			int minVidx = getVertexWithMinWeight(weight, visitedSet);
			
			Pair minPair = pq.remove();
			
			//Traverse edges from from min weight vertex and update weight and parent of its neighbour 
			for(EdgeNew edge : adjList[minPair.index]) 
			{
				if((!visitedSet.contains(edge.dest)) && weight[edge.dest]>edge.weight) {
					weight[edge.dest] = edge.weight;
					parent[edge.dest] = minPair.index;
					
					pq.add(new Pair(edge.dest, edge.weight));
					
				}
				
			}
			

//			for(EdgeNew edge : adjList[minVidx]) 
//			{
//				if((!visitedSet.contains(edge.dest)) && weight[edge.dest]>edge.weight) {
//					weight[edge.dest] = edge.weight;
//					parent[edge.dest] = minVidx;
//					
//					pq.add(new Pair(edge.dest, edge.weight));
//					
//				}
//				
//			}
			//Mark vertex as visited
			
			visitedSet.add(minPair.index);
		}
		int sum=0;
		for(int i=0;i<v;i++) {
			sum+=weight[i];
		}

		return sum;
	}

	private static int getVertexWithMinWeight(int[] weight, HashSet<Integer> isVisitedSet) {
		int min = Integer.MAX_VALUE, vidx = -1;
		for(int i=0;i<weight.length;i++) {
			if(isVisitedSet.contains(i)) {
				continue;
			}
			if(weight[i]<min) {
				min = weight[i];
				vidx = i;
			}
		}
		return vidx;
		
	}

}
