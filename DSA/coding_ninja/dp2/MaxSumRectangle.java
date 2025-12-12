package dp2;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumRectangle {

	private static long maxSumRectangle2(int[][] rec, int m, int n) {
		
		long[][] rec_crows_sum = new long[m][n];
		
		for(int i=0;i<m;i++) {
			rec_crows_sum[i][0] = rec[i][0];
		}
		
		for(int i=0;i<m;i++) {
			for(int j=1;j<n;j++) {
				rec_crows_sum[i][j]= rec_crows_sum[i][j-1] + rec[i][j];
			}
		}
		
//		for(int i=0;i<m;i++) {
//			System.out.println(Arrays.toString(rec_crows_sum[i]));
//		}
//		System.out.println();
		long maxArea = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			
			for(int j=i;j<n;j++) {
				
				long[] sumArray = new long[m];
				for(int k=0;k<m;k++) {
					
					if(i==0)
						sumArray[k] = rec_crows_sum[k][j];
					else
						sumArray[k] = rec_crows_sum[k][j] - rec_crows_sum[k][i-1];
					
				}
//				System.out.println(Arrays.toString(sumArray));
				long ans = kadene(sumArray, m);
				maxArea = Math.max(maxArea, ans);
				
			}
//			System.out.println();
			
		}
		
		return maxArea;
		
		
	}
	
	static long kadene(long[] sumArray, int m) {
		
		long maxSum =sumArray[0];
		long curMax = sumArray[0];
		for(int i=1;i<m;i++) {
			
			curMax = Math.max(sumArray[i], curMax+sumArray[i]);
			maxSum = Math.max(maxSum, curMax);
			
		}
		return maxSum;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] rec = new int[m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					rec[i][j] = sc.nextInt();
				}
			}
			
			//System.out.println(maxSumRectangle1(rec, m, n));
			System.out.println(maxSumRectangle2(rec, m, n));
		}
		

	}

	private static long maxSumRectangle1(int[][] rec, int m, int n) {

		int[][] rec_csum = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				rec_csum[i][j] = 0;
				for(int k=i;k<m;k++) {
					for(int l=j;l<n;l++) {
						rec_csum[i][j] += rec[k][l];
					}
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(rec_csum[i][j]+" ");
			}
			System.out.println();
		}
		
		long maxArea = Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				for(int k=i;k<m;k++) {
					for(int l=j;l<n;l++) {
						long area = rec_csum[i][j]; 
						if(k+1 < m)
							area = area - rec_csum[k+1][j];
						if(l+1<n)
							area = area - rec_csum[i][l+1];
						if((k+1)<m && (l+1)<n)
							area = area + rec_csum[k+1][l+1];
						
						maxArea = Math.max(maxArea, area);
						
					}
				}	
			}
		}
		
		return maxArea;
	}

}
