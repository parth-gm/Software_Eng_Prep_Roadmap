package modulo_airthmetic;

import java.util.Scanner;

public class PowerFunction {
	static final int moduloBy = 1000000007;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			System.out.println(getPower(x, y));
		}
		
		
	}

	private static int getPower(int x, int y) {
		// TODO Auto-generated method stub
		long prod =1;
		int ans =1;
		for(int i=0;i<y;i++) {
			prod = x*prod;
			ans = (int)(prod % moduloBy);
			prod = ans;
		}
		return ans;
	}

}
