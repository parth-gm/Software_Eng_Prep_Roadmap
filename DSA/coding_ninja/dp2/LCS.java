package dp2;

import java.util.Scanner;

public class LCS {

	static int lcs(String s1, String s2) {
		
		if(s1.isEmpty() || s2.isEmpty()) {
			return 0;
		}
		
		if(s1.charAt(0) == s2.charAt(0)) {
			return 1 + lcs(s1.substring(1), s2.substring(1));
		}else {
			
			int option1 = lcs(s1.substring(1), s2);
			int option2 = lcs(s1, s2.substring(1));
			
			return Math.max(option1, option2);
			
		}
		
	}
	
	
	static int lcs2Helper(String s1, String s2, int m, int n, int[][] dp) {
		
		if(m==0 || n==0) {
			return 0;
		}
		
		if(dp[m][n]>-1) {
			return dp[m][n];
		}
		int ans = -1;
		if(s1.charAt(0) == s2.charAt(0)) {
			ans = 1 + lcs2Helper(s1.substring(1), s2.substring(1), m-1, n-1, dp);
		}else {
			
			int option1 = lcs2Helper(s1.substring(1), s2, m-1, n, dp);
			int option2 = lcs2Helper(s1, s2.substring(1), m, n-1, dp);
			
			ans = Math.max(option1, option2);
			
		}
		dp[m][n] = ans;
		return ans;
	}
	
	static int lcs2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				dp[i][j] = -1;
			}
		}
		int ans = lcs2Helper(s1, s2, m, n, dp);
		//deallocate memeory of dp array
		
		return ans;
		
		
	}
	
	static int lcsI(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0;j<=n;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
		}
		
		return dp[m][n];
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			String a = sc.next();
			String b = sc.next();
			
			//System.out.println(lcs2(a, b));
			System.out.println(lcsI(a, b));
		}
	}

}
