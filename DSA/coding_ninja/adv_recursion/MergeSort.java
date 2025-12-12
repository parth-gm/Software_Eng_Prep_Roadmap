package adv_recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			
			int len = sc.nextInt();
			int[] arr = new int[len];
			for(int i=0;i<len;i++)
			{
				arr[i] = sc.nextInt();
			}
			applymergeSort(arr,0 , len-1);
			for(int t:arr) {
				System.out.print(t+" ");
			}
//			System.out.println(Arrays.toString(arr));
			
		}

	}

	private static void applymergeSort(int[] arr, int s, int e) {
		if(s>=e)
			return;
		
		int mid = s+(e-s)/2;
		applymergeSort(arr, s, mid);
		applymergeSort(arr, mid+1, e);
		merge(arr, s, mid, e);
		
	}

	private static void merge(int[] arr, int s, int mid, int e) {
		int nlen = e-s+1;
		int[] tmpArr = new int[nlen];
		int lptr = s, rptr = mid+1, idx=0;
		while(lptr<=mid && rptr<=e)
		{
			if(arr[lptr]<arr[rptr]) {
				tmpArr[idx++] = arr[lptr++];
			}else {
				tmpArr[idx++] = arr[rptr++];
			}
		}

		while(lptr<=mid) {
			tmpArr[idx++] = arr[lptr++];
		}
		
		while(rptr<=e) {
			tmpArr[idx++] = arr[rptr++];
		}
		
		for(int i=s,k=0;i<=e;i++,k++) {
			arr[i] = tmpArr[k];
		}
		
	}

}
