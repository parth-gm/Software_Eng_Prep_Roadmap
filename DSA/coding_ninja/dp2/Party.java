package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class Party {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fee = new int[n];
		
		int[] fun = new int[n];
		
		for(int i=0;i<n;i++) {
			fee[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			fun[i] = sc.nextInt();
		}
		
		int budget = sc.nextInt();
		
		int[][] dp = new int[n+1][budget+1];
		int[][] dp_fee_sum = new int[n+1][budget+1];
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=budget;j++) {
				if(j>=fee[i-1]) {
					if(dp[i-1][j] == (fun[i-1]+dp[i-1][j-fee[i-1]]))
					{
						dp[i][j] = dp_fee_sum[i-1][j] < (fee[i-1] + dp[i-1][j-fee[i-1]])?dp[i-1][j]: (fun[i-1]+dp[i-1][j-fee[i-1]]);
						dp_fee_sum[i][j] = Math.min(dp_fee_sum[i-1][j-fee[i-1]] + fee[i-1], dp_fee_sum[i-1][j]);
					
					}else if(dp[i-1][j] < fun[i-1]+dp[i-1][j-fee[i-1]]) {
						dp[i][j] = fun[i-1]+dp[i-1][j-fee[i-1]];
						dp_fee_sum[i][j] = dp_fee_sum[i-1][j-fee[i-1]] + fee[i-1];
					}else {
						dp[i][j] = dp[i-1][j];
						dp_fee_sum[i][j] = dp_fee_sum[i-1][j];
					}
				}else {
					dp[i][j] = dp[i-1][j];
					dp_fee_sum[i][j] = dp_fee_sum[i-1][j];
				}
			}
		}
				
		System.out.println(dp_fee_sum[n][budget] + " "+ dp[n][budget]);
		
	}

}
