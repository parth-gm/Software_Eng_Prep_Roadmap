package TenDaysCode;

import java.util.Scanner;

public class HelpRahul {
	static int search(int no,int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==no) {
				return i;
			}
		}
		return -1;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		while(sc.hasNext()) {
			int no=sc.nextInt();
			System.out.println(search(no,arr));
		}
	}

}
