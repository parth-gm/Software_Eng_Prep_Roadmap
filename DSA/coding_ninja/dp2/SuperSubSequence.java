package dp2;

import java.util.Scanner;

public class SuperSubSequence {

	static int getMinSuperSequence(String s1, String s2, int i, int j) {
		
		if(i==s1.length())
			return s2.length() - j;
		
		if(j==s2.length())
			return s1.length() - i;
	
		
		if(s1.charAt(i) == s2.charAt(j))
		{
			return 1 + getMinSuperSequence(s1, s2, i+1, j+1);
		}else
		{
			return 1 + Math.min(getMinSuperSequence(s1, s2, i+1, j), getMinSuperSequence(s1, s2, i, j+1));
		}
		
	}
	
	static int getMinSuperSequence_itr(String s1, String s2) {
		
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<=s1.length();i++) {
			dp[i][s2.length()] = s1.length() - i;
		}
		
		for(int i=0;i<=s2.length();i++) {
			dp[s1.length()][i] = s2.length() - i;
		}
		
		for(int i=s1.length()-1;i>=0;i--) {
			for(int j=s2.length()-1;j>=0;j--) {
				if(s1.charAt(i)==s2.charAt(j))
				{
					dp[i][j] = 1 + dp[i+1][j+1];
				}
				else
				{
					dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			System.out.println(getMinSuperSequence_itr(s1, s2));
			System.out.println(getMinSuperSequence(s1, s2, 0, 0));
			
		}
	}

}
