package codechef;

import java.util.Scanner;

public class PrimeNoGenerator {

	static int gcd(int a, int b) 
	{ 
	    if (a == 0) 
	        return b; 
	    return gcd(b % a, a); 
	} 
	
	static boolean checkPrime(int x) {
		
		if(x==2)return true;
		if(x==1)return false;
		for(int i=2;i<=Math.sqrt(x);i++) {
			if(x%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int t=sc.nextInt();
//		for(int i=0;i<t;i++) {
//			int x=sc.nextInt();
//			int y=sc.nextInt();
//			
//			while(x<=y) {
//				if(checkPrime(x))
//					System.out.println(x);
//				x++;
//			}
//			System.out.println();
//			
//		}
		
		System.out.println(gcd(1,0));
	}

}
