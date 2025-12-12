package dp2;

import java.util.Scanner;

public class TraderProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int[] sprices = new int[n];
			
			for(int i=0;i<n;i++) {
				
				sprices[i] = sc.nextInt();
				
			}
			//stocks_prices, no. days, max_transections, current_item, ongoing
			System.out.println(getMaxProfit(sprices, n, k, 0, false)); 
			long[][][] dp = new long[n+1][k+1][2];
			
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=k;j++) {
					for(int o=0;o<=1;o++) {
						dp[i][j][o] = -1;
					}
				}
			}
			
			System.out.println(getMaxProfit_memo(sprices, n, k, 0, 0, dp));
			
		}

	}

	private static long getMaxProfit(int[] sprices, int n, int k, int i, boolean ongoing) {
	
		if(i == n || k < 0)
			return 0;
		
		
		long o1 = getMaxProfit(sprices, n, k, i+1, ongoing);
		long o2 = Integer.MIN_VALUE, o3 = Integer.MIN_VALUE;
		if(ongoing) {
			o2 = getMaxProfit(sprices, n, k-1, i, false) + sprices[i];
		}else {
			if(k>0) {
				o3 = getMaxProfit(sprices, n, k, i+1, true) - sprices[i]; 
			}
		}
		
		return Math.max(o1, Math.max(o2, o3));
	}

	private static long getMaxProfit_memo(int[] sprices, int n, int k, int i, int ongoing, long[][][] dp) {
		
		if(i == n || k < 0)
			return 0;
		
		
		if(dp[i][k][ongoing]>-1)
			return dp[i][k][ongoing];
		
		long o1 = getMaxProfit_memo(sprices, n, k, i+1, ongoing, dp);
		long o2 = Integer.MIN_VALUE, o3 = Integer.MIN_VALUE;
		if(ongoing==1) {
			o2 = getMaxProfit_memo(sprices, n, k-1, i, 0, dp) + sprices[i];
		}else {
			if(k>0) {
				o3 = getMaxProfit_memo(sprices, n, k, i+1, 1, dp) - sprices[i]; 
			}
		}
		
		dp[i][k][ongoing] = Math.max(o1, Math.max(o2, o3));
		return dp[i][k][ongoing];
	}
	
	
	
	
	
	
	
	
	
	
	
}
