package Sorting;

import java.util.Arrays;

public class CountingSort {

	public static int[] countSort(int[] arr) {
		int max=Arrays.stream(arr).max().getAsInt();
		int min=Arrays.stream(arr).min().getAsInt();
		int[] countArr=new int[max-min+1];
		int[] outputArr=new int[arr.length];
 		for(int i=0;i<arr.length;i++) {
			countArr[arr[i]-min]++;
		}
		
		for(int i=1;i<countArr.length;i++) {
			countArr[i]=countArr[i]+countArr[i-1];
		}
		
		System.out.println("----------------INITIAL SUM-COUNT ARRAY-------------");
		for(int i: countArr) System.out.println(i);
		
		for(int i=0;i<arr.length;i++) {
			int position=countArr[arr[i]-min];
			outputArr[position-1]=arr[i];
			countArr[arr[i]-min]--;
		}

		System.out.println("----------------AFTER SUM-COUNT ARRAY-------------");
		for(int i: countArr) System.out.println(i);
		
		return outputArr;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,3,4,7,2,1,0,1,3,4,5}; 
		int[] output=countSort(arr);
		System.out.println("------------OUTPUT ARAAY-----------");
		for(int value:output)
			System.out.println(value);
		
	}

}
