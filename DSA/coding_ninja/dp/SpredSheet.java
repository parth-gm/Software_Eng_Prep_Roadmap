package dp;

import java.util.Scanner;

public class SpredSheet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] input = new int[m][n];
			
			int[][] dp = new int[m][n];
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					input[i][j] = sc.nextInt();
					if(i>0) {
						if(input[i][j]>=input[i-1][j])
							dp[i][j] = dp[i-1][j];
						else
							dp[i][j] = i;
					}
				}
			}
			
			int[] rows = new int[m];
			
			for(int i=0;i<m;i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<n;j++) {
					min = Math.min(min, dp[i][j]);
				}
				rows[i] = min;
				
			}
			
			
			int q = sc.nextInt();
			
			for(int i=0;i<q;i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				if(rows[r-1]<=(l-1))
				{
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				
			}
			
			
		}
		

	}

}
