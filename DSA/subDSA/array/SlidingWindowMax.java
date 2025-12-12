package array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMax {

	//wrong solution; checkout leetcode submitted code
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        Deque<Integer> dqueue = new LinkedList<>();
	        int[] result = new int[nums.length-k+1];
	        int idx = 0;
	        for(int i=0;i<nums.length;i++){
	                
	            if((i>=(k-1)) && nums[i]<nums[dqueue.peekLast()]){

	                if(dqueue.size()==k){
	                    dqueue.removeFirst();    
	                }
	                dqueue.add(i);    

	            }
	            else{
	                
	                while(!dqueue.isEmpty() && nums[i]>nums[dqueue.peekLast()])
	                {
	                    dqueue.removeLast();    
	                }
	                dqueue.add(i);

	            }
	            if(i>=(k-1))
	                result[idx++] = dqueue.peekFirst(); 

	            
	        }
	        return result;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
