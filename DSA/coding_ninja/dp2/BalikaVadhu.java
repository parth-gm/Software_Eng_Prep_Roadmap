package dp2;

import java.util.Scanner;

public class BalikaVadhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			String s1 = sc.next();
			String s2 = sc.next();
			int k = sc.nextInt();
			int[][][] dp = new int[s1.length()+1][s2.length()+1][k+1];
			for(int i=0;i<=s1.length();i++) {
				for(int j=0;j<=s2.length();j++) {
					for(int c=0;c<=k;c++) {
						dp[i][j][c] = -1;
					}
				}
			}
//			int ans = getMaxBlessings(s1, s2, 0, 0, k);
//			System.out.println(ans);
			System.out.println(getMaxBlessings_memo(s1, s2, 0, 0, k, dp));
		}
	}

	private static int getMaxBlessings(String s1, String s2, int i, int j, int k) {
		
		if(k==0) {
			return 0;
		}
		if((i==s1.length() || j == s2.length() ))
			return 0;
		
		int ans =0;
		if(s1.charAt(i) == s2.charAt(j)) {
			
			int option1 = s1.charAt(i) + getMaxBlessings(s1, s2, i+1, j+1, k-1);		
			if(option1-s1.charAt(i)==0 && k>1)
				option1 = 0;
			int option2	= getMaxBlessings(s1, s2, i+1, j, k);
			int option3	= getMaxBlessings(s1, s2, i, j+1, k);
			ans = Math.max(option2, Math.max(option1, option3));
		}
		else {
			
			int option1 =getMaxBlessings(s1, s2, i+1, j, k); 
			int option2 = getMaxBlessings(s1, s2, i, j+1, k);
			ans = Math.max(option1, option2);
		}
		
		return ans;
		
	}


	private static int getMaxBlessings_memo(String s1, String s2, int i, int j, int k, int[][][] dp) {
		
		if(k==0) {
			return 0;
		}
		if((i==s1.length() || j == s2.length() ))
			return 0;
		
		if(dp[i][j][k]>-1)
			return dp[i][j][k];
		int ans =0;
		
		if(s1.charAt(i) == s2.charAt(j)) {
			
			int option1 = s1.charAt(i) + getMaxBlessings_memo(s1, s2, i+1, j+1, k-1, dp);		
			if(option1-s1.charAt(i)==0 && k>1)
				option1 = 0;
			int option2	= getMaxBlessings_memo(s1, s2, i+1, j, k, dp);
			int option3	= getMaxBlessings_memo(s1, s2, i, j+1, k, dp);
			ans = Math.max(option2, Math.max(option1, option3));
		}
		else {
			
			int option1 = getMaxBlessings_memo(s1, s2, i+1, j, k, dp); 
			int option2 = getMaxBlessings_memo(s1, s2, i, j+1, k, dp);
			ans = Math.max(option1, option2);
		}
		dp[i][j][k] = ans;
		return ans;
		
	}

}














