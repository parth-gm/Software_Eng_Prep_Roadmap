package graph;

import java.util.*;

public class Graph {

	int V;
//	HashMap<Integer, ArrayList<Integer>> adjList;
	ArrayList<Integer> adjList[];
	Graph(int v){
		this.V = v;
//		adjList = new HashMap<>();
		this.adjList = new ArrayList[v];
		for(int i=0;i<v;i++) {
			adjList[i] =new ArrayList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		this.adjList[u].add(v);
		this.adjList[v].add(u);
//		ArrayList<Integer> arrU = adjList.getOrDefault(u, new ArrayList<Integer>());
//		arrU.add(v);
//		adjList.put(u, arrU); 
//		
//		ArrayList<Integer> arrV = adjList.getOrDefault(v, new ArrayList<Integer>());
//		arrV.add(u);
//		adjList.put(v, arrV);

	}
	
	void bfs(int source, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			
			int currentNode = queue.remove();
			System.out.print(currentNode+" ");
			
			for(int nb: adjList[currentNode]) {
				if(!visited[nb]){
					queue.add(nb);
					visited[nb] = true;
				}
			}
		
		
		}
		
	}
	
}
