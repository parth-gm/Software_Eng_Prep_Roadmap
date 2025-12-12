package dp;

import java.util.Arrays;

public class DecodeWays {

	public static int numDecodings(String s) {
	    
		
		if(s.length()==0)
			return s.length();
		
		if(s.charAt(0)=='0')
			return 0;
		
		
		int[] dp = new int[s.length()];
		
		dp[0] = 1;
		
		for(int i=1;i<s.length();i++) {
			
			int nextno = Integer.parseInt(""+s.charAt(i-1)+s.charAt(i));
	
			if(s.charAt(i)=='0' && s.charAt(i-1)=='0') {
				return 0;
			
			}else if(s.charAt(i)=='0' && s.charAt(i-1)!='0') {
				
				if(nextno<=26 && nextno>0)
				{
					dp[i] = i>=2?dp[i-2]:1;
					continue;
				}
				else {
					return 0;
				}
				
			}else if(s.charAt(i)!='0' && s.charAt(i-1)=='0')
			{
				dp[i] = dp[i-1];
			}
			else {
				
				if(nextno<=26 && nextno>0)
				{
					dp[i] = i>=2?dp[i-2]+dp[i-1]:dp[i-1]+1;
					continue;
				}else {
					dp[i] = dp[i-1];
				}
			
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length()-1];
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(numDecodings("1123"));

	}

}
