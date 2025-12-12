package Sorting;

import java.util.Scanner;

public class TajMahalEntry {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			
			arr[i] = sc.nextInt();
			
		}
		System.out.println(getWindowNo(arr, n));
		
	}

	private static int getWindowNo(int[] arr, int n) {
	
		int firstShop = Integer.MAX_VALUE;
		int ans = -1;
		for(int i=0;i<n;i++) {
			
			
			int itr = (int) Math.ceil((double)(arr[i]-i)/n);
			int indexOfZero = i+(n*itr);
			if(indexOfZero<firstShop) {
				ans = i+1;
				firstShop = indexOfZero;
			}
			
		}
		return ans;
	}

}
