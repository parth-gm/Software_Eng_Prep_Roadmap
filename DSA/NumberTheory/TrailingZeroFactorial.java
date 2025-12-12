package codechef;

import java.util.Scanner;

public class Reverse {

//	static int reverse(int x) {
//		int rev=x;
//
//		if(x/10==0) return rev;
//
//		StringBuffer sb=new StringBuffer();
//		while(x>0) {
//			int y=x%10;
//			sb.append(y);
//			x=x/10;
//		}
//		//System.out.println(sb.toString());
//
//		int i=0;
//
//		while(sb.charAt(i)=='0')i++;
//
//
//
//		return Integer.parseInt(sb.substring(i));
//	}
//

    /*The function counts how many trailing zeroes are in x!, using repeated division by 5.*/
	static int noZeroes(int x) {
		int count=0;
		while(x>4) {
			x=(x/5);
			count=count+x;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		for(int i=0;i<t;i++) {
			int x=sc.nextInt();
			System.out.println(noZeroes(x));
		}
	}

}
