package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleOf3 {
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()+1;
		int m = sc.nextInt();
		
		
		adjList = new ArrayList[n];
		
		for(int i=1;i<n;i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int[][] edges = new int[2][m];
		
		for(int i=0;i<m;i++) {
			edges[0][i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			edges[1][i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			if(edges[0][i] == edges[1][i])
				continue;
			adjList[edges[0][i]].add(edges[1][i]);
			adjList[edges[1][i]].add(edges[0][i]);
		}
		
		System.out.println(getNoof3Cycles(n, m));
		

	}
	private static int getNoof3Cycles(int n, int m) {
		int count=0;
		
		for(int i=1;i<n;i++) {
			for(int nb:adjList[i]) {
				for(int ib:adjList[nb]) {
					if(adjList[ib].contains(i)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
		return (count/6);
	}

}
