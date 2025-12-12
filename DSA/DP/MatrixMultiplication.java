package DP;

import java.util.Arrays;

public class MatrixMultiplication {

	static int tdp[][]=new int[100][100];
	static int matrixMultiplicationTDP(int m[],int i,int j) {
		
		if(i==j) {
			tdp[i][j]=0;
			return 0;
		}
		if(tdp[i][j]!=-1) {
			return tdp[i][j];
		}
		 
		int ans=Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++) {
			int temp=matrixMultiplicationTDP(m, i, k)+matrixMultiplicationTDP(m, k+1,j)+ (m[i-1]*m[k]*m[j]);
			
			ans=Math.min(ans, temp);
			
		}
		tdp[i][j]=ans;
		
		return ans;
		
	
	}
	
	
	
	static int matrixMultiplication(int m[],int i,int j) {
		
		if(i==j)
			return 0;
		
		int ans=Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++) {
			int temp=matrixMultiplication(m, i, k)+matrixMultiplication(m, k+1,j)+ (m[i-1]*m[k]*m[j]);
			
			ans=Math.min(ans, temp);
			
		}
		return ans;
		
	
	}
	
	
	static int matrixChainBottomUp(int m[],int n) {
		
		int dp[][]=new int[100][100];
		
		
		for(int i=1;i<n;i++)
			dp[i][i]=0;
		
		for(int L=2;L<n;L++) {
			for(int i=1;i<=n-L;i++) {
				
				int j=i+(L-1);

				dp[i][j]=Integer.MAX_VALUE;
				
				
				for(int k=i;k<j;k++) {
					
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+m[i-1]*m[k]*m[j]);
				
					
				}
					
			}
			
		}
		
		System.out.println("BDP---------Matrix");
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return dp[1][n-1];
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrices[]= {25,75,20,95,110};
		int n=matrices.length;
		
		for(int[] line:tdp) {
			Arrays.fill(line, -1);
		}
		System.out.println("Recursion: "+matrixMultiplication(matrices, 1, n-1));
		System.out.println("TDP: "+matrixMultiplicationTDP(matrices, 1, n-1));
		System.out.println("TDP matrix--------------");
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				System.out.print(tdp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("BDP ANS: "+matrixChainBottomUp(matrices, n));

	}

}
