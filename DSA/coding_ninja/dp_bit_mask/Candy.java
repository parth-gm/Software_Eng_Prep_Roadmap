package dp_bit_mask;

import java.util.Scanner;

public class Candy {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n= sc.nextInt();
			int[][] likes = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					likes[i][j] = sc.nextInt();
				}
			}
			
			int[] dp = new int[(1<<n)];
			
			dp[0] = 1;
			
			for(int mask=0;mask<((1<<n)-1);mask++) {
				
				int setbits =0, temp = mask;
				while(temp>0) {
					if((temp&1)==1)
						setbits++;
					temp= temp/2;
				}
				
				
				for(int j=0;j<n;j++) {
					
					if((mask&(1<<j))==0 && likes[setbits][j]==1) {
						dp[mask|(1<<j)] = dp[mask|(1<<j)] + dp[mask];
					}
					
				}
				
			}
			
			System.out.println(dp[(1<<n) -1]);
			
			
		
		}
		
	}

}
