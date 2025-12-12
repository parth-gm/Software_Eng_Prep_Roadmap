package array;

public class FIndUniqueElement {

	public static void main(String[] args) {
		//int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5};
		int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
		System.out.println(getMeUniqueEle(arr));
		
	}

	private static int  getMeUniqueEle(int[] arr) {
		
		int left = 0;
		int right = arr.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if((mid==0 && arr[mid]!=arr[mid+1]) || (mid==arr.length-1 && arr[mid]!=arr[mid-1])
					|| (arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]))
			{
				return arr[mid];
			}else if((mid%2==1 && arr[mid]==arr[mid-1]) ||
					(mid%2==0 && arr[mid]==arr[mid+1])
					) {
				left = mid+1;
			}else {
				right = mid -1;
			}
			
		}
		return arr[left];
	}
	
}
