package dp;

import java.util.Scanner;

public class StairCaseProblem {

	static final int mode = 1000000007;
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
		
		int ntests = sc.nextInt();
		
		while(ntests-->0) {
			
			int n = sc.nextInt();
			System.out.println(getSteps(n));
		}
	}

	private static long getSteps(int n) {
		
		if(n==1)
			return 1;
		
		if(n==2)
			return 2;
		
		
		long[] output = new long[n+1];
		
		output[0]=0;
		output[1]=1;
		output[2]=2;
		
		for(int i=3;i<=n;i++) {
			output[i]=(output[i-1]%mode+output[i-2]%mode+output[i-3]%mode)%mode;
		}
		
		return output[n];
	}

}
