package TenDaysCode;

import java.util.Scanner;

public class GaneshaProblem {
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	
		int N=sc.nextInt();
		int half=N/2;
		for(int i=1;i<=half;i++) {
			System.out.print("*");
			for(int j=1;j<=half-1;j++) {
				System.out.print(" ");
			}
			if(i==1) {
				for(int k=1;k<=half+1;k++) {
					System.out.print("*");
				}
			}
			else {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=N;i++)
		{
			System.out.print("*");
		}
		System.out.println();
		for(int i=1;i<=half;i++) {
			
			if(i==half) {
				
				for(int k=1;k<=half+1;k++) {
					System.out.print("*");
				}
				
				for(int k=1;k<=half-1;k++) {
					System.out.print(" ");
				}
				System.out.print("*");
				
			}
			else {
				
				for(int j=1;j<=half;j++) {
					System.out.print(" ");
				}
				
				System.out.print("*");
				for(int l=1;l<=half-1;l++) {
					System.out.print(" ");
					
			}
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
