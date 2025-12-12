	package graph2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			Edge[] edges = new Edge[E];
			
			for(int i=0;i<E;i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(edges, new Comparator<Edge>() {
				public int compare(Edge e1, Edge e2) {
					return e1.weight - e2.weight;
				}
			});
		
		System.out.println(getMinimumSpanningTreeWeight(edges, V));
		}
	}

	private static int getMinimumSpanningTreeWeight(Edge[] edges, int V) {
		
		int count=0;
		int weight = 0;
		int pointer = 0;
		int[] parent = new int[V];
		int[] rank = new int[V];
		for(int i=0;i<V;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		while(count<(V-1)) {
			
			if(possibleToFormEdge(edges[pointer].u, edges[pointer].v, parent, rank)) {
				
				weight+=edges[pointer].weight;
				count++;
			}
			pointer++;
		
		}
		return weight;
	}

	private static boolean possibleToFormEdge(int u, int v, int[] parent, int[] rank) {
		int parentU = findParent(u, parent);
		int parentV = findParent(v, parent);
		
		if (parentV != parentU) {
			if(rank[parentU]<=rank[parentV])
			{
				parent[parentU] = parentV;
			}else {
				parent[parentV] = parentU;
			}
			return true ;
		}
		return false;
	}
	
	static int findParent(int node, int[] parent) {
		if(parent[node]==node)
			return node;
		parent[node] = findParent(parent[node], parent);
		return 	parent[node];		
		
	}
	
	
}
