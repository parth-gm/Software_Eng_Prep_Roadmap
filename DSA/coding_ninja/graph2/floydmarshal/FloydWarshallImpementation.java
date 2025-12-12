package graph2.floydwarshall;

import java.util.Arrays;
import java.util.Scanner;

import graph2.floydwarshall.*;

public class FloydWarshallImpementation {
	final static int MAX_WEIGHT = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			
			int[][] dist = new int[V+1][V+1];
			
			for(int i=0;i<=V;i++) {
				for(int j=0;j<=V;j++) {
					if(i==j)
						dist[i][j] = 0;
					else
						dist[i][j] = MAX_WEIGHT;
				}
				
			}
			
			for(int i=0,j=0;i<=(E-1);i++,j+=2) {
				int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
				dist[u][v] = Math.min(dist[u][v], w);
				dist[v][u] = dist[u][v];
				
                
			}
			
			getMinDistUsingFloydWar(V, dist);
			int queries = sc.nextInt();
			while(queries-->0) {
				System.out.println(dist[sc.nextInt()][sc.nextInt()]);
			}
			
		}

	}

	private static void getMinDistUsingFloydWar(int V, int[][] dist) {
		
//		for(int i=0;i<V+1;i++) {
//		
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		for(int v=1;v<=V;v++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if((dist[i][v]==MAX_WEIGHT || dist[v][j]==MAX_WEIGHT))
						continue;
					if(dist[i][j]>(dist[i][v]+dist[v][j])) {
						dist[i][j] = (dist[i][v]+dist[v][j]);
					}
				}
				
			}
			
		}
		
		
	}

}
