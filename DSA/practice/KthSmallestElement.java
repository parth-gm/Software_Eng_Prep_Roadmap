package practice;

public class KthSmallestElement {

	static int partition(int arr[],int start,int end) {
		int pivotIndex=start,pivot=arr[start];
		int low=start,high=end;
		
		while(low<high) {
			
			while(low<high && arr[low]<=pivot)low++;
			
			while(arr[high]>pivot) high--;
		
			if(low<high) {
				int temp=arr[low];
				arr[low]=arr[high];
				arr[high]=temp;
		
			}
			
		}
		
		int temp=arr[high];
		arr[high]=arr[pivotIndex];
		arr[pivotIndex]=temp;
		
		return high;

		
	}
	
	//insted of using global static varible do it by function call
	static int ans=-1;
	static void  kthSmallest(int[] arr, int p,int q,int k) {
		if(p==q) {
			if(p==k)
				ans= arr[p];
		}
		else
		{	
			
			int r=partition(arr,p,q);
			if(r==k) {
				ans=arr[r];
			}
			else if(r>k) {
				System.out.println(p+" "+(r-1));
				kthSmallest(arr, p, r-1, k);
			}else {
				System.out.println((r+1)+" "+q);
				kthSmallest(arr, r+1, q, k);
			}
			
		}	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,1,7,2,25,11,14};
		kthSmallest(arr, 0, arr.length-1, 1);
		System.out.println(ans);
		
	}

}
