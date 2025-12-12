package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsDiffrence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tests = sc.nextInt();
		while(tests-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n-1;i++) {
				int diff = Math.abs(arr[i] - arr[i+1]);
				if(diff<min) {
					min = diff;
				}
			}
			System.out.println(min);
			
		}

	}

}
