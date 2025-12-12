package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class CharliAndPilot {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int n = sc.nextInt();
			int[] pisal = new int[n];
			int[] asssal = new int[n];
			
			for(int i=0;i<n;i++) {
				
				pisal[i] = sc.nextInt();
				asssal[i] = sc.nextInt();
				
			}	
			int[][] dp = new int[(n/2)+1][(n/2)+1];
			for(int i=0;i<=(n/2);i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(getMinSalary(0, 0, n, pisal, asssal, dp));
		}
		
	}

	private static int getMinSalary(int act, int pct, int n, int[] pisal, int[] asssal, int[][] dp) {
		
		if(act+pct>=n)
			return 0;
		
		if(dp[act][pct]>-1)
			return dp[act][pct];
	
		int ans = Integer.MAX_VALUE;
		if(pct<(n/2) && pct<act) {
			ans = Math.min(ans, getMinSalary(act, pct+1, n, pisal, asssal, dp)+pisal[act+pct]);
			
		}
		
		if(act<(n/2))
		{
			ans = Math.min(ans, getMinSalary(act+1, pct, n, pisal, asssal, dp)+asssal[act+pct]);
		}
		dp[act][pct] = ans;
		return ans;
	}

}
