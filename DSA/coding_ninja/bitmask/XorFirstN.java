package bit_mask;

import java.util.Scanner;

public class XorFirstN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int n = sc.nextInt();
			if(n%4==0) {
				System.out.println(n);
			}else if(n%4==1) {
				System.out.println(1);
			}else if(n%4==2) {
				System.out.println(n+1);
			}else {
				System.out.println(0);
			}
		}

	}

}
