package dp2;

import java.util.Scanner;

public class MiserMan {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] fares = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					fares[i][j] = sc.nextInt();
				}
			}
			
			//System.out.println(mm_rec(fares, n, m));
			System.out.println(mm_itr(fares, n, m));
		}

	}

	private static long mm_itr(int[][] fares, int n, int m) {
		
		long[][] dp = new long[n][m];
		
		for(int i=0;i<m;i++) {
			dp[0][i] = fares[0][i];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				long o1 = Integer.MAX_VALUE, o2 = Integer.MAX_VALUE;
				if(j-1>=0)
					o1 = dp[i-1][j-1];
				if(j+1<m)
					o2 = dp[i-1][j+1];

				dp[i][j] = fares[i][j] + Math.min(dp[i-1][j], Math.min(o1, o2));
				
			}
		}
		
		long minAns = dp[n-1][0];
		for(int i=1;i<m;i++) {
			minAns = Math.min(minAns, dp[n-1][i]);
		}
		
		return minAns;
	}

	private static long mm_rec(int[][] fares, int n, int m) {
		
		long min = Integer.MAX_VALUE;
		for(int j=0;j<m;j++) {
			long ans = mm_rec_helper(fares, 0, j, n, m);
			
			min = Math.min(min, ans);
		}
		return min;
	}

	private static long mm_rec_helper(int[][] fares, int i, int j, int n, int m) {
		
		if(i==(n-1) && j>=0 && j<m)
			return fares[i][j];
		
		if(i>=n || j<0 || j>=m)
			return Integer.MAX_VALUE;
		
		long o1 = mm_rec_helper(fares, i+1, j+1, n, m) +fares[i][j] ;
		long o2 = mm_rec_helper(fares, i+1, j-1, n, m) + fares[i][j];
		long o3 = mm_rec_helper(fares, i+1, j, n, m) + fares[i][j];
		long ans = Math.min(o1, Math.min(o2, o3));
	
		return ans;
	}

}
