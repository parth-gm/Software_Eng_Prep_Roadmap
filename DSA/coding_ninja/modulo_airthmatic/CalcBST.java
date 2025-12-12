package modulo_airthmetic;

import java.util.Scanner;

public class CalcBST {
	static final int moduloBy = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int h = sc.nextInt();
			System.out.println(calcNoBSTs(h));
		}
	}

	private static int calcNoBSTs(int h) {
		
		if(h==0 || h==1) {
			return 1;
		}
		
		int x = calcNoBSTs(h-1);
		
		int y = calcNoBSTs(h-2);
		long ans1 = (long)x*x;
		long ans2 = (long)x*y*2;
		
		int res1 = (int)(ans1%moduloBy);
		int res2 = (int)(ans2%moduloBy);
		
		int ans = (res1+res2)%moduloBy;
		
		return ans;
	}

}
