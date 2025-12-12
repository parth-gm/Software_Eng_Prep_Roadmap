package adv_recursion;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	static void quickSort(int[] arr, int start, int end) {
		if(start>=end)
			return;
		System.out.println(start+", "+end);
		int pid = partition(arr, start, end);
		quickSort(arr, start, pid-1);
		quickSort(arr, pid+1, end);

	}
	
	static int partition(int[] arr, int start, int end) {
		int pivot_item = arr[start];
		int lptr = start, rptr = end;
		while(lptr<rptr) {
			while(lptr<end && pivot_item>=arr[lptr]) {
				lptr++;
			}
			while(rptr>start && pivot_item<arr[rptr] ) {
				rptr--;
			}
			if(lptr<rptr) {
				int tmp = arr[rptr];
				arr[rptr] = arr[lptr];
				arr[lptr] = tmp;
			}
		}
		int tmp = arr[rptr];
		arr[rptr] = arr[start];
		arr[start] = tmp;
		System.out.println(Arrays.toString(arr));
		return rptr;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			
			int len = sc.nextInt();
			int[] arr = new int[len];
			for(int i=0;i<len;i++)
			{
				arr[i] = sc.nextInt();
			}
			quickSort(arr, 0, arr.length-1);
			for(int t:arr) {
				System.out.print(t+" ");
			}
		}
	}
}
