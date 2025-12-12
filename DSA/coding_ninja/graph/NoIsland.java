package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class NoIsland {
private static void dfsTraversal(int s, int[][] adjMat, boolean[] visited) {
		
		visited[s] = true;
		
		for(int i=0;i<adjMat[0].length;i++) {
			
			if((i!=s) && adjMat[s][i]==1 && (!visited[i])) {
				dfsTraversal(i, adjMat, visited);
			}
		}
	
	}
	private static int  getConnectedComponents(int[][] adjMat, int v) {
		boolean[] visited = new boolean[v]; 
		int count = 0;
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				
				dfsTraversal(i, adjMat, visited);
				count++;
			}
		}
		return count;
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
//			for(int[] row:adjMat) {
//				System.out.println(Arrays.toString(row));
//			}
			System.out.println(getConnectedComponents(adjMat, v));

		}

	}

}
