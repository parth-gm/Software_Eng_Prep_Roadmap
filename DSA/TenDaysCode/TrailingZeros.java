package TenDaysCode;

import java.util.Scanner;

public class TrailingZeros {

	static int trailingZeroes(int n) {
		if(n<5)return 0;
		int m=5,count=0;
		while((n/m)>0) {
			count=count+(n/m);
			m=m*5;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		System.out.println(trailingZeroes(n));
	}

}
