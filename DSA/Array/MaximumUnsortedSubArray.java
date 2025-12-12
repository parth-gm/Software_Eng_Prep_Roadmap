package arrays;

import java.util.Arrays;

/*

Problem Statement

Find the Maximum Unsorted Subarray (a.k.a. Smallest Window to Sort)
Given an array nums, return the smallest subarray [start, end] such that sorting this subarray makes the whole array
sorted.

If the array is already fully sorted, return [-1].

✔ Example

Input:

[1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15]


Output:

2 10


Meaning:
If we sort elements from index 2 to 10, the entire array becomes sorted.
 */

public class MaximumUnsortedSubArray {


    public static void main(String[] args) {

        int[] nums = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};
//int[] nums= {4, 15, 4, 4, 15, 18, 20 };
        //[ 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 ]
        int[] ans = maxUS(nums);
        if (ans.length == 2)
            System.out.println(ans[0] + " " + ans[1]);
        else
            System.out.println(ans[0]);

    }

    private static int[] maxUS(int[] nums) {


        int[] dupnums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dupnums[i] = nums[i];
        }
        Arrays.sort(dupnums);
        int start = 0;
        while (dupnums[start] == nums[start]) {
            start++;
        }

        if (start == nums.length) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }

        int end = nums.length - 1;
        while (dupnums[end] == nums[end]) {
            end--;
        }
        int[] sols = new int[2];
        sols[0] = start;
        sols[1] = end;


        return sols;

//		int[] sols=new int[2];
//		int prev=nums[0];
//		int globmin=Integer.MAX_VALUE;
//		int lastIndex=-1;
//		for(int i=1;i<nums.length;i++) {
//			
//			if(prev>nums[i]) {
//				int key=nums[i];
//				lastIndex=i;
//				int j=i-1;
//				while(j>=0 && key<	nums[j]) {
//					j--;
//				}
//				j++;
//				if(globmin>j) {
//					globmin=j;
//				}
//			}
//			prev=nums[i];
//			
//		}
//		
//		if(lastIndex==-1) {
//			int[] ans= new int[1];
//			ans[0]=-1;
//			return ans;
//		}
//		
//		sols[0]=globmin;
//		sols[1]=lastIndex;
//		return sols;
    }

}
