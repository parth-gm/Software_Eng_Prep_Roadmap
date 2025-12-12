package Sorting;

public class BubbleSort {

	static void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int itr=1;itr<=n-1;itr++) {
			boolean isChange=false;
			for(int j=0;j<n-itr;j++) {
				if(arr[j]>arr[j+1]) {
					isChange=true;
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(!isChange)
				break;
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,4,3,2,1};
		bubbleSort(arr);
		for(int item:arr) {
			System.out.print(item+" ");
		}
		System.out.println(Integer.toBinaryString(-10));
		
	}

}
