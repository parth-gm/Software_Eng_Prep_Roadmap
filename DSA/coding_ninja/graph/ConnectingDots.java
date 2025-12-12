package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConnectingDots {
	static char[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		matrix = new char[n][m];
		
		for(int i=0;i<n;i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		
		boolean isFound = false;
//		boolean[][] visited = new boolean[n][m];
		
		HashMap<Integer, ArrayList<Integer>> visited1 = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(visited1.containsKey(i) && visited1.get(i).contains(j))
					continue;
				
				if(checkCycle(matrix[i][j], i, j, visited1, 0, -1, -1)) {
					isFound = true;
					break;
				}
				
			}
			if(isFound)
				break;
		}
		System.out.println(isFound?1:0);
	}

	private static boolean checkCycle(char ch, int i, int j, 
				HashMap<Integer, ArrayList<Integer>> visited, int count, int pri, int prj) {
		System.out.println(i+","+j);
	
		
		if(matrix[i][j]==ch)
		{
			
			
			if(visited.containsKey(i) && visited.get(i).contains(j))
				return true;
			else {
				ArrayList<Integer> xList = visited.getOrDefault(i, new ArrayList<Integer>());
				xList.add(j);
				visited.put(i, xList);
				
				for(Pair pr: getNighbhours(i, j)) {
					if(pr.x<0 || pr.y<0 || pr.x>=matrix.length || pr.y>=matrix[0].length) {
						continue;
					} 
					if(pr.x==pri && pr.y==prj)
						continue;
					
					boolean ans = checkCycle(ch, pr.x, pr.y, visited, count, i, j);
					if(ans) {
						return true;
					}
				}
			
			}
		}
		
		return false;
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
class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
