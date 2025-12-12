package numbertheory2;

import java.util.Scanner;

public class Advance_GCD {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			
			int a = sc.nextInt();
			String b = sc.next();
			
			int prevVal = Character.getNumericValue(b.charAt(0));
			for(int i=1;i<b.length();i++) {
				
				prevVal = (prevVal*10 + Character.getNumericValue(b.charAt(i)))%a;
				
			}
			
			System.out.println(gcd(a, prevVal));
		}
		
	}

	private static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}

}
