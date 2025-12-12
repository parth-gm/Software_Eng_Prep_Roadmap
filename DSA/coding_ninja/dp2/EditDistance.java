package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

	
	static int editDistance_rec(String s1, String s2) {
		
		if(s1.isEmpty() || s2.isEmpty()) {
			if(s1.isEmpty())
				return s2.length();		
			if(s2.isEmpty())
				return s1.length();
			return 0;
		}
		if(s1.charAt(0) == s2.charAt(0)) {
			return editDistance_rec(s1.substring(1), s2.substring(1));
		}else {
			int o1 = 1+editDistance_rec(s1.substring(1), s2.substring(1));
			int o2 = 1+editDistance_rec(s1.substring(1), s2);
			int o3 = 1+editDistance_rec(s1, s2.substring(1));
			return Math.min(o1, Math.min(o2, o3));
		}
		
	}
	
	
	static int editDistance(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1;i<=n;i++) {
			dp[0][i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			dp[i][0] = i;
		}
		//System.out.println(Arrays.toString(dp[0]));
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					
					dp[i][j] = Math.min(1+dp[i-1][j-1], Math.min(1+dp[i][j-1], 1+dp[i-1][j]));
					
				}
				
			}
		}
		
		return dp[m][n];
		
	}
	
	static int editDistance2_Helper(String s1, String s2, int m, int n, int[][] dp) {
		
		if(m==0) {
			return n;
		}
		
		if(n==0) {
			return m;
		}
		
		if(dp[m][n]>-1) {
			return dp[m][n];
		}
		int ans = -1;
		if(s1.charAt(0) == s2.charAt(0)) {
			ans =  editDistance2_Helper(s1.substring(1), s2.substring(1), m-1, n-1, dp);
		}else {
			
			int option1 = 1+editDistance2_Helper(s1.substring(1), s2, m-1, n, dp);
			int option2 = 1+editDistance2_Helper(s1, s2.substring(1), m, n-1, dp);
			int option3 = 1 + editDistance2_Helper(s1.substring(1), s2.substring(1), m-1, n-1, dp);
			ans = Math.min(option1, Math.min(option2, option3));
			
		}
		dp[m][n] = ans;
		return ans;
	}
	
	static int editDistance2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				dp[i][j] = -1;
			}
		}
		int ans = editDistance2_Helper(s1, s2, m, n, dp);
		//deallocate memeory of dp array
		
		return ans;
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			String a = sc.next();
			String b = sc.next();
			
			//System.out.println(editDistance_rec(a, b));
			//System.out.println(editDistance(a, b));
			System.out.println(editDistance2(a, b));
			
		}
		
	}

}
