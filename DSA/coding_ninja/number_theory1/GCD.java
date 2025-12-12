package numbertheory1;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(gcd(a,b));
		}
		
	}

	private static int gcd(int a, int b) {

		if(b==0)
			return a;
		
		return gcd(b, a%b);
	}

}
