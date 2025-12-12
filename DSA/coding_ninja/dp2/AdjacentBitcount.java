package dp2;

import java.util.Scanner;

public class AdjacentBitcount {
	static final int modulo_by=1000000007;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			long[][][] dp = new long[n+1][k+1][2];
			
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=k;j++) {
					for(int c=0;c<=1;c++) {
						dp[i][j][c] = -1;
					}
				}
			}
			
			//System.out.println(getPS(n, k, 0)+getPS(n, k, 1));
			System.out.println(getPS_memo(n, k, 0, dp)+getPS_memo(n, k, 1, dp));
		}
		
	}


	private static long getPS_memo(int n, int adjC, int bit, long[][][] dp) {

		if(n==0) {
			if(adjC==0 && bit==0)
				return 1;
			return 0;
		}
		
		if(adjC<0)
			return 0;
		
		//System.out.println(n+","+adjC+","+bit);
		if(dp[n][adjC][bit]>-1)
			return dp[n][adjC][bit];
		
		if(bit==1) {
			long o1 = getPS_memo(n-1, adjC-1, 1, dp); 
			long o2	= getPS_memo(n-1, adjC, 0, dp);
			
			dp[n][adjC][bit] = (o1%modulo_by +o2%modulo_by)%modulo_by;
			
		}
		else 
		{
			long o1 = getPS_memo(n-1, adjC, 1, dp);
			long o2 = getPS_memo(n-1, adjC, 0, dp);
			
			dp[n][adjC][bit] = (o1%modulo_by +o2%modulo_by)%modulo_by;
			
		}
		return dp[n][adjC][bit] ;
		
	}
	
	private static long getPS(int n, int adjC, int bit) {
		
		if(n==0) {
			if(adjC==0 && bit==0)
				return 1;
			return 0;
		}
		
		if(bit==1) {
			long o1 = getPS(n-1, adjC-1, 1); 
			long o2	= getPS(n-1, adjC, 0);
			
			return (o1%modulo_by +o2%modulo_by)%modulo_by;
			
		}
		else 
		{
			long o1 = getPS(n-1, adjC, 1);
			long o2 = getPS(n-1, adjC, 0);
			
			return (o1%modulo_by +o2%modulo_by)%modulo_by;
			
		}
		
	}

}











