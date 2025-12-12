package numbertheory1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SuperPrime {

	public static void main(String[] args) {
		// 

	  	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		System.out.println(get_super_prime_count(n));
		
//		
//		long[] primes = sieve_eratosthenes(n);
////		ArrayList<Long> arrl = new ArrayList<>();
//		int count=0;
//		for(int i=0;i<primes.length-1;i++) {
//			for(int j=i+1;j<primes.length;j++) {
//				long x = primes[i];
//				long y = primes[j];
//				
//				long product = x*y;
//			
//				while(product<=n) {
//					//arrl.add(product);
//					count++;
//					product *=x;
//					
//				}
//				
//				product = x*y*y;
//				
//				while(product<=n) {
//					//arrl.add(product);
//					count++;
//					product *=y;
//					
//				}
//				
//				product = x*x*y*y;
//				
//				while(product<=n) {
//					//arrl.add(product);
//					count++;
//					product *=x*y;
//					
//				}
//				
//			}
//			
//		}
//		System.out.println(count);
//		//		System.out.println(arrl);
////		System.out.println(Arrays.toString(primes));
//		
	}

	
	static int get_super_prime_count(int n) {
		
		int[] sieve = new int[n+1];
		int count=0;
		for(int i=2;i<=(n/2);i++)
		{
			if(sieve[i]==0) {
				for(int j=i*2;j<=n;j+=i) {
					sieve[j]++;
				}
			}
		}
		
		
		for(int i=4;i<=n;i++)
		{
			if(sieve[i]==2) {
				count++;
			}
		}
		
		return count;
	}
	
	
	static long[] sieve_eratosthenes(long n) {
		
		boolean[] array = new boolean[(int)n+1];
		
		Arrays.fill(array, true);
		
		array[0] = array[1] = false;
		int count=0;
		for(int i=2;i*i<=n;i++) {
			
			if(array[i]) {
				for(int j=i;j*i<=n;j++) { // for(int j=i*i;j<=n;j=j+i)
					array[j*i] = false;
				}
			}
		}
		
		for(int i=0;i<=n;i++) {
			if(array[i])
				count++;
		}
		long[] primeNos = new long[count];
		//System.out.println(Arrays.toString(array));
		for(int i=2, idx=0;i<=n;i++) {
			if(array[i])
				primeNos[idx++]=i;
		}
		return primeNos;
	}

	
}
