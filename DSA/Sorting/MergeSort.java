package Sorting;

public class MergeSort {

	 static void mergeSort(int arr[],int start,int end) {
		if(start<end) {
			int m=(start+end)/2;
			mergeSort(arr, start, m);
			mergeSort(arr, m+1, end);
			merge(arr,start,m,end);
		}
	}
	 
	  static void merge(int arr[],int start,int m,int end) {
		 int leftSize=m-start+1;
		 int rightSize=end-m;
		 
		 
		 
		 int[] leftArr=new int[leftSize];
		 int[] rightArr=new int[rightSize];
		 
		 int index=start; 
		 
		 for(int i=0;i<leftSize;i++) {
			 leftArr[i]=arr[index++];
		 }
		 for(int i=0;i<rightSize;i++,index++) {
			 rightArr[i]=arr[index];
		 }
		 
		 int leftPointer=0,rightPointer=0,arrIndex=start;
		 
		 while(leftPointer<leftSize && rightPointer<rightSize) {
			 if(leftArr[leftPointer]<rightArr[rightPointer]) {
				 arr[arrIndex]=leftArr[leftPointer];
				 leftPointer++;
				 
			 }else {
				 arr[arrIndex]=rightArr[rightPointer];
				 rightPointer++;
				 
			 }
			 arrIndex++;
		 }
		 
		 if(leftPointer==leftSize)
		 {
			 while(rightPointer<rightSize)
			 {
				 arr[arrIndex]=rightArr[rightPointer];
				 rightPointer++;
				 arrIndex++;
			 }
		 }
		 
		 if(rightPointer==rightSize)
		 {
			 while(leftPointer<leftSize)
			 {
				 arr[arrIndex]=leftArr[leftPointer];
				 leftPointer++;
				 arrIndex++;
			 }
		 }
		 for(int i:arr) 
			 System.out.print(i+" ");
		 System.out.println();
	 }
	
	 public static void main(String[] args) {
		
		 int[] arr= {6,5,4,3,2,1,0};
		 //MergeSort ms=new MergeSort();
		 mergeSort(arr, 0, arr.length-1);
		 for(int i:arr) {
			 System.out.print(i+" ");
		 }
	}
}
