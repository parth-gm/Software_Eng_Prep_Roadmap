package dp2;

import java.util.Scanner;

public class SubsetSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int n = sc.nextInt();
			int[] nos = new int[n];
			for(int i=0;i<n;i++) {
				nos[i] = sc.nextInt();
			}
			
			int k = sc.nextInt();
			
			System.out.println(subsetSum(nos, n, k));
			
		}
		
	}

	private static String subsetSum(int[] nos, int n, int k) {
		
		boolean[][] dp = new boolean[2][k+1];
		
		 for(int i=1;i<=k;i++) {
			 dp[0][i] = false;
		 }
		
		 for(int i=0;i<=1;i++) {
			 dp[i][0] = true;
		 }
		 
		 int flag =1;
		 
		 for(int i=1;i<=n;i++) {
			 for(int j=1;j<=k;j++) {
				 
				 if(j>=nos[i-1]) {
					 dp[flag][j] = dp[flag^1][j] || dp[flag^1][j-nos[i-1]];
				 }else {
					 dp[flag ][j] = dp[flag^1][j];
				 }
				 
			 }
			 flag = flag^1;
		 }
 
		
		return dp[flag][k]?"Yes":"No";
	}

}
