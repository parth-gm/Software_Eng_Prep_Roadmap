package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Sum3 {

	public static List<List<Integer>> threeSum(int[] nums) {
        
		HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		
		for(int i=0;i<=nums.length-3;i++) {
			
			for(int j=i+1;j<=nums.length-2;j++) {
				
				for(int k=j+1;k<=nums.length-1;k++) {
					
					if((nums[i]+nums[j]+nums[k])==0) {
						Integer[] arr= {nums[i],nums[j],nums[k]};
						Arrays.sort(arr);
						hs.add(Arrays.asList(arr));
						//System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
					}
					
				}
				
			}
			
		}
		
		
		 Iterator<List<Integer>> it = hs.iterator();
	     while(it.hasNext()){
	    	 ans.add(it.next());
	        
	     }
		
	     return ans;
		
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {-1, 0, 1, 2, -1, -4};
		
		List<List<Integer>> lst=threeSum(arr);
		//threeSum(arr);
		
		
		for(List each:lst) {
			
			System.out.println(each.toString());
			
		}
		
	}

}
