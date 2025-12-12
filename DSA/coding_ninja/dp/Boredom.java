package dp;

import java.util.Scanner;

public class Boredom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n= sc.nextInt();
			int input[] = new int[100000];
			int max = -1;
			for(int i=0;i<n;i++) {
				int val = sc.nextInt();
				max = Math.max(max, val);
				input[val-1]++;
				
			}
			
			System.out.println(max_points(input, max, n));
			
			
		}
		
		
	}

	private static long max_points(int[] input, int max, int n) {
		
		if(n==1)
			return input[0];
		
		if(n==2)
			return Math.max(input[0], input[1]);
		
		long prev_prev = input[0];
		long prev = Math.max(input[0]*1, input[1]*2);
		long cur = 0;
		
		for(int i=2;i<max;i++) {
		
			cur = Math.max((long)(i+1)*input[i] + prev_prev, prev);
			prev_prev = prev;
			prev = cur;
			
		}
		
		return cur;
		
	}

}
