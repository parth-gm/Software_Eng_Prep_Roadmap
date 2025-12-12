package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class IsConnected {
	private static void dfsTraversal(int s, int[][] adjMat, boolean[] visited) {
		
		visited[s] = true;
		
		for(int i=0;i<adjMat[0].length;i++) {
			if((i!=s) && adjMat[s][i]==1 && (!visited[i])) {
				dfsTraversal(i, adjMat, visited);
			}
		}
	
	}
	private static boolean isConnected(int[][] adjMat, int v, int source) {
		boolean[] visited = new boolean[v]; 
		dfsTraversal(source, adjMat, visited);
		for(boolean stat:visited) {
			if(!stat)
				return false;
		}
		return true;
		
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
			System.out.println(isConnected(adjMat, v, 0));

		}

	}
}
