package binarySearch;

import java.util.Arrays;
import java.util.Collections;

public class LowerUpperBound {

	 public static  int getLowerBound(int[] nums, int target, int left, int right){
	        while(left<right){
	            int mid = left + (right-left)/2;
//	            System.out.println(left+","+right);
	            if(nums[mid]>=target)
	                right = mid;
	            else
	                left = mid+1;
	        }
	        
	        if(left<nums.length && nums[left]<target) 
	        {
	        	left++;
	        }
	        
	        return left;
	        
	    }

	    public static int getUpperBound(int[] nums, int target, int left, int right){
	    	  	
	        while(left<right){
	            int mid = left + (right-left)/2;
	            if(nums[mid]<=target)
	                left = mid+1;
	            else
	                right = mid;
	        }
	        if(left<nums.length && nums[left]<=target) {
	        	left++;
	        }
	         
	        return left;
	    }

	    public static int findRightIndex(int[] nums, int target){
	        int left = 0, right = nums.length-1;
	        int ans = -1;
	        while(left<=right){
	            int mid = left + (right-left)/2;
	            if(nums[mid]==target){
	                ans = mid;
	                left = mid + 1;
	            }else if(nums[mid]<target){
	                left = mid +1;
	            }else{
	                right = mid - 1;
	            }
	        }
	        return ans;
	    }
	      
	   public static void main(String[] args) {
//		int[] arr = {5, 7, 7, 8, 8, 10};
		int[] arr = {6, 16, 24, 32, 39, 46, 53};
//		int[] arr = {0, 0, 0, 1, 1, 1, 1};
		System.out.println(getLowerBound(arr,24, 0,arr.length-1));
		System.out.println(getUpperBound(arr, 24, 0, arr.length-1));
		System.out.println(findRightIndex(arr, 0));
		
		 String s[] = "i like this program very much".split(" ");
		 System.out.println(Arrays.toString(s));
		 
//		   
//	        Arrays.sort(arr, (i1, i2)-> i2-i1);
//	        
	        
//	        int[] squares = { 4, 25, 9, 36, 49 }; 
//	        System.out.println("int[] array before sorting : " + Arrays.toString(squares)); 
//	        System.out.println("sorting array in ascending order"); 
//	        Arrays.sort(squares, Collections.reverseOrder()); 
//	        System.out.println("reversing array in place");
		 
	}
	
}
