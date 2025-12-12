package Sorting;

public class QuickSort {

	static void quickSort(int[] arr,int start,int end) {
		if(start<end) {
			int pindex=partition(arr,start,end);
			quickSort(arr, start, pindex-1);
			quickSort(arr, pindex+1, end);
			
		}
		
	}
	
	static int partition(int arr[],int start,int end) {
		int pivotIndex=start,pivot=arr[start];
		int low=start,high=end;
		
		while(low<high) {
			
			while(low<high && arr[low]<=pivot)low++;
			
			while(arr[high]>pivot) high--;
		
			if(low<high) {
				//System.out.println("Exchanged "+arr[low]+" "+arr[high]);
				int temp=arr[low];
				arr[low]=arr[high];
				arr[high]=temp;
		
			}
			
		}
		//System.out.println("Pivote Exchanged"+high+" "+pivotIndex);
		int temp=arr[high];
		arr[high]=arr[pivotIndex];
		arr[pivotIndex]=temp;
		
		
//		for(int i:arr) System.out.print(i+" ");
//		System.out.println();
		return high;

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		quickSort(arr, 0, arr.length-1);
		for(int i:arr)System.out.print(i+" ");
		
	}

}
