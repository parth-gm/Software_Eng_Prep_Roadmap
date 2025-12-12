package dp_bit_mask;

import java.util.Arrays;


public class MinCost {

	
	
	public static void main(String[] args) {
		
		int n=4;
		int[][] cost = {{10, 2, 6, 5},{1, 15, 12, 8},{7, 8, 9, 3},{15, 13, 4, 10}};
		int[] dp = new int[1<<n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println(getMinCost(cost, n, 0, 0, dp));
		

	}

	private static int getMinCost(int[][] cost, int n, int p, int mask, int[] dp) {
		
		if(p>=n) {
			return 0;
		}
		
		if(dp[mask]!=Integer.MAX_VALUE)
			return dp[mask];
		
		int minimum = Integer.MAX_VALUE;
		for(int j=0;j<n;j++) {
			
			if((mask&(1<<j))==0)
			{
				int ans = getMinCost(cost, n, p+1, mask|(1<<j), dp) + cost[p][j];
				if(ans<minimum)
					minimum = ans;
				
			}
			
		}
		dp[mask] = minimum;
		return minimum;
	}
	
//	private static int getMinCost_itr(int[][] cost, int n) {
//		
//		int[] dp = new int[1<<n];
//		for(int i=0;i<(1<<n);i++) {
//			dp[i] = Integer.MAX_VALUE;
//		}
//		
//		dp[0] = 0;
//			
//		for(int mask=0;mask<((1<<n)-1);mask++) {
//			
//			
//			
//		}
//		
//	}
	

}
