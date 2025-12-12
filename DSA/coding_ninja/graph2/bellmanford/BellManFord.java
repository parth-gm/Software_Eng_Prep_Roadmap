package graph2.bell;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class BellManFord {
	final static int MAX_WEIGHT = 1000000000;
	static void getMinDistUsingBellMan(int V, Edge[] edges, int src, int dest)
	{
		
		int[] dist = new int[V+1];
		for(int i=1;i<=V;i++) {
			dist[i] = MAX_WEIGHT;
		}
		dist[src] = 0;
//		System.out.println(Arrays.toString(edges));
		
		//Relax V-1 times to get single source shortest dist
		//At Vth time relaxing if dist get reduced then there is -ve cycle
		for(int i=0;i<V-1;i++) {
			for(Edge edge: edges) {
				
				//To Avoid Overflow of Weight
				if(dist[edge.u]==MAX_WEIGHT)
					continue;
				
				//Relax the vertex v
				if((dist[edge.u] + edge.weight)<dist[edge.v]) {
					dist[edge.v] = dist[edge.u] + edge.weight;
				}
				
			}
			
		}
		System.out.println(dist[dest]);
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int src = sc.nextInt();
			int dest = sc.nextInt();
			
			Edge[] edges = new Edge[E];
			
			for(int i=0;i<E;i++) {
				
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			getMinDistUsingBellMan(V, edges, src, dest);
			
			
		}
		
	}
	
}
