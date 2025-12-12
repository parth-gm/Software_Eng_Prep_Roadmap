package dp;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] input = new int[n];
			for(int i=0;i<n;i++) {
				input[i] = sc.nextInt();
				
			}
			Arrays.sort(input);
			
			long[] cum_sum = new long[n];
			cum_sum[0] = input[0];
			for(int i=1;i<n;i++) {
				cum_sum[i]= cum_sum[i-1] + input[i];
			}
			
			long minFairness = 0;
			for(int i=1;i<=k-1;i++) {
				minFairness += i*input[i]-cum_sum[i-1];
			}
			System.out.println("first:"+minFairness);
			long prevFairness = minFairness;
			long min = minFairness;
			for(int i=k;i<n;i++) {
				
				minFairness = prevFairness - 2*(cum_sum[i-1]-cum_sum[i-k]) + (k-1)*(input[i] + input[i-k]); 
				System.out.println("loop:"+minFairness);
				prevFairness = minFairness;
				
				min = Math.min(minFairness, min);
			}
			
			System.out.println(min);
			
			
			
		}

	}

}
