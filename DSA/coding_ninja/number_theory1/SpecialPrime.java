package numbertheory1;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialPrime {

	public static void main(String[] args) {


	  	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sieve_eratosthenes_specl_prime(n));
		
		
	}
	
	
	static int sieve_eratosthenes_specl_prime(int n) {
		
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
		int prevPrimeNo = 2;
		for(int i=3;i<=n;i++) {
			if((i+prevPrimeNo+1)>n+1)
				break;
			if(array[i]) {
				if(array[i+prevPrimeNo+1])
					count++;
				prevPrimeNo = i;
			}
		}
		
		return count;
	}

}
