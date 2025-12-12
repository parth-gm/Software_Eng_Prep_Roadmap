package coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	
	int noVertex; //No. of Vertex in tree
	ArrayList<Integer> adjList[] ; //Adjecency List
	public Graph(int noVertex) {
		this.noVertex = noVertex;
		this.adjList = new ArrayList[noVertex];
		for(int i=0;i<noVertex;i++) {
			this.adjList[i] = new ArrayList<Integer>();
		}
	}
	
	//Undirected graph - Adding Edges
	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
	}
	
	public ArrayList<Integer>  getNeighbour(int node){
		return this.adjList[node];
	}
	
	//Remove neighbour v from u
	public boolean removeEdge(int u, int v) {
		
		return this.adjList[u].remove((Integer)v);
	
	}
	
	//Find Maximum depth of tree using BFS
	public int getMaxDepth(int source) {
		
		List<Integer> queue = new LinkedList<Integer>(); 
		boolean visited[] = new boolean[this.noVertex]; 
		queue.add(source);
		visited[source] = true;
		
		int[] dist = new int[this.noVertex];
		
		while(!queue.isEmpty()) {
			int node = queue.remove(0);
			for(int cnode: this.adjList[node]) {
				if(!visited[cnode]) {
					
					visited[cnode] = true;
					queue.add(cnode);
					dist[cnode] = dist[node]+1;
				}
			}
		}
		int maxDepth = -1;
		for(int i=0;i<this.noVertex;i++) {
			maxDepth = Math.max(maxDepth, dist[i]);
		}
		
		return maxDepth;
	}
	
	
}
