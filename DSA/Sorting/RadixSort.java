package Sorting;

import java.util.Arrays;

public class RadixSort {

	

	public static void countSort(int[] arr,int exp) {
//		int max=Arrays.stream(arr).max().getAsInt();
//		int min=Arrays.stream(arr).min().getAsInt();
		int[] countArr=new int[10];
		int[] outputArr=new int[arr.length];
 		for(int i=0;i<arr.length;i++) {
			countArr[(arr[i]/exp)%10]++;
		}
		
		for(int i=1;i<countArr.length;i++) {
			countArr[i]=countArr[i]+countArr[i-1];
		}
		
//		System.out.println("----------------INITIAL SUM-COUNT ARRAY-------------");
//		for(int i: countArr) System.out.println(i);
		
		for(int i=arr.length-1;i>=0;i--) {
			int position=countArr[(arr[i]/exp)%10];
			outputArr[position-1]=arr[i];
			countArr[(arr[i]/exp)%10]--;
		}

//		System.out.println("----------------AFTER SUM-COUNT ARRAY-------------");
//		for(int i: countArr) System.out.println(i);
		

		for(int i=0;i<arr.length;i++) {
			arr[i]=outputArr[i];
			System.out.print(arr[i]+" ");
		}
		System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                );
	}
	
	public static int getMax(int[] arr) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i])max=arr[i];
		}
		return max;
	}
	public static void radixSort(int[] arr) {
		
		int max=getMax(arr);
		
		for(int exp=1;max/exp>0;exp*=10) {
			countSort(arr,exp);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {121, 432, 564, 23, 1, 45, 788};
		 //int arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
	     radixSort(arr);
	     
	}

}
