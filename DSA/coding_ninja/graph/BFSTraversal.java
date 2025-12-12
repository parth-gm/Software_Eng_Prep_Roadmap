package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversal {
	static void bfsTraversal(int source, int[][] adjMat, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			
			int currentNode = queue.remove();
			System.out.print(currentNode+" ");
			
			for(int i=0;i<adjMat[0].length;i++)
			{
				if((currentNode!=i) && (!visited[i]) && adjMat[currentNode][i]==1) {
					queue.add(i);
					visited[i] = true;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		int[][] adjMat = new int[v][v];
		
		for(int i=0;i<e;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adjMat[a][b] = 1;
			adjMat[b][a] = 1;
		}
		
		printDFS(adjMat, v);
		System.out.println();
		printBFS(adjMat, v);
		
		/*
		 * For AdjList From Graph Class
		 * 
		Graph graph = new Graph(v);
		for(int i=0;i<e;i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		boolean[] visited = new boolean[v]; 
		for(int i=0;i<v;i++)
		{
			if(!visited[i]) {
				graph.bfs(i, visited);
			}
		}
		*/
	}

	private static void printBFS(int[][] adjMat, int v) {
		boolean[] visited = new boolean[v]; 
		for(int i=0;i<v;i++)
		{
			if(!visited[i]) {
				bfsTraversal(i, adjMat, visited);
			}
		}
		
	}

	private static void printDFS(int[][] adjMat, int v) {
		boolean[] visited = new boolean[v]; 
		for(int i=0;i<v;i++)
		{
			if(!visited[i]) {
				dfsTraversal(i, adjMat, visited);
			}
		}
		
	}

	private static void dfsTraversal(int s, int[][] adjMat, boolean[] visited) {
		
		visited[s] = true;
		System.out.print(s+" ");
		for(int i=0;i<adjMat[0].length;i++) {
			if((i!=s) && adjMat[s][i]==1 && (!visited[i])) {
				dfsTraversal(i, adjMat, visited);
			}
		}
		
	}
}
