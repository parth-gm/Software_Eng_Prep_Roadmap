package array;

import java.util.HashSet;
import java.util.*;
public class LogestConsecutiveSequence {

	
	
	public static int logestConsecutive(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		for(int n:nums)
			set.add(n);
		int best = 1;
		for(int n:nums) {
			if(!set.contains(n-1)) {
				int start = n;
				n = n+1;
				while(set.contains(n++));
				best = Math.max(best, n-start-1);
				
			}
		}
		return best;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {100,4,200,1,3,2};
		
		System.out.println(logestConsecutive(arr));
	}

}
