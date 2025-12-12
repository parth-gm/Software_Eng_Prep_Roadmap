package TenDaysCode;

import java.util.Scanner;

public class DivisibleSubArrays {

	static int nC2(int n) {
		return (n*(n-1))/2;
	}
	
	static int countSubArrays(int[] arr,int nos) {
		int[] sumarrmod=new int[nos+1];
		
		for(int i=1;i<=nos;i++) {
			int sum=(sumarrmod[i-1]+arr[i-1])%nos;
			sumarrmod[i]=(sum+nos)%nos;
		}
		for(int i=0;i<nos+1;i++)
		{
			System.out.print(sumarrmod[i]+" ");
		}
		
		
		int[] occurarr=new int[nos];
		for(int i=0;i<=nos;i++)
		{
			occurarr[sumarrmod[i]]++;
		}
		
		for(int i=0;i<nos;i++)
		{
			System.out.print(occurarr[i]+" ");
		}
		int countsub=0;
		for(int k=0;k<nos;k++) {
			if(occurarr[k]>1) {
				countsub+=nC2(occurarr[k]);
			}
		}
		return countsub;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int notest=sc.nextInt();
		for(int i=0;i<notest;i++) {
			int nos=sc.nextInt();
			int[] arr=new int[nos];
			for(int j=0;j<nos;j++)
				arr[j]=sc.nextInt();
			System.out.println(countSubArrays(arr,nos));
		}
	}

}
