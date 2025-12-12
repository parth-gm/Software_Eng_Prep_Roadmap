package gfg;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
        
		List<List<Integer>> ll=new ArrayList<List<Integer>>();
		
		computePermutations(nums,0,nums.length-1,ll);
		return ll;
			
    }
	
	public static void swap(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void computePermutations(int[] nums,int l,int r,List<List<Integer>> ll){
		
		if(l==r) {
			List<Integer> al=new ArrayList<Integer>(nums.length);
			for(int val:nums) {
				al.add(val);
			}
			ll.add(al);
		}else {
			for(int i=l;i<=r;i++) {
				swap(nums,l,i);
				computePermutations(nums, l+1, r, ll);
				swap(nums,i,l);
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] nums= {1,2,3};
		System.out.println(permute(nums));
	}

}
