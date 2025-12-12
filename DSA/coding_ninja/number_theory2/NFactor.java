package numbertheory2;

import java.util.Scanner;

public class NFactor {
	static int NO_LIMIT = 1000000;
	static int[] sieve = new int[NO_LIMIT+1];
	
	static void intialize_sieve() {
		sieve[0] =0;
		sieve[1] = 0;
		
		for(int i=2;i<=NO_LIMIT;i++) {
			if(sieve[i]==0) {
				if(i>(NO_LIMIT/2))
					sieve[i] =1;
				else {
					for(int j=i;j<=NO_LIMIT;j+=i) {
						sieve[j]++;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		intialize_sieve();
		while(q-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int np = sc.nextInt();
			
			System.out.println(getCount(a, b, np));
		}
	}
	private static int getCount(int a, int b, int np) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=a;i<=b;i++) {
			if(sieve[i]==np)
				count++;
		}
		return count;
	}

}
