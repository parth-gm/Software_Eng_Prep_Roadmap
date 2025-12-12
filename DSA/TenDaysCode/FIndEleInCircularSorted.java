package TenDaysCode;

public class FIndEleInCircularSorted {

	static int findEle(int[] arr,int low,int high,int search){
		
		while(low<=high) {
			int mid=(low+high)/2;
			
			if(arr[mid]==search) {
				return mid;
			}
			if(arr[mid]<=arr[high]) {
				if(search>arr[mid] && search<=arr[high])
				{
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
			else {
				if(search>=arr[low] && search<arr[mid]) {
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6,8,11,12,15,18,2,5};
		System.out.println(findEle(arr,0,arr.length-1,11));
		
	}

}
