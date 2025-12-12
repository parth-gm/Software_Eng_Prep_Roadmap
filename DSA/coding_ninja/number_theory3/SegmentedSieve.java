package numbertheory3;

import java.util.ArrayList;
import java.util.Scanner;

public class SegmentedSieve {

	static final int MAX =100001;
	static ArrayList<Integer> sieve() {
		
		boolean[] isPrime = new boolean[MAX];
		for(int i=0;i<MAX;i++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2;i*i<MAX;i++) {
			if(isPrime[i]) {
				for(int j=i*i;j<MAX;j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		ArrayList<Integer> arrl = new ArrayList<>();
		for(int i=2;i<MAX;i++) {
			if(isPrime[i])
				arrl.add(i);
		}
		
		return arrl;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr_sieve = sieve();
		
		Scanner sc = new Scanner(System.in);	
		int tests = sc.nextInt();
		while(tests-->0) {
			
			long l = sc.nextLong();
			long r = sc.nextLong();
			printPrimes(l, r, arr_sieve);
			System.out.println();
		}

	}

	private static void printPrimes(long l, long r, ArrayList<Integer> arr_sieve) 
	{
		boolean[] isPrime = new boolean[(int)(r-l+1)];
		
		for(int i=0;i<=(r-l);i++) {
			
			isPrime[i] = true;
			
		}
		//System.out.println(arr_sieve);
		
		if(l==1 || r==1)
			isPrime[0] = false;
		for(int i=0;arr_sieve.get(i)*(long)arr_sieve.get(i)<=r;i++) {
			int currPrime = arr_sieve.get(i);
			//System.out.println("currentPrime: "+ currPrime);
			long base = (l/currPrime)* currPrime;
			if(base<l) {
				base = base +currPrime;
			}
			for(long j=base;j<=r;j+=currPrime) {
				isPrime[(int)(j-l)] = false;
			}
			//System.out.println(base);
			if(base==currPrime && base!=1)
				isPrime[(int)(base-l)] = true;
		}
		
		for(int i=0;i<=(r-l);i++) {
			if(isPrime[i])
				System.out.print(i+l+" ");
		}
		
		
	}
	
	

}
