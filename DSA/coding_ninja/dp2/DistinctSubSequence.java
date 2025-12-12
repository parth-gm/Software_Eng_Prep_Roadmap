package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubSequence {
	static final int  module_by=1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			String str = sc.next();
			System.out.println(getDistinctSubsequence(str));
		}
		
	}

	private static long getDistinctSubsequence(String str) {
		
		int[] last =new int[26];
		
		Arrays.fill(last, -1);
		
		long[] dp = new long[str.length()+1];
		dp[0] = 1;
		
		for(int i=1;i<=str.length();i++) {
			
			dp[i] = (2*dp[i-1])%module_by;
			
			if(last[(int)str.charAt(i-1) - 'A']>-1) {
				
				dp[i] = (dp[i] - dp[last[(int)str.charAt(i-1) - 'A']] +module_by)%module_by;
				
			}
			last[(int)str.charAt(i-1) - 'A'] = i-1;
		}
		
		return dp[str.length()];
	}

}
