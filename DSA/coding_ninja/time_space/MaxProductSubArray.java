package time_space;

public class MaxProductSubArray {

	static int getMaxSubArrayProduct(int arr[], int n) {
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = arr[0];
		for(int i=1;i<n;i++)
		{
			if(max_so_far< arr[i])
				max_so_far = arr[i];
		}	
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				max_ending_here = max_ending_here*arr[i];
				min_ending_here = Math.min(1, min_ending_here*arr[i]);
			}else if (arr[i]==0)
			{
				max_ending_here =1;
				min_ending_here =1;
			}else {
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here*arr[i], 1);
				min_ending_here = temp*arr[i];
			}
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		
		return max_so_far;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,-3, 	-10,0,2 };
//		int arr[] = {-2,0,-1};
		System.out.println(getMaxSubArrayProduct(arr, arr.length));
	}

}
