package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MakeCodingNinja {
	
	static char[][] matrix;
	static String toForm = "CODINGNINJA";
	
	static boolean checkString(int currentPointer, 
				int x, int y,  HashMap<Integer, ArrayList<Integer>>  visited) {
		System.out.println(x+","+y);
		
		if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length) {
			System.out.println("false:"+x+","+y);
			return false;
		}
		if(visited.containsKey(x) && visited.get(x).contains(y)) {
			System.out.println("false:"+x+","+y);
			return false;
		}
		
		if(toForm.charAt(currentPointer) == matrix[x][y]) {
			
			if(currentPointer==(toForm.length()-1))
				return true;
			
			ArrayList<Integer> xList = visited.getOrDefault(x, new ArrayList<Integer>());
			xList.add(y);
			visited.put(x, xList);
			
			int[] factors = {0, 1, -1};
			for(int i=0;i<factors.length;i++) {
				for(int j=0;j<factors.length;j++){
					if(factors[i]==0 && factors[j]==0)
						continue;
					int nextX = x+factors[i];
					int nextY = y+factors[j];
					
					
					boolean ans = checkString(currentPointer+1, nextX, nextY, visited);
					if(ans) {
						return true;
					}
					
				}
			
			}
			visited.get(x).remove((Integer)y);
			
		}
		System.out.println("false:"+x+","+y);
		return false;
	}
		
	static boolean checkStringV2(int currentPointer, 
			int x, int y,  boolean[][]  visited) {
	
	if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length) {
		System.out.println("false:"+x+","+y);
		return false;
	}
	
	if(toForm.charAt(currentPointer) == matrix[x][y] && (!visited[x][y])) {
		
		if(currentPointer==(toForm.length()-1))
			return true;
		visited[x][y] = true;
		int[] factors = {0, 1, -1};
		for(int i=0;i<factors.length;i++) {
			for(int j=0;j<factors.length;j++){
				if(factors[i]==0 && factors[j]==0)
					continue;
				int nextX = x+factors[i];
				int nextY = y+factors[j];
								
				boolean ans = checkStringV2(currentPointer+1, nextX, nextY, visited);
				if(ans) {
					return true;
				}
				
			}
		
		}
		visited[x][y] = false;
		
	}
	System.out.println("false:"+x+","+y);
	return false;
}
		
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			matrix = new char[n][m];
			
			for(int i=0;i<n;i++) {
				matrix[i] = sc.next().toCharArray();
//				System.out.println(Arrays.toString(area[i]));
			}
			
			
			boolean isFound = false;
			boolean[][] visited = new boolean[n][m];
			
			HashMap<Integer, ArrayList<Integer>> visited1 = new HashMap<>();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					
					if(checkString(0, i, j, visited1)) {
						isFound = true;
						break;
					}
					
				}
				if(isFound)
					break;
			}
			System.out.println(isFound?1:0);
			
		}
	}
		
}


