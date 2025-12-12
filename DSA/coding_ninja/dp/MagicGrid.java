package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MagicGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int ntests = sc.nextInt();
	
		while(ntests-->0) {
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] input = new int[m][n];
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					input[i][j] = sc.nextInt();
				}
			}
//			int[][] output = new int[m][n];

//			for(int i=0;i<m;i++) {
//				Arrays.fill(output[i], -1);
//			}
//			System.out.println(get_magic_grid_rec(input, 0, 0, m, n, output));
//			
			
			System.out.println(get_magic_grid_itr(input, m, n));
			
		}
	}

	

	private static int get_magic_grid_itr(int[][] input, int m, int n) {
	
		int[][] dp = new int[m][n];
		
		dp[m-1][n-1] = 1;
		
		for(int i=m-2;i>=0;i--) {
			if(input[i][n-1]<dp[i+1][n-1])
			{	dp[i][n-1] = dp[i+1][n-1] - input[i][n-1];
				continue;
			}
			dp[i][n-1] =1;
			
		}
		
		for(int i=n-2;i>=0;i--) {
			if(input[m-1][i]<dp[m-1][i+1])
			{	dp[m-1][i] = dp[m-1][i+1] - input[m-1][i];
				continue;
			}
			dp[m-1][i] =1;
			
		}
		
		
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
			
				int bottom = dp[i+1][j], right = dp[i][j+1], ans=1;
				if(input[i][j]<Math.min(right, bottom))
				{
					ans = Math.min(bottom, right) - input[i][j];
				}
				dp[i][j] = ans;
				
			}
		}
		
		return dp[0][0];
			
	}

	
	private static int get_magic_grid_rec(int[][] input, int i, int j, int m, int n, int[][] output) {
	
		if(i==m-1 && j==n-1)
			return 1;
		
		if(i>=m || j>=n)
		{
			return Integer.MAX_VALUE;
		}
		
		if(output[i][j]>0) {
			return output[i][j];
		}
		int right = get_magic_grid_rec(input, i, j+1, m, n, output);
		int bottom = get_magic_grid_rec(input, i+1, j, m, n, output);
		
		int ans = 1;
		if(input[i][j]<Math.min(right, bottom))
		{
			ans = Math.min(right, bottom) - input[i][j];
		}
		output[i][j] = ans;
		return ans;
			 
		
	}

}
