package leetcode_july;

import java.util.Arrays;

public class PlusOne {

	static int[] plusOne(int[] arr) {
		int[] ans=new int[arr.length+1];
		
		int carry=0;
		int index=arr.length-1;
		
		if((arr[index]+1)<10) {
			arr[index]=arr[arr.length-1]+1;
			return arr;
		}else {
			carry=1;
		}
		
		while( index>=0  && (arr[index]+1)>=10 ) {
			ans[index+1]=0;
			arr[index]=0;
			index--;
		}
		
		if(index<0) {
			ans[0]=1;
			return ans;
		}else {
			arr[index]=arr[index]+1;
			return arr;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr= {1,2,4};
		System.out.println(Arrays.toString(plusOne(arr)));
		
	}
	
}
