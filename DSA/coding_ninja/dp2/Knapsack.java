package dp2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Knapsack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] weights = new int[n];
		
		int[] values = new int[n];
		
		for(int i=0;i<n;i++) {
			weights[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			values[i] = sc.nextInt();
		}
		
		int max_w = sc.nextInt();
		
		int[][] dp = new int[n+1][max_w+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=max_w;j++) {
				dp[i][j] = -1;
			}
		}
		
		//System.out.println(getMaxValue_rec(weights, values, n, max_w));
		//System.out.println(getMaxValue_rec_memo(weights, values, n, max_w, dp));
		System.out.println(getMaxVaule_itr(weights, values, n, max_w));
	}

	
	
	private static int getMaxValue_rec(int[] weights, int[] values, int n, int max_w) {
		
		if(max_w == 0 || n==0 )
		{
			return 0;
		}
		
		
		int option1 = 0;
		if(max_w - weights[n-1] >=0)
			option1 = values[n-1] + getMaxValue_rec(weights, values, n-1, max_w - weights[n-1]);
		
		int option2 = getMaxValue_rec(weights, values, n-1, max_w);
		
		return Math.max(option1, option2);
	}

	private static int getMaxValue_rec_memo(int[] weights, int[] values, int n, int max_w, int[][] dp) {
		
		if(max_w == 0 || n==0 )
		{
			return 0;
		}
		
		if(dp[n][max_w]>-1) {
			return dp[n][max_w];
		}
		
		int option1 = 0;
		if(max_w - weights[n-1] >=0)
			option1 = values[n-1] + getMaxValue_rec(weights, values, n-1, max_w - weights[n-1]);
		
		int option2 = getMaxValue_rec(weights, values, n-1, max_w);
		
		
		dp[n][max_w] = Math.max(option1, option2);
		return dp[n][max_w];
	}


	static int getMaxVaule_itr(int[] weights, int[] values, int n, int max_w) {
		
		int[][] dp = new int[2][max_w+1];
		
		for(int i=0;i<2;i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0;j<=max_w;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=max_w;j++) {
				
				if(j>=weights[(i-1)])
					dp[i%2][j] = Math.max(dp[(i-1)%2][j], values[(i-1)] + dp[(i-1)%2][j-weights[(i-1)]]);
				else
					dp[i%2][j] = dp[(i-1)%2][j];
			}
			
			
		}
		return dp[(n)%2][max_w];
	}
	
	
}



















