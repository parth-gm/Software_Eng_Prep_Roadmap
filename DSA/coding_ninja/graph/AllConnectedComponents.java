package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AllConnectedComponents {
private static void dfsTraversal(int s, ArrayList<Integer>[] adjList, boolean[] visited, ArrayList<Integer> path) {
		
		visited[s] = true;
		
		for(int nb: adjList[s]) {
			if(!visited[nb]) {
				path.add(nb);
				dfsTraversal(nb, adjList, visited, path);
			}
		}
			
	
	}
	private static void getConnectedComponents(ArrayList<Integer>[] adjList , int v) {
		boolean[] visited = new boolean[v]; 
		ArrayList<Integer> path = new ArrayList<>();
		for(int i=1;i<v;i++) {
			if(!visited[i]) {
				
				path.add(i);
				if(adjList[i]!=null)
					dfsTraversal(i, adjList, visited, path);
				Collections.sort(path);
				for(int n:path) {
					System.out.print(n+" ");
				}
				System.out.println();
				path.clear();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			
			int v = sc.nextInt()+1;
			int e = sc.nextInt();
			
			int[][] adjMat = new int[v][v];
			ArrayList<Integer>[] adjList = new ArrayList[v];
			
			for(int i=0;i<e;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(adjList[a]==null) {
					adjList[a] = new ArrayList<>();
				}
				if(adjList[b]==null) {
					adjList[b] = new ArrayList<>();
					
				}
				adjList[a].add(b);
				adjList[b].add(a);
				

			}
//			for(int[] row:adjMat) {
//				System.out.println(Arrays.toString(row));
//			}
			getConnectedComponents(adjList, v);

		}

	}

}
