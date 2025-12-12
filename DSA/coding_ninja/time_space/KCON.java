package time_space;

import java.io.IOException;
import java.util.Scanner;

public class KCON {

	static long kadane(int[] arr, int n) {
		int bestSoFar = 0;
		int curSum = 0;
		
		for(int i=0;i<n;i++)
		{
			curSum+=arr[i];
			if(bestSoFar<curSum)
				bestSoFar=curSum;
			if(curSum<0)
				curSum=0;
			
		}
		return bestSoFar;
		
	}
	
	static long maxSumSubarray(int arr[], int n, int k) {
		
		long kadaneSum =  kadane(arr, n);
		if(k==1)
			return kadaneSum;
		
		long curr_prefix_sum = 0, max_prefix_sum=Long.MIN_VALUE;
		long curr_suffix_sum = 0, max_suffix_sum=Long.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			curr_prefix_sum = arr[i]+curr_prefix_sum;
			if(curr_prefix_sum>max_prefix_sum) {
				max_prefix_sum=curr_prefix_sum;
			}
		}
		long total_sum = curr_prefix_sum;
		for(int i=n-1;i>=0;i--) {
			curr_suffix_sum = arr[i]+curr_suffix_sum;
			max_suffix_sum = Math.max(curr_suffix_sum, max_suffix_sum);
		}
		long ans ;
		if(total_sum<0) {
			ans = Math.max(max_suffix_sum+ max_prefix_sum, kadaneSum);
		}else {
			ans = Math.max(max_suffix_sum+max_prefix_sum+(total_sum*(k-2)),
					kadaneSum);
		}
		return ans;
	}
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
		for(int i=0;i<noTest;i++) {
			int n = sc.nextInt();
			int k= sc.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			System.out.println(maxSumSubarray(arr, n, k));
		}
		
	}

}
