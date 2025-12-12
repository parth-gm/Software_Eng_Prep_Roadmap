package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
	
		while (noTest-->0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println(getMaxCandies(arr, N, K));
		}
		
	}

	private static int getMaxCandies(int[] arr, int n, int k) {
		
		int ans = -1,  left = 0, right=arr[n-1];
		while(left<=right) {
			int mid = left + (right-left)/2;
			if(checker(arr, mid, k)) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
			
		}
		return ans;
	}

	private static boolean checker(int[] arr, int mid, int k) {
		int perPerson = 0;
		for(int i=0;i<arr.length;i++) {
			perPerson += (arr[i]/mid);
		}
		return perPerson>=k?true:false;
	}

}
