package array;

public class KthSmallestElement {

	
	
	public static void main(String[] args) {
		
		int[] arr = {3, 3, 3, 1, 5, 6};
		
		 System.out.print(kthSmallestElement(arr, 2));
		
		
		

	}

	private static int kthSmallestElement(int[] arr, int k) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		
		int l = min, r= max;
		while(l<=r) {
			
			int mid = l + (r-l)/2;
			int countLess =0; 
			int countEqual = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==mid)
					countEqual++;
				if(arr[i]<mid)
					countLess++;
			}
			
			if(countLess<k && (countLess+countEqual)>=k)
				return mid;
			else if(countLess<k) {
				l = mid+1;
			}else
				r = mid-1;
			
		}
		return -1;
	}

}
