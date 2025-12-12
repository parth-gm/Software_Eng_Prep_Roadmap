package Core;

public class FindROtationCOunt {

	public static int findRotation(int[] arr) {
		
		int low=0, high=arr.length-1;
		while(low<=high)
		{
			if(arr[low]<=arr[high])
			{
				return low;
			}
			int mid = (low+high)/2;
			int next = (mid+1)%arr.length;
			int prev = (mid-1+arr.length)%arr.length;
			if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])
			{
				return mid;
			}
			else if(arr[mid]<=arr[high])
			{
				high = mid -1;
			}else if(arr[mid]>=arr[low])
			{
				low = mid +1;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,6,7,8,4};
		System.out.println(findRotation(arr));
	}

}
