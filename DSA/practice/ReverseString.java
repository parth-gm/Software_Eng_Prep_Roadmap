package practice;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] arr= {'h','e','l','l','o'};
		
		int left=0,right=arr.length-1;
		
		while(left<right) {
			
			char temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
		System.out.println(Arrays.toString(arr));
		
		
		
		
	}

}
