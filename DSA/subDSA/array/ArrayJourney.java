package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayJourney {

	static long maxSum(List<Integer> arr, int maxStep){
		
		if(arr.size()==1)
			return arr.get(0);
		
		long[] dp = new long[arr.size()];
		Arrays.fill(dp, Long.MIN_VALUE);
		dp[arr.size()-1] = arr.get(arr.size()-1);
		
		for(int i=arr.size()-1;i>=0;i--) {
			for(int j=1;j<=maxStep && (i-j)>=0;j++) {
				dp[i-j] = Math.max(dp[i-j], dp[i] + arr.get(i-j));
				
			}
		}
		
		return dp[0];
		
		
		
	}
	
	public static void main(String[] args) {
		
//		Integer[] arr = {-1, -2, -3, -4, -5};
		Integer[] arr2 = {10, 2, -10, 5, 20};
		System.out.println(maxSum(Arrays.asList(arr2), 4));
		
	}

}
