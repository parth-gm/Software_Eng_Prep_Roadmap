package TenDaysCode;

import java.util.Scanner;

public class Gcd {

	static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		
		System.out.println(gcd(n1,n2));
		
	}

}
