package recursion;

public class UniquePaths {
	static int  uniquePathCount =0;
	
	public static int dpUniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0;i<n;i++) {
			dp[m-1][i] = 1;
		}
		
		for(int i=0;i<m;i++) {
			dp[i][n-1] = 1;
		}
		dp[m-1][n-1] = 0;
		
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				dp[i][j] = dp[i+1][j] + dp[i][j+1];
			}
		}
		
		return dp[0][0];

	}
	
	public static int uniquePaths(int m, int n) {
		uniquePathCount =0;
		helper(0, 0, m, n);
		return uniquePathCount;
	}
	private static void helper(int i, int j, int m, int n) {
		
		if(i==(m-1) && j==(n-1))
		{
			uniquePathCount++;
		}
		
		if(i<0 || i>=m || j>=n || j<0)
		{
			return;
		}
		
		helper(i+1, j, m, n);
		helper(i, j+1, m, n);
		
	}
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 3));
		System.out.println(dpUniquePaths(3, 3));
		
		
	}

}
