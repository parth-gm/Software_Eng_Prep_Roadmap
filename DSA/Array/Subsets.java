package leetcode_july;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	static  List<List<Integer>> findSubsets(int[] nums){
		
		int length=(1<<nums.length);
		List<List<Integer>> llst=new ArrayList<List<Integer>>();
		for(int i=0;i<length;i++) {
			int dl=nums.length, dummyi=i ;
			ArrayList<Integer> al=new ArrayList<Integer>();
			while(dl>0) {
				if((dummyi&1)==1){
					al.add(nums[dl-1]);
				}
				dummyi=dummyi>>1;
				dl--;
			}
			llst.add(al);
		}
		
		return llst;
		
		
	}
	
	public static void main(String[] args) {

		int[] nums= {1,2,3};
		System.out.println(findSubsets(nums));
		

	}

}
