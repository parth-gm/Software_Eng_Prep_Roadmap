package array;

public class ContainerWithMostWater {

	 public static int maxArea(int[] height) {
	        
		 int left =0;
		 int right = height.length -1;
		 int maxArea = Integer.MIN_VALUE;
		 while(left<right) {
			 
			 maxArea = Math.max(maxArea, Math.min(height[left], height[right])*(right-left));
			 if(height[left]<=height[right]) {
				 left++;
			 }
			 else {
				 right--;
			 }
		 }
		 return maxArea;
		 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
