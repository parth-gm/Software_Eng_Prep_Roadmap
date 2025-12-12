package practice;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

	
	static int[] findNextGreaterElement(int[] nums1,int nums2[]){
		
		HashMap<Integer,Integer> map=new HashMap<>();
		Stack<Integer> stack=new Stack<>();
		stack.push(0);
		for(int i=1;i<nums2.length;i++) {
			if(nums2[stack.peek()]>nums2[i])
			{
				//System.out.println("push "+i);
				stack.push(i);
			}
			else
			{
				//System.out.println(stack.toString());
				while((!stack.isEmpty()) && (nums2[stack.peek()]<nums2[i])) {
					//System.out.println(stack.peek()+" = "+nums2[i]);
					//ans[stack.pop()]=nums2[i];
					map.put(nums2[stack.pop()], nums2[i]);
				}
				stack.push(i);
				
			}
			
		}

		while(!stack.isEmpty())
		{
			//ans[stack.pop()]=-1;
			map.put(nums2[stack.pop()],-1);
		}
		//System.out.println(map.toString());
		for(int i=0;i<nums1.length;i++) {
			
			nums1[i]=map.get(nums1[i]);
			
		}
		
		return nums1;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2,4}, nums2 = {1,2,3,4};
		int[] arr=findNextGreaterElement(nums1,nums2);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

}
