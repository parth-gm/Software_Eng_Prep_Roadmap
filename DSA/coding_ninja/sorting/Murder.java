package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Murder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int noTestCases = sc.nextInt();
		while(noTestCases-->0) {
			
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i=0;i<n;i++) {
				arr[i] =  sc.nextInt();
			}
			System.out.println(calculateStairCount(arr, n));
			
		}
	}

	static long calculateStairCount(long[] arr, int n) {
		// TODO Auto-generated method stub
		int start=0, end=n-1;
		return merge(arr, start, end);
	}

	static long merge(long[] arr, int start, int end) {
		
		if(start<end) {
			int mid = start + (end-start)/2;
			
			long leftCount = merge(arr, start, mid);
			long rightCount = merge(arr, mid+1, end);
			long mergeCount = mergeAndGetCount(arr, start, mid, end);
			return leftCount+rightCount+mergeCount;
		}
		return 0;
	}

	static long mergeAndGetCount(long[] arr, int start, int mid, int end) {
		
		int lsize = mid-start +1;
		int rsize = end - mid;
		long larr[] = new long[lsize];
		long rarr[] = new long[rsize];
		
		for(int i=0;i<lsize;i++) {
			larr[i] =  arr[i+start];
		}
		
		for(int i=0;i<rsize;i++) {
			rarr[i] =  arr[i+mid+1];
		}
		
		int lptr = 0 ,rptr = 0 ; 
		int index = start;
		long ansCount = 0;
		while(lptr<lsize && rptr<rsize) {
			
			if(larr[lptr] < rarr[rptr]) {
				
				arr[index] = larr[lptr];
				ansCount+= (rsize - rptr)*larr[lptr];
				lptr++;
			
			}
			else {				
				arr[index] = rarr[rptr];
				rptr++;
			}
			index++;
		}
		
		while(lptr<lsize)
			arr[index++] =  larr[lptr++];
		
		while(rptr<rsize)
			arr[index++] =  rarr[rptr++];
		
		
		
		return ansCount;
		
	}

}
