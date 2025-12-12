package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LargestPiece {
	static char[][] matrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			
			matrix = new char[n][n];
			
			for(int i=0;i<n;i++) {
				matrix[i] = sc.next().toCharArray();
			}
			
			boolean isFound = false;
			HashMap<Integer, ArrayList<Integer>> visited1 = new HashMap<>();
			
			int max = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					if(visited1.containsKey(i) && visited1.get(i).contains(j))
						continue;
					if(matrix[i][j] == '1')
						max = Math.max(max, getLargestLength(i, j, visited1, -1, -1)); 
					
				}
			}
			System.out.println(max);
		}
	}
	private static int getLargestLength(int i, int j, HashMap<Integer, ArrayList<Integer>> visited,
				int prvi, int prvj) 
	{
		
		if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length) {
			return 0;
		}
		
		if(matrix[i][j]!='1' || (visited.containsKey(i) &&  visited.get(i).contains((Integer)j)))
			return 0;
		
		
		int ans = 1;
		ArrayList<Integer> xList = visited.getOrDefault(i, new ArrayList<Integer>());
		xList.add(j);
		visited.put(i, xList);
		
		for(Pair pr: getNighbhours(i, j)) {
			
			if(pr.x==prvi && pr.y==prvj)
				continue;
			
			ans = ans+getLargestLength(pr.x, pr.y, visited, i, j);
			
		}
		
		return ans;
	}
	private static ArrayList<Pair> getNighbhours(int i, int j) {
		
		ArrayList<Pair> nbrs = new ArrayList<>();
		nbrs.add(new Pair(i+1, j));
		nbrs.add(new Pair(i, j+1));
		nbrs.add(new Pair(i-1, j));
		nbrs.add(new Pair(i, j-1));
		
		
		return nbrs;
	}
}

