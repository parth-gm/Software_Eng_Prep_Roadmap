package dp;

import java.util.Scanner;

public class GCDAndVanaya {
	final static int  moduloby=1000000007;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			int n = sc.nextInt();
			int[] inputs = new int[n];
			for(int i=0;i<n;i++) {
				inputs[i] = sc.nextInt();
			}
			
			System.out.println(getCountGCD1(inputs, n));
		}
		

	}

	static int gcd(int a, int b) {
		if(a==0) {
			return b;
		}
		return gcd(b%a, a);
	}
	
	private static long getCountGCD1(int[] inputs, int n) {
		
		long[][] dp = new long[n][100];
		
		dp[0][inputs[0]-1] = 1;
		
		
		for(int i=1;i<n;i++) {
			
			dp[i][inputs[i]-1] = 1;
			for(int j=0;j<i;j++) {
				
				if(inputs[j]<inputs[i]) {
					
					
					for(int gcd=0;gcd<100;gcd++) {
						if(dp[j][gcd]>0) {
							int newgcd = gcd(inputs[i], gcd+1);
							dp[i][newgcd-1] += dp[j][gcd] ;
						}
					}
					
				}
				
			}
			
		}
		
		long ans =0;
		for(int i=0;i<n;i++) {
			ans= (ans%moduloby + dp[i][0]%moduloby)%moduloby;
		}
		
		return ans;
	}

}
