package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
static boolean bfsTraversal(int source, int[][] adjMat, boolean[] visited, int dest) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(!queue.isEmpty()) {
			
			int currentNode = queue.remove();
//			System.out.print(currentNode+" ");
			
			for(int i=0;i<adjMat[0].length;i++)
			{
				if(currentNode==dest)
					return true;
				if((currentNode!=i) && (!visited[i]) && adjMat[currentNode][i]==1) {
					queue.add(i);
					visited[i] = true;
				}
				
				
			}
			
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			int[][] adjMat = new int[v][v];
			
			for(int i=0;i<e;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adjMat[a][b] = 1;
				adjMat[b][a] = 1;
			}
			int tu = sc.nextInt();
			int tv = sc.nextInt();
			System.out.println(checkHasPathDFS(adjMat, v, tu, tv));
			System.out.println(checkHasPathBFS(adjMat, v, tu, tv));

		}
			
		
//		System.out.println();
//		printBFS(adjMat, v);
		
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

	private static boolean checkHasPathDFS(int[][] adjMat, int v, int tu, int tv) {
		boolean[] visited = new boolean[v]; 
		return dfsTraversal(tu, adjMat, visited, tv);
		
	
	}

	private static boolean checkHasPathBFS(int[][] adjMat, int v, int tu, int tv) {
		boolean[] visited = new boolean[v]; 
		return bfsTraversal(tu, adjMat, visited, tv);
		
		
	}


	private static boolean dfsTraversal(int s, int[][] adjMat, boolean[] visited, int dest) {
		
		if(s==dest) 
			return true;
		
		visited[s] = true;
		
		for(int i=0;i<adjMat[0].length;i++) {
			if((i!=s) && adjMat[s][i]==1 && (!visited[i])) {
				boolean ans =  dfsTraversal(i, adjMat, visited, dest);
				if(ans)
					return ans;
			}
		}
		return false;
	}
}
