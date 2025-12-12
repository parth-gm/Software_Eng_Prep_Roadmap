package Sorting;

public class BinarySearch {

	static int findNextElement(int arr[], int n, int tofind) {
		int start = 0, end = n-1, ans = n;
		while(start<=end){
			int mid =  start + (end-start)/2;
			
			if(arr[mid]> tofind)
			{
				end = mid -1;
			}else
			{
				start = mid+1;
			}
		}
		
		return start;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5, 9, 20, 23, 23, 23};
		System.out.println(findNextElement(arr, arr.length, 23));
	}

}
