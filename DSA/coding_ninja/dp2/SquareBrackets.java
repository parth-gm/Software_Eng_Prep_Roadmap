package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class SquareBrackets {
	
	static final int  module_by=1000000007;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			boolean[] isPresent = new boolean[2*n];
			for(int i=0;i<k;i++) {
				int idx = sc.nextInt();
				isPresent[idx-1] = true;
			}
			long[][] dp = new long[n+1][n+1];
			for(int i=0;i<=n;i++) {
				Arrays.fill(dp[i], -1);
			}
			
			//System.out.println(getVBPattern(n,isPresent, 0, 0));
			System.out.println(getVBPattern_rec_dp(n, isPresent, 0, 0, dp));
			
		}
		
	}

	private static long getVBPattern(int n, boolean[] isPresent, int i, int count) {

		if(count==0 && i==(2*n)) {
			return 1;
		
		}
		
		if(count<0 ||  i>=(2*n))
			return 0;
		
		
		if(isPresent[i] || count==0 ) {
			
			long o1 = getVBPattern(n, isPresent, i+1, count+1);
			return o1%module_by;
		}else
		{
			long o2 = getVBPattern(n, isPresent, i+1, count+1);
		
			long o3 = getVBPattern(n, isPresent, i+1, count-1);
			
			return (o2%module_by +o3%module_by)%module_by;
		}
		
		
		
	}

	private static long getVBPattern_rec_dp(int n, boolean[] isPresent, int o, int c, long[][] dp) {
		
		if(o>n || c>n) {
			return 0;
		}
		if(o==n && c==n) {
			
			return 1;
		}
		
		if(dp[o][c]>-1) {
			
			return dp[o][c];
		}
		
		long ans = 0;
		if((o == c) || isPresent[(c+o)])
		{
			
			long o1 = getVBPattern_rec_dp(n, isPresent, o+1, c, dp);
			ans = o1%module_by;
			
		}else if(o==n)
		{
			
			long o2 = getVBPattern_rec_dp(n, isPresent, o, c+1, dp);
			ans = o2%module_by;
			
		}else {
			
			long o3 = getVBPattern_rec_dp(n, isPresent, o+1, c, dp);
		
			long o4 = getVBPattern_rec_dp(n, isPresent, o, c+1, dp);
			ans = (o3%module_by +o4%module_by)%module_by;
			
		}
		dp[o][c] = ans;
		return dp[o][c];
		
	}
	
}
