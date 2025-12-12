package dp;

import java.util.Scanner;

public class MinChocolates {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(getMinChocolates_dp(arr, n));
			
		}
		
	}

	static long getMinChocolates_dp(int[] input, int n) {
		
		long dp[] = new long[n];
		long ans = 0;
		dp[0] = 1;
		
		for(int i=1;i<n;i++) {
			if(input[i]>input[i-1]) {
				dp[i] = dp[i-1]+1; 
						continue;
			}
			dp[i] = 1;
		}
		
		for(int i=n-2;i>=0;i--) {
			if(input[i]>input[i+1] && dp[i] <=dp[i+1]) {
				dp[i] = dp[i+1]+1; 
						continue;
			}
		}
		
		for(int i=0;i<n;i++) {
			ans = ans + dp[i];
		}
		
		return ans;
		
	}
	
	//Will not work for 5 test cases
	private static long getMinChocolates(int[] input, int n) {
		
		long output[] = new long[n];
		long ans = 0;
		output[0] = 1;
		
		for(int i=1;i<n;i++) {
			
			if(input[i]>input[i-1])
			{
				output[i]=output[i-1]+1;
				continue;
			}
			else if(input[i] == input[i-1]) {
				output[i]=1;
			}
			else {
				if(output[i-1]==1) {
					output[i] = 1;
					output[i-1] = 2;
					int curIdx = i-1;
					while((curIdx>0) && (input[curIdx]<input[curIdx-1]))
					{
						output[curIdx-1] = output[curIdx]+1;
						curIdx--;
					}
				}else {
					output[i] = 1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			ans = ans + output[i];
		}
		
		return ans;
		
		
	}

}
