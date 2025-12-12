package dp;

import java.util.Arrays;

public class StocksBuySellProfit {

	
	
	public static void main(String[] args) {
//		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr = {1,2,3,4,5};
		int K = 2;
		int[][][] dp = new int[arr.length+1][2][K];
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<K;k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
//			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		System.out.println(max_p_rec(arr, 0, 1, dp, 0));
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

	private static int max_p_rec(int[] arr, int i, int b, int[][][] dp, int count) {
		
		if(count>=2 || i==arr.length)
			return 0;
		
		if(dp[i][b][count]!=Integer.MAX_VALUE)
			return dp[i][b][count];
		
		int ans1=0, ans2=0;
		if(b==1) {
			ans1 = -arr[i] + max_p_rec(arr, i+1, 0, dp, count);
			ans2 =  max_p_rec(arr, i+1, 1, dp, count);
			
		}
		else{
			ans1 = arr[i] + max_p_rec(arr, i+1, 1, dp, count+1);
			ans2 =  max_p_rec(arr, i+1, 0, dp, count);
			
		}
		return dp[i][b][count] = Math.max(ans1, ans2);
		
		
	}

}
