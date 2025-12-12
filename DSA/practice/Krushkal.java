package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Krushkal {
	
	
	static int findParent(int parent[],int i) {
		while(parent[i]!=i) {
			i=parent[i];
		}
		return i;
	}
//	
//	static boolean checkCycle(int[][] edges,int[] arr) {
//		
//		for(int i=0;i<edges.length;i++) {
//			
//			if(find(arr,edges[i][0],edges[i][1])) {
//				return true;
//			}
//			else{
//				//union(arr,edges[i][0],edges[i][1]);
//				weightedUnion(arr,edges[i][0],edges[i][1]);
//			}
//			
//		}
//		return  false;
//		
//	}
//	
	
	static void krushkal(Edge[] edges,int n,int e) {
		
		Edge[] output=new Edge[n-1];
		Arrays.sort(edges, new Comparator<Edge>() {

            public int compare(Edge o1, Edge o2) 
            {
            return o1.weight-o2.weight;           
            }
           } );
		
		int count=0;
		int current=0;
		
		int parent[]=new int[n];
		
		for(int i=0;i<parent.length;i++) {
			parent[i]=i;
			
		}
		
		while(count<n-1) {
			
			Edge currentEdge=edges[current];
			int sourceParent=findParent(parent, currentEdge.source);
			int destParent=findParent(parent, currentEdge.dest);
			
			if(sourceParent!=destParent) {
				output[current]=currentEdge;
				parent[sourceParent]=destParent;
				count++;
			}
			current++;
			
			
		}
		
		
		for(int i=0;i<n-1;i++) {
			System.out.println(output[i]);
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int e=sc.nextInt(); 
		
		Edge[] edges=new Edge[e];
		
		for(int i=0;i<e;i++) {
			
			edges[i]=new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
		}
		
		
		krushkal(edges, n,e);
		
		
		
	}
	

}
