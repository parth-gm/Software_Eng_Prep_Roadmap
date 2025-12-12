package DP;

public class LongestCommonSubSeq {

	static int lcs(String A,String B,int i,int j) {
		
		if(i==A.length() || j==B.length()) {
			return 0;
		}else if(A.charAt(i)==B.charAt(j)) {
			return 1+lcs(A,B,i+1,j+1);
		}else {
			return Math.max(lcs(A,B,i+1,j), lcs(A,B,i,j+1));
		}
		
	}
	
	
	static int lcsBottomUp(String A,String B) {
		
		int dp[][]=new int[A.length()+1][B.length()+1];
		
//		for(int i=0;i<A.length()+1;i++) {
//			dp[i][0]=0;
//		}
//		
//		for(int i=0;i<B.length()+1;i++) {
//			dp[0][i]=0;
//		}
//		
		
		for(int i=1;i<=A.length();i++) {
			
			for(int j=1;j<=B.length();j++) {
				
				if(A.charAt(i-1)==B.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
			
		}
		
		for(int i=0;i<=A.length();i++) {
			
			for(int j=0;j<=B.length();j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
			
		}
		
		int icur=A.length();
		int jcur=B.length();
		StringBuffer sb=new StringBuffer();
		while(dp[icur][jcur]!=0)
		{
			
			if(A.charAt(icur-1)==B.charAt(jcur-1)) {
				sb.append(A.charAt(icur-1));
				icur--;
				jcur--;
			}else {
				if(dp[icur-1][jcur]>dp[icur][jcur-1]) {
					icur--;
				}else {
					jcur--;
				}
			}
			
			
		}
		System.out.println(sb.reverse());
		
		return dp[A.length()][B.length()];
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(lcs("bd","abcd",0,0));
		System.out.println(lcsBottomUp("stone", "longest"));
	}
	
}
