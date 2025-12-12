package adhoc_problems;

import java.util.Scanner;

public class InterestingSequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l= sc.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		long minCost = Long.MAX_VALUE;
		for(int i=min;i<=max;i++) {
			
			int inc=0,dec=0;
			for(int j=0;j<n;j++) {
				if(arr[j]<i)
					inc += (i-arr[j]);
				else
					dec += (arr[j]-i);
			}
			
			if(dec>inc)
				continue;
			
			minCost = Math.min(minCost, ((long)dec*k + (long)(inc-dec)*l));
			
			
		}
		System.out.println(minCost);
	}
}
