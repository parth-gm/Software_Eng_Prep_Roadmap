package practice;

import java.util.Scanner;

public class FindInversionCount {

	static int inversionCount(int[] arr) {
		int inv_count=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					inv_count++;
				}
			}
		}
		
		return inv_count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int test=sc.nextInt();
		for(int i=0;i<test;i++) {
			int L=sc.nextInt();
			int[] arr=new int[L];
			for(int j=0;j<L;j++) {
				arr[j]=sc.nextInt();
			}
			System.out.println(inversionCount(arr));
			
		}
		

	}

}
