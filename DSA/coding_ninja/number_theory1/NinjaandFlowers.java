package numbertheory1;

import java.util.Arrays;
import java.util.Scanner;

public class NinjaandFlowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sieve_eratosthenes_specl_prime(n+1);
	}


	static void sieve_eratosthenes_specl_prime(long n) {
		
		boolean[] array = new boolean[(int)n+1];
		
		Arrays.fill(array, true);
		
		array[0] = array[1] = false;
		int countPrime=0, countNonPrime=0;
		for(int i=2;i*i<=n;i++) {
			
			if(array[i]) {
				for(int j=i;j*i<=n;j++) { // for(int j=i*i;j<=n;j=j+i)
					array[j*i] = false;
				}
			}
		}
		
		for(int i=2;i<=n;i++) {
			if(array[i])
				countPrime++;
			else
				countNonPrime++;
		}
		if(countNonPrime<countPrime)
			System.out.println(countNonPrime+" "+countPrime);
		else
			System.out.println(countPrime+" "+countNonPrime);
	
	}

	
}
