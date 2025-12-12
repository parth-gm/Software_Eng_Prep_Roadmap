package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int n = sc.nextInt();
			System.out.println(getMinimumCount(n));
			
		}

	}

	private static int getMinimumCount(int n) {
		int limit = (int)Math.sqrt(n);
		int[][] dp = new int[limit+1][n+1];
		
		for(int i=1;i<=n;i++) {
			dp[1][i] = i;
		}
		//System.out.println(Arrays.toString(dp[1]));
		for(int i=2;i<=limit;i++) {
			
			for(int j=1;j<=n;j++) {
				
				if(j<(i*i)) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				int countRequired = j/(i*i);
				dp[i][j] = Math.min(dp[i][j-(countRequired*i*i)] + countRequired, dp[i-1][j]); 
				
				
			}
			//System.out.println(Arrays.toString(dp[i]));
			
		}
		
		return dp[limit][n];
		
		
	}

}




