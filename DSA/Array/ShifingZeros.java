package mmtinterview;

import java.util.Arrays;

public class ShifingZeros {

	static void shiftZerostoRight(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left<right) {
			
			while(nums[left]!=0 && left<nums.length)
				left++;
			
			while(nums[right]==0 && right>=0)
				right--;
			
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			
			left++;
			right--;
		}
		System.out.println(Arrays.toString(nums));
		
		int[] nums2 = new int[nums.length];
		
		
		
		
	}
	
	static int nums1[] = {4};
	static int nums2[] = {1,2, 3};
	
//	[1, 2, ,3, 4, 4, 5]
	static void findMedian() {
		
		int n = nums1.length;
		int m = nums2.length;
		int toStop = (n+m)%2==0?(n+m)/2 -1:(n+m)/2;
		int countItr =0;
		int i=0, j=0;
		
		while(toStop-->0)
		{
			
			if(nums1[i]<nums2[j]) {
				i++;
			}else {
				j++;
			}
			
			
			
		}
		
//		
//		if(j==nums2.length)
//		
		System.out.println(i);
		System.out.println(j);
		
		
		
//		System.out.println(nums[]);
		
		
		
	}
	
	public static void main(String[] args) {
//		int[] nums = {1, 9, 0, 3, 0, 5};
//		
//		
//		//[1, 9, 3, 5, 0]
//		//[1, 9, 3, 0, 0, 5]
//		shiftZerostoRight(nums);
		
		findMedian();

	}

}
