package dp;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPathExists {

	static boolean dfs(char[][] mat, int i, int j) {
		
		if((mat.length-1)==i && (mat[0].length-1)==j) {
			return true;
		}
		
		if(i<0 || i>= (mat.length) || j<0 || j>=(mat[0].length) || mat[i][j]=='#') {
			return false;
		}
		mat[i][j] = '#';																
		System.out.println(i+","+j);
		if(dfs(mat, i+1, j) || dfs(mat, i, j+1)){
			return true;
		}
		return false;	
	}
	
	static boolean dpApproach(char[][] mat, int k) {
		
		int[][] dp = new int[mat.length][mat[0].length];
		dp[0][0] = 0;
//		for(int i=1;i<mat.length;i++) {
//			if(mat[i][0]=='.') {
//				dp[i][0] = dp[i-1][0]+1;
//			}else {
//				dp[i][0] = Integer.MAX_VALUE;
//			}
//		}
//		
//		for(int i=1;i<mat[0].length;i++) {
//			if(mat[0][i]=='.') {
//				dp[0][i] = dp[0][i-1]+1;
//			}else {
//				dp[0][i] = Integer.MAX_VALUE;
//			}
//		}
		
		for(int i=mat.length-1;i>=0;i--) {
			for(int j=mat[0].length-1;j>=0;j--) {
				
				if(mat[i][j]=='.') {
					int minDist = Math.min(dp[i][j-1], dp[i-1][j]);
					if(minDist!=Integer.MAX_VALUE)
					{
						dp[i][j] = minDist+1;
					}else {
						dp[i][j] = Integer.MAX_VALUE;
					}
					
				}else {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
		}
		System.out.println(dp[mat.length-1][mat[0].length-1]);
		
		for(int i=0;i<mat.length;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		if(dp[mat.length-1][mat[0].length-1]<=k) {
			return true;
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
		char[][] mat = new char[6][8];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<6;i++) {
			mat[i] = sc.next().toCharArray();
		
		}
		
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		System.out.println(dfs(mat, 0, 0));
		System.out.println(dpApproach(mat, 13));
		
	}

}
