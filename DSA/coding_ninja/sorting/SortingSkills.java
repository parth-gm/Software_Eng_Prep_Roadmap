package Sorting;

import java.util.Scanner;

public class SortingSkills {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
		while(noTest-->0) {
			
			int size = sc.nextInt();
			int[] arr = new int[size];
			for(int i=0;i<size;i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(checkIsSortable(arr, size));
			
		}
	}

	private static String checkIsSortable(int[] arr, int size) {
		// TODO Auto-generated method stub
		int arrMax[] = new int[size];
		int arrMin[] = new int[size];
		int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i=0;i<size;i++)
		{
			max = Math.max(max, arr[i]);
			arrMax[i] = max;
		}
		
		for(int i=size-1;i>=0;i--)
		{
			min = Math.min(min, arr[i]);
			arrMin[i] = min;
		}
		
		for(int k=0;k<size;k++) {
			if(Math.abs(arrMax[k]-arrMin[k])>1)
				return "No";
		}
		return "Yes";
	}

}
