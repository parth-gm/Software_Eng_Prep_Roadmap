package numbertheory3;

import java.util.Scanner;

public class SumLCM {
	static int maxLimit = (int)Math.pow(10, 5);
	static long[] phi = new long[maxLimit+1];
	static long[] res = new long[maxLimit+1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tests = sc.nextInt();
		intializeArray();
		while(tests-->0) {
			int no = sc.nextInt();
			long ans =((no)*(res[no] + 1))/2 ;
			System.out.println(ans);
		}
	}
	
	private static long getSumLCM(int n) {
		long sum =0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				sum+=phi[i]*i;
			}
//			System.out.println(sum);
		}
//		System.out.println(sum);
		return ((n)*(sum + 1))/2 ;
	}
	
	static public int phi(int n)
	 {
	  int result = n;
	   for (int i = 2; i * i <= n; i++)
	   {
	    if (n % i == 0)
	    {
	    while (n % i == 0)
	     n /= i;
	   result -= result / i;
	   }
	}
	 if (n > 1)
	  result -= result / n;
	  return result;
	}
	
	private static void intializeArray() {
		for(int i=1;i<=maxLimit;i++) {
			phi[i]=i;
		}
		for(int i=2;i<=maxLimit;i++) {
			if(phi[i]==i) {
				phi[i] = i-1;
				for(int j=i*2;j<=maxLimit;j+=i) {
					phi[j] =  (phi[j]*(i-1))/i;
				}
			}
		}
		
		for(int i=1;i<=maxLimit;i++) {
			for(int j=i;j<=maxLimit;j+=i) {
				res[j] += phi[i]*i;
			}
		}
		
	}
	
}
