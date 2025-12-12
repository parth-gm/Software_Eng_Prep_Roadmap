package time_space;

public class KadaneAlgo {
	
	static int kadane(int[] arr, int n) {
		int current_sum =0;
		int best_sum =0;
		for(int  i=0;i<n;i++) {
			current_sum+=arr[i];
			if(current_sum<0)
				current_sum=0;
			if(current_sum>best_sum)
				best_sum=current_sum;
		}
		return best_sum;
		
	}
	
	public static void main(String[] args) {
		//int[] arr= {-5,6,7,-20,3,5,8,-1};
		int[] arr= {1,7,-5,8,4};
		
		System.out.println(kadane(arr, arr.length));

	}

}
