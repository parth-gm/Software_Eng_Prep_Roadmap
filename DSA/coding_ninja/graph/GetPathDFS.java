package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathDFS {
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
			
			getPathBFS(adjMat, v, tu, tv);
	
		}
	}

	private static void getPathDFS(int[][] adjMat, int v, int tu, int tv) {
		boolean[] visited = new boolean[v]; 
		ArrayList<Integer> paths = new ArrayList<>();
		if (dfsTraversal(tu, adjMat, visited, tv, paths)) {
			paths.add(tu);
			for(int a: paths) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
	
	private static void getPathBFS(int[][] adjMat, int v, int tu, int tv) {
		
		ArrayList<Integer> paths = new ArrayList<>();
		boolean[] visited = new boolean[v]; 
		int[] parent = new int[v];
		if (bfsTraversal(tu, adjMat, tv, paths, parent, visited)) {
			int i=tv;
			while(i!=-1) {
				System.out.print(i+ " ");
				i = parent[i];
			}
		}
	}
	
	private static boolean bfsTraversal(int s, int[][] adjMat, int dest, ArrayList<Integer> paths, int[] parent, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		parent[s] = -1;
		visited[s] = true;
		while(!queue.isEmpty()) {
			
			int currentNode = queue.remove();
			
			for(int i=0;i<adjMat[0].length;i++) {
				if(adjMat[currentNode][i]==1 && (!visited[i]) && (i!=currentNode)) {
					
					parent[i] = currentNode;
					queue.add(i);
					visited[i] = true;
					if(i== dest)
						return true;
				}
				
			}
			
		}
		return false;
		
	}

	
	private static boolean dfsTraversal(int s, int[][] adjMat, boolean[] visited, int dest, ArrayList<Integer> paths) {
		
		if(s==dest) 
			return true;
		
		visited[s] = true;
		
		for(int i=0;i<adjMat[0].length;i++) {
			if((i!=s) && adjMat[s][i]==1 && (!visited[i])) {
				boolean ans =  dfsTraversal(i, adjMat, visited, dest, paths);
				if(ans) {
					paths.add(i);
					return ans;
				}
			}
		}
		return false;
	}
	
}
