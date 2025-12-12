package interview_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sum3 {

	static void find3Sum(int[] nums) {
		
		for(int i=0;i<=nums.length-3;i++) {
			for(int j=i+1;j<=nums.length-2;j++) {
				for(int k=j+1;k<nums.length;k++) {
					if((nums[i]+nums[j]+nums[k])==0) {
						System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
					}
				}
			}
		}
		
		
	}
	
//	static void find3Sumv1(int[] nums) {
//		HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
//		List<List<Integer>> ans=new ArrayList<List<Integer>>();
//		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
//		
//		
//		ArrayList<Integer> arrl=new ArrayList<Integer>();
//		for(int i=0;i<nums.length;i++) {
//			
//		}
//		
//		for(int i=0;i<=nums.length-2;i++) {
//			for(int j=i+1;j<=nums.length-1;j++) {
//				System.out.println(i+" "+j);
//				
//				int dsum=(nums[i]+nums[j]);
//				if(arrl.contains(dsum) ) {
//					Integer[] arr= {nums[i],nums[j],dsum};
//					Arrays.sort(arr);
//					System.out.println(nums[i]+" "+nums[j]+" "+nums[]);
//					hs.add(Arrays.asList(arr));
//				}
//			}
//		}
//		
//
//		 Iterator<List<Integer>> it = hs.iterator();
//	     while(it.hasNext()){
//	    	 ans.add(it.next());
//	        
//	     }
//	     
//	     System.out.println(ans);
//	     
//	}
	
	static ArrayList<List<Integer>> findSumv2(int[] nums) {
		
		Set<List<Integer>> res=new HashSet<List<Integer>>();
		if(nums.length==0) return new ArrayList<>(res);
		
		Arrays.sort(nums);
	
		for(int i=0;i<nums.length-2;i++) {
			
			int start=i+1;
			int end=nums.length-1;
	
			while(start<end) {
				int sum=-(nums[start]+nums[end]);
				if((sum)==nums[i]) {
					
					res.add(Arrays.asList(nums[start],nums[end],nums[i]));
					start++;
					end--;
					
				}else if(sum<nums[i]) {
					end--;
				}else {
					start++;
				}
			
			}

		}
		return new ArrayList<List<Integer>>(res);
	}
	
	public static void main(String[] args) {

		int[] nums= {1,-1,-1,0};
		
		ArrayList<List<Integer>> ans=findSumv2(nums);
		System.out.println(ans.toString());
		
	}

}
