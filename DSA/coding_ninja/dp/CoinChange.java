package dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	static final int mode = 1000000007;
	static int coin_change_itr(int[] darr, int n, int numD) {
		
		long[][] output = new long[numD+1][n+1];
		
		for(int i=1;i<=numD;i++) {
			output[i][0]=1;
		}
		
		
		for(int i=1;i<=numD;i++) {
			for(int j=1;j<=n;j++) {
				if((j-i)<0)
				{
					output[i][j] = output[i-1][j];
					continue;
				}
				output[i][j] = (output[i][j-i]%mode+output[i-1][j]%mode)%mode;
			}
		}
		
		
		
		return (int)output[numD][n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int notest = sc.nextInt();
		while(notest-->0)
		{	
			int nd = sc.nextInt();
			int[] arr = new int[nd];
			for(int i=0;i<nd;i++) {
				
				arr[i] = sc.nextInt();
				
			}
			int make = sc.nextInt();
//			int[][] output = new int[nd+1][make+1];
//			
//			for (int[] row: output)
//			    Arrays.fill(row, -1);
//			int ans = coin_change(arr, make, arr.length, output);
			System.out.println(coin_change_itr(arr, make, nd));
		}
	}

	private static int coin_change(int[] darr, int n , int numD, int[][] output) {
		
		if(n==0)
		{
			return 1;
		}
		
		if(n<0)
			return 0;
		if(numD==0)
		{
			return 0;
		}
		if(output[numD][n]>0) {
			return output[numD][n];
		}
		int first = coin_change(darr, n-darr[numD-1], numD, output);
		int second = coin_change(darr, n, numD-1, output);
		output[numD][n] = first+second;
		return first+second;
		
		
	}

}
