package practice;

import java.util.HashMap;

public class SubArraySum {

	//return counts
	  public static int subarraySum(int[] nums, int k) {
	      
		  HashMap<Integer,Integer> hm=new HashMap<>();
		  hm.put(0, 1);
		  
		  int sum=0;
		  int result=0;
		  
		  for(int i=0;i<nums.length;i++) {
			  sum+=nums[i];
			  
			  if(hm.containsKey(sum-k)){
				  result+=hm.get(sum-k);
			  }
			  
			  
			  hm.put(sum,hm.getOrDefault(sum, 0)+1);
		  }
		  
		  return result;
		  
	  }
	
	  //return index
	  public static void subarraySumv1(int[] nums, int k) {
	      
		  HashMap<Integer,Integer> hm=new HashMap<>();
		  int cur_sum=0;
		  int start=0;
		  int end=-1;
		  

		  for(int i=0;i<nums.length;i++) {
			  cur_sum+=nums[i];
			  
			  if(cur_sum-k==0) {
				  start=0;
				  end=i;
				  break;
			  }
			  if(hm.containsKey(cur_sum-k)){
				  start=hm.get(cur_sum-k)+1;
				  end=i;
				  break;
			  }
			  
			  
			  hm.put(cur_sum,i);
		  }
		  
		  if(end==-1) {
			  System.out.println("No SubArray");
			  
		  }
		  else {
			  System.out.println((start+1)+" "+(end+1));
		  }
	  }
	
	
	  
	public static void main(String[] args) {
		int[] nums = {2,3,5,1,2};
		System.out.println(subarraySum(nums, 5));
		subarraySumv1(nums, 9);
	}

}
