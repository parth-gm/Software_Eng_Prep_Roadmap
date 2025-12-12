package dp_bit_mask;

import java.util.Scanner;

public class StringMatcher {

	static final int modulo_by=1000000007;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String s1 = sc.next();
			String s2 = sc.next();
			String s3 = sc.next();
			long[][][] dp = new long[s1.length()+1][s2.length()+1][s3.length()+1];
			
			for(int i=0;i<s1.length()+1;i++) {
				for(int j=0;j<s2.length()+1;j++) {
					for(int k=0;k<s3.length()+1;k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			System.out.println(no_ways(s1, s2, s3, dp));
		}

	}

	private static long no_ways( String s1, String s2, String s3, long[][][] dp) {
		
		if(s3.length()==0)
		{
			return 1;
		}
		
		if(s1.length()<=0 && s2.length()<=0)
			return 0;
		
		if(dp[s1.length()][s2.length()][s3.length()]>-1) {
			return dp[s1.length()][s2.length()][s3.length()]%modulo_by;
		}
		
		long ways = 0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s3.charAt(0))
			{
				ways += no_ways(s1.substring(i+1), s2, s3.substring(1), dp)%modulo_by;
			}
		}
		
		for(int i=0;i<s2.length();i++) {
			if(s2.charAt(i)==s3.charAt(0))
			{
				ways += no_ways(s1, s2.substring(i+1), s3.substring(1), dp)%modulo_by;
			}
		}
		dp[s1.length()][s2.length()][s3.length()] = ways%modulo_by;
		return ways%modulo_by;
		
	}

}
