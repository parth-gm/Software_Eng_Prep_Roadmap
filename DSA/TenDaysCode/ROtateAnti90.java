package TenDaysCode;

import java.util.Scanner;

public class ROtateAnti90 {

	
	
	static void rotate(int[][] arr,int no) {
		
		for(int i=1;i<=no/2;i++) {
			int len=no-(2*i);
		
			if(len>0) {
				int[] dum=new int[len];
				
				int id=0;
				for(int j=i;j<=len+(i-1);j++) {
					dum[id]=arr[i-1][j];
					id++;
				}
				
				//right to top
				for(int k=i;k<=len+(i-1);k++) {
					arr[i-1][k]=arr[k][(no-1)-(i-1)];
					
				}
			
				//bottom to right
				for(int k=i;k<=len+(i-1);k++) {
					arr[k][no-1-(i-1)]=arr[no-1-(i-1)][no-1-k];
					
				}
				
				//left to bottom
				for(int k=i;k<=len+(i-1);k++) {
					arr[no-1-(i-1)][k]=arr[k][i-1];
					
				}
				
				//top to left
				int idx=0;
				for(int k=no-1-i;k>=i;k--) {
					arr[k][i-1]=dum[idx];
					idx++;
				}
			}
			
			int temp=arr[i-1][i-1];
			arr[i-1][i-1]=arr[i-1][no-1-(i-1)];
			arr[i-1][no-1-(i-1)]=arr[no-1-(i-1)][no-1-(i-1)];
			arr[no-1-(i-1)][no-1-(i-1)]=arr[no-1-(i-1)][i-1];
			arr[no-1-(i-1)][i-1]=temp;
			
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		int[][] arr=new int[no][no];
		for(int i=0;i<no;i++) {
			for(int j=0;j<no;j++) {
				arr[i][j]=sc.nextInt();
				
			}
			
		}
//		
//		for(int i=0;i<no;i++) {
//			for(int j=0;j<no;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------");
		rotate(arr,no);
		
		for(int i=0;i<no;i++) {
			for(int j=0;j<no;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
