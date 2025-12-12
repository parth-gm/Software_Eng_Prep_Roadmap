package numbertheory1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PrimeNo {

	public static void main(String[] args) {
		
    	Scanner sc = new Scanner(System.in);
    	
		int n = sc.nextInt();
		int count=0;
		for(int i=2;i<=n;i++) {
			if(checkPrime(i)) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sieve_eratosthenes(n));
		System.out.println(Rotate(234));
		System.out.println(Rotate(423));
		System.out.println(Rotate(324));
	}
	//T = N*N^(1/2)
	private static boolean checkPrime(int n) {
	
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		
		return true;
	}
	
	static int sieve_eratosthenes(int n) {
		
		boolean[] array = new boolean[n+1];
		
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
		
		return count;
	}
	
	 public static int countDigits(int n)
	    {
	        int digit = 0;
	        while ((n /= 10) > 0)
	            digit++;
	        return digit;
	    }
	 
	
	   public static int Rotate(int n)
	    {
	        int rem = n % 10; 
	        rem *= Math.pow(10, countDigits(n)); 
	        
	        n /= 10; 
	        n += rem; 
	        return n;
	    }

}
