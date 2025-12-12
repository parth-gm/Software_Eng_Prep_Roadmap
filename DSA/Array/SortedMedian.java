package questions;

import java.util.Arrays;

public class SortedMedian {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1idx=0, n2idx=0;
        
        if(nums1.length==0 && nums2.length==0)
        {
        	return 0;
        }
        
        int resultantLength = nums1.length+nums2.length;
        int[] resArray = new int[nums1.length+nums2.length];
        int i=0;
        while(n1idx<nums1.length && n2idx<nums2.length)
        {
            if(nums1[n1idx]<nums2[n2idx]){
                resArray[i] = nums1[n1idx];
                n1idx++;
            }else
            {
                resArray[i] = nums2[n2idx];
                n2idx++;
            }
            i++;
        }
        if(n2idx==nums2.length){
            while(n1idx<nums1.length )
            {
                resArray[i] = nums1[n1idx];
                n1idx++;
                i++;
            }
        }
            
        if(n1idx==nums1.length){
            while(n2idx<nums2.length )
            {
                resArray[i] = nums2[n2idx];
                n2idx++;
                i++;
            }
        }
        System.out.println(Arrays.toString(resArray));
        int mid = resultantLength/2;    
        
        if (resultantLength%2==0)
        {
            return (double)(resArray[mid]+resArray[mid-1])/2;
            
            
        }
        return resArray[mid];
        
    }

	
	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {};
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

}
