package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AggresiveCow {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTestCases = sc.nextInt();
		
		for(int i=0;i<noTestCases;i++) {
		
			int n = sc.nextInt();
			int c = sc.nextInt();
			long arr[] = new long[n];
			for(int j=0;j<n;j++) {
				
				arr[j] = sc.nextInt();
			
			}
			Arrays.sort(arr);
			System.out.println(getMinDistance(arr, n, c));
		}
		
		
		
 	}

	 static long getMinDistance(long[] arr, int n, int c) {
		long start = 0, end=arr[n-1]-arr[0], mid=0;
		long ans = 0;
		while(end>=start) {
			mid = start + ((end-start)/2);
//			System.out.println("mid: "+mid);
//			System.out.println("ans:"+ checkDSatisfy(arr, n, mid, c));
			if(checkDSatisfy(arr, n, mid, c)) {
				start = mid + 1;
				ans = mid;
			}else {
				end = mid - 1;
			}
		}
		return ans;
	}

	 static boolean checkDSatisfy(long[] arr, int n, long d, int c) {
		long prevPos = arr[0];
		int count=1;
		for(int i=1;i<n;i++) {
			long diff = arr[i]-prevPos;
			if(diff>=d) {
				count++;
				prevPos = arr[i];
			}
			if(count==c)
				return true;
		}
		return false;
	}
}
