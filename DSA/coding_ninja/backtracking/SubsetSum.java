package backtracking;

import java.util.Scanner;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(getCountSub(arr, n, k, 0, 0));
		}
	}

	private static int getCountSub(int[] arr, int n, int k, int i, int curSum) {
		// TODO Auto-generated method stub
		if(i==n) {
			if(curSum==k) {
				return 1;
			}
			return 0;
		}
		
		int with = getCountSub(arr, n, k, i+1, curSum+arr[i]);
		int without = getCountSub(arr, n, k, i+1, curSum);
		return with+without;
		
	}

}
