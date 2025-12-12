package Sorting;

public class TestBinarySearch {

	public static int index(int arr[], int value)
	{
		int start = 0, end=arr.length-1;
	    while(start<end)
	    {
	        int mid=start + (end-start)/2;
	        
	        if(arr[mid]>=value)
	        	end = mid;
	        else
	        	start = mid+1;
	    }
	    if(arr[start]<value)
	    	start++;
	    return start;
	}
	
	public static void main(String[] args) {
		int[] arr= {1,5,10};
		System.out.println(index(arr, 5));
	}

}
