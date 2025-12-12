package modulo_airthmetic;

import java.util.Scanner;

public class ProductFirstN {
	static final int moduloBy = 100000007;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int no = sc.nextInt();
			int ans = (int) getProduct(no);
			System.out.println(ans);
		}
	}

	private static long getProduct(int no) {
		// TODO Auto-generated method stub
		long prod =1;
		for(int i=1;i<=no;i++) {
			
			prod = prod*i;
			int ans = (int)(prod % moduloBy);
			prod = ans;
		}
		return prod;
	}

}
